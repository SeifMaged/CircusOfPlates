package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class ImageObject implements GameObject {

    private int x;
    private int y;
    private String imagePath;
    private boolean isVisible;
    private final Context context;
    protected boolean horizontalOnly;
    protected BufferedImage sourceImage;
    protected BufferedImage[] image = new BufferedImage[1];

    public ImageObject(String imagePath) {
        setVisible(true);

        this.imagePath = imagePath;
        
        sourceImage = createImageFromPath(this.imagePath);
        this.image[0] = this.sourceImage;

        this.context = new Context(new MovingState(this));
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
    	this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        if (this.horizontalOnly == false) {
            this.y = y;
        } else if (this.horizontalOnly == true && y == 0) {
            this.y = 0;
        }
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public int getWidth() {
        if (image[0] != null) {
            return image[0].getWidth();
        }
        return 0;
    }

    @Override
    public int getHeight() {
        if (image[0] != null) {
            return image[0].getHeight();
        }
        return 0;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return image;
    }
    
    public void changeSpriteImages(BufferedImage[] newImages) {
    	image = newImages;
    }

    public void handleMoving() {
        this.context.request(getNextXPosition(), getNextYPosition());
    }

    public void changeToControlState() {
        this.context.setState(new ControlState(this));
    }

    public int getNextXPosition() {
        return getX();
    }

    public int getNextYPosition() {
        return getY() + 1;
    }
    
    public BufferedImage createImageFromPath(String path) {
    	
    	BufferedImage b = null;
    	try {
            b = ImageIO.read(new File(path));
        } catch (IOException e) {
            b = null;
        }
    	return b;
    	
    }

}
