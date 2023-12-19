package model;

public abstract class FallingObject extends ImageObject{

	public FallingObject(String imagePath) {
		super(imagePath);
	}

        public abstract void caughtByClown();
}
