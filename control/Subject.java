/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;

/**
 *
 * @author adham
 */
public abstract class Subject {
    protected List <Observer> observers;

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

  
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }


    public abstract void notifyAllSubscribers();
    
}
