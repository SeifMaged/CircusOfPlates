package model;

import control.Circus;

/**
 *
 
@author Adham*/
public class Clown extends ImageObject {
    private static volatile Clown clownInstance = null;
    private static final String CLOWN_IMAGE = "src/resources/clown.png";
    private static final int LEFT_HAND_X = -27;
    private static final int RIGHT_HAND_X = 106;

    private Clown(int x,int y){
        super(CLOWN_IMAGE);
        setX(x);
        setY(y);
        this.horizontalOnly=true;
    }


    public static synchronized Clown getInstance() {
        if (clownInstance == null) {
            synchronized (Clown.class) {
                if (clownInstance == null) {
                    double width = Circus.getScreenWidth() * 0.42; // centers the clown
                    double height = Circus.getScreenHeight() * 0.64;
                    Clown.clownInstance = clownInstance = new Clown((int)width, (int)height);
                }
            }
        }
        return clownInstance;
    }


    /*
    @Override
    public void setX(int x) {
        // Limits the clown's horizontal Movement
        if (x > 16 && x < Circus.getScreenWidth() - (int)(0.2 * Circus.getScreenWidth()) - 14)
            super.setX(x);
    }
    */

    public static int getLeftHandX() {
        return LEFT_HAND_X;
    }


    public static int getRightHandX() {
        return RIGHT_HAND_X;
    }


}