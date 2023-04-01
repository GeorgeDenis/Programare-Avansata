package com.example.laborator6;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ConfigPanel extends HBox{
    private ComboBox<Double> linesInput;
    private Button createButton;
    private Spinner<Integer> dotsInput;


    public ConfigPanel()
    {
        /**
         * Configuration Panel
         */
       super(10);//grupeaza toate obiectele din el pe orizontala(horizontal box)

        Label dotsLabel = new Label("Number of dots: ");
        dotsInput = new Spinner<>(1,10,1);
        dotsInput.setEditable(true);

        Label linesPanel = new Label("Lines probability: ");
        linesInput = new ComboBox<>(FXCollections.observableArrayList(0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0));
        linesInput.getSelectionModel().selectLast();


        createButton = new Button("Create new game");
        getChildren().addAll(dotsLabel,dotsInput,linesPanel,linesInput,createButton);

        setAlignment(Pos.CENTER);

    }

    public Spinner<Integer> getDotsInput() {
        return dotsInput;
    }

    public ComboBox<Double> getLinesInput() {
        return linesInput;
    }

    public Button getCreateButton() {
        return createButton;
    }
}
