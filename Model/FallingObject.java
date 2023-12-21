package model;

import control.Circus;

public abstract class FallingObject extends ImageObject{

	public FallingObject(String imagePath) {
		super(imagePath);
                this.horizontalOnly=false;
	}

        public abstract void caughtByClown(Circus game);
}
