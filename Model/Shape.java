package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Shape implements GameObject {

    private int x;
    private int y;
    private boolean isVisible;
    private Color color;
    private ShapeColor shapeColor;
    
    private BufferedImage[] image = new BufferedImage[1];

    public Shape(int x, int y, ShapeColor shapeColor, String imagePath) {
        setX(x);
        setY(y);
        color = shapeColor.getColor();

        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image[0] = applyColorToImage(bufferedImage);
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

    @Override
    public BufferedImage[] getSpriteImages() {
        return image;
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

    public ShapeColor getColor() {
    	return shapeColor;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private BufferedImage applyColorToImage(BufferedImage image) {
        if (image != null) {
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage coloredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    coloredImage.setRGB(x, y, color.getRGB());
                }
            }

            return coloredImage;
        }
        return null;
    }


}
