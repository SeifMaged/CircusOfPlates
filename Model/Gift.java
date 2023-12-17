package model;

public class Gift extends FallingObject{

	private static final String IMAGE_PATH = "src/resources/gift.png";
	public Gift(int x, int y) {
		super(IMAGE_PATH);
		setX(x);
		setY(y);
	}
	
}
