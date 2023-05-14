package org.example.model;

public class Board {
    private char[][] board;
    private static final int SIZE = 15;

    public Board() {
        this.board = new char[SIZE][SIZE];
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    board[i][j] = '_';
                }
            }
    }

    /**
     * Metoda marcheaza o mutare pe tabla cu simbolul player-ului ce a facut mutarea
     * @param x
     * @param y
     * @param player
     * @return
     */
    public boolean move(int x,int y,int player){
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && board[x][y] == '_') {
            if(player == 2)
            board[x][y] = 'x';
            else
                board[x][y] = 'o';
            return true;
        }
        return false;
    }

    /**
     * Metoda verifica daca un player a castigat facand 5 puncte intr-o linie (orizontala, verticala etc)
     * @param player
     * @return
     */
    public boolean checkWin(int player) {
        final int SIZE = 15;
        final int TARGET = 5;
        char[][] board = this.board;
        char symbol;
        if(player == 1){
             symbol =  'x';
        }else{
             symbol =  'o';
        }
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE - TARGET + 1; x++) {
                int i;
                for (i = 0; i < TARGET; i++) {
                    if (board[y][x + i] != symbol) {
                        break;
                    }
                }
                if (i == TARGET) {
                    return true;
                }
            }
        }

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE - TARGET + 1; y++) {
                int i;
                for (i = 0; i < TARGET; i++) {
                    if (board[y + i][x] != symbol) {
                        break;
                    }
                }
                if (i == TARGET) {
                    return true;
                }
            }
        }

        for (int x = 0; x < SIZE - TARGET + 1; x++) {
            for (int y = 0; y < SIZE - TARGET + 1; y++) {
                int i;
                for (i = 0; i < TARGET; i++) {
                    if (board[y + i][x + i] != symbol) {
                        break;
                    }
                }
                if (i == TARGET) {
                    return true;
                }
            }
        }

        for (int x = 0; x < SIZE - TARGET + 1; x++) {
            for (int y = TARGET - 1; y < SIZE; y++) {
                int i;
                for (i = 0; i < TARGET; i++) {
                    if (board[y - i][x + i] != symbol) {
                        break;
                    }
                }
                if (i == TARGET) {
                    return true;
                }
            }
        }

        return false;
    }

    public char[][] getBoard() {
        return board;
    }


}
