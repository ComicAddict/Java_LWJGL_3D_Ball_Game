package renderEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import models.TexturedModel;
import shaders.StaticShader;
import skybox.SkyboxRenderer;
import terrains.Terrain;
import terrains.TerrainShader;

/**
 * Renderer
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class MasterRenderer {

	// Properties

	private static final float FOV = 70;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 10000;

	private Matrix4f projectionMatrix;
	private StaticShader shader = new StaticShader();
	private EntityRenderer renderer;
	private TerrainShader terrainShader = new TerrainShader();
	private TerrainRenderer terrainRenderer;
	private SkyboxRenderer skyboxRenderer;
	private Map<TexturedModel, List<Entity>> entities = new HashMap<TexturedModel, List<Entity>>();
	private List<Terrain> terrains = new ArrayList<Terrain>();

	// Constructors

	/**
	 * Creates a renderer
	 */
	public MasterRenderer() {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		shader = new StaticShader();
		terrainShader = new TerrainShader();
		entities = new HashMap<TexturedModel, List<Entity>>();
		terrains = new ArrayList<Terrain>();
		createProjectionMatrix();
		renderer = new EntityRenderer(shader, projectionMatrix);
		terrainRenderer = new TerrainRenderer(terrainShader, projectionMatrix);
	}

	/**
	 * Creates a renderer with a skybox setup
	 * 
	 * @param loader
	 * @param map
	 */
	public MasterRenderer(Loader loader, String map) {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		shader = new StaticShader();
		terrainShader = new TerrainShader();
		entities = new HashMap<TexturedModel, List<Entity>>();
		terrains = new ArrayList<Terrain>();
		createProjectionMatrix();
		renderer = new EntityRenderer(shader, projectionMatrix);
		terrainRenderer = new TerrainRenderer(terrainShader, projectionMatrix);
		skyboxRenderer = new SkyboxRenderer(loader, projectionMatrix, map);
	}

	/**
	 * Enables culling
	 */
	public static void enableCulling() {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
	}

	/**
	 * Disables culling
	 */
	public static void disableCulling() {
		GL11.glDisable(GL11.GL_CULL_FACE);
	}

	/**
	 * Renders objects according to camera and light
	 * 
	 * @param sun
	 * @param camera
	 */
	public void render(Light sun, Camera camera) {
		prepare();
		shader.start();
		shader.LoadLight(sun);
		shader.loadViewMatrix(camera);
		renderer.render(entities);
		shader.stop();
		terrainShader.start();
		terrainShader.LoadLight(sun);
		terrainShader.loadViewMatrix(camera);
		terrainRenderer.render(terrains);
		terrainShader.stop();
		skyboxRenderer.render(camera);
		entities.clear();
		terrains.clear();
	}

	/**
	 * Adds a terrain to the list
	 * 
	 * @param terrain
	 */
	public void processTerrain(Terrain terrain) {
		terrains.add(terrain);
	}

	/**
	 * Prepares the rendering setup
	 */
	public void prepare() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0, 0.3f, 0.0f, 1);
	}

	/**
	 * Processes an entity
	 * 
	 * @param entity
	 */
	public void processEntity(Entity entity) {
		TexturedModel entityModel = entity.getModel();
		List<Entity> batch = entities.get(entityModel);
		if (batch != null) {
			batch.add(entity);
		} else {
			List<Entity> newBatch = new ArrayList<Entity>();
			newBatch.add(entity);
			entities.put(entityModel, newBatch);
		}
	}

	/**
	 * Cleans all the components
	 */
	public void cleanUp() {
		shader.cleanUp();
		terrainShader.cleanUp();
	}

	/**
	 * creates a projection matrix
	 */
	private void createProjectionMatrix() {
		float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
		float y_scale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
		float x_scale = y_scale / aspectRatio;
		float frustum_length = FAR_PLANE - NEAR_PLANE;

		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = x_scale;
		projectionMatrix.m11 = y_scale;
		projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustum_length);
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustum_length);
		projectionMatrix.m33 = 0;
	}

}
