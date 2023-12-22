package model;

import java.util.Random;

public class FallingObjectFactory {

    private static final Random random = new Random();

    /*
	 * Randomly Generates FallingObjects
     */
    public FallingObject createFallingObject(int height, int width, int numColor) {
        int x = random.nextInt(Math.abs(width - 80));
        int y = random.nextInt(Math.abs(height / 2)) - height / 2;
        int shapeType = random.nextInt(10);
        int colorChooser = random.nextInt(numColor);
        ShapeColor color;

        switch (colorChooser) {
            case 0 ->
                color = ShapeColor.RED;
            case 1 ->
                color = ShapeColor.YELLOW;
            case 2 ->
                color = ShapeColor.BLUE;
            case 3 ->
                color = ShapeColor.BLACK;
            case 4 ->
                color = ShapeColor.GREEN;
            default -> {
                color = ShapeColor.RED;
            }
        }

        switch (shapeType) {
            case 0, 5, 6 -> {
                return new Plate(x, y, color);
            }
            case 1, 4, 9 -> {
                return new Candy(x, y, color);
            }
            case 2, 8 -> {
                return new Bomb(x, y);
            }
            case 3, 7 -> {
                return new Gift(x, y);
            }
        }
        return new Plate(x, y, color);
    }

}
