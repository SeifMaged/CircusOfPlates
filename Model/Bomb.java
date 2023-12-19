package model;

import control.Circus;
import control.GameObjectContainer;

public class Bomb extends FallingObject {

    private static final String IMAGE_PATH = "src/resources/bomb.png";

    public Bomb(int x, int y) {
        super(IMAGE_PATH);
        setX(x);
        setY(y);
    }

    @Override
    public void caughtByClown() {
        this.handleMoving();
        Circus game = Circus.getInstance();
        if (!GameObjectContainer.leftHand.isEmpty() && game.intersect(this, GameObjectContainer.leftHand.peek())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);

        }
        if (!GameObjectContainer.rightHand.isEmpty() && game.intersect(this, GameObjectContainer.rightHand.peek())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);
        }
        if (game.intersect(this, Clown.getInstance())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);
        }

    }

}
