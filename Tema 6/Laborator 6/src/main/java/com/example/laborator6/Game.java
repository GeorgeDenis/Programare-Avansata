package com.example.laborator6;

import javafx.scene.paint.Color;

import java.io.*;
import java.util.List;

public class Game implements Serializable {
    private Player currentPlayer;
    private List<Line> lines;
    private List<Dot> dots;

    private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Game(List<Line> lines,List<Dot> dots)
    {
        this.currentPlayer = Player.RED;
        this.lines = lines;
        this.dots = dots;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Dot> getDots() {
        return dots;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void setDots(List<Dot> dots) {
        this.dots = dots;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Verifica daca mutarea pe care vrea sa o faca player-ul este valida, adica sa nu fie colorata deja cu RED sau BLUE
     * @param line linia pe care vrem sa o coloram
     * @return true daca linia este GRAY, altfel false
     */
    public boolean isValidMove(Line line)
    {
        return line.getColor() == Color.GRAY;
    }

    /**
     * Metoda verifica mai intai daca colorarea este valida, iar apoi coloreaza linia cu, culoarea jucatorului ce a facut mutarea, urmand sa schimbe jucatorul
     * @param line linia pe care vrea sa o coloreze jucatorul
     */
    public void makeMove(Line line)
    {
        if(isValidMove(line))
        {
            line.setColor(currentPlayer.getColor());
            currentPlayer = currentPlayer.opposite();
        }
    }

    /**
     * Metoda verifica daca nu cumva s-a format un triunghi de aceeasi culoare pe tabla
     * @return true daca s-a format un triunghi de aceeasi culoare, altfel false
     */
    public boolean isTriangleFormed() {
        for (int i = 0; i < lines.size(); i++) {
            Line line1 = lines.get(i);
            for (int j = i + 1; j < lines.size(); j++) {
                Line line2 = lines.get(j);
                for (int k = j + 1; k < lines.size(); k++) {
                    Line line3 = lines.get(k);
                    if (line1.getColor() == line2.getColor() && line2.getColor() == line3.getColor() &&
                            line1.getColor() != Color.GRAY && line1.connectsTo(line2) && line2.connectsTo(line3) && line3.connectsTo(line1)) {

                        Dot sharedDot1 = line1.getSharedDot(line2);
                        Dot sharedDot2 = line2.getSharedDot(line3);
                        Dot sharedDot3 = line3.getSharedDot(line1);

                        if (sharedDot1 != null && sharedDot2 != null && sharedDot3 != null && !sharedDot1.equals(sharedDot2) && !sharedDot2.equals(sharedDot3) && !sharedDot3.equals(sharedDot1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Metoda salveaza in folder starea curenta a jocului, salvand obiectele
     * @param fileName numele salvarii
     * @throws IOException
     */
    public void saveToFile(String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    /**
     * Metoda incarca din folder salvarea unei stari precedente a jocului
     * @param fileName numele salvarii
     * @return o instanta a clasei game, ce semnifica salvarea
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Game loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Game game = (Game) ois.readObject();
        ois.close();
        return game;
    }


}
