package org.example.model.commands;

import org.example.ClientThread;
import org.example.GameServer;
import org.example.model.Game;

public class Command {
    private final String command;
    private final GameServer gameServer;
    private final ClientThread clientThread;

    public Command(String command, GameServer gameServer, ClientThread clientThread) {
        this.command = command;
        this.gameServer = gameServer;
        this.clientThread = clientThread;
    }
    public String  executeCommand() {
        String[] parts = command.split(" ");
        String cmd = parts[0];

        switch (cmd) {
            case "create":
                gameServer.createGame();
                return "Game created";
            case "join":

                Game game = gameServer.getLastGame();
                if (game != null) {
                    clientThread.setGame(game);
                    return "Joined game";

                } else {
                    return "No game to join";
                }
            case "move":

                if (parts.length == 3) {
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    Game currentGame = clientThread.getGame();
                    if (currentGame != null) {
                        String message = currentGame.submitMove(clientThread,x, y);
                        message += "\n" + currentGame.boardToString() + "\n<END>";
                        currentGame.printBoard();
                        return message;
                    } else {
                        return "No game to make a move in";
                    }
                } else {
                    return "Invalid command";
                }
            default:
                return "Unrecognized command";

        }
    }
}
