package com.example.laborator6;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ConfigPanel extends HBox{
    private TextField dotsInput;
    private TextField linesInput;
    private Button createButton;

    public ConfigPanel()
    {
        /**
         * Configuration Panel
         */
       super(10);//grupeaza toate obiectele din el pe orizontala(horizontal box)

        Label dotsLabel = new Label("Number of dots: ");
        dotsInput = new TextField();
        Label linesPanel = new Label("Lines probability: ");
        linesInput = new TextField();
        createButton = new Button("Create new game");
        getChildren().addAll(dotsLabel,dotsInput,linesPanel,linesInput,createButton);

        setAlignment(Pos.CENTER);

    }

    public TextField getDotsInput() {
        return dotsInput;
    }

    public TextField getLinesInput() {
        return linesInput;
    }

    public Button getCreateButton() {
        return createButton;
    }
}
