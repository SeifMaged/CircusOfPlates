package control;

/**
 *
 * @author adham
 */
public class Lives extends Subject {

    private int lives;

    public Lives(int lives) {
        this.lives = lives;
    }

    public void decreaseLives(int decrement) {
        if (lives > 0) {
            lives -= decrement;
            notifyAllSubscribers();
        }
    }

    public int getlives() {
        return this.lives;
    }

    @Override
    public void notifyAllSubscribers() {
        for (Observer observer : observers) {
            observer.getStatus();
        }
    }
}
