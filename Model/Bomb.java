package model;

import control.Circus;
import control.GameObjectContainer;
import view.LevelsFrame;

public class Bomb extends FallingObject {

    private static final String IMAGE_PATH = "src/resources/bomb.png";
    public Bomb(int x, int y) {
        super(IMAGE_PATH);
        setX(x);
        setY(y);
    }

    @Override
    public void caughtByClown(Circus game) {
        this.handleMoving();
        if (!GameObjectContainer.leftHand.isEmpty() && game.intersect(this, GameObjectContainer.leftHand.peek())) {
            game.getLives().decreaseLives(1);
            GameObjectContainer.controllable.remove(GameObjectContainer.leftHand.pop());
            freeze();
        }
        if (!GameObjectContainer.rightHand.isEmpty() && game.intersect(this, GameObjectContainer.rightHand.peek())) {
            game.getLives().decreaseLives(1);
            GameObjectContainer.controllable.remove(GameObjectContainer.rightHand.pop());
            freeze();
        }
    }

    private void freeze() {
        LevelsFrame.getController().pause();
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
        }
        GameObjectContainer.movable.remove(this);
        this.setVisible(false);
        LevelsFrame.getController().resume();
    }
    
}
