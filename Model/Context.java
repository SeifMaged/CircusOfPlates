package model;

/**
 *
 * @author Adham
 */
public class Context { //delegation class for state
    private State state;
    public Context(State initialState) {
        this.state = initialState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request(int x,int y) {
        state.handleState(x,y);
    }
}
