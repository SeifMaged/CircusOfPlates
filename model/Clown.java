
package model;

import control.Circus;

/**
 *
 * @author Adham
 */
public class Clown extends ImageObject {
    private static volatile Clown clownInstance = null;
    private static final String clownImage = "src/resources/clown.png";
    
    public Clown(int x,int y,String path){
    	super(path);
        setX(x);
        setY(y);
        this.horizontalOnly=true;
    }
    
    
    public static synchronized Clown getInstance() {
        if (clownInstance == null) {
            synchronized (Clown.class) {
                if (clownInstance == null) {
                    double width = Circus.getScreenWidth() * 0.4;
                    double height = Circus.getScreenHeight() * 0.64;
                    Clown.clownInstance = clownInstance = new Clown((int)width, (int)height, clownImage);
                }
            }
        }
        return clownInstance;
    }

    
//    @Override
//    public void setY(int y) {
//        
//    }
}