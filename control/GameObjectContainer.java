package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author adham
 */
public interface GameObjectContainer {
    ArrayList<GameObject> constant = new ArrayList<>();
    ArrayList<GameObject> movable = new ArrayList<>();
    ArrayList<GameObject> controllable = new ArrayList<>();
    Stack<GameObject> leftHand = new Stack<>();
    Stack<GameObject> rightHand = new Stack<>();
}
