package com.example.laborator6;

import java.io.Serializable;

public class Dot implements Serializable {
    private double x;
    private double y;

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dot dot = (Dot) obj;
        return Double.compare(dot.x, x) == 0 && Double.compare(dot.y, y) == 0;
    }


}
