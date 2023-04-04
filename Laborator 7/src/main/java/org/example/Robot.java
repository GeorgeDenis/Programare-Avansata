package org.example;

import java.util.List;
import java.util.Random;

public class Robot implements Runnable{
    private String name;
    private boolean running;
    private boolean paused;
    private int row;
    private int col;
    private Random random;
    Exploration explore;
    public Robot(String name) {
        this.name = name;
        this.running = true;
        this.paused = false;
        this.random = new Random();
    }
    public void setExploration(Exploration explore) {
        this.explore = explore;
    }

    public String getName() {
        return name;
    }

    public Exploration getExplore() {
        return explore;
    }
    public List<Token> extractTokens(){
        return explore.getMem().extractTokens(explore.getMapSize());
    }
    public void pauseRobot(){
        this.paused = true;
    }
    public void resumeRobot(){
        this.paused = false;
    }

    /**
     * Metoda muta robotul cu valori de -1, 0, 1 ceea ce poate insemna un pas in spate, sa ramana pe loc sau sa mearga in fata(difera de la linie la coloana)
     */
    private void move(){
        int n = explore.getMapSize();
        int newRow = row + random.nextInt(3)-1;
        int newCol = col + random.nextInt(3)-1;
        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
            row = newRow;
            col = newCol;
        }
    }

    /**
     * Metoda verifica daca procesul este functional si daca nu este pus pe pauza, muta robotii si exploreaza harta marcand celulele vizitate, fiecare robot are un thread
     */
    @Override
    public void run() {
        while (running) {
            if (!paused) {
                move();
                explore.getMap().visit(row, col, this);
                if (explore.getMap().allCellsVisited()) {
                    running = false;
                }
                try {
                    Thread.sleep(random.nextInt(1000) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
