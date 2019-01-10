package models;

import textures.ModelTexture;

/**
 * Textured model is a raw model with texture wrapped around it
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class TexturedModel {

	// Properties

	private RawModel rawModel;
	private ModelTexture texture;

	// Constructor

	/**
	 * Constructs a textured model
	 * 
	 * @param model
	 * @param texture
	 */
	public TexturedModel(RawModel model, ModelTexture texture) {
		this.rawModel = model;
		this.texture = texture;
	}

	// Methods

	/**
	 * Gives raw model of the textured model
	 * 
	 * @return raw model
	 */
	public RawModel getRawModel() {
		return rawModel;
	}

	/**
	 * Returns the texture of textured model
	 * 
	 * @return
	 */
	public ModelTexture getTexture() {
		return texture;
	}
}
