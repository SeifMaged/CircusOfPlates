/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;
import model.Iterator;

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
