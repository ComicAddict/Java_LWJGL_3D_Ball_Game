package textures;

/**
 * A texture containing 4 other texture
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class TerrainTexturePack {

	// Properties

	private TerrainTexture backgroundTexture;
	private TerrainTexture rTexture;
	private TerrainTexture gTexture;
	private TerrainTexture bTexture;

	// Constructor

	/**
	 * Constructs the pack
	 * 
	 * @param backgroundTexture
	 * @param rTexture
	 * @param gTexture
	 * @param bTexture
	 */
	public TerrainTexturePack(TerrainTexture backgroundTexture, TerrainTexture rTexture, TerrainTexture gTexture,
			TerrainTexture bTexture) {
		this.backgroundTexture = backgroundTexture;
		this.rTexture = rTexture;
		this.gTexture = gTexture;
		this.bTexture = bTexture;
	}

	/**
	 * Gives background texture
	 * 
	 * @return backgroundTexture
	 */
	public TerrainTexture getBackgroundTexture() {
		return backgroundTexture;
	}

	/**
	 * Gives red texture
	 * 
	 * @return rTexture
	 */
	public TerrainTexture getrTexture() {
		return rTexture;
	}

	/**
	 * Gives green texture
	 * 
	 * @return gTexture
	 */
	public TerrainTexture getgTexture() {
		return gTexture;
	}

	/**
	 * Gives blue Texture
	 * 
	 * @return bTexture
	 */
	public TerrainTexture getbTexture() {
		return bTexture;
	}
}