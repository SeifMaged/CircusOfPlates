package model;

import control.Circus;
import control.GameObjectContainer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.LevelsFrame;

public class Bomb extends FallingObject {

    private static final String IMAGE_PATH = "src/resources/bomb.png";
    private static final String IMAGE_PATH2 = "src/resources/bomb2.png";

    public Bomb(int x, int y) {
        super(IMAGE_PATH);
        setX(x);
        setY(y);
    }

    @Override
    public void caughtByClown(Circus game) {
        this.handleMoving();
        if (!GameObjectContainer.leftHand.isEmpty() && game.intersect(this, GameObjectContainer.leftHand.peek())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);
            freeze();
        }
        if (!GameObjectContainer.rightHand.isEmpty() && game.intersect(this, GameObjectContainer.rightHand.peek())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);
            freeze();
        }
        if (game.intersect(this, Clown.getInstance())) {
            GameObjectContainer.movable.remove(this);
            this.setVisible(false);
            game.getLives().decreaseLives(1);
            freeze();
        }
    }

    private void freeze() {
        LevelsFrame.getController().pause();

        setImage(IMAGE_PATH2);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }

        setImage(IMAGE_PATH);

        LevelsFrame.getController().resume();
    }

    private void setImage(String imagePath) {
        image = new BufferedImage[2];
        try {
            this.sourceImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            this.sourceImage = null;
        }
        this.image[0] = this.sourceImage;
    }

}
