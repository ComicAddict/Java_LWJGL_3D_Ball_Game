package shaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

/**
 * Loads information to the shader and bind attributes and unbind them
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public abstract class ShaderProgram {

	// Properties

	private int programID;
	private int vertexShaderID;
	private int fragmentShaderID;

	private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16);

	// Constructir

	/**
	 * Creates a program which uses two files
	 * 
	 * @param vertexFile
	 * @param fragmentFile
	 */
	public ShaderProgram(String vertexFile, String fragmentFile) {
		vertexShaderID = loadShader(vertexFile, GL20.GL_VERTEX_SHADER);
		fragmentShaderID = loadShader(fragmentFile, GL20.GL_FRAGMENT_SHADER);
		programID = GL20.glCreateProgram();
		GL20.glAttachShader(programID, vertexShaderID);
		GL20.glAttachShader(programID, fragmentShaderID);
		bindAttributes();
		GL20.glLinkProgram(programID);
		GL20.glValidateProgram(programID);
		getAllUniformLocations();
	}

	/**
	 * Gets all information location
	 */
	protected abstract void getAllUniformLocations();

	/**
	 * Gives the location of an attributes
	 * 
	 * @param uniformName
	 * @return location of the attribute
	 */
	protected int getUniformLocation(String uniformName) {
		return GL20.glGetUniformLocation(programID, uniformName);
	}

	/**
	 * Starts to using the program
	 */
	public void start() {
		GL20.glUseProgram(programID);
	}

	/**
	 * Stops the usage of the program
	 */
	public void stop() {
		GL20.glUseProgram(0);
	}

	/**
	 * Stops the program Clears all components
	 */
	public void cleanUp() {
		stop();
		GL20.glDetachShader(programID, vertexShaderID);
		GL20.glDetachShader(programID, fragmentShaderID);
		GL20.glDeleteShader(vertexShaderID);
		GL20.glDeleteShader(fragmentShaderID);
		GL20.glDeleteProgram(programID);
	}

	/**
	 * Loads attributes to vaos
	 */
	protected abstract void bindAttributes();

	/**
	 * Loads attributes
	 * 
	 * @param attribute
	 * @param variableName
	 */
	protected void bindAttribute(int attribute, String variableName) {
		GL20.glBindAttribLocation(programID, attribute, variableName);
	}

	/**
	 * Loads float variables to the attribute location
	 * 
	 * @param location
	 * @param value
	 */
	protected void loadFloat(int location, float value) {
		GL20.glUniform1f(location, value);
	}

	/**
	 * Loads integer variables to the attribute location
	 * 
	 * @param location
	 * @param value
	 */
	protected void loadInt(int location, int value) {
		GL20.glUniform1i(location, value);
	}

	/**
	 * Loads vectorial variables to the attribute location
	 * 
	 * @param location
	 * @param vector
	 */
	protected void loadVector(int location, Vector3f vector) {
		GL20.glUniform3f(location, vector.x, vector.y, vector.z);
	}

	/**
	 * Loads boolean variables to the attribute location
	 * 
	 * @param location
	 * @param value
	 */
	protected void loadBoolean(int location, boolean value) {
		float toLoad = 0;
		if (value) {
			toLoad = 1;
		}
		GL20.glUniform1f(location, toLoad);
	}

	/**
	 * Loads matrix variables to the attribute location
	 * 
	 * @param location
	 * @param matrix
	 */
	protected void loadMatrix(int location, Matrix4f matrix) {
		matrix.store(matrixBuffer);
		matrixBuffer.flip();
		GL20.glUniformMatrix4(location, false, matrixBuffer);
	}

	/**
	 * Loads the shader program file
	 * 
	 * @param file
	 * @param type
	 * @return
	 */
	private static int loadShader(String file, int type) {
		StringBuilder shaderSource = new StringBuilder();
		try {
			InputStream in = Class.class.getResourceAsStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				shaderSource.append(line).append("//\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		int shaderID = GL20.glCreateShader(type);
		GL20.glShaderSource(shaderID, shaderSource);
		GL20.glCompileShader(shaderID);
		if (GL20.glGetShader(shaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.out.println(GL20.glGetShaderInfoLog(shaderID, 500));
			System.err.println("Could not compile shader!");
			System.exit(-1);
		}
		return shaderID;
	}
}