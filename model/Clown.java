
package model;

import control.Circus;

/**
 *
 * @author Adham
 */
public class Clown extends ImageObject {
    private static volatile Clown clownInstance = null;
    private static final String CLOWNIMAGE = "src/resources/clown1.png";
    
    private Clown(int x,int y,String path){
    	super(path);
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
                    Clown.clownInstance = clownInstance = new Clown((int)width, (int)height, CLOWNIMAGE);
                }
            }
        }
        return clownInstance;
    }
    
//    @Override
//    public void setX(int x) {
//    	// Limits the clown's horizontal Movement
//        if (x > 10 && x < Circus.getScreenWidth() - (int)(0.2 * Circus.getScreenWidth() - 100))
//            super.setX(x);
//    }

}