package com.example.laborator6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Main extends Application {
    private Canvas canvas;
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawPanel drawPanel;
    private int lines;
    private int dots;

    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 800, 600);//e toata interfata efectiv

            drawPanel = new DrawPanel(800,400);

            canvas = drawPanel.getCanvas();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            root.setCenter(canvas);

            configPanel = new ConfigPanel();
            root.setTop(configPanel);

            controlPanel = new ControlPanel(root);
            root.setBottom(controlPanel);

        configPanel.getCreateButton().setOnAction(e -> {
            try{
                int dots = Integer.parseInt(configPanel.getDotsInput().getText());
                double lineProbability = Double.parseDouble(configPanel.getLinesInput().getText());
                if (dots < 0 || lineProbability < 0 || lineProbability > 1) {
                    throw new IllegalArgumentException("Argumente invalide: numarul de puncte trebuie > 0, probabilitatea ca o linie sa fie intre 2 puncte trebuie sa fie intre 0 si 1");
                }
                drawPanel.paintComponent(gc, dots,lineProbability);
            } catch (NumberFormatException ex) {
                System.err.println("Numerele introduse sunt invalide");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }


        });

        primaryStage.setTitle("Triangle Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        }




}

