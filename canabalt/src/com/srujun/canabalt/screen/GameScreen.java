package com.srujun.canabalt.screen;

import com.badlogic.gdx.Gdx;
import com.srujun.canabalt.entities.World;
import com.srujun.canabalt.renderer.WorldRenderer;

public class GameScreen extends Screen {

	World world;
	WorldRenderer renderer;
	
	public GameScreen() {
		super();
		
		Gdx.app.log("Canabalt", "GameScreen.constructor()");
		
		world = new World();
		renderer = new WorldRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		world.update(delta);
		
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		renderer.dispose();
	}

}
