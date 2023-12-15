package model;

public interface ShapeFactory {

	public Shape createShape(int x, int y, ShapeColor shapeColor, String imagePath);
}
