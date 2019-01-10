package models;

/**
 * Raw Model created from .obj files
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class RawModel {

	// Properties

	private int vaoID;
	private int vertexCount;

	// Constructor

	/**
	 * Constructs a raw model
	 * 
	 * @param vaoID
	 * @param vertexCount
	 */
	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}

	// Method

	/**
	 * Gives vertex buffer object ID
	 * 
	 * @return vertex buffer object ID
	 */
	public int getVaoID() {
		return vaoID;
	}

	/**
	 * Gives vertex count of the object
	 * 
	 * @return vertex count of the object
	 */
	public int getVertexCount() {
		return vertexCount;
	}
}
