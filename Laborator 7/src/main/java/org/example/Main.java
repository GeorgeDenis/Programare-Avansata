package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        Exploration explore = new Exploration(n);
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

}