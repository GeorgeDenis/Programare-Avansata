package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokens;
    private boolean visited;

    public Cell() {
        tokens = new ArrayList<>();
        visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    /**
     * Fiecare celula reprezinta o lista de tokens
     * @param tokens
     */
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
        this.visited = true;
    }

}
