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
    public void move(int x,int y,int player){
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && board[x][y] == '_') {
            if(player == 2)
            board[x][y] = 'x';
            else
                board[x][y] = 'o';
        }
    }
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
        // Check horizontal lines
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

        // Check vertical lines
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

        // Check forward diagonals
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

        // Check backward diagonals
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
