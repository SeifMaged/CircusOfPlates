package control;

/**
 * @author Ahmed Mahmoud
 */
public class Easy implements Strategy{

    @Override
    public int getObjectSpeed() {
        return 1;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

    @Override
    public int getLives() {
        return 10;
    }

}
