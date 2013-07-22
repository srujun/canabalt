package com.srujun.canabalt.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {

	public Rectangle bounds = new Rectangle();
	
	public Vector2 velocity = new Vector2(500f, 400f); 
	
	public Player(float xPos, float yPos) {
		this.bounds.set(xPos, yPos, 32f, 32f);
	}

	@Override
	public void create() {
		
	}

	@Override
	public void update(float delta) {
		bounds.y -= velocity.y * delta;
	}
		
}
