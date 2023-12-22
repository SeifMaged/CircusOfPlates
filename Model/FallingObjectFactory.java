package model;

import java.util.Random;

public class FallingObjectFactory {

    private static final Random random = new Random();
    /*
	 * Randomly Generates FallingObjects
     */
    public FallingObject createFallingObject(int height, int width) {
        int x = random.nextInt(Math.abs(width - 80));
        int y = random.nextInt(Math.abs(height / 2)) - height / 2;
        int shapeType = random.nextInt(5) + 1;
        int colorChooser = random.nextInt(5) + 1;
        ShapeColor color = null;
        FallingObject fallingObject;

        switch (colorChooser) {
            case 1 ->
                color = ShapeColor.RED;
            case 2 ->
                color = ShapeColor.YELLOW;
            case 3 ->
                color = ShapeColor.BLUE;
            case 4 ->
                color = ShapeColor.BLACK;
            case 5 ->
                color = ShapeColor.GREEN;
        }

        switch (shapeType) {

            case 1 -> {
                fallingObject = new Plate(x, y, color);
                break;
            }

            case 2 -> {
                fallingObject = new Bomb(x, y);
                break;
            }
            case 3 -> {
                fallingObject = new Gift(x, y);
                break;
            }

            case 4 -> {
                fallingObject = new Plate(x, y, color);
                break;
            }

            case 5 -> {
                fallingObject = new Plate(x, y, color);
                break;
            }
            default -> {
                fallingObject = new Plate(x, y, color);
            }

        }

        return fallingObject;
    }

}
