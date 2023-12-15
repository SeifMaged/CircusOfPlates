package model;

/**
 * @author Ahmed Mahmoud
 */
public class Medium implements Strategy{

    @Override
    public int getObjectSpeed() {
        return 20;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public int getLives() {
        return 5;
    }

}
