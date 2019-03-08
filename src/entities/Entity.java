package entities;

import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;

/* Entity class
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
	
	/* Constructs an entity from a textured model with given position
	 * @param a textured model with position and rotational velocity and scale of the model
	 * @return none
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
	
	/* Increases position
	 * @param increase amounts at three vertices, dx, dy, dz
	 * @return none
	 */
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	
	/* Increases rotation
	 * @param increase amounts at three component, dx, dy, dz
	 * @return none
	 */
	public void increaseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}

	/* Returns the static model of the entity
	 * @param none
	 * @return static textured model
	 */
	public TexturedModel getModel() {
		return model;
	}

	/* Sets model to another model
	 * @param other static model
	 * @return none
	 */
	public void setModel(TexturedModel model) {
		this.model = model;
	}

	/* Gives the position vector of the entity
	 * @param none
	 * @return position vector
	 */
	public Vector3f getPosition() {
		return position;
	}

	/* Sets position vector of the entity
	 * @param poition vector
	 * @return none
	 */
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	/* Gives rotation on x axis
	 * @param none
	 * @return rotation on x axis
	 */
	public float getRotX() {
		return rotX;
	}
	
	/* Sets rotation on x axis
	 * @param rotation on x axis
	 * @return none
	 */
	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	/* Gives rotation on y axis
	 * @param none
	 * @return rotation on y axis
	 */
	public float getRotY() {
		return rotY;
	}

	/* Sets rotation on y axis
	 * @param rotation on y axis
	 * @return none
	 */
	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	/* Gives rotation on z axis
	 * @param none
	 * @return rotation on z axis
	 */
	public float getRotZ() {
		return rotZ;
	}

	/* Sets rotation on z axis
	 * @param rotation on z axis
	 * @return none
	 */
	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	/* Gives the scale ratio
	 * @param none
	 * @return scale ratio
	 */
	public float getScale() {
		return scale;
	}
	
	/* Sets the scale ratio
	 * @param scale ratio
	 * @return none
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}
}
