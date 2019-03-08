package models;

import textures.ModelTexture;

/* Textured model is a raw model with texture wrapped around it 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class TexturedModel {
	
	// Properties
	
	private RawModel rawModel;
	private ModelTexture texture;
	
	// Constructor
	
	public TexturedModel(RawModel model, ModelTexture texture){
		this.rawModel = model;
		this.texture = texture;
	}

	// Methods
	
	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getTexture() {
		return texture;
	}

}
