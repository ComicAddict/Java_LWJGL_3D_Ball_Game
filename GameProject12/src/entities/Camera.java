package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

/**
 * View point of the game
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class Camera {

	// Properties

	private Vector3f position;
	private float distanceFromEntity;
	private float angleAroundEntity;
	private float pitch;
	private float yaw;
	private float roll;
	private boolean isBounded;
	private Entity entity;

	// Constructor

	/**
	 * Constructs a camera with free
	 */
	public Camera() {
		position = new Vector3f();
		distanceFromEntity = 10;
		angleAroundEntity = 0;
		pitch = 20;
		isBounded = false;
	}

	/**
	 * Constructs a locked camera
	 * 
	 * @param entity
	 */
	public Camera(Entity entity) {
		position = new Vector3f();
		distanceFromEntity = 10;
		angleAroundEntity = 0;
		pitch = 20;
		this.entity = entity;
		isBounded = true;
	}

	// Methods

	/**
	 * Moves the camera depending on if an entity is bounded to the camera
	 */
	public void move() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.z -= 0.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += 0.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= 0.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.z += 0.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			position.y += 0.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			position.y -= 0.1f;
		}

		if (isBounded) {
			calculateZoom();
			calculatePitch();
			calculateAngleAroundEntity();
			float horizontalDistance = calculateHorizontalDistance();
			float verticalDistance = calculateVerticalDistance();
			calculateCameraPosition(horizontalDistance, verticalDistance);
			this.yaw = 180 - entity.getRotY() - angleAroundEntity;
		}

		position.y += Mouse.getDWheel() / 1000.0;
	}

	/**
	 * Gives the position vector
	 * 
	 * @return position vector
	 */
	public Vector3f getPosition() {
		return position;
	}

	/**
	 * Gives pitch angle of the camera
	 * 
	 * @return pitch angle
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * Gives yaw angle of the camera
	 * 
	 * @param none
	 * 
	 * @return yaw angle
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * Gives roll angle of the camera
	 * 
	 * @param none
	 * 
	 * @return roll angle
	 */
	public float getRoll() {
		return roll;
	}

	/**
	 * Calculates the new camera position
	 * 
	 * @param horizontal and vertical length of the camera-entity distance
	 * 
	 * @return none
	 */
	private void calculateCameraPosition(float horizontal, float vertical) {
		float theta = entity.getRotY() + angleAroundEntity;
		float offsetX = (float) (horizontal * Math.sin(Math.toRadians(theta)));
		float offsetZ = (float) (horizontal * Math.cos(Math.toRadians(theta)));
		position.x = entity.getPosition().x - offsetX;
		position.z = entity.getPosition().z - offsetZ;
		position.y = entity.getPosition().y + vertical;
	}

	/**
	 * Calculates horizontal distance to the entity
	 * 
	 * @param none
	 * 
	 * @return horizontal distance to the entity
	 */
	private float calculateHorizontalDistance() {
		return (float) (distanceFromEntity * Math.cos(Math.toRadians(pitch)));
	}

	/**
	 * Calculates vertical distance to the entity
	 * 
	 * @param none
	 * 
	 * @return vertical distance to the entity
	 */
	private float calculateVerticalDistance() {
		return (float) (distanceFromEntity * Math.sin(Math.toRadians(pitch)));
	}

	/**
	 * Calculates the zoom to the entity and changes distance to the entity
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	private void calculateZoom() {
		float zoomLevel = Mouse.getDWheel() * 0.005f;
		distanceFromEntity -= zoomLevel;
	}

	/**
	 * Calculates the pitch angle
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	private void calculatePitch() {
		if (Mouse.isButtonDown(1)) {
			float pitchChange = Mouse.getDY() * 0.1f;
			pitch -= pitchChange;
		}
	}

	/**
	 * Calculates angle around the entity
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	private void calculateAngleAroundEntity() {
		if (Mouse.isButtonDown(0)) {
			float angleChange = Mouse.getDX() * 0.3f;
			angleAroundEntity -= angleChange;
		}
	}
}
