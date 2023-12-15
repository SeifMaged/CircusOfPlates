package model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Stack;

/**
 * @author Ahmed Mahmoud
 */
public class StackIterator implements Iterator<GameObject>{

    private final Stack<GameObject> currentStack;
    
    public StackIterator(Stack<GameObject> givenStack){
        this.currentStack = cloneStack(givenStack);
    }
    
    private static Stack<GameObject> cloneStack(Stack<GameObject> givenStack){
        Stack<GameObject> clone = new Stack<>();
        for(var item : givenStack){
            clone.push(item);
        }
        return clone;
    }
    
    @Override
    public boolean hasNext() {
        currentStack.pop();
        return !currentStack.isEmpty();
    }

    @Override
    public GameObject next() {
        currentStack.pop();
        return currentStack.peek();
    }

}
