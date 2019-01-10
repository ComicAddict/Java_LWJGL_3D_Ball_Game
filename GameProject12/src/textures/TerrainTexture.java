package textures;

/**
 * Texture of the terrain
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class TerrainTexture {

	// Properties

	private int textureID;

	// Constructor

	/**
	 * Constructs a texture with ID for vao
	 * 
	 * @param textureID
	 */
	public TerrainTexture(int textureID) {
		super();
		this.textureID = textureID;
	}

	/**
	 * Gives the ID of the texture
	 * 
	 * @return textureID
	 */
	public int getTextureID() {
		return textureID;
	}
}