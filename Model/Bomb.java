package model;

public class Bomb extends FallingObject{

	private static final String IMAGE_PATH = "bomb.png";
	public Bomb(int x, int y) {
		super(IMAGE_PATH);
		setX(x);
		setY(y);
	}
	
}
