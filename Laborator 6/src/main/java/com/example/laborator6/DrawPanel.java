package com.example.laborator6;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class DrawPanel extends StackPane {
    private Canvas canvas;

    public DrawPanel(double width, double height) {
        canvas = new Canvas(width, height);
        getChildren().add(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }
    /**
     * Metoda care imi deseneaza punctele si liniile pe canvas, utilizand numarul de puncte si probabilitatea ca o linie sa fie intre 2 puncte
     * @param gc
     * @param dots
     * @param lineProbability
     */
    public void paintComponent(GraphicsContext gc, int dots, double lineProbability) {

        if(dots < 0 || lineProbability < 0 || lineProbability > 1)
            throw new IllegalArgumentException("Argumente invalide: numarul de puncte trebuie > 0, probabilitatea ca o linie sa fie intre 2 puncte trebuie sa fie intre 0 si 1");
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.8;

        // Calculate and store the positions of the dots
        double[] dotX = new double[dots];
        double[] dotY = new double[dots];
        for (int i = 0; i < dots; i++) {
            double angle = 2 * Math.PI * i / dots;
            dotX[i] = centerX + radius * Math.cos(angle);
            dotY[i] = centerY + radius * Math.sin(angle);

            // Draw the dot
            gc.setFill(Color.BLACK);
            gc.fillOval(dotX[i] - 5, dotY[i] - 5, 10, 10);
        }

        // Draw the lines
        gc.setStroke(Color.GRAY);
        for (int i = 0; i < dots; i++) {
            for (int j = i + 1; j < dots; j++) {
                if (Math.random() <= lineProbability) {
                    gc.strokeLine(dotX[i], dotY[i], dotX[j], dotY[j]);
                }
            }
        }
    }
}

