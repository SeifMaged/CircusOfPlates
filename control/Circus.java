package control;

import model.Strategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.List;
import model.*;

/**
 *
 * @author Adham
 */
public class Circus implements World, Observer {

    private final Score score = new Score();
    private final Lives lives = new Lives();

    private final int screenWidth;
    private final int screenHeight;
    private Strategy strategy;
    private final FallingObjectFactory Ourfactory = new FallingObjectFactory();
    private final Clown clown;

    public Circus(int width, int height, Strategy strategy) {
        this.screenWidth = width;
        this.screenHeight = height;
        this.strategy = strategy;
        
        clown = Clown.getInstance((int) (screenWidth * 0.4), (int) (screenHeight * 0.64), "src/resources/clown.png");
        GameObjectContainer.controllable.add(clown);
        
        Factory();
        this.score.subscribe(this);
        this.lives.subscribe(this);
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
        return this.screenWidth;
    }

    @Override
    public int getHeight() {
        return this.screenHeight;
    }

// will be implmented.
    @Override
    public boolean refresh() {
        ListIterator list = new ListIterator(GameObjectContainer.movable);
        boolean flag = false;
        while (list.hasNext()) {

            FallingObject go = (FallingObject)list.next();
            intersectedWithMoving(go);

            if (go.getY() == getHeight()) {
                reusePlates(go);
            }
            
            go.caughtByClown(this);
        }

        if (lives.getlives() == 0) {
            flag = true;
        }
        return !flag;
    }

    public boolean intersect(GameObject object1, GameObject object2) {
        double o1CenterX = object1.getX() + object1.getWidth() / 2;
        double o1CenterY = object1.getY() + object1.getHeight() / 2;

        double o2CenterX = object2.getX() + object2.getWidth() / 2;
        double o2CenterY = object2.getY() + object2.getHeight() / 2;

        double horizontalDistance = Math.abs(o1CenterX - o2CenterX);
        double verticalDistance = Math.abs(o1CenterY - o2CenterY);

        double maxHorizontalDistance = object1.getWidth() / 2;
        double maxVerticalDistance = object1.getHeight() / 2;
        //System.out.println(horizontalDistance <= maxHorizontalDistance && verticalDistance <= maxVerticalDistance);
        return horizontalDistance <= maxHorizontalDistance && verticalDistance <= maxVerticalDistance;
    }

    void reusePlates(GameObject p) {

        p.setY(-1 * (int) (Math.random() * getHeight()));
        p.setX((int) (Math.random() * getWidth()));

    }

    public void intersectedWithMoving(GameObject x) {
        ListIterator l = new ListIterator(GameObjectContainer.movable);
        while (l.hasNext()) {
            GameObject gameObject = l.next();
            if (x != gameObject && intersect(x, gameObject) && x.getY() == 0 && !(x instanceof Bomb) && !(x instanceof Gift)) {
                reusePlates(gameObject);
            }
        }
    }

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

    public Clown getClown() {
        return clown;
    }
    
    public void setStrategy(Strategy s){
        this.strategy = s;
    }
    
}
