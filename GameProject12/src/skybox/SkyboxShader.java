package skybox;

import org.lwjgl.util.vector.Matrix4f;

import entities.Camera;

import shaders.ShaderProgram;
import toolbox.Maths;

/**
 * Skybox shader, uses shader program
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class SkyboxShader extends ShaderProgram {

	// Properties

	private static final String VERTEX_FILE = "/skybox/skyboxVertexShader.txt";
	private static final String FRAGMENT_FILE = "/skybox/skyboxFragmentShader.txt";

	private int location_projectionMatrix;
	private int location_viewMatrix;

	// Constructor

	/**
	 * Constructs the program
	 */
	public SkyboxShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	/**
	 * Loads Projection matrix
	 * 
	 * @param matrix
	 */
	public void loadProjectionMatrix(Matrix4f matrix) {
		super.loadMatrix(location_projectionMatrix, matrix);
	}

	/**
	 * Loads view matrix according to camera
	 * 
	 * @param camera
	 */
	public void loadViewMatrix(Camera camera) {
		Matrix4f matrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, matrix);
	}

	/**
	 * Gets location of the attributes
	 */
	@Override
	protected void getAllUniformLocations() {
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
	}

	/**
	 * Bind the attributes
	 */
	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}
}