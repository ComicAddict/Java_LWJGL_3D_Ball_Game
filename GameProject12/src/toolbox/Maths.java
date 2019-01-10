package toolbox;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;

/**
 * Mathematical function class
 * 
 * @author Tolga YILDIZ
 * @version 19.04.2018
 */
public class Maths {

	/**
	 * Finds value of the middle of the coordinates
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param pos
	 * @return value of the middle point
	 */
	public static float barryCentric(Vector3f p1, Vector3f p2, Vector3f p3, Vector2f pos) {
		float det = (p2.z - p3.z) * (p1.x - p3.x) + (p3.x - p2.x) * (p1.z - p3.z);
		float l1 = ((p2.z - p3.z) * (pos.x - p3.x) + (p3.x - p2.x) * (pos.y - p3.z)) / det;
		float l2 = ((p3.z - p1.z) * (pos.x - p3.x) + (p1.x - p3.x) * (pos.y - p3.z)) / det;
		float l3 = 1.0f - l1 - l2;
		return l1 * p1.y + l2 * p2.y + l3 * p3.y;
	}

	/**
	 * Creates a 4x4 transformation matrix
	 * 
	 * @param translation
	 * @param rx
	 * @param ry
	 * @param rz
	 * @param scale
	 * @return matrix
	 */
	public static Matrix4f createTransformationMatrix(Vector3f translation, float rx, float ry, float rz, float scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale, scale, scale), matrix, matrix);
		return matrix;
	}

	/**
	 * Creates a 4x4 view Matrix according to the camera
	 * 
	 * @param camera
	 * @return matrix
	 */
	public static Matrix4f createViewMatrix(Camera camera) {
		Matrix4f viewMatrix = new Matrix4f();
		viewMatrix.setIdentity();
		Matrix4f.rotate((float) Math.toRadians(camera.getPitch()), new Vector3f(1, 0, 0), viewMatrix, viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getYaw()), new Vector3f(0, 1, 0), viewMatrix, viewMatrix);
		
		Vector3f negativeCameraPos = new Vector3f(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z);
		Matrix4f.translate(negativeCameraPos, viewMatrix, viewMatrix);
		return viewMatrix;
	}

	/**
	 * Creates a 4x4 transformation matrix
	 * 
	 * @param translation
	 * @param scale
	 * @return matrix
	 */
	public static Matrix4f createTransformationMatrix(Vector2f translation, Vector2f scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.scale(new Vector3f(scale.x, scale.y, 1f), matrix, matrix);
		return matrix;
	}

	/**
	 * Returns the scale of two vector
	 * 
	 * @param vec
	 * @return scale vector
	 */
	public static Vector2f getScale(Vector2f vec) {
		return getScale(vec.x, vec.y);
	}

	/**
	 * Gives a scale of two
	 * 
	 * @param xx
	 * @param yy
	 * @return scale vector
	 */
	public static Vector2f getScale(float xx, float yy) {
		float x = (float) (xx / Display.getWidth());
		float y = (float) (yy / Display.getHeight());
		float dx = (float) (x * ((double) Display.getHeight() / Display.getWidth()));
		float dy = (float) (y * ((double) Display.getHeight() / Display.getWidth()));
		return new Vector2f(dx, dy);
	}

	/**
	 * Gives the coordinates of the mouse according to the display
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @return position of the mouse
	 */
	public static Vector2f getNormalisedDeviceCoordinates(float mouseX, float mouseY) {
		float x = (2.0f * mouseX) / Display.getWidth() - 1f;
		float y = (2.0f * mouseY) / Display.getHeight() - 1f;
		return new Vector2f(x, y);
	}

	/**
	 * Gives the distance between two point
	 * 
	 * @param position
	 * @param position2
	 * @return distance
	 */
	public static float distance(Vector3f position, Vector3f position2) {
		float x = position.x - position2.x;
		float z = position.z - position2.z;
		float dis = (float) Math.sqrt(x * x + z * z);
		return dis;
	}
}