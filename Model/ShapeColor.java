package model;

import java.awt.Color;

public enum ShapeColor {
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE);

    private final Color color;

    ShapeColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
