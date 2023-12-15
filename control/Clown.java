/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Adham
 */
public class Clown implements GameObject {
    private BufferedImage[] spriteImages = new BufferedImage[1];
    private final boolean isVisible = true;
    private static volatile Clown clownInstance=null;
    private int x;
    private int y;
    
    public Clown(int x,int y,String path){
        this.x = x;
        this.y = y;
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            System.out.println("Image of clown not found.");
        }
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
    
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return this.spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return this.spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return this.isVisible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return this.spriteImages;
    }
    
    
}
