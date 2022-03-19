package lights;

import java.awt.Color;

public class ColoredLight extends Light{
	
	private Color color;
	
	/**
	 * Creates a new colored light.
	 * @param color - color of this light.
	 */
	public ColoredLight(Color color) {
		// TODO
		super(true);
		this.color = color;
//		throw new RuntimeException("ColoredLight(Color) not yet implemented!");
	}
	
	/**
	 * Returns the color of this light.
	 * @return color of this light.
	 */
	public Color getColor() {
		// TODO
//		throw new RuntimeException("ColoredLight.getColor() not yet implemented!");
		return this.color;
	}
	
	/**
	 * Changes the color of this light to be c.
	 */
	public void setColor(Color c) {
		// TODO
		this.color = c;
//		throw new RuntimeException("ColoredLight.setColor() not yet implemented!");
	}
	
	/**
	 * Randomly changes this light to be on or off and its color.
	 */
	@Override
	public void randomChange() {
		// TODO. 
		// Take advantage of Light.randomChange
//		throw new RuntimeException("ColoredLight.randomChange() not yet implemented!");
		Color cRed = Color.red;
		Color cGreen = Color.green;
		Color cBlue = Color.blue;
		
		if (Math.random() < .3) {
			this.setColor(cRed);
		} else if(Math.random() < .6 && Math.random() > .3){
			this.setColor(cGreen);
		}
		else {
			this.setColor(cBlue);
		}
		
	}
	
}