package engineTester;

import models.RawModel;
import models.TexturedModel;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import audio.AudioMaster;
import audio.Source;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;
import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Player;
import entities.Projectile;
import guis.GuiRenderer;
import guis.GuiTexture;

/* Game tester class
 * @author Tolga Talha YILDIZ
 * @version 10.04.2018
 */
public class MainGameLoop {

	public static void main(String[] args) {
		
		List<Entity> entities = new ArrayList<Entity>();
		List<GuiTexture> guis = new ArrayList<GuiTexture>();
		
		AudioMaster.init();
		
		Source source = new Source();
		Source source1 = new Source();
		
		Boolean pause = false;
		
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		MasterRenderer renderer = new MasterRenderer(loader, "forbiddenCity");
		GuiRenderer guiRenderer = new GuiRenderer(loader);
		
		RawModel rawBall = OBJLoader.loadObjModel("3DModels/ball", loader);
		RawModel rawObst = OBJLoader.loadObjModel("3DModels/obstacle", loader);
		
		TexturedModel staticBall = new TexturedModel(rawBall, new ModelTexture(loader.loadTexture("Textures/BALL")));
		TexturedModel staticObst = new TexturedModel(rawObst, new ModelTexture(loader.loadTexture("Textures/BALL")));
	
		Projectile ball = new Projectile(staticBall, new Vector3f(), new Vector3f(1,1,1), 0.1f, 1, 0, 0, 0, 1);
		Entity obst = new Entity(staticObst, new Vector3f(), 0, 0, 0, 1);
		
		Light light = new Light(new Vector3f(3000,2000,2000), new Vector3f(1,1,1));
		Camera camera = new Camera(ball);
		AudioMaster.setListenerData(camera.getPosition().x,camera.getPosition().y,camera.getPosition().z);
		
		TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("Textures/grass"));
		TerrainTexture whiteField = new TerrainTexture(loader.loadTexture("Textures/whiteGrass"));
		TerrainTexture darkGreen = new TerrainTexture(loader.loadTexture("Textures/darkGrass"));
		TerrainTexture lightGreen = new TerrainTexture(loader.loadTexture("Textures/lightGrass"));
		
		TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, whiteField, darkGreen, lightGreen);
		
		Terrain terrain = new Terrain(-1, -1, loader, texturePack, new TerrainTexture(loader.loadTexture("Textures/blendMap")), "Textures/default");
		AL10.alDistanceModel(AL11.AL_EXPONENT_DISTANCE_CLAMPED);
		source.setPosition(0, 0, 0);
		source.setVolume(4);
		
		entities.add(ball);
		
		
		while(!Display.isCloseRequested()) {
		
			for(Entity entity : entities) {
				renderer.processEntity(entity);
			}
			
			renderer.processTerrain(terrain);
			renderer.render(light, camera);
			
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

		guiRenderer.cleanUp();
		source.delete();
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		AudioMaster.cleanUp();
	}

}
