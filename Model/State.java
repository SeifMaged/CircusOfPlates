package model;

/**
 *
 * @author Adham
 */
public interface State {
    
    void handleState(int x,int y);
    boolean isControlState();
}
