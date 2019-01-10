package textures;

/**
 * Texture of the model
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class ModelTexture {

	// Properties

	private int textureID;

	private float shineDamper;
	private float reflectitivty;
	private boolean hasTransparency;
	private boolean usingFakeLightning;

	// Constructor

	/**
	 * Constructs the texture
	 * 
	 * @param texture
	 */
	public ModelTexture(int texture) {
		shineDamper = 1;
		reflectitivty = 0;
		hasTransparency = false;
		usingFakeLightning = false;
		this.textureID = texture;
	}

	/**
	 * Gives the information of presence of fake lights
	 * 
	 * @return information of presence of fake lights
	 */
	public boolean isUsingFakeLightning() {
		return usingFakeLightning;
	}

	/**
	 * Sets fake lights
	 * 
	 * @param usingFakeLightning
	 */
	public void setUsingFakeLightning(boolean usingFakeLightning) {
		this.usingFakeLightning = usingFakeLightning;
	}

	/**
	 * Gives the information of transparency of the object
	 * 
	 * @return information of transparency of the object
	 */
	public boolean hasTransparency() {
		return hasTransparency;
	}

	/**
	 * Set the information of transparency of the object
	 * 
	 * @param hasTransparency
	 */
	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}

	/**
	 * Gives ID of the texture
	 * 
	 * @return ID
	 */
	public int getID() {
		return textureID;
	}

	/**
	 * Gives the shine damper coefficient
	 * 
	 * @return shine damper
	 */
	public float getShineDamper() {
		return shineDamper;
	}

	/**
	 * Sets the shine damper coefficient
	 * 
	 * @param shineDamper
	 */
	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	/**
	 * Gives the reflectivity of the object
	 * 
	 * @return reflectivity
	 */
	public float getReflectitivty() {
		return reflectitivty;
	}

	/**
	 * Sets the refkectivity of the object
	 * 
	 * @param reflectitivty
	 */
	public void setReflectitivty(float reflectitivty) {
		this.reflectitivty = reflectitivty;
	}
}