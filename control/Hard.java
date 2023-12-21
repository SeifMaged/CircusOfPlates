package control;

/**
 * @author Ahmed Mahmoud
 */
public class Hard implements Strategy{

    @Override
    public int getObjectSpeed() {
        return 1;
    }

    @Override
    public int getControlSpeed() {
        return 5;
    }

    @Override
    public int getLives() {
        return 3;
    }

}
