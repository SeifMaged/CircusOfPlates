package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.List;
import model.*;

/**
 *
 * @author Adham
 */
public class Circus implements World, Observer {

    private final String backgroundFile = "src/resources/background.png";
    private final Score score;
    private final Lives lives;

    private final static int screenWidth = 800;
    private final static int screenHeight = 600;
    private Strategy strategy;
    private final FallingObjectFactory Ourfactory = new FallingObjectFactory();
    private final Clown clown;

    public Circus(Strategy strategy) {
        this.strategy = strategy;
        this.score = new Score();
        this.lives = new Lives(strategy.getLives());

        clown = Clown.getInstance();
        GameObjectContainer.controllable.add(clown);

        Factory();
        this.score.subscribe(this);
        this.lives.subscribe(this);
        GameObjectContainer.constant.add(new BackGround(backgroundFile));
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return GameObjectContainer.constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return GameObjectContainer.movable;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return GameObjectContainer.controllable;
    }

    @Override
    public int getWidth() {
        return screenWidth;
    }

    @Override
    public int getHeight() {
        return screenHeight;
    }

// will be implmented.
    @Override
    public boolean refresh() {
        ListIterator list = new ListIterator(GameObjectContainer.movable);
        boolean flag = false;
        while (list.hasNext()) {

            FallingObject go = (FallingObject) list.next();
            //RightAndLeftStack.checkIntersect(go, clown);

            if (go.getY() == getHeight()) {
                reuseShapes(go);
            }

            go.caughtByClown(this);
        }

        if (lives.getlives() == 0 || isStackFull()) {
            flag = true;

        }

        int nonShapeCounter = 0;
        for (var object : GameObjectContainer.movable) {
            if (!(object instanceof Shape)) {
                nonShapeCounter++;
            }
        }
        if (nonShapeCounter > GameObjectContainer.movable.size() / 2 || GameObjectContainer.movable.size() < 7) {
            Factory();
        }

        if (getScore().getScore() > 8) {
            setStrategy(new Medium());
        }

        if (getScore().getScore() > 20) {
            setStrategy(new Hard());
        }

        return !flag;
    }

    private boolean isStackFull() {
        return GameObjectContainer.rightHand.size() > 18 && GameObjectContainer.leftHand.size() > 18;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public boolean intersect(GameObject object1, GameObject object2) {
        return RightAndLeftStack.intersect(object1, object2);
    }

    void reuseShapes(GameObject p) {

        p.setY(-1 * (int) (Math.random() * getHeight()));
        p.setX((int) (Math.random() * getWidth()));

    }

//    public void intersectedWithMoving(GameObject x) {
//        ListIterator l = new ListIterator(GameObjectContainer.movable);
//        while (l.hasNext()) {
//            GameObject gameObject = l.next();
//            if (x != gameObject && intersect(x, gameObject) && x.getY() == 0 && !(x instanceof Bomb) && !(x instanceof Gift)) {
//                reuseShapes(gameObject);
//            }
//        }
//    }
    @Override
    public String getStatus() {
        //notification that something has been changed (will be edited).
        return "Score: " + score.getScore() + "  |   Lives: " + lives.getlives();
    }

    @Override
    public int getSpeed() {
        return this.strategy.getObjectSpeed();
    }

    @Override
    public int getControlSpeed() {
        return this.strategy.getControlSpeed();
    }

    ////////// edit the factory 
    private void Factory() {
        for (int i = 0; i < 20; i++) {
            GameObjectContainer.movable.add(Ourfactory.createFallingObject(getHeight(), getWidth()));
        }
    }

    public Score getScore() {
        return score;
    }

    public Lives getLives() {
        return lives;
    }

    public void setStrategy(Strategy s) {
        this.strategy = s;
    }

}
