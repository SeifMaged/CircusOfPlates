/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author adham
 */
public class Lives extends Subject{
    private int lives=5;
    
    public void decreaseLives(int decrement){
        lives -=decrement;
        notifyAllSubscribers();
    }
    
    public int getlives(){
        return this.lives;
    }

    @Override
    public void notifyAllSubscribers() {
        for(Observer observer: observers){
            observer.getStatus();
        }
    }
}
