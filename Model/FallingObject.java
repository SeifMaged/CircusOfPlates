package model;

import control.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class FallingObject extends ImageObject{

	public FallingObject(String imagePath) {
		super(imagePath);
	}

        public abstract void caughtByClown(Circus game);
}
