package com.srujun.canabalt.entities;

import com.badlogic.gdx.math.Rectangle;

public class Player {

	public Rectangle bounds = new Rectangle();
	
	public Player(float xPos, float yPos) {
		this.bounds.set(xPos, yPos, 32f, 32f);
	}
	
	
}