package com.example.laborator6;

import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ControlPanel extends HBox {
    private Button loadButton;
    private Button saveButton;
    private Button resetButton;
    private Button exitButton;
    public ControlPanel(BorderPane root) {
        super();
        /**
         * Mi-am creat butoane de load, save, reset si exit
         */
         loadButton = new Button("Load");
         saveButton = new Button("Save");
         resetButton = new Button("Reset");
         exitButton = new Button("Exit");
         exitButton.setOnAction(e -> System.exit(0));
        getChildren().addAll(loadButton,saveButton,resetButton,exitButton);
        setAlignment(Pos.CENTER);
    }

    public Button getLoadButton() {
        return loadButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public Button getExitButton() {
        return exitButton;
    }


}
