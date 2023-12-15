/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author adham
 */
public interface GameObjectContainer {
    List<GameObject> constant = new ArrayList<>();
    List<GameObject> movable = new ArrayList<>();
    List<GameObject> controllable = new ArrayList<>();
    Stack<GameObject> leftHand = new Stack<>();
    Stack<GameObject> rightHand = new Stack<>();
}
