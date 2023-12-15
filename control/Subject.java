/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package control;

/**
 *
 * @author adham
 */
public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyAllSubscribers();
}
