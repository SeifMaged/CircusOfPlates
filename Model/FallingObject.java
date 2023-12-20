package model;

public abstract class FallingObject extends ImageObject{

	public FallingObject(String imagePath) {
		super(imagePath);
                this.horizontalOnly=false;
	}

        public abstract void caughtByClown();
}
