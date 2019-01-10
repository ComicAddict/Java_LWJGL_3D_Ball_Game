package entities;

import org.lwjgl.util.vector.Vector3f;

/**
 * Light component of the world
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class Light {

	// Properties

	private Vector3f position;
	private Vector3f color;

	// Constructor

	/**
	 * Constructs a radial light
	 * 
	 * @param position
	 * @param color
	 */
	public Light(Vector3f position, Vector3f color) {
		this.position = position;
		this.color = color;
	}

	/**
	 * Gives the position
	 * 
	 * @return position vector
	 */
	public Vector3f getPosition() {
		return position;
	}

	/**
	 * Sets the position
	 * 
	 * @param position
	 */
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	/**
	 * Gives the color of the light
	 * 
	 * @return color vector(R,G,B)
	 */
	public Vector3f getColor() {
		return color;
	}

	/**
	 * Sets the color
	 * 
	 * @param color vector(R,G,B)
	 */
	public void setColor(Vector3f color) {
		this.color = color;
	}
}
