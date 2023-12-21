package model;

import control.Circus;
import control.GameObjectContainer;

public class Gift extends FallingObject {

    private static final String IMAGE_PATH = "src/resources/gift.png";

    public Gift(int x, int y) {
        super(IMAGE_PATH);
        setX(x);
        setY(y);
    }

    @Override
    public void caughtByClown(Circus game) {
        this.handleMoving();

        if (!GameObjectContainer.leftHand.isEmpty() && game.intersect(this, GameObjectContainer.leftHand.peek())) {
            GameObjectContainer.movable.remove(this);
            game.getScore().increaseScore(2);
        }
        if (!GameObjectContainer.rightHand.isEmpty() && game.intersect(this, GameObjectContainer.rightHand.peek())) {
            GameObjectContainer.movable.remove(this);
            game.getScore().increaseScore(2);
        }
        if(game.intersect(this, Clown.getInstance())){
            GameObjectContainer.movable.remove(this);
            game.getScore().increaseScore(2);
        }
    }

}
