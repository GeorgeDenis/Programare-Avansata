package com.example.laborator6;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.image.WritableImage;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends StackPane {
    private Canvas canvas;
    private List<Dot> dotList;
    private List<Line> lineList;
    
    private Game game;

    public DrawPanel(double width, double height) {
        canvas = new Canvas(width, height);
        getChildren().add(canvas);
        dotList = new ArrayList<>();
        lineList = new ArrayList<>();
        this.game = new Game(lineList,dotList);
        canvas.setOnMouseClicked(this::handleClick);
    }
    public DrawPanel(double width, double height,Game game) {
        canvas = new Canvas(width, height);
        getChildren().add(canvas);
        this.game = game;
        dotList = game.getDots();
        lineList = game.getLines();
        canvas.setOnMouseClicked(this::handleClick);
    }

    public List<Dot> getDotList() {
        return dotList;
    }

    public List<Line> getLineList() {
        return lineList;
    }

    /**
     * Metoda inregistreaza un click pe ecran
     * Daca jocul e deja terminat, se va afisa un mesaj pe ecran
     * Salvam coordonatele click-ului
     * Vedem care este cea mai apropiata linie de coordonatele click-ului
     * Verificam daca colorarea este valida, daca da efectuam colorarea si verificam daca nu cumva s-a format un triunghi
     * Verificam daca nu cumva s-au colorat toate liniile si nu s-a format niciun triunghi, atunci afisam Draw
     * @param mouseEvent
     */
    private void handleClick(MouseEvent mouseEvent) {
        if (game.isGameOver()) {
            System.out.println("The game has ended!");
            return;
        }
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        Line closestLine = findClosestLine(x,y);
        if(game.isValidMove(closestLine)){
            game.makeMove(closestLine);
            if(game.isTriangleFormed())
            {
                System.out.println(game.getCurrentPlayer().opposite() + " wins!");
                game.setGameOver(true);
            }
        }
        if(!game.isGameOver())
        {
            int g = 0;
            for (Line line : lineList)
                if (line.getColor().equals(Color.GRAY))
                    g = 1;
            if (g == 0) {
                System.out.println("Draw!");
                game.setGameOver(true);
            }
        }
        paintComponent(getGraphicsContext());
    }

    public void reinitializeGame(Game game) {
        this.game = game;
        this.lineList = game.getLines();
        this.dotList = game.getDots();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Game getGame() {
        return game;
    }

    public GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }
    /**
     * Metoda care imi deseneaza punctele si liniile pe canvas, utilizand numarul de puncte si probabilitatea ca o linie sa fie intre 2 puncte
     * @param gc
     * @param dots numarul de puncte
     * @param lineProbability probabilitatea ca o linie sa fie intre 2 puncte
     */
    public void initializeBoard(GraphicsContext gc, int dots, double lineProbability) {
        game.setGameOver(false);

        if(dots < 0 || lineProbability < 0 || lineProbability > 1)
            throw new IllegalArgumentException("Argumente invalide: numarul de puncte trebuie > 0, probabilitatea ca o linie sa fie intre 2 puncte trebuie sa fie intre 0 si 1");
        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        dotList.clear();
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.8;

        for (int i = 0; i < dots; i++) {
            double angle = 2 * Math.PI * i / dots;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            dotList.add(new Dot(x,y));
        }
        lineList.clear();
        for (int i = 0; i < dots; i++) {
            for (int j = i + 1; j < dots; j++) {
                if (Math.random() <= lineProbability) {
                    lineList.add(new Line(dotList.get(i),dotList.get(j)));
                }
            }
        }
    }

    /**
     * Metoda imi gaseste cea mai apropiata linie de coordonatele unui click
     * @param x
     * @param y
     * @return
     */
    private Line findClosestLine(double x, double y) {
        Line closestLine = null;
        double minDistance = 999.99;

        for (Line line : lineList) {
            double distance = distanceFromPointToLine(x, y, line);

            if (distance < minDistance) {
                minDistance = distance;
                closestLine = line;
            }
        }

        return closestLine;
    }

    /**
     * Metoda calculeaza distanta de la click la o linie
     * @param x
     * @param y
     * @param line
     * @return
     */
    private double distanceFromPointToLine(double x, double y, Line line) {
        Dot A = line.getDot1();
        Dot B = line.getDot2();

        double dotProduct = (x - A.getX()) * (B.getX() - A.getX()) + (y - A.getY()) * (B.getY() - A.getY());
        double lenSquared = Math.pow(B.getX() - A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2);
        double t = Math.max(0, Math.min(1, dotProduct / lenSquared));

        double projX = A.getX() + t * (B.getX() - A.getX());
        double projY = A.getY() + t * (B.getY() - A.getY());

        return Math.sqrt(Math.pow(x - projX, 2) + Math.pow(y - projY, 2));
    }

    /**
     * Metoda deseneaza pe tabla punctele si liniile
     * @param gc
     */

    public void paintComponent(GraphicsContext gc){
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        for (Dot dot : dotList) {

            gc.setFill(Color.BLACK);
            gc.fillOval(dot.getX() - 5, dot.getY() - 5, 10, 10);

        }

        for (Line line : lineList) {
            gc.setLineWidth(6);
            gc.setStroke(line.getColor());
            gc.strokeLine(line.getDot1().getX(), line.getDot1().getY(), line.getDot2().getX(), line.getDot2().getY());
        }
    }

    /**
     * Metoda deseneaza punctele si liniile pe tabla, dar de data aceasta in contextul incarcarii unei salvari din folder
     * @param gc
     */
    public void rePaintComponent(GraphicsContext gc){
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        for (Dot dot : dotList) {

            gc.setFill(Color.BLACK);

            gc.fillOval(dot.getX() - 5, dot.getY() - 5, 10, 10);

        }

        for (Line line : lineList) {
            gc.setLineWidth(6);
            int colorPicker = line.getColorPicker();
            if(colorPicker == 0)
            {
                gc.setStroke(Color.GRAY);
                line.setColor(Color.GRAY);
            }
            else if(colorPicker == 1)
            {gc.setStroke(Color.RED);
                line.setColor(Color.RED);}
            else if(colorPicker == 2)
            {gc.setStroke(Color.BLUE);
                line.setColor(Color.BLUE);}

            gc.strokeLine(line.getDot1().getX(), line.getDot1().getY(), line.getDot2().getX(), line.getDot2().getY());
        }

    }

    /**
     * Metoda reseteaza un joc, setand jucatorul initial ca fiind cel RED, redesenand punctele si liniile
     */
    public void reset()
    {
        GraphicsContext gc = getGraphicsContext();
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        game.setCurrentPlayer(Player.RED);
        game.setGameOver(false);
        for (Dot dot : dotList) {

            gc.setFill(Color.BLACK);
            gc.fillOval(dot.getX() - 5, dot.getY() - 5, 10, 10);

        }
        for (Line line : lineList) {
            gc.setLineWidth(6);
            gc.setStroke(Color.GRAY);
            line.setColor(Color.GRAY);
            gc.strokeLine(line.getDot1().getX(), line.getDot1().getY(), line.getDot2().getX(), line.getDot2().getY());
        }
        game.setDots(dotList);
        game.setLines(lineList);
    }

    /**
     * Metoda salveaza in folder un Screenshot al jocului
     * @param filename
     */
    public void exportToPng(String filename) {
        // Create a snapshot of the current board state
        WritableImage snapshot = canvas.snapshot(new SnapshotParameters(), null);

        // Save the snapshot as a PNG file
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File(filename + ".png"));
        } catch (IOException ex) {
            System.err.println("Error exporting to PNG: " + ex.getMessage());
        }
    }
    public void save(String filename) throws IOException {
        game.saveToFile(filename);
    }
}

