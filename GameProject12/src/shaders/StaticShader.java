package shaders;

import org.lwjgl.util.vector.Matrix4f;

import toolbox.Maths;

import entities.Camera;
import entities.Light;

/**
 * Shades entities
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class StaticShader extends ShaderProgram {

	// Properties

	private static final String VERTEX_FILE = "/shaders/vertexShader.txt";
	private static final String FRAGMENT_FILE = "/shaders/fragmentShader.txt";

	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_lightPosition;
	private int location_lightColour;
	private int location_shineDamper;
	private int location_reflectivity;
	private int location_useFakeLightning;

	// Constructor

	/**
	 * Constructs the shader
	 */
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	//Methods
	
	/**
	 * Binds vaos
	 */
	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoordinates");
		super.bindAttribute(2, "normal");
	}

	/**
	 * Gets all information
	 */
	@Override
	protected void getAllUniformLocations() {
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		location_lightPosition = super.getUniformLocation("lightPosition");
		location_lightColour = super.getUniformLocation("lightColour");
		location_shineDamper = super.getUniformLocation("shineDamper");
		location_reflectivity = super.getUniformLocation("reflectivity");
		location_useFakeLightning = super.getUniformLocation("useFakeLightning");
	}

	/**
	 * Loads the fake light
	 * 
	 * @param useFake
	 */
	public void loadFakeLightningVariable(boolean usingFake) {
		super.loadBoolean(location_useFakeLightning, usingFake);
	}

	/**
	 * Loads shining variables
	 * 
	 * @param damper
	 * @param reflectivity
	 */
	public void loadShineVariables(float damper, float reflectivity) {
		super.loadFloat(location_shineDamper, damper);
		super.loadFloat(location_reflectivity, reflectivity);
	}

	/**
	 * Loads transformation matrix
	 * 
	 * @param matrix
	 */
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(location_transformationMatrix, matrix);
	}

	/**
	 * Loads light
	 * 
	 * @param light
	 */
	public void LoadLight(Light light) {
		super.loadVector(location_lightPosition, light.getPosition());
		super.loadVector(location_lightColour, light.getColor());
	}

	/**
	 * Loads view matrix according to the camera
	 * 
	 * @param camera
	 */
	public void loadViewMatrix(Camera camera) {
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}

	/**
	 * Loads projection matrix
	 * 
	 * @param projection
	 */
	public void loadProjectionMatrix(Matrix4f projection) {
		super.loadMatrix(location_projectionMatrix, projection);
	}
}
