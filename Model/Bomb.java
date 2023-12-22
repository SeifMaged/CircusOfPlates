package model;

import control.Circus;
import control.GameObjectContainer;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Stack;
import view.LevelsFrame;

public class Bomb extends FallingObject {

    private static final String IMAGE_PATH = "src/resources/bomb.png";
    private static final String IMAGE_PATH2 = "src/resources/bomb2.png";
    
    private BackGround bomb = new BackGround(IMAGE_PATH2);

    public Bomb(int x, int y) {
        super(IMAGE_PATH);
        setX(x);
        setY(y);
        GameObjectContainer.constant.add(bomb);
        bomb.setVisible(false);
    }

    @Override
    public void caughtByClown(Circus game) {
        this.handleMoving();
        if (!GameObjectContainer.leftHand.isEmpty() && game.intersect(this, GameObjectContainer.leftHand.peek())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);
            GameObjectContainer.controllable.remove(GameObjectContainer.leftHand.pop());
            freeze();
        }
        if (!GameObjectContainer.rightHand.isEmpty() && game.intersect(this, GameObjectContainer.rightHand.peek())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);
            GameObjectContainer.controllable.remove(GameObjectContainer.rightHand.pop());
            freeze();
        }
    }

    private void freeze() {
        LevelsFrame.getController().pause();
        //bomb.setVisible(true);

        
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }

        //bomb.setVisible(false);

        
        
        LevelsFrame.getController().resume();
    }

}
