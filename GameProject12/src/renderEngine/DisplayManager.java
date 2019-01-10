package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

/**
 * Manages Displays
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class DisplayManager {

	// Properties

	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
	private static final int FPS_CAP = 120;

	private static long lastFrameTime;
	private static float delta;

	//Methods
	
	/**
	 * Creates a display
	 */
	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(3, 2).withForwardCompatible(true).withProfileCore(true);

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("Action Frame!");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		lastFrameTime = getCurrentTime();
	}

	/**
	 * Updates the display
	 */
	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();

		long currentFrameTime = getCurrentTime();
		delta = (currentFrameTime - lastFrameTime) / 1000f;
		lastFrameTime = currentFrameTime;
	}

	/**
	 * Gives the frame time
	 * 
	 * @return delta
	 */
	public static float getFrameTimeSecond() {
		return delta;
	}

	/**
	 * Closes the display
	 */
	public static void closeDisplay() {
		Display.destroy();
	}

	/**
	 * Gives the current time in seconds
	 * 
	 * @return time
	 */
	private static long getCurrentTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
}
