package com.midfag.entity.decorations;


import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Phys;
import com.midfag.game.Enums.EntityType;

public class DecorCystern extends DecorStoneWall {

	public DecorCystern(Vector2 _v) {
		
		super(_v);

		custom_phys=true;
		
		id=this.getClass().getName();
		uid="3d3919bf";
		type=EntityType.INDUSTRIAL;
		spr.setTexture(Assets.cystern);
		icon=Assets.decoration_cystern_icon;
		
		//Helper.log("ID="+id);
		
		diagonal=false;
		
		spr.setSize(200, 200);
		spr.setOrigin(100, 50);
		
		path=true;
		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
	}
	
	

			
	

	

	

}
