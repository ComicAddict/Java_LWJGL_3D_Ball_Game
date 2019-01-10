package engineTester;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import audio.AudioMaster;
import audio.Source;
import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Projectile;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;

/**
 * Game / Simulation class
 * 
 * @author Tolga YILDIZ
 * @version 05.05.2018
 */
public class Game {

	// Properties

	private List<Entity> entities;
	private boolean pause;
	private Source source;
	private Loader loader;
	private MasterRenderer renderer;
	private RawModel rawBall, rawObstacle, rawGoalPost;
	private TexturedModel staticBall, staticObstacle, staticGoalPost;
	private Projectile ball;
	private Entity obstacle, obstacle1, obstacle2, goalPost, player;
	private Light light;
	private Camera camera;
	private TerrainTexturePack texturePack;
	private TerrainTexture background, white, darkGreen, lightGreen;
	private Terrain terrain;

	/**
	 * Construcst a gamea
	 * 
	 * @param map
	 * @param positions
	 * @param velocity
	 * @param wind
	 * @param frictionCoef
	 */
	public Game(String map, float[] positions, float[] velocity, float[] wind, float frictionCoef) {
		init(map, positions, velocity, wind, frictionCoef);
		while (!Display.isCloseRequested()) {
			loop();
		}

		if (getAnswer() == JOptionPane.YES_OPTION) {
			end();
		} else {
			end();
			System.exit(0);
		}
	}

	/**
	 * Initializes components
	 * 
	 * @param map
	 * @param positions
	 * @param velocity
	 * @param wind
	 * @param friction
	 */
	private void init(String map, float[] positions, float[] velocity, float[] wind, float friction) {
		DisplayManager.createDisplay();
		AudioMaster.init();

		entities = new ArrayList<Entity>();
		source = new Source();
		pause = false;
		loader = new Loader();
		renderer = new MasterRenderer(loader, map);

		rawBall = OBJLoader.loadObjModel("3DModels/ball", loader);
		rawObstacle = OBJLoader.loadObjModel("3DModels/obstacle", loader);
		rawGoalPost = OBJLoader.loadObjModel("3dModels/goalPost", loader);

		staticBall = new TexturedModel(rawBall, new ModelTexture(loader.loadTexture("Textures/BALL")));
		staticObstacle = new TexturedModel(rawObstacle, new ModelTexture(loader.loadTexture("Textures/obstacle")));
		staticGoalPost = new TexturedModel(rawGoalPost,
				new ModelTexture(loader.loadTexture("Textures/goalPostTexture")));

		ball = new Projectile(staticBall, new Vector3f(positions[0], 0, positions[1]),
				new Vector3f(velocity[0], velocity[1], velocity[2]), new Vector3f(wind[0], wind[1], wind[2]), friction,
				0.2f, 0, 0, 0, 0.2f);
		player = new Entity(staticBall, new Vector3f(0, 0, 0), 0, 0, 0, 1);
		obstacle = new Entity(staticObstacle, new Vector3f(positions[3], 0, positions[2]), 0, 0, 0, 1);
		obstacle1 = new Entity(staticObstacle, new Vector3f(positions[5], 0, positions[4]), 0, 0, 0, 1);
		obstacle2 = new Entity(staticObstacle, new Vector3f(positions[7], 0, positions[6]), 0, 0, 0, 1);
		goalPost = new Entity(staticGoalPost, new Vector3f(40, 0, 0), 0, 0, 0, 1);

		light = new Light(new Vector3f(0, 2000, 0), new Vector3f(1, 1, 1));
		camera = new Camera(ball);

		background = new TerrainTexture(loader.loadTexture("Textures/grass"));
		white = new TerrainTexture(loader.loadTexture("Textures/whiteGrass"));
		darkGreen = new TerrainTexture(loader.loadTexture("Textures/darkGrass"));
		lightGreen = new TerrainTexture(loader.loadTexture("Textures/lightGrass"));

		texturePack = new TerrainTexturePack(background, white, darkGreen, lightGreen);

		terrain = new Terrain(-1, -1, loader, texturePack, new TerrainTexture(loader.loadTexture("Textures/blendMap")),
				"Textures/default");

		source.setPosition(0, 0, 0);
		source.setVolume(4);

		entities.add(ball);
		entities.add(player);
		entities.add(goalPost);
		entities.add(obstacle);
		entities.add(obstacle1);
		entities.add(obstacle2);
	}

	/**
	 * Main Game loop
	 */
	private void loop() {
		for (Entity entity : entities) {
			renderer.processEntity(entity);
		}

		renderer.processTerrain(terrain);
		renderer.render(light, camera);
		camera.move();
		AudioMaster.setListenerData(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z);

		if (!source.isPlaying() || isOver()) {
			if (!isOver()) {
				source.stop();
				source.play(AudioMaster.loadSound("/res/stadiumSound.wav"));
			} else if (isOut() || isCollidingWithObstacles() || !isMoving()) {
				source.stop();
				source.play(AudioMaster.loadSound("/res/whistle.wav"));
			} else if (isGoal()) {
				source.stop();
				source.play(AudioMaster.loadSound("/res/cheer.wav"));
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_F)) {
			camera = new Camera();
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_B)) {
			camera = new Camera(ball);
		}
		if (isOver()) {
			pause = true;
		}

		if (!pause) {
			if (Keyboard.isKeyDown(Keyboard.KEY_P)) {
				pause = true;
			}
			ball.move(terrain);

		} else if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
			pause = false;
		}

		DisplayManager.updateDisplay();
	}

	/**
	 * Gets the answer of the user
	 * 
	 * @return answer
	 */
	private int getAnswer() {
		int answer = -5;
		if (isGoal()) {
			answer = JOptionPane.showConfirmDialog(null, "You Win!\nDo you want play again?", "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		} else if (isCollidingWithObstacles()) {
			answer = JOptionPane.showConfirmDialog(null, "Ball Hit the Obstacle!\nDo you want play again?", "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		} else if (!isMoving()) {
			answer = JOptionPane.showConfirmDialog(null, "Ball fell short!\nDo you want play again?", "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		} else if (isOut()) {
			answer = JOptionPane.showConfirmDialog(null, "Ball is out!\nDo you want play again?", "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}
		return answer;
	}

	/**
	 * Determines the region ball has gone
	 * 
	 * @return region number
	 */
	public int determineRegion() { // this method is related to hints
		if (isCollidingWithObstacles() == false) {
			if (ball.getPosition().z < -5f && ball.getPosition().y < 6f && isOut()) {
				return 1;
			} else if (ball.getPosition().z > 5f && ball.getPosition().y < 6f && isOut()) {
				return 2;
			} else if (ball.getPosition().z > -5f && ball.getPosition().z < 5f && ball.getPosition().y > 6f
					&& isOut()) {
				return 3;
			} else if (ball.getPosition().z < -5f && ball.getPosition().y > 6f && isOut()) {
				return 4;
			} else if (ball.getPosition().z > 5f && ball.getPosition().y > 6f && isOut()) {
				return 5;
			}
		} else {
			return 6; // this means that the ball hit an obstacle
		}
		return 0;
	}

	/**
	 * Colliding checker
	 * 
	 * @return is ball colliding with obstacles
	 */
	public boolean isCollidingWithObstacles() {
		return (ball.isColliding(obstacle) || ball.isColliding(obstacle1) || ball.isColliding(obstacle2));
	}

	/**
	 * Goal Checker
	 * 
	 * @return is goal
	 */
	public boolean isGoal() {
		return ball.isInside(goalPost, 4f, 3f, 5f);
	}

	/**
	 * Checks if shot is out
	 * 
	 * @return is ball out
	 */
	public boolean isOut() {
		return (Math.abs(ball.getPosition().x) - (terrain.SIZE / 2) >= -2.5f
				|| Math.abs(ball.getPosition().z) - (terrain.SIZE / 2) >= -2.5f);
	}

	/**
	 * Checks if ball is moving
	 * 
	 * @return is ball moving
	 */
	public boolean isMoving() {
		return ball.getVelocity().length() > 0.03f;
	}

	/**
	 * Checks if game is over
	 * 
	 * @return is game over
	 */
	private boolean isOver() {
		return isGoal() || isCollidingWithObstacles() || !isMoving() || isOut();
	}

	/**
	 * Clears all components from memory
	 */
	private void end() {
		entities.clear();
		source.delete();
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		AudioMaster.cleanUp();
	}
}
