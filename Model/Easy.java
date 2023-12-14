package Model;

/**
 * @author Ahmed Mahmoud
 */
public class Easy implements Strategy{

    @Override
    public int getObjectSpeed() {
        return 15;
    }

    @Override
    public int getControlSpeed() {
        return 15;
    }

    @Override
    public int getLives() {
        return 10;
    }

}
