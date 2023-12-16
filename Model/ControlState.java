/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Adham
 */
public class ControlState implements State{
    GameObject obj=null;
    
    public ControlState(GameObject obj){
        this.obj = obj;
    }
    @Override
    public void handleState(int x,int y) {
        this.obj.setX(x);
        this.obj.setY(y);
    }
}
