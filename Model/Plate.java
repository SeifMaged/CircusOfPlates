package model;

public class Plate extends Shape{

	private static final String imagePath = "black bar.png";
	public Plate(int x, int y,ShapeColor shapeColor) {
		super(x, y, shapeColor, imagePath);
	}

}
