package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class ImageObject implements GameObject{

    private int x;
    private int y;
    private String imagePath;
    private boolean isVisible;
    private Context context;
    private Random random = new Random();
    protected BufferedImage sourceImage;
    protected BufferedImage[] image = new BufferedImage[1];

    
	public ImageObject(String imagePath) {
		this.imagePath = imagePath;
		setVisible(true);
        try {
        	sourceImage = ImageIO.read(new File(this.imagePath));
        } catch (IOException e) {
            sourceImage = null;
        }
        image[0] = sourceImage;
        this.context = new Context(new MovingState(this));
	}

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        if(x > 0)
        	this.x = x;
        else
        	this.x = 0;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
    	if(y > 0)
        	this.y = y;
        else
        	this.y = 0;
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
        if (image[0] != null)
            return image[0].getWidth();
        return 0;
    }

    @Override
    public int getHeight() {
        if (image[0] != null)
            return image[0].getHeight();
        return 0;
    }
    
    @Override
    public BufferedImage[] getSpriteImages() {
        return image;
    }
    
    public String getPath() {
    	if(imagePath != null)
    		return imagePath;
    	return "";
    }
    public void handleMoving(){
        this.context.request(getNextXPosition(), getNextYPosition());
    }
    public void changeToControlState(){
        this.context.setState(new ControlState(this));
    }
    public int getNextXPosition() {
        return getX();
    }
    
    public int getNextYPosition() {
        return getY() + 1;
    }
	

}
