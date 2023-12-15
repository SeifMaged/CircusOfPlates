package model;

public class Plate extends Shape{

	private static final String imagePath = "plate.png";
	public Plate(int x, int y,ShapeColor shapeColor) {
		super(x, y, shapeColor, imagePath);
	}

}
