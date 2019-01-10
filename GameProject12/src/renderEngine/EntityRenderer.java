package renderEngine;

import models.RawModel;
import models.TexturedModel;

import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import shaders.StaticShader;
import textures.ModelTexture;
import toolbox.Maths;

import entities.Entity;

/**
 * Renders Entity
 * 
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class EntityRenderer {

	// Properties

	private StaticShader shader;

	// Constructor

	/**
	 * Creates an entity renderer
	 * 
	 * @param shader
	 * @param projectionMatrix
	 */
	public EntityRenderer(StaticShader shader, Matrix4f projectionMatrix) {
		this.shader = shader;
		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.stop();
	}

	/**
	 * Renders a list of entities
	 * 
	 * @param entities
	 */
	public void render(Map<TexturedModel, List<Entity>> entities) {
		for (TexturedModel model : entities.keySet()) {
			prepareTexturedModel(model);
			List<Entity> batch = entities.get(model);
			for (Entity entity : batch) {
				prepareInstances(entity);
				GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
			}
			unbindTexturedVoid();
		}
	}

	/**
	 * Prepares textures
	 * 
	 * @param model
	 */
	private void prepareTexturedModel(TexturedModel model) {
		RawModel rawModel = model.getRawModel();
		GL30.glBindVertexArray(rawModel.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);
		ModelTexture texture = model.getTexture();
		if (texture.hasTransparency()) {
			MasterRenderer.disableCulling();
		}
		shader.loadFakeLightningVariable(texture.isUsingFakeLightning());
		shader.loadShineVariables(texture.getShineDamper(), texture.getReflectitivty());
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
	}

	/**
	 * Clears the data from vbo slots
	 */
	private void unbindTexturedVoid() {
		MasterRenderer.enableCulling();
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);
	}

	/**
	 * Prepares the transformation matrix for the entity
	 * 
	 * @param entity
	 */
	private void prepareInstances(Entity entity) {
		Matrix4f transformationMatrix = Maths.createTransformationMatrix(entity.getPosition(), entity.getRotX(),
				entity.getRotY(), entity.getRotZ(), entity.getScale());
		shader.loadTransformationMatrix(transformationMatrix);
	}
}