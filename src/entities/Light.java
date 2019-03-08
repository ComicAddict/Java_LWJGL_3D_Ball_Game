package entities;

import org.lwjgl.util.vector.Vector3f;

/* Light component of the world
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class Light {
	
	// Properties
	
	private Vector3f position;
	private Vector3f color;
	
	// Constructor
	
	/* Constructs a light at given position with given color
	 * @param position and color of light
	 * @return none
	 */
	public Light(Vector3f position, Vector3f color) {
		this.position = position;
		this.color = color;
	}
	
	/* Gives the position of the light
	 * @param none
	 * @return position of the light
	 */
	public Vector3f getPosition() {
		return position;
	}
	
	/* Sets the position of the light
	 * @param position vector
	 * @return none
	 */
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	/* Gives the color of the light
	 * @param none
	 * @return color of the light
	 */
	public Vector3f getColor() {
		return color;
	}
	
	/* Sets the color of the light
	 * @param color vector
	 * @return none
	 */
	public void setColor(Vector3f color) {
		this.color = color;
	}
}
