package com.srujun.canabalt.entities;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class World extends Entity {

	public Player player;
	public ArrayList<Building> buildings = new ArrayList<Building>();
	
	public OrthographicCamera camera;
	
	public World() {
		create();
	}
	
	@Override
	public void create() {
		Gdx.app.log("Canabalt", "World.create()");
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(false);
		 
		player = new Player(300f, 608f);
		
		buildings.add(new Building(0f, 0f, Building.generateBuildingWidth(), Building.generateBuildingHeight()));
		
		for(int i = 1;i < 10;++i) {
			Building prevBuilding = buildings.get(i - 1);
			buildings.add(new Building(Building.generateBuildingPosition(prevBuilding),
					0f, Building.generateBuildingWidth(), Building.generateBuildingHeight(prevBuilding)));
		}
	}
	
	@Override
	public void update(float delta) {
		//camera.position.x += player.velocity.x * delta;
		camera.update();
		player.update(delta);
		
		if(player.bounds.overlaps(buildings.get(0).bounds)) {
			player.bounds.y = buildings.get(0).bounds.y + buildings.get(0).bounds.height;
		}
		
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			
		}
	}
	
}
