package org.example.model;

import org.example.ClientThread;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private int currentPlayer;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = 1;
    }

    public String submitMove(ClientThread client, int x, int y) {
        if (client.getPlayer().getNumber() == currentPlayer) {
            board.move(x, y, currentPlayer);
            if (board.checkWin(currentPlayer)) {
                return "Player " + currentPlayer + " has won!";
            } else {
                currentPlayer = 3 - currentPlayer;
                return "Player " + currentPlayer + "'s turn";
            }
        }else{
            return "It's not your turn";
        }

    }

    public void printBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(board.getBoard()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String boardToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                builder.append(board.getBoard()[i][j]);
                builder.append(" ");
            }
                builder.append("\n");
        }
        return builder.toString();
    }
    public int getCurrentPlayerRemainingTime() {
        return currentPlayer == 1 ? player1.getTimeLeft() : player2.getTimeLeft();
    }
    public void decreaseCurrentPlayerTime(int timeSpent) {
        if (currentPlayer == 1) {
            player1.setTimeLeft(player1.getTimeLeft() - timeSpent);
        } else {
            player2.setTimeLeft(player2.getTimeLeft() - timeSpent);
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

}
