package model;

import java.awt.Color;

public enum ShapeColor {
    RED(Color.RED),
    YELLOW(Color.YELLOW),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    BLACK(Color.BLACK);

    private final Color color;

    ShapeColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
