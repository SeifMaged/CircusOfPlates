package model;

public class Gift extends ImageObject{

	private static final String imagePath = "gift.png";
	public Gift(int x, int y) {
		super(imagePath);
		setX(x);
		setY(y);
	}
	
}
