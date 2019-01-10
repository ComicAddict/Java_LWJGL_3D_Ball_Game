package audio;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.newdawn.slick.openal.WaveData;

/**
 * Master audio class
 * 
 * @author Tolga YILDIZ
 * @version 14.04.2018
 */
public class AudioMaster {

	// Properties

	private static List<Integer> buffers = new ArrayList<Integer>();

	// Methods

	/**
	 * Initializes the audio
	 */
	public static void init() {
		try {
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set the listener with given x, y, z position
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void setListenerData(float x, float y, float z) {
		AL10.alListener3f(AL10.AL_POSITION, x, y, z);
		AL10.alListener3f(AL10.AL_VELOCITY, 0, 0, 0);
	}

	/**
	 * Loads a sound
	 * 
	 * @param fileName
	 * @return buffer ID of the sound
	 */
	public static int loadSound(String fileName) {
		int buffer = AL10.alGenBuffers();
		buffers.add(buffer);
		WaveData waveFile = WaveData.create(Class.class.getResourceAsStream(fileName));
		AL10.alBufferData(buffer, waveFile.format, waveFile.data, waveFile.samplerate);
		waveFile.dispose();
		return buffer;
	}

	/**
	 * Destroys the audio master
	 */
	public static void cleanUp() {
		for (int buffer : buffers) {
			AL10.alDeleteSources(buffer);
		}
		AL.destroy();
	}
}
