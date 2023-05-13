package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
    /**
     * Creezi un client care se conecteaza la server
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            Scanner input = new Scanner(System.in);
            String cmd;
            while (true) {
                System.out.println("command: ");
                cmd = input.nextLine();
                String[] parts = cmd.split(" ");
                String command = parts[0];

                switch (command) {
                    case "create":
                        out.println(cmd);
                        break;
                    case "join":
                        out.println(cmd);
                        break;
                    case "move":
                        if (parts.length != 3) {
                            System.out.println("Invalid command. Please use the format 'move x y'");
                            continue;
                        }
                        try {
                            int x = Integer.parseInt(parts[1]);
                            int y = Integer.parseInt(parts[2]);

                            out.println(cmd);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid coordinates. Please use the format 'move x y', where x and y are integers.");
                            continue;
                        }
                        break;
                    case "stop":
                        System.out.println("stopping...");
                        out.println(cmd);
                        break;
                    case "exit":
                        System.out.println("exiting...");
                        break;
                    default:
                        System.out.println("Unrecognized command: " + cmd);
                }

                String line;
                StringBuilder response = new StringBuilder();
                while (!(line = in.readLine()).equals("<END>")) {
                    response.append(line).append("\n");
                }
                System.out.println(response.toString());
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (SocketException e) {
            System.out.println("Connection closed by server!");
        }
    }
}
