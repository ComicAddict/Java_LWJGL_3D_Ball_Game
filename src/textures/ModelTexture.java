package textures;

/* Texture of the model
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class ModelTexture {
	
	private int textureID;
	
	private float shineDamper = 1;
	private float reflectitivty = 0;
	private boolean hasTransparency = false;
	private boolean useFakeLightning = false;
	
	public ModelTexture(int texture){
		this.textureID = texture;
	}
	
	public boolean isUseFakeLightning() {
		return useFakeLightning;
	}

	public void setUseFakeLightning(boolean useFakeLightning) {
		this.useFakeLightning = useFakeLightning;
	}

	public boolean isHasTransparency() {
		return hasTransparency;
	}

	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}

	public int getID(){
		return textureID;
	}

	public float getShineDamper() {
		return shineDamper;
	}

	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	public float getReflectitivty() {
		return reflectitivty;
	}

	public void setReflectitivty(float reflectitivty) {
		this.reflectitivty = reflectitivty;
	}

	
}
