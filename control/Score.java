/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;

/**
 *
 * @author Adham
 */
public class Score extends Subject{
    private int score=0;
    
    public void increaseScore(int increment){
        score +=increment;
        notifyAllSubscribers();
    }
    
    public int getScore(){
        return this.score;
    }

    @Override
    public void notifyAllSubscribers() {
        for(Observer observer: observers){
            observer.getStatus();
        }
    }
    
}
