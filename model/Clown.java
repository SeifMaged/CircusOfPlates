
package model;

/**
 *
 * @author Adham
 */
public class Clown extends ImageObject {
    private static volatile Clown clownInstance = null;
    
    public Clown(int x,int y,String path){
    	super(path);
        setX(x);
        setY(y);
    }
    
    public static synchronized Clown getInstance(int x, int y, String path) {
        if (clownInstance == null) {
            synchronized (Clown.class) {
                if (clownInstance == null) {
                    clownInstance = new Clown(x, y, path);
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