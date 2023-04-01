package com.example.laborator6;

import javafx.scene.paint.Color;

public enum Player {
    RED(Color.RED),
    BLUE(Color.BLUE);
    private final Color color;
    Player(Color color)
    {
        this.color = color;
    }

    public  Color getColor(){
        return color;
    }
    public Player opposite() {
        return this == RED ? BLUE : RED;
    }
}
