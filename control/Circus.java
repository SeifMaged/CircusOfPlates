/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Strategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.List;
import model.Bomb;
import model.Gift;
import model.ListIterator;

/**
 *
 * @author Adham
 */
public class Circus implements GameObjectContainer,World,Observer{
    private Score score = new Score();
    private Lives lives = new Lives();
  
    private final int screenWidth;
    private final int screenHeight;
    private Strategy strategy;
   // private GameFactory Ourfactory = new GameFactory();
    
    public Circus(int width,int height,Strategy strategy){
        this.screenWidth = width;
        this.screenHeight = height;
        this.strategy = strategy;
        controllable.add(Clown.getInstance((int) (screenWidth * 0.4), (int) (screenHeight * 0.64), "/clown.png"));
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return this.constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return this.movable;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return this.controllable;
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
        Clown clown = (Clown) controllable.get(0);
        ListIterator list = new ListIterator(movable);
        while (list.hasNext()) {

            GameObject go = list.next();
            intersectedWithMoving(go);

            if (go.getY() == getHeight()) {
                reusePlates(go);
            }

            
        }
        //to be implemented
        return true;
    }
    private boolean intersect(GameObject object1, GameObject object2) {
    double o1CenterX = object1.getX() + object1.getWidth() / 2;
    double o1CenterY = object1.getY() + object1.getHeight() / 2;

    double o2CenterX = object2.getX() + object2.getWidth() / 2;
    double o2CenterY = object2.getY() + object2.getHeight() / 2;

    double horizontalDistance = Math.abs(o1CenterX - o2CenterX);
    double verticalDistance = Math.abs(o1CenterY - o2CenterY);

    double maxHorizontalDistance = object1.getWidth() / 2;
    double maxVerticalDistance = object1.getHeight() / 2;

    return horizontalDistance <= maxHorizontalDistance && verticalDistance <= maxVerticalDistance;
    }

    private void reusePlates(GameObject p) {

        p.setY(-1 * (int) (Math.random() * getHeight()));
        p.setX((int) (Math.random() * getWidth()));

    }
    
    public void intersectedWithMoving(GameObject x) {
        ListIterator l = new ListIterator(movable);
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
}
