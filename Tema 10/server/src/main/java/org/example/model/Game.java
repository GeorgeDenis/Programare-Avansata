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

    /**
     * Metoda face o mutare si verifica daca nu cumva cineva a castigat
     * @param client
     * @param x
     * @param y
     * @return
     */
    public String submitMove(ClientThread client, int x, int y) {
        if (board.checkWin(currentPlayer)) {
            int oppositePlayer = 3 - currentPlayer;
            return "Player " + oppositePlayer + " has won!";
        } else if (board.checkWin(currentPlayer)) {
             currentPlayer = 3 - currentPlayer;
            return "Player " + currentPlayer + " has won!";
        } else {
            if (client.getPlayer().getNumber() == currentPlayer) {
                boolean cond = board.move(x, y, currentPlayer);
                if (cond) {
                    if (board.checkWin(currentPlayer)) {
                        currentPlayer = 3 - currentPlayer;
                        return "Player " + currentPlayer + " has won!";
                    } else {
                        currentPlayer = 3 - currentPlayer;
                        return "Player " + currentPlayer + "'s turn";
                    }
                } else {
                    return "Invalid move!";
                }
            } else {
                return "It's not your turn";
            }
        }
    }

    /**
     * Metoda converteste board-ul de joc intr-un String pentru a fi afisat
     * @return
     */
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
