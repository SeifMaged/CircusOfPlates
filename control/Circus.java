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

    private final static int SCREENWIDTH = 800;
    private final static int SCREENHEIGHT = 600;
    private Strategy strategy;
    private final Factory factory = new RandomFallingObjectFactory();
    private final Clown clown;

    public Circus(Strategy strategy) {
        this.strategy = strategy;
        this.score = new Score();
        this.lives = new Lives(strategy.getLives());

        clown = Clown.getInstance();
        GameObjectContainer.controllable.add(clown);
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
        return SCREENWIDTH;
    }

    @Override
    public int getHeight() {
        return SCREENHEIGHT;
    }

// will be implmented.
    @Override
    public boolean refresh() {
        ListIterator list = new ListIterator(GameObjectContainer.movable);
        boolean flag = false;
        while (list.hasNext()) {

            FallingObject f = (FallingObject) list.next();
            intersectedWithMoving(f);

            if (f.getY() >= getHeight()) {
                reuseShapes(f);
            }

            f.caughtByClown(this);
        }

        if (lives.getlives() == 0 || isStackFull()) {
            flag = true;
        }

        int bombCounter = 0;
        for (var object : GameObjectContainer.movable) {
            if (object instanceof Bomb) {
            	bombCounter++;
            }
        }
        if (bombCounter > GameObjectContainer.movable.size() / 2 || GameObjectContainer.movable.size() < 7) {
            Factory();
        }
        
        if(strategy instanceof DefaultEasyStrategy defaultStrategy){
            defaultStrategy.increaseDifficulty(this);
        }
        if(strategy instanceof DefaultMediumStrategy defaultStrategy){
            defaultStrategy.increaseDifficulty(this);
        }

        return !flag;
    }

    private boolean isStackFull() {
        return GameObjectContainer.rightHand.size() > 18 && GameObjectContainer.leftHand.size() > 18;
    }

    public static int getScreenWidth() {
        return SCREENHEIGHT;
    }

    public static int getScreenHeight() {
        return SCREENHEIGHT;
    }

    public boolean intersect(GameObject object1, GameObject object2) {
        return RightAndLeftStack.intersect(object1, object2);
    }

    public void reuseShapes(GameObject p) {
        p.setY(-1 * (int) (Math.random() * getHeight()));
        p.setX((int) (Math.random() * getWidth()));

    }

    public void intersectedWithMoving(GameObject shape) {
        for (var obj : GameObjectContainer.movable) {
            if (shape != obj && intersect(shape, obj) && shape.getY() == 0 && (shape instanceof Shape)) {
                reuseShapes(obj);
            }
        }
    }

    @Override
    public String getStatus() {
        //notification that something has been changed (will be edited).
//        String right = "    right " + GameObjectContainer.rightHand.size();
//        if (!GameObjectContainer.rightHand.empty()) {
//            right += " " + ((Shape) GameObjectContainer.rightHand.peek()).getColor();
//        }
//        String left = "   left " + GameObjectContainer.leftHand.size();
//        if (!GameObjectContainer.leftHand.empty()) {
//            left += " " + ((Shape) GameObjectContainer.leftHand.peek()).getColor();
//        }

//        String control = "   control " + getControlSpeed();
//        String speed = "   speed " + getSpeed();
//            String str = "      Strategy " + strategy;
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
    public void Factory() {
        for (int i = 0; i < 20; i++) {
            GameObjectContainer.movable.add(factory.createFallingObject(getHeight(), getWidth(), strategy.getNumOfColors()));
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
