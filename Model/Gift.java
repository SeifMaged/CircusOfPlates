package model;

public class Gift extends ImageObject implements FallingObject{

	private static final String IMAGE_PATH = "gift.png";
	public Gift(int x, int y) {
		super(IMAGE_PATH);
		setX(x);
		setY(y);
	}
	
}
