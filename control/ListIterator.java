package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

/**
 *
 * @author Adham
 */
public class ListIterator implements Iterator<GameObject> {
    private List<GameObject> list = null;
    private int index;
    
     public ListIterator(List<GameObject> givenList) {
        this.list = givenList;
        this.index = 0;
    }
     
    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public GameObject next() {
        if (!hasNext()) {
            return null;
        }
        GameObject value = list.get(index);
        index++;
        return value;
    }
    
}
