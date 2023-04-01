package com.example.laborator6;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class Line implements Serializable {
    private Dot dot1;
    private Dot dot2;
    private transient Color color;
    private int colorPicker;

    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.color = Color.GRAY;
    }

    public Dot getDot1() {
        return dot1;
    }
    public Dot getDot2() {
        return dot2;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        if(color.equals(Color.GRAY))
            colorPicker = 0;
        else if(color.equals(Color.RED))
            colorPicker = 1;
        else if (color.equals(Color.BLUE))
            colorPicker= 2;
    }

    public int getColorPicker() {
        return colorPicker;
    }

    /**
     * metoda verifica daca daca 2 linii sunt conectate
     * @param line2
     * @return
     */
    public boolean connectsTo(Line line2) {
        if(dot1.equals(line2.getDot1()) || dot1.equals(line2.getDot2()) || dot2.equals(line2.getDot1()) || dot2.equals(line2.getDot2()))
        {
            return true;
        }
        else
            return false;
    }

    /**
     * Metoda verifica ce punct comun au doua linii
     * @param other
     * @return
     */
    public Dot getSharedDot(Line other) {
        if (this.dot1.equals(other.dot1) || this.dot1.equals(other.dot2)) {
            return this.dot1;
        } else if (this.dot2.equals(other.dot1) || this.dot2.equals(other.dot2)) {
            return this.dot2;
        } else {
            return null;
        }
    }

}
