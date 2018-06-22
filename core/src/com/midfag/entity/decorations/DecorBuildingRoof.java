package com.midfag.entity.decorations;


import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.Enums.EntityType;

public class DecorBuildingRoof extends DecorBuilding {

	public DecorBuildingRoof(Vector2 _v) {
		
		super(_v);

		custom_phys=true;
		
		id=this.getClass().getName();
		uid="f7fbb5b0";
		type=EntityType.BUILDING;
		spr.setTexture(Assets.building_roof);
		icon=Assets.building_roof_icon;
		
		
		spr.setSize(100, 11);
		spr.setOrigin(50f, 0);
		
		path_x=-1;
		path_y=-1;
		
		//shield=999999;
		// TODO Auto-generated constructor stub
	}
	


}
