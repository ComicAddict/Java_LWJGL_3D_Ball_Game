package terrains;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import models.RawModel;
import renderEngine.Loader;
import textures.TerrainTexture;
import textures.TerrainTexturePack;
import toolbox.Maths;

/* Terrain, platform which entities stands on
 * @author Tolga Talha YILDIZ
 * @version 19.04.2018
 */
public class Terrain {
	
	private static final int DEFAULT_VERTEX_COUNT = 1024;
	private static final float DEFAULT_HEIGHT = -150;
	private static final float MAX_HEIGHT = 20;
	private static final float MAX_PIXEL_COLOR = 256 * 256 * 256;
	public static final float SIZE = 80;
	
	private float x;
	private float z;
	private RawModel model;
	private TerrainTexturePack texture;
	private TerrainTexture blendMap;
	private boolean hasHeightMap = false;
	
	private float[][] heights;
	
	public Terrain(float gridX, float gridZ, Loader loader, TerrainTexturePack texture, TerrainTexture blendMap) {
		this.texture = texture;
		this.blendMap = blendMap;
		this.x = gridX * SIZE / 2;
		this.z = gridZ * SIZE / 2;
		this.model = generateTerrain(loader);
	}
	
	public Terrain(float gridX, float gridZ, Loader loader, TerrainTexturePack texture, TerrainTexture blendMap, String heightMap) {
		this.texture = texture;
		this.blendMap = blendMap;
		this.x = gridX * SIZE / 2;
		this.z = gridZ * SIZE / 2;
		this.model = generateTerrain(loader, heightMap);
		hasHeightMap = true;
	}
	
	public boolean hasHeightMap() {
		return hasHeightMap;
	}
	
	public float getX() {
		return x;
	}

	public float getZ() {
		return z;
	}

	public RawModel getModel() {
		return model;
	}

	public TerrainTexturePack getTexture() {
		return texture;
	}

	public TerrainTexture getBlendMap() {
		return blendMap;
	}
	
	public float getHeightOfTerrain(float worldX, float worldZ) {
		float answer;
		if(hasHeightMap) {
			float terrainX = worldX - this.x;
			float terrainZ = worldZ - this.z;
			float gridSquareSize = SIZE / ((float)heights.length - 1);
			int gridX = (int) Math.floor(terrainX / gridSquareSize);
			int gridZ = (int) Math.floor(terrainZ  / gridSquareSize);
			
			if(gridX >= heights.length - 1 || gridZ >= heights.length || gridX < 0 || gridZ < 0) {
				return 0;
			}
			
			float xCoord = (terrainX % gridSquareSize) / gridSquareSize;
			float zCoord = (terrainZ % gridSquareSize) / gridSquareSize;
			if (xCoord <= (1-zCoord)) {
				answer = Maths.barryCentric(new Vector3f(0, heights[gridX][gridZ], 0), new Vector3f(1,
								heights[gridX + 1][gridZ], 0), new Vector3f(0,
								heights[gridX][gridZ + 1], 1), new Vector2f(xCoord, zCoord));
			} else {
				answer = Maths.barryCentric(new Vector3f(1, heights[gridX + 1][gridZ], 0), new Vector3f(1,
								heights[gridX + 1][gridZ + 1], 1), new Vector3f(0,
								heights[gridX][gridZ + 1], 1), new Vector2f(xCoord, zCoord));
			}
		} else {
			answer = DEFAULT_HEIGHT;
		}
		return answer;
	}

	private RawModel generateTerrain(Loader loader, String heightMap){
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("res/" + heightMap + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int VERTEX_COUNT = image.getHeight();
		
		heights = new float[VERTEX_COUNT][VERTEX_COUNT];
		
		int count = VERTEX_COUNT * VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count * 2];
		int[] indices = new int[6 * (VERTEX_COUNT - 1) * (VERTEX_COUNT - 1)];
		int vertexPointer = 0;
		for(int i = 0; i < VERTEX_COUNT; i++){
			for(int j = 0; j < VERTEX_COUNT; j++){
				heights[j][i] = getHeight(j, i, image);
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				vertices[vertexPointer*3+1] = getHeight(j, i, image);
				vertices[vertexPointer*3+2] = (float)i/((float)VERTEX_COUNT - 1) * SIZE;
				Vector3f normal = calculateNormal(j - 1 , i - 1, image);
				normals[vertexPointer * 3] = normal.x;
				normals[vertexPointer * 3 + 1] = normal.y;
				normals[vertexPointer * 3 + 2] = normal.z;
				textureCoords[vertexPointer * 2] = (float)j/((float)VERTEX_COUNT - 1);
				textureCoords[vertexPointer * 2 + 1] = (float)i/((float)VERTEX_COUNT - 1);
				vertexPointer++;
			}
		}
		int pointer = 0;
		for(int gz=0;gz<VERTEX_COUNT-1;gz++){
			for(int gx=0;gx<VERTEX_COUNT-1;gx++){
				int topLeft = (gz*VERTEX_COUNT)+gx;
				int topRight = topLeft + 1;
				int bottomLeft = ((gz+1)*VERTEX_COUNT)+gx;
				int bottomRight = bottomLeft + 1;
				indices[pointer++] = topLeft;
				indices[pointer++] = bottomLeft;
				indices[pointer++] = topRight;
				indices[pointer++] = topRight;
				indices[pointer++] = bottomLeft;
				indices[pointer++] = bottomRight;
			}
		}
		return loader.loadToVAO(vertices, textureCoords, normals, indices);
	}
	
	private RawModel generateTerrain(Loader loader){
		int count = DEFAULT_VERTEX_COUNT * DEFAULT_VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices = new int[6*(DEFAULT_VERTEX_COUNT-1)*(DEFAULT_VERTEX_COUNT-1)];
		int vertexPointer = 0;
		for(int i=0;i<DEFAULT_VERTEX_COUNT;i++){
			for(int j=0;j<DEFAULT_VERTEX_COUNT;j++){
				vertices[vertexPointer*3] = (float)j/((float)DEFAULT_VERTEX_COUNT - 1) * SIZE;
				vertices[vertexPointer*3+1] = -100;
				vertices[vertexPointer*3+2] = (float)i/((float)DEFAULT_VERTEX_COUNT - 1) * SIZE;
				normals[vertexPointer*3] = 0;
				normals[vertexPointer*3+1] = 1;
				normals[vertexPointer*3+2] = 0;
				textureCoords[vertexPointer*2] = (float)j/((float)DEFAULT_VERTEX_COUNT - 1);
				textureCoords[vertexPointer*2+1] = (float)i/((float)DEFAULT_VERTEX_COUNT - 1);
				vertexPointer++;
			}
		}
		int pointer = 0;
		for(int gz=0;gz<DEFAULT_VERTEX_COUNT-1;gz++){
			for(int gx=0;gx<DEFAULT_VERTEX_COUNT-1;gx++){
				int topLeft = (gz*DEFAULT_VERTEX_COUNT)+gx;
				int topRight = topLeft + 1;
				int bottomLeft = ((gz+1)*DEFAULT_VERTEX_COUNT)+gx;
				int bottomRight = bottomLeft + 1;
				indices[pointer++] = topLeft;
				indices[pointer++] = bottomLeft;
				indices[pointer++] = topRight;
				indices[pointer++] = topRight;
				indices[pointer++] = bottomLeft;
				indices[pointer++] = bottomRight;
			}
		}
		return loader.loadToVAO(vertices, textureCoords, normals, indices);
	}
	
	private Vector3f calculateNormal(int x, int z, BufferedImage image) {
		float heightL = getHeight(x - 1, z, image);
		float heightR = getHeight(x + 1, z, image);
		float heightD = getHeight(x, z - 1, image);
		float heightU = getHeight(x, z + 1, image);
		
		Vector3f normal = new Vector3f(heightL - heightR, 2f, heightD - heightU);
		normal.normalise();
		
		return normal;
	}
	
	private float getHeight(int x, int z, BufferedImage image) {
		if( x < 0 || x > image.getHeight() || z < 0 || z > image.getWidth()) {
			return 0;
		}
		float height = image.getRGB(x, z);
		height += MAX_PIXEL_COLOR / 2;
		height /= MAX_PIXEL_COLOR;
		height *= MAX_HEIGHT;
		return height;
	}
}
