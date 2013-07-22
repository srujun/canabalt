package com.srujun.canabalt.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.srujun.canabalt.entities.Building;
import com.srujun.canabalt.entities.World;

public class WorldRenderer {

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
		
		shapeBatch = new ShapeRenderer();
		spriteBatch = new SpriteBatch();
		
		font = new BitmapFont(Gdx.files.internal("fonts/visitor-tt2-32.fnt"), false);
	}
	
	public void render(float delta) {
		fps.log();
		
		shapeBatch.setProjectionMatrix(world.camera.combined);
		spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		world.camera.update();
		
		spriteBatch.begin();
			font.draw(spriteBatch, "# Buildings: " + world.buildings.size(), 0, 640);
		spriteBatch.end();
		
		spriteBatch.setProjectionMatrix(world.camera.combined);
		
		for(Building building: world.buildings) {
			shapeBatch.begin(ShapeType.Filled);
				shapeBatch.setColor(0.5f, 0.5f, 0.5f, 1f);
				shapeBatch.rect(building.bounds.x, building.bounds.y, building.bounds.width, building.bounds.height);
			shapeBatch.end();
		
			spriteBatch.begin();
				font.draw(spriteBatch, "Building #" + (world.buildings.indexOf(building) + 1),
						building.bounds.x, building.bounds.y + 48f);
				font.draw(spriteBatch, "X: " + building.bounds.x + ", Y: " + building.bounds.y,
					building.bounds.x, building.bounds.y + 32f);
				font.draw(spriteBatch, "W: " + building.bounds.width + ", H: " + building.bounds.height,
					building.bounds.x, building.bounds.y + 16f);
			spriteBatch.end();
		}
		
		shapeBatch.begin(ShapeType.Filled);
		shapeBatch.setColor(1f, 1f, 1f, 1f);
		shapeBatch.rect(world.player.bounds.x, world.player.bounds.y,
				world.player.bounds.width, world.player.bounds.height);
		shapeBatch.end();
	}
	
	public void dispose() {
		spriteBatch.dispose();
		shapeBatch.dispose();
	}

}
