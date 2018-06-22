package com.midfag.entity.decorations;

import com.badlogic.gdx.math.Vector2;
import com.midfag.game.Assets;
import com.midfag.game.Enums.EntityType;

public class DecorGraffiti extends DecorBuildingWall {

	public DecorGraffiti(Vector2 _v) {
		super(_v);
		
		custom_phys=true;
		
		id=this.getClass().getName();
		uid="25d569cf";
		type=EntityType.DECORATION;
		spr.setTexture(Assets.graffiti_01);
		icon=Assets.graffiti_01_icon;
		spr.setSize(spr.getTexture().getWidth(), spr.getTexture().getHeight());
		spr.setOrigin(spr.getTexture().getWidth()/2f, 00f);

		
		diagonal=true;
		path_x=-1;
		path_y=-1;
		//spr.setOrigin(10.0f, 65);
		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
		
		// TODO Auto-generated constructor stub
	}

}
