/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import Model.Strategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.Plate;
import model.ShapeColor;

/**
 *
 * @author Adham
 */
public class Circus implements GameObjectContainer,World,Observer{
    private Score score = new Score();
    private Lives lives = new Lives();
    
    private int vanish;
  
    private final int screenWidth;
    private final int screenHeight;
    private Strategy strategy;
   // private GameFactory Ourfactory = new GameFactory();
    
    public Circus(int width,int height,Strategy strategy){
        this.screenWidth = width;
        this.screenHeight = height;
        this.strategy = strategy;
        controllable.add(Clown.getInstance((int) (screenWidth * 0.4), (int) (screenHeight * 0.64), "/clown.png"));
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return this.constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return this.movable;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return this.controllable;
    }

    @Override
    public int getWidth() {
        return this.screenWidth;
    }

    @Override
    public int getHeight() {
        return this.screenHeight;
    }
    
// will be implmented.
    @Override
    public boolean refresh() {
        return true;
    }

    @Override
    public String getStatus() {
        //notification that something has been changed (will be edited).
        return "Score: " + score.getScore() + "  |   Lives: " + lives.getlives();
    }

    @Override
    public int getSpeed() {
        return this.strategy.getObjectSpeed();
    }

    @Override
    public int getControlSpeed() {
        return this.getControlSpeed();
    }

    
    private void VanishLeftHand() {
    int vanishingThreshold = 3; // Number of elements required for vanishing
    
    if (leftHand.size() >= vanishingThreshold) {
        List<Plate> platesToRemove = new ArrayList<>();
        
        for (int i = 0; i < vanishingThreshold; i++) {
            platesToRemove.add((Plate) leftHand.pop());
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
            for (Plate plate : platesToRemove) {
                controllable.remove(plate);
                // reusePlates(plate);
            }
            vanish++;
        } else {
           
            leftHand.addAll(platesToRemove);
        }
    }
}
    private void VanishRightHand() {
        int vanishingThreshold = 3; // Number of elements required for vanishing

        if (rightHand.size() >= vanishingThreshold) {
            List<Plate> platesToRemove = new ArrayList<>();

            for (int i = 0; i < vanishingThreshold; i++) {
                platesToRemove.add((Plate) rightHand.pop());
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
                for (Plate plate : platesToRemove) {
                    controllable.remove(plate);
                    // reusePlates(plate);
                }
                vanish++;
            } else {
                rightHand.addAll(platesToRemove);
            }
        }
    }
 
}

    
 

    
    
    
          