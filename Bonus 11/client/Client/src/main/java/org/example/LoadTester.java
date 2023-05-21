package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LoadTester {
    private static final String API_URL = "http://localhost:8082/api/v1/game";
    private static final String JWT_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJEZW5pczEyMyIsImlhdCI6MTY4NDY5MTA0OSwiZXhwIjoxNjg0Njk0NjQ5fQ.hYD4sF82IfPmevrw1j7nah27SaRB8XBhFqorsfGQMqLItzSlwEBGBh9qOZ0hqHFtKmITPRUPivxsK6qqrn80wg";


    /**
     * Client Http folosit pentru a trimite cereri catre serviciu Games
     */
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    /**
     * Metoda construiste cererea HTTP GET
     * @param url
     * @return
     */
    private static HttpRequest buildGetRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .header("Authorization", JWT_TOKEN)
                .GET()
                .build();
    }

    /**
     * Metoda trimite cererile
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8082/api/v1/game";
        //folosit pentru a trimite cereri in paralel
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        //Facem 100 de request-uri
        for (int requestsCount = 100; requestsCount <= 10000; requestsCount += 100) {
            CompletableFuture[] futures = new CompletableFuture[requestsCount];

            long startTime = System.currentTimeMillis();

            IntStream.range(0, requestsCount).forEach(i ->
                    futures[i] = CompletableFuture.supplyAsync(() -> HTTP_CLIENT.sendAsync(buildGetRequest(url),
                            HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body), executorService));
            //Se asteapta ca toate cererile sa fie finalizate
            CompletableFuture.allOf(futures).join();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("Sent " + requestsCount + " requests in " + duration + "ms");
            //Se calculeaza numarul de cereri pe minut
            double rpm = requestsCount / (duration / 1000.0 / 60.0);
            System.out.println("Requests per minute: " + rpm);
            //Astepta sa treaca un minut, in caz ca nu a trecut
            Thread.sleep(60000 - duration);
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
