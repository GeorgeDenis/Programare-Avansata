package com.example.laborator6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main extends Application {
    private Canvas canvas;
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawPanel drawPanel;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);//e toata interfata efectiv

        drawPanel = new DrawPanel(600,400);

        canvas = drawPanel.getCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        configPanel = new ConfigPanel();
        root.setTop(configPanel);

        controlPanel = new ControlPanel(root);
        root.setBottom(controlPanel);
        /**
         * Adaugam functionalitate butonului de Create New Game
         */
        configPanel.getCreateButton().setOnAction(e -> {
            try{
                int dots = Integer.parseInt(configPanel.getDotsInput().getValue().toString());
                double lineProbability = Double.parseDouble(configPanel.getLinesInput().getValue().toString());
                if (dots < 0 || lineProbability < 0 || lineProbability > 1) {
                    throw new IllegalArgumentException("Argumente invalide: numarul de puncte trebuie > 0, probabilitatea ca o linie sa fie intre 2 puncte trebuie sa fie intre 0 si 1");
                }
                drawPanel.initializeBoard(gc, dots,lineProbability);
                drawPanel.paintComponent(gc);
            } catch (NumberFormatException ex) {
                System.err.println("Numerele introduse sunt invalide");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        });
        /**
         * Adaugam functionalitate butonului de reset
         */
        controlPanel.getResetButton().setOnAction(f ->{
                drawPanel.reset();
            });
        /**
         * Adaugam functionalitate butonului de Save
         * Salveaza un joc in folder
         */
            controlPanel.getSaveButton().setOnAction( d ->{
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                    Date date = new Date();
                    drawPanel.exportToPng(dateFormat.format(date));
                    drawPanel.save("save");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        /**
         * Adaugam functionalitate butonului de Load
         * Incarca o salvare din folder
         */
            controlPanel.getLoadButton().setOnAction(event -> {
                try {
                    Game savedGame = Game.loadFromFile("save");

                    drawPanel.reinitializeGame(savedGame);
                    drawPanel.rePaintComponent(drawPanel.getGraphicsContext());
                } catch (IOException | ClassNotFoundException ex) {
                    System.err.println("Error loading game data: " + ex.getMessage());
                }
            });


        primaryStage.setTitle("Triangle Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
}

