package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.List;

import java.util.Stack;
import model.Clown;
import model.Shape;
import model.ShapeColor;

public class RightAndLeftStack {

    private static final int MARGIN = 5;
    private static final int LEFT_HAND = 1;
    private static final int RIGHT_HAND = 2;

    private static int vanish;

    public static boolean checkIntersect(GameObject go, GameObject clown) {
        if (checkIntersect(go, clown, GameObjectContainer.rightHand, RIGHT_HAND)) {
            return true;
        } else if (checkIntersect(go, clown, GameObjectContainer.leftHand, LEFT_HAND)) {
            return true;
        }
        return false;
    }

    private static boolean checkIntersect(GameObject go, GameObject clown, Stack<GameObject> handStack, int handType) {
        int yIntersection = 0; // this initialization won't affect anything
        boolean intersected = false;

        if (handStack.isEmpty() && intersectWithHand(go, Clown.getInstance(), handType)) {
            yIntersection = clown.getY();
            intersected = true;

        } else if (!handStack.isEmpty() && intersect(go, handStack.peek())) {
            yIntersection = handStack.peek().getY();
            intersected = true;
        }

        if (intersected) {
            int start = handType == LEFT_HAND ? 0 : 120;

            Shape caught = (Shape) go;
            caught.setX(clown.getX() + start);
            caught.setY(yIntersection - caught.getHeight() / 2);
            GameObjectContainer.movable.remove(go);
            GameObjectContainer.controllable.add(go);
            handStack.push(go);
        }

        return intersected;
    }

    private static boolean intersectWithHand(GameObject o, Clown clown, int handType) {
        boolean intersected;
        if (handType == RIGHT_HAND) {
            intersected = (Math.abs((clown.getX() + clown.getWidth()) - (o.getX() + o.getWidth())) <= o.getWidth() - MARGIN
                    && o.getY() == clown.getY() - MARGIN);
        } else {
            intersected = (Math.abs(clown.getX() - o.getX()) <= o.getWidth() - MARGIN
                    && o.getY() == clown.getY() - MARGIN);
        }
        return intersected;
    }

    public static boolean intersect(GameObject o1, GameObject o2) {
        long intersectedX = Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2));
        boolean isIntersectedX = intersectedX <= o1.getWidth();
        long intersectedY = Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2));
        boolean isIntersectedY = intersectedY <= o1.getHeight();

        return isIntersectedX && isIntersectedY;
    }

    private static boolean vanishHand(Stack<GameObject> handStack, Circus circus) {
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
                for (Shape shape : platesToRemove) {
                    GameObjectContainer.controllable.remove(shape);

                    circus.reuseShapes(shape);
                }
                vanish++;
                return true;
            } else {
                //handStack.addAll(platesToRemove);
            	
            	//returns the items removed from the stack back to the stack in the correct order
            	handStack.add(platesToRemove.get(2));
            	handStack.add(platesToRemove.get(1));
            	handStack.add(platesToRemove.get(0));
            	
                return false;
            }
        }
        return false;
    }

    public static void VanishLeftHand(Circus circus, Score score) {
        if (vanishHand(GameObjectContainer.leftHand, circus)) {
            score.increaseScore(1);
        }
    }

    public static void VanishRightHand(Circus circus, Score score) {
        if (vanishHand(GameObjectContainer.rightHand, circus)) {
            score.increaseScore(1);
        }
    }

    public static int getVanish() {
        return vanish;
    }
}
