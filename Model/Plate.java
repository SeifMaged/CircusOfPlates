package model;

public class Plate extends Shape{

	private static final String IMAGE_PATH = "src/resources/plate.png";
	public Plate(int x, int y,ShapeColor shapeColor) {
		super(x, y, shapeColor, IMAGE_PATH);
	}

}
