package audio;

import org.lwjgl.openal.AL10;

/**
 * A sound source
 * 
 * @author Tolga YILDIZ
 * @version 14.04.2018
 */
public class Source {

	// Properties

	private int sourceID;

	// Constructor

	/**
	 * Constructs a source
	 */
	public Source() {
		sourceID = AL10.alGenSources();
		AL10.alSourcef(sourceID, AL10.AL_ROLLOFF_FACTOR, 1);
		AL10.alSourcef(sourceID, AL10.AL_REFERENCE_DISTANCE, 8);
		AL10.alSourcef(sourceID, AL10.AL_MAX_DISTANCE, 500);
	}

	// Methods

	/**
	 * Plays the sound with specialized buffer ID
	 * 
	 * @param buffer
	 */
	public void play(int buffer) {
		stop();
		AL10.alSourcei(sourceID, AL10.AL_BUFFER, buffer);
		continuePlaying();
	}

	/**
	 * Deletes the source
	 */
	public void delete() {
		AL10.alDeleteSources(sourceID);
	}

	/**
	 * Pauses the sound
	 */
	public void pause() {
		AL10.alSourcePause(sourceID);
	}

	/**
	 * Continues the sound
	 */
	public void continuePlaying() {
		AL10.alSourcePlay(sourceID);
	}

	/**
	 * Stops the source
	 */
	public void stop() {
		AL10.alSourceStop(sourceID);
	}

	/**
	 * Sets the velocity of the source
	 * 
	 * @param dx
	 * @param dy
	 * @param dz
	 */
	public void setVelocity(float dx, float dy, float dz) {
		AL10.alSource3f(sourceID, AL10.AL_VELOCITY, dx, dy, dz);
	}

	/**
	 * Sets the loop properties
	 * 
	 * @param loop
	 */
	public void setLooping(boolean loop) {
		AL10.alSourcei(sourceID, AL10.AL_LOOPING, loop ? AL10.AL_TRUE : AL10.AL_FALSE);
	}

	/**
	 * Gives the information of whether source is playing or not
	 * 
	 * @return information of whether source is playing or not
	 */
	public boolean isPlaying() {
		return AL10.alGetSourcei(sourceID, AL10.AL_SOURCE_STATE) == AL10.AL_PLAYING;
	}

	/**
	 * Sets the volume
	 * 
	 * @param volume
	 */
	public void setVolume(float volume) {
		AL10.alSourcef(sourceID, AL10.AL_GAIN, volume);
	}

	/**
	 * Sets the pitch
	 * 
	 * @param pitch
	 */
	public void setPitch(float pitch) {
		AL10.alSourcef(sourceID, AL10.AL_PITCH, pitch);
	}

	/**
	 * Sets the position of the source
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void setPosition(float x, float y, float z) {
		AL10.alSource3f(sourceID, AL10.AL_POSITION, x, y, z);
	}
}
