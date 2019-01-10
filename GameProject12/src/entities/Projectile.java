package entities;

import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;
import renderEngine.DisplayManager;
import terrains.Terrain;

/**
 * A projectile class
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class Projectile extends Entity {

	// Properties

	private static final float GRAVITY = -10;
	private final Vector3f initVelocity;

	private Vector3f velocity;
	private Vector3f angularVelocity;
	private Vector3f wind;
	private float frictionCoefficient;
	private float radius;

	// Constructors

	/**
	 * Constructs a projectile
	 * 
	 * @param model
	 * @param position
	 * @param velocity
	 * @param wind
	 * @param frictionCoefficient
	 * @param radius
	 * @param rotX
	 * @param rotY
	 * @param rotZ
	 * @param scale
	 */
	public Projectile(TexturedModel model, Vector3f position, Vector3f velocity, Vector3f wind,
			float frictionCoefficient, float radius, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
		this.velocity = velocity;
		this.initVelocity = velocity;
		this.wind = wind;
		this.frictionCoefficient = frictionCoefficient;
		this.radius = radius;
		angularVelocity = new Vector3f();
	}

	// Methods

	/**
	 * Collide checker
	 * 
	 * @param entity
	 * @return if prjectile is colliding with another object
	 */
	public boolean isColliding(Entity entity) {
		if (Math.abs(getPosition().x - entity.getPosition().x) <= (radius + 0.1f)
				&& Math.abs(getPosition().y - entity.getPosition().y) <= (radius + 2f)
				&& Math.abs(getPosition().z - entity.getPosition().z) <= (radius) + 0.1f) {
			return true;
		}
		return false;
	}

	/**
	 * Return the information of whether object is in another entity or not
	 * 
	 * @param entity
	 * @param x
	 * @param y
	 * @param z
	 * @return information of whether object is in another entity or not
	 */
	public boolean isInside(Entity entity, float x, float y, float z) {
		return (Math.abs(getPosition().x - entity.getPosition().x) < x
				&& Math.abs(getPosition().y - entity.getPosition().y) < y
				&& Math.abs(getPosition().z - entity.getPosition().z) < z);
	}

	/**
	 * Gives the radius of the projectile
	 * 
	 * @return radius
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Gives the velocity of projectile
	 * 
	 * @return velocity vector
	 */
	public Vector3f getVelocity() {
		return velocity;
	}

	/**
	 * Moves the projectile on the given terrain
	 * 
	 * @param terrain
	 * @return none
	 */
	public void move(Terrain terrain) {
		float terrainHeight = terrain.getHeightOfTerrain(super.getPosition().x, super.getPosition().z);

		angularVelocity.x = velocity.z / radius;
		angularVelocity.z = velocity.x / radius;

		super.increasePosition(velocity.x * DisplayManager.getFrameTimeSecond(),
				velocity.y * DisplayManager.getFrameTimeSecond(), velocity.z * DisplayManager.getFrameTimeSecond());

		if (super.getPosition().y - radius - 0.05 < terrainHeight) {
			super.increaseRotation(angularVelocity.x, 0, angularVelocity.z);
		}

		velocity.y += (GRAVITY + wind.y) * DisplayManager.getFrameTimeSecond();

		if (Math.abs((super.getPosition().y - terrainHeight)) < 0.2f) {
			velocity.x += ((initVelocity.x / Math.abs(initVelocity.x)) * GRAVITY * frictionCoefficient + wind.x)
					* DisplayManager.getFrameTimeSecond();
			velocity.z += ((initVelocity.z / Math.abs(initVelocity.z)) * GRAVITY * frictionCoefficient + wind.z)
					* DisplayManager.getFrameTimeSecond();
		}

		if (super.getPosition().y - radius < terrainHeight) {
			velocity.y /= -3;

			super.getPosition().y = terrainHeight + 0.01f + radius;
		}
	}
}
