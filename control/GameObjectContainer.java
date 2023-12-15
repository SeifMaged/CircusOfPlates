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
    List<GameObject> CONSTANT = new ArrayList<>();
    List<GameObject> MOVABLE = new ArrayList<>();
    List<GameObject> CONTROLLABLE = new ArrayList<>();
    Stack<GameObject> L_HAND = new Stack<>();
    Stack<GameObject> R_HAND = new Stack<>();
}
