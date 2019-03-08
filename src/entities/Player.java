package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;
import renderEngine.DisplayManager;
import terrains.Terrain;

/* A player class
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class Player extends Entity{
	
	// Properties
	
	private static final float RUN_SPEED = 20;
	private static final float TURN_SPEED = 160;
	private static final float GRAVITY = -50;
	private static final float JUMP_POWER = 30;
	
	private float currentSpeed = 0;
	private float currentTurnSpeed = 0;
	private float upwardSpeed = 0;
	private boolean isInAir = false;

	// Constructors
	
	/* Constructs a player
	 * @param a static model with position and rotational information and scale ratio
	 * @return none
	 */
	public Player(TexturedModel model, Vector3f position, float rotX,
			float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}
	
	// Methods
	
	/* Moves the player on the given terrain
	 * @param a terrain to sit the player on top
	 * @return none
	 */
	public void move(Terrain terrain) {
		checkInputs();
		super.increaseRotation(0, currentTurnSpeed * DisplayManager.getFrameTimeSecond(), 0);
		float distance = currentSpeed * DisplayManager.getFrameTimeSecond();
		float dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
		float dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));
		super.increasePosition(dx, 0, dz);
		float terrainHeight = terrain.getHeightOfTerrain(super.getPosition().x, super.getPosition().z);
		upwardSpeed += GRAVITY * DisplayManager.getFrameTimeSecond();
		super.increasePosition(0, upwardSpeed * DisplayManager.getFrameTimeSecond(), 0);
		if(super.getPosition().y < terrainHeight) {
			isInAir = false;
			super.getPosition().y = terrainHeight;
		}
	}
	
	/* Gives upward speed to the player
	 * @param none
	 * @return none
	 */
	private void jump() {
		if(!isInAir) {
			upwardSpeed = JUMP_POWER;
			isInAir = true;
		}
	}
	
	/* Checks inputs from keyboard
	 * @param none
	 * @return none
	 */
	private void checkInputs() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			currentSpeed = RUN_SPEED;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			currentSpeed = -RUN_SPEED;
		}else {
			currentSpeed = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			currentTurnSpeed = -TURN_SPEED;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			currentTurnSpeed = TURN_SPEED;
		}else {
			currentTurnSpeed = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			jump();
		}
	}
}
