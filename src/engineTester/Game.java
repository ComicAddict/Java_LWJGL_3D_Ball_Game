package engineTester;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import audio.AudioMaster;
import audio.Source;
import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Projectile;
import guis.GuiRenderer;
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

public class Game {
	
	private List<Entity> entities;
	private Source source;
	private boolean pause;
	private Loader loader;
	private MasterRenderer renderer;
	private GuiRenderer guiRenderer;
	private RawModel rawBall, rawObstacle, rawGoalPost;
	private TexturedModel staticBall, staticObstacle, staticGoalPost;
	private Projectile ball;
	private Entity obstacle, obstacle1, obstacle2, goalPost;
	private Light light;
	private Camera camera;
	private TerrainTexturePack texturePack;
	private TerrainTexture background, white, darkGreen, lightGreen;
	private Terrain terrain;
	
	
	public Game(String map, float[] positions, float[] velocity) {
		init(map, positions, velocity);
		while(!Display.isCloseRequested() && !isGoal() && !isCollidingWithObstacles() && isMoving() && !isOut()) {
			loop();
		}
		end();
	}
	
	private void init(String map, float[] positions, float[] velocity) {
		DisplayManager.createDisplay();
		AudioMaster.init();
		
		entities = new ArrayList<Entity>();
		source = new Source();
		pause = false;
		loader = new Loader();
		renderer = new MasterRenderer(loader, map);
		guiRenderer = new GuiRenderer(loader);
		
		rawBall = OBJLoader.loadObjModel("3DModels/ball", loader);
		rawObstacle = OBJLoader.loadObjModel("3DModels/obstacle", loader);
		rawGoalPost = OBJLoader.loadObjModel("3dModels/goalPost", loader);
		
		staticBall = new TexturedModel(rawBall, new ModelTexture(loader.loadTexture("Textures/BALL")));
		staticObstacle = new TexturedModel(rawObstacle, new ModelTexture(loader.loadTexture("Textures/goalPostTexture")));
		staticGoalPost = new TexturedModel(rawGoalPost, new ModelTexture(loader.loadTexture("Textures/goalPostTexture")));
	
		ball = new Projectile(staticBall, new Vector3f(positions[0] , 0, positions[1]), 
							new Vector3f(velocity[0], velocity[1], velocity[2]), 0.1f, 0.1f, 0, 0, 0, 0.1f);
		
		obstacle = new Entity(staticObstacle, new Vector3f(positions[2], 0, positions[3]), 0, 0, 0, 1);
		obstacle1 = new Entity(staticObstacle, new Vector3f(positions[4], 0, positions[5]), 0, 0, 0, 1);
		obstacle2 = new Entity(staticObstacle, new Vector3f(positions[6], 0, positions[7]), 0, 0, 0, 1);
		goalPost = new Entity(staticGoalPost, new Vector3f(40, 0, 0), 0, 0, 0, 1);
		
		light = new Light(new Vector3f(0,2000,0), new Vector3f(1,1,1));
		camera = new Camera(ball);
		
		background = new TerrainTexture(loader.loadTexture("Textures/grass"));
		white = new TerrainTexture(loader.loadTexture("Textures/whiteGrass"));
		darkGreen = new TerrainTexture(loader.loadTexture("Textures/darkGrass"));
		lightGreen = new TerrainTexture(loader.loadTexture("Textures/lightGrass"));
		
		texturePack = new TerrainTexturePack(background, white, darkGreen, lightGreen);
		
		terrain = new Terrain(-1, -1, loader, texturePack, new TerrainTexture(loader.loadTexture("Textures/blendMap")), "Textures/default");
		
		entities.add(ball);
		entities.add(goalPost);
		entities.add(obstacle);
		entities.add(obstacle1);
		entities.add(obstacle2);
	}
	
	private void loop() {
		for(Entity entity : entities) {
			renderer.processEntity(entity);
		}
		renderer.processTerrain(terrain);
		renderer.render(light, camera);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_F)) {
			camera = new Camera();
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_B)) {
			camera = new Camera(ball);
		}
		camera.move();
		
		AudioMaster.setListenerData(camera.getPosition().x,camera.getPosition().y,camera.getPosition().z);

		if(!pause) {
			if(Keyboard.isKeyDown(Keyboard.KEY_P)) {
				pause = true;
			}
			ball.move(terrain);
		}else{
			if(Keyboard.isKeyDown(Keyboard.KEY_C)) {
				pause = false;
			}
		}
		DisplayManager.updateDisplay();
	}
	
	public boolean isCollidingWithObstacles() {
		return (ball.isColliding(obstacle) || ball.isColliding(obstacle1) || ball.isColliding(obstacle2));
	}
	
	public boolean isGoal() {
		return ball.isInside(goalPost, 4f, 3f, 5f);
	}
	
	public boolean isOut() {
		return (Math.abs(ball.getPosition().x) - (terrain.SIZE / 2) >= 0 || Math.abs(ball.getPosition().z) - (terrain.SIZE / 2) >= 0);
	}
	
	public boolean isMoving() {
		return ball.getVelocity().length() > 0.01f;
	}
	
	private void end() {
		entities.clear();
		guiRenderer.cleanUp();
		source.delete();
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		AudioMaster.cleanUp();
	}
}
