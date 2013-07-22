package com.srujun.canabalt.entities;

import com.badlogic.gdx.math.Rectangle;

public class Building extends Entity {

	public Rectangle bounds = new Rectangle();
	
	public Building(float xPos, float yPos, float width, float height) {
		this.bounds.set(xPos, yPos, width, height);
	}
	
	@Override
	public void create() {
		
	}

	@Override
	public void update(float delta) {
		
	}
	
	/* Minimum width: 240px
	 * Maximum width: 860px
	 */
	public static float generateBuildingWidth() {
		return (float)(240f + (int)(Math.random() * 621f));	
	}
	
	/* Minimum height: 64px
	 * Maximum height: 574px
	 */
	public static float generateBuildingHeight() {
		return (float)(64f + (int)(Math.random() * 511f));
	}
	
	/* Minimum height: 64px
	 * Maximum height: 574px
	 * 
	 * Maximum generated difference above previous height: 96px
	 */
	public static float generateBuildingHeight(Building previousBuilding) {
		float prevHeight = previousBuilding.bounds.height;
		if((prevHeight + 96f) >= 574f) {
			// if prevHeight + maxJumpHeight >  maxPossibleHeight
			// set the range to [minimum, maximum]
			return Building.generateBuildingHeight();
		} else {
			// if prevHeight + maxJumpHeight is in range of allowed maxHeight
			// set the range to [minimum, (prevHeight + 96)]
			return (float)(64f + (int)(Math.random() * (prevHeight + 33f)));
		}
	}
	
	/* Minimum distance: 64px
	 * Maximum distance: 192px
	 */
	public static float generateBuildingPosition(Building previousBuilding) {
		return previousBuilding.bounds.x + previousBuilding.bounds.width
				+ (float)(64f + (int)(Math.random() * 119f));
	}

}
