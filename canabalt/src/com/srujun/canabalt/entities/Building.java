package com.srujun.canabalt.entities;

import com.badlogic.gdx.math.Rectangle;

public class Building {

	public Rectangle bounds = new Rectangle();
	
	public Building(float xPos, float yPos, float width, float height) {
		this.bounds.set(xPos, yPos, width, height);
	}

}
