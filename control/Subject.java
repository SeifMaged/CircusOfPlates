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
