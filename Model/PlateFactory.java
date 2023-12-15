package model;

public class PlateFactory implements ShapeFactory{

	@Override
	public Shape createShape(int x, int y, ShapeColor shapeColor, String imagePath) {
		return new Plate(x,y,shapeColor);
	}

}
