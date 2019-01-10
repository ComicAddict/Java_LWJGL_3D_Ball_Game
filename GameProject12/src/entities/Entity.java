package entities;

import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;

/**
 * Entity class
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class Entity {

	// Properties

	private TexturedModel model;
	private Vector3f position;
	private float rotX, rotY, rotZ;
	private float scale;

	// Constructors

	/**
	 * Constucs a model in the space
	 * 
	 * @param model
	 * @param position
	 * @param rotX
	 * @param rotY
	 * @param rotZ
	 * @param scale
	 */
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}

	// Methods

	/**
	 * Increases the position of the entity
	 * 
	 * @param dx
	 * @param dy
	 * @param dz
	 */
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}

	/**
	 * Increases the rotation of the entity
	 * 
	 * @param dx
	 * @param dy
	 * @param dz
	 */
	public void increaseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}

	/**
	 * Gives the model
	 * 
	 * @return model
	 */
	public TexturedModel getModel() {
		return model;
	}

	/**
	 * Sets the model
	 * 
	 * @param model
	 */
	public void setModel(TexturedModel model) {
		this.model = model;
	}

	/**
	 * Gives the position of the entity
	 * 
	 * @return position
	 */
	public Vector3f getPosition() {
		return position;
	}

	/**
	 * Sets the position of the entity
	 * 
	 * @param position
	 */
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	/**
	 * Gives the rotation in x axis
	 * 
	 * @return x axis rotation
	 */
	public float getRotX() {
		return rotX;
	}

	/**
	 * Sets the rotation in x axis
	 * 
	 * @param x
	 *            axis rotation
	 */
	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	/**
	 * Gives the rotation in y axis
	 * 
	 * @return y axis rotation
	 */
	public float getRotY() {
		return rotY;
	}

	/**
	 * Sets the rotation in y axis
	 * 
	 * @return y axis rotation
	 */
	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	/**
	 * Gives the rotation in z axis
	 * 
	 * @return z axis rotation
	 */
	public float getRotZ() {
		return rotZ;
	}

	/**
	 * Sets the rotation in z axis
	 * 
	 * @return z axis rotation
	 */
	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	/**
	 * Gives the scale of the entity
	 * 
	 * @return
	 */
	public float getScale() {
		return scale;
	}

	/**
	 * Sets the scale of the entity
	 * 
	 * @param scale
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}
}
