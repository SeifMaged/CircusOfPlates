package model;

import java.util.Random;

public class FallingObjectFactory {
	
	private static Random random = new Random();
	
	/*
	 * Randomly Generates FallingObjects
	 */
	
	public FallingObject createFallingObject(int width){
		int x = random.nextInt(Math.abs(width));
		int y = random.nextInt(Math.abs(width/2)) - 400;
		int shapeType = random.nextInt(5) + 1;
		int colorChooser = random.nextInt(3) + 1;
		ShapeColor color = null;
		FallingObject fallingObject = null;
		
		switch(colorChooser) {
		case 1:
			color = ShapeColor.RED;
			break;
		case 2:
			color = ShapeColor.YELLOW;
			break;
		case 3:
			color = ShapeColor.BLUE;
			break;
		}
		
		switch(shapeType) {
		
			case 1 -> {
				fallingObject = new Plate(x, y, color);
				break;
			}
				
			case 2 -> {
				fallingObject = new Bomb(x,y);
				break;
			}
			case 3 -> {
				fallingObject = new Gift(x,y);
				break;
			}
			
			case 4 -> {
				fallingObject = new Plate(x, y, color);
				break;
			}
			
			case 5
			-> {
				fallingObject = new Plate(x, y, color);
				break;
			}
			default -> {
				fallingObject = null;
			}
			
		}
		
		return fallingObject;
	}
	
}
