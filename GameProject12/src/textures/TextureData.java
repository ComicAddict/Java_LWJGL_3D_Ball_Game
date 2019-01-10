package textures;

import java.nio.ByteBuffer;

/**
 * Stores texture data
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class TextureData {

	// Properties

	private int width;
	private int height;
	private ByteBuffer buffer;

	// Constructor

	/**
	 * Constructs the data of the texture
	 * 
	 * @param buffer
	 * @param width
	 * @param height
	 */
	public TextureData(ByteBuffer buffer, int width, int height) {
		this.buffer = buffer;
		this.width = width;
		this.height = height;
	}

	/**
	 * Gives the width of the texture image
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gives the height of the texture image
	 * 
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Gives the Byte code of the texture image
	 * 
	 * @return buffer
	 */
	public ByteBuffer getBuffer() {
		return buffer;
	}
}