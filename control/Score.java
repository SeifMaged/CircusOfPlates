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
public class Score implements Subject{
    int score;
    private List <Observer> observers;
    
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllSubscribers() {
        for(Observer observer: observers){
            observer.update(this.score);
        }
    }
    
    public void increaseScore(int increment){
        score +=increment;
        notifyAllSubscribers();
    }
    
}
