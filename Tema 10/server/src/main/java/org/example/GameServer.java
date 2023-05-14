package org.example;

import org.example.model.Game;
import org.example.model.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    public static final int PORT = 8100;
    private int serverTimeout = 30_000;
    private int clientTimeout = 20_000;
    private boolean running;
    private final List<ClientThread> clientThreads;
    private final List<Game> games = new ArrayList<>();


    public void createGame() {
        Player player1 = new Player("Player 1", 1, 10);
        Player player2 = new Player("Player 2", 2, 5 * 60);
        Game game = new Game(player1, player2);
        games.add(game);
        ClientThread clientThread1 = clientThreads.get(clientThreads.size() - 2);
        clientThread1.setGame(game);
        clientThread1.setPlayer(player1);

        ClientThread clientThread2 = clientThreads.get(clientThreads.size() - 1);
        clientThread2.setGame(game);
        clientThread2.setPlayer(player2);
    }
    public Game getLastGame() {
        if (!games.isEmpty()) {
            return games.get(games.size() - 1);
        } else {
            return null;
        }
    }
    /**
     * Metoda imi inchide serverul
     */
    public void stopServer() {
        System.out.println("Shuting down the server...");
        running = false;
    }

    /**
     * Imi initializez server-ul si astept clienti
     * @throws IOException
     */
    public GameServer() throws IOException {
        clientThreads = new ArrayList<>();
        ServerSocket serverSocket = null;
        running = true;
        try {
            serverSocket = new ServerSocket(PORT);
            //serverSocket.setSoTimeout(serverTimeout);
            while (running) {
                System.out.println("Waiting for a client ...");
                try{
                    Socket socket = serverSocket.accept();
                    //socket.setSoTimeout(clientTimeout);
                    ClientThread clientThread = new ClientThread(this, socket);
                    clientThreads.add(clientThread);
                    clientThread.start();
//                }catch (SocketTimeoutException e){
//                    if (!running) {
//                        System.out.println("Server stopped.");
//                    }
                }catch (IOException e){
                    throw  new IOException();
                }

            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }

}
