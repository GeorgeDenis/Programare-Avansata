package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        long timeLimit = 100_000;
        Exploration explore = new Exploration(n);
        Robot wallE = new Robot("Wall-E",0,0,explore);
        Robot r2d2 = new Robot("R2D2",n-1,n-1,explore);
        Robot optimus = new Robot("Optimus Prime",0,n-1,explore);

        explore.addRobot(wallE);
        explore.addRobot(r2d2);
        explore.addRobot(optimus);
        explore.start();
        explore.startTimekeeper(timeLimit);
        Scanner scanner = new Scanner(System.in);
        while (!explore.getMap().allCellsVisited()) {
            System.out.print("Alegeti o comanda:\n1.Start All\n2.Start by id\n3.Pause All\n4.Pause by id\n5.Exit\n");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1 -> explore.resumeRobots();
                case 2 -> {
                    System.out.println("Introduceti numele robotului: ");
                    String resumeName = scanner.nextLine();
                    explore.resumeRobotByName(resumeName);
                }
                case 3 -> {
                    System.out.println("Introduceti durata pauzei in milisecunde(0 pentru pauza ce necesita resume): ");
                    long timePausedAll = scanner.nextLong();
                    explore.pauseRobots(timePausedAll);
                }
                case 4 -> {
                    System.out.println("Introduceti numele robotului: ");
                    String pauseName = scanner.nextLine();
                    System.out.println("Introduceti durata pauzei in milisecunde(0 pentru pauza ce necesita resume): ");
                    long timePaused = scanner.nextLong();
                    explore.pauseRobotByName(pauseName, timePaused);
                }
                case 5 -> System.exit(0);
                case 6 -> explore.printTokensByRobot();
                default -> System.out.println("Comanda invalida");
            }

        }
        explore.printTokensByRobot();
    }

}