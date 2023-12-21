package model;

public class Candy extends Shape{

	private static final String IMAGE_PATH = "src/resources/candy.png";
	public Candy(int x, int y,ShapeColor shapeColor) {
		super(x, y, shapeColor, IMAGE_PATH);
	}

}
