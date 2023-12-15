package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;

public abstract class Shape extends ImageObject{

    private Color color;
    private ShapeColor shapeColor;

    public Shape(int x, int y, ShapeColor shapeColor, String imagePath) {
    	super(imagePath);
        setX(x);
        setY(y);
        this.shapeColor = shapeColor;
        color = this.shapeColor.getColor();
        image[0] = applyColorToImage(sourceImage);
    }

    public ShapeColor getColor() {
    	return shapeColor;
    }

    public void setColor(ShapeColor color) {
        this.shapeColor = color;
        this.color = shapeColor.getColor();
        
        image[0] = applyColorToImage(sourceImage);
        
    }

    /*
     * This method is used to apply a color to the image.
     * It assumes the image was previously colorless or in black and white so
     * that the filter applied can have a more dominant effect on the overall color.
     */
    private BufferedImage applyColorToImage(BufferedImage image) {
        if (image != null) {
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage coloredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Get the Graphics2D object to draw on the new image
            Graphics2D g2d = coloredImage.createGraphics();

            // Draw the original image onto the new image
            g2d.drawImage(image, 0, 0, null);

            // Set the blending mode to achieve the desired effect
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));

            // Fill the entire image with the desired color
            g2d.setColor(color);
            g2d.fillRect(0, 0, width, height);

            // Dispose of the Graphics2D object
            g2d.dispose();

            return coloredImage;
        }

        return null;
    }


}

