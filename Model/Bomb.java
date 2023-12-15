package model;

public class Bomb extends ImageObject{

	private static final String imagePath = "bomb.png";
	public Bomb(int x, int y) {
		super(imagePath);
		setX(x);
		setY(y);
	}
	
}
