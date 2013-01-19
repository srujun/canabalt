package com.srujun.canabalt.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import com.srujun.canabalt.entities.Building;
import com.srujun.canabalt.entities.World;

public class WorldRenderer {

	OrthographicCamera camera;
	ShapeRenderer shapeBatch;
	SpriteBatch spriteBatch;
	
	World world;
	FPSLogger fps = new FPSLogger();
	
	BitmapFont font;
	
	public WorldRenderer(World world) {
		this.world = world;
		
		create();
	}
	
	public void create() {
		Gdx.app.log("Canabalt", "WorldRenderer.create()");
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(false);
		
		shapeBatch = new ShapeRenderer();
		spriteBatch = new SpriteBatch();
		
		font = new BitmapFont(Gdx.files.internal("fonts/visitor-tt2-32.fnt"), false);
	}
	
	public void render(float delta) {
		fps.log();
		
		shapeBatch.setProjectionMatrix(camera.combined);
		spriteBatch.setProjectionMatrix(camera.combined);
		camera.update();
		
		spriteBatch.begin();
			font.draw(spriteBatch, "# Buildings: " + world.buildingsArray.size(), 0, 640);
		spriteBatch.end();
		
		shapeBatch.begin(ShapeType.FilledRectangle);
			shapeBatch.setColor(1f, 1f, 1f, 1f);
			shapeBatch.filledRect(world.player.bounds.x, world.player.bounds.y, world.player.bounds.width, world.player.bounds.height);
		shapeBatch.end();
			
		for(Building building: world.buildingsArray) {
			shapeBatch.begin(ShapeType.FilledRectangle);
				shapeBatch.setColor(0.5f, 0.5f, 0.5f, 1f);
				shapeBatch.filledRect(building.bounds.x, building.bounds.y, building.bounds.width, building.bounds.height);
			shapeBatch.end();
		
			spriteBatch.begin();
				shapeBatch.setColor(1f, 1f, 1f, 1f);
				font.draw(spriteBatch,
					"X: " + building.bounds.x + ", Y: " + building.bounds.y,
					building.bounds.x, building.bounds.y + 32f);
				font.draw(spriteBatch, "W: " + building.bounds.width + ", H: " + building.bounds.height,
					building.bounds.x, building.bounds.y + 16f);
			spriteBatch.end();
		}
	}
	
	public void dispose() {
		shapeBatch.dispose();
	}

}