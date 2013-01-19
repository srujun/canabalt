package com.srujun.canabalt;

import com.badlogic.gdx.Game;

import com.srujun.canabalt.screen.GameScreen;

public class Canabalt extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
