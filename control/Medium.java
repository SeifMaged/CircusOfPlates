package control;

/**
 * @author Ahmed Mahmoud
 */
public class Medium implements Strategy{

    @Override
    public int getObjectSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public int getLives() {
        return 5;
    }

    @Override
    public int getNumOfColors() {
        return 4;
    }

}
