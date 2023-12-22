package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.List;

import java.util.Stack;
import model.Clown;
import model.Shape;
import model.ShapeColor;

public class RightAndLeftStack {

    private static final int MARGIN = 10;
    private static final int LEFT_HAND = 1;
    private static final int RIGHT_HAND = 2;

    private static int vanish;

    public static boolean checkIntersect(GameObject rondom, GameObject clown) {
        if (checkIntersect(rondom, clown, GameObjectContainer.rightHand, RIGHT_HAND)) {
            return true;
        } else if (checkIntersect(rondom, clown, GameObjectContainer.leftHand, LEFT_HAND)) {
            return true;
        }
        return false;
    }

    private static boolean checkIntersect(GameObject rondom, GameObject clown, Stack<GameObject> handStack, int handType) {
        int yIntersection = 0; // this initialization won't affect anything
        boolean intersected = false;

        if (handStack.isEmpty() && intersectWithHand(rondom, Clown.getInstance(), handType)) {
            yIntersection = clown.getY();
            intersected = true;

        } else if (!handStack.isEmpty() && intersect(rondom, handStack.peek())) {
            yIntersection = handStack.peek().getY();
            intersected = true;
        }

        if (intersected) {
            int start = handType == LEFT_HAND ? 0 : 120;
            
            Shape caughted = (Shape) rondom;
            caughted.setX(clown.getX() + start);
            caughted.setY(yIntersection - caughted.getHeight() / 2);
            GameObjectContainer.movable.remove(rondom);
            GameObjectContainer.controllable.add(rondom);
            handStack.push(rondom);
        }

        return intersected;
    }

    private static boolean intersectWithHand(GameObject object, Clown clown, int handType) {
        boolean intersected;
        if (handType == RIGHT_HAND) {
            intersected = (Math.abs((clown.getX() + clown.getWidth()) - (object.getX() + object.getWidth())) <= object.getWidth() - MARGIN
                    && object.getY() == clown.getY() - MARGIN);
        } else {
            intersected = (Math.abs(clown.getX() - object.getX()) <= object.getWidth() - MARGIN
                    && object.getY() == clown.getY() - MARGIN);
        }
        return intersected;
    }

    public static boolean intersect(GameObject object1, GameObject object2) {
        long intersectedX = Math.abs((object1.getX() + object1.getWidth() / 2) - (object2.getX() + object2.getWidth() / 2));
        boolean isIntersectedX = intersectedX <= object1.getWidth();
        long intersectedY = Math.abs((object1.getY() + object1.getHeight() / 2) - (object2.getY() + object2.getHeight() / 2));
        boolean isIntersectedY = intersectedY <= object1.getHeight();

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