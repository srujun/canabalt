package com.srujun.canabalt.entities;

import java.lang.Math;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;

public class World {

	public Player player;
	public ArrayList<Building> buildingsArray = new ArrayList<Building>();
	
	public World() {
		create();
	}
	
	public void create() {
		Gdx.app.log("Canabalt", "World.create()");
		
		player = new Player(928f, 608f);
		
		buildingsArray.add(new Building(0f, 0f, generateBuildingWidth(), generateBuildingHeight()));
		
		for(int i = 1;i < 2;++i) {
			buildingsArray.add(new Building(buildingsArray.get(i - 1).bounds.width + generateBuildingDistance(),
					0f, generateBuildingWidth(), generateBuildingHeight()));
		}
	}
	
	public void update(float delta) {
	}
	
	/*
	 * Minimum width: 240px
	 * Maximum width: 860px
	 */
	private float generateBuildingWidth() {
		return (float)(240f + (int)(Math.random() * 621f));	
	}
	
	/*
	 * Minimum height: 64px
	 * Maximum height: 574px
	 * 
	 * Maximum generated difference above previous height: 96px
	 */
	private float generateBuildingHeight() {
		if(buildingsArray.size() < 1)
			return (float)(64f + (int)(Math.random() * 511f));
		else {
			float prevHeight = buildingsArray.get(buildingsArray.size() - 1).bounds.height;
			if((prevHeight + 96f) >= 574f) {
				// if prevHeight + maxJumpHeight >  maxPossibleHeight
				// set the range to [minimum, maximum]
				return (float)(64f + (int)(Math.random() * 511f));
			} else {
				// if prevHeight + maxJumpHeight is in range of allowed maxHeight
				// set the range to [minimum, (prevHeight + 96)]
				return (float)(64f + (int)(Math.random() * (prevHeight + 33f)));
			}
		}
	}
	
	/*
	 * Minimum distance: 64px
	 * Maximum distance: 192px
	 */
	private float generateBuildingDistance() {
		return (float)(64f + (int)(Math.random() * 119f));
	}

}
