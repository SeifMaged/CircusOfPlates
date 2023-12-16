package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.List;

import java.util.Stack;
import model.Shape;
import model.ShapeColor;

public class RightAndLeftStack{

    private static final int MARGIN = 10;
    private static final int LEFT_HAND = 1;
    private static final int RIGHT_HAND = 2;

    private static int vanish;

    public static void checkIntersect(GameObject go, GameObject clown) {
        checkIntersect(go, clown, GameObjectContainer.rightHand, RIGHT_HAND);
        checkIntersect(go, clown, GameObjectContainer.leftHand, LEFT_HAND);
    }

    private static boolean checkIntersect(GameObject go, GameObject clown, Stack<GameObject> handStack, int handType) {
        int yIntersection = 0; // this initialization won't affect anything
        boolean intersected = false;
        
        if (handStack.isEmpty() && intersectWithHand(go, clown, handType)) {
            yIntersection = clown.getY();
            intersected = true;

        } else if (!handStack.isEmpty() && intersect(go, handStack.peek())) {
            yIntersection = handStack.peek().getY();
            intersected = true;
        }
        
        if(intersected)
        {
            Shape pCaught = (Shape) go;
            GameObjectContainer.movable.remove(go);
            pCaught.setX(clown.getX() + 130);
            pCaught.setY(yIntersection - pCaught.getHeight() / 2);
            GameObjectContainer.controllable.add(go);
            handStack.push(go);
        }
        
        return intersected;
    }

    static boolean intersectWithHand(GameObject o, GameObject clown, int handType) {
        if (handType == RIGHT_HAND) {
            clown = GameObjectContainer.controllable.get(0);

            return (Math.abs(clown.getX() + clown.getWidth() - (o.getX() + o.getWidth())) <= o.getWidth() - MARGIN
                    && o.getY() == GameObjectContainer.controllable.get(0).getY() - MARGIN);
        } else {

            clown = GameObjectContainer.controllable.get(0);

            return (Math.abs(clown.getX() - o.getX()) <= o.getWidth() - MARGIN
                    && o.getY() == GameObjectContainer.controllable.get(0).getY() - MARGIN);
        }
    }

    private static boolean intersect(GameObject o1, GameObject o2) {
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth())
                && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
    }

    static void vanishHand(Stack<GameObject> handStack) {
        int vanishingThreshold = 3; // Number of elements required for vanishing

        if (handStack.size() >= vanishingThreshold) {
            List<Shape> platesToRemove = new ArrayList<>();

            for (int i = 0; i < vanishingThreshold; i++) {
                platesToRemove.add((Shape) handStack.pop());
            }

            boolean areColorsEqual = true;
            ShapeColor firstColor = platesToRemove.get(0).getColor();

            for (int i = 1; i < platesToRemove.size(); i++) {
                if (!platesToRemove.get(i).getColor().equals(firstColor)) {
                    areColorsEqual = false;
                    break;
                }
            }

            if (areColorsEqual) {
                for (Shape shapes : platesToRemove) {
                    GameObjectContainer.controllable.remove(shapes);
                    // reusePlates(plate);
                }
                vanish++;
            } else {
                handStack.addAll(platesToRemove);
            }
        }
    }

    static void VanishLeftHand() {
        vanishHand(GameObjectContainer.leftHand);
    }

    static void VanishRightHand() {
        vanishHand(GameObjectContainer.rightHand);
    }

    public static int getVanish() {
        return vanish;
    }
}
