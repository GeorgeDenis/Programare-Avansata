package org.example.model;

public class Player {
    private String name;
    private int number;
    private int timeLeft;

    public Player(String name, int number, int timeLeft) {
        this.name = name;
        this.number = number;
        this.timeLeft = timeLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
