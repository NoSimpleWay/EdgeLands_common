package com.midfag.entity.decorations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Main;
import com.midfag.game.Enums.EntityType;

public class SSD extends Entity {
public SSD(Vector2 _v) {
		
		super(_v);

		id=this.getClass().getName();
		//foot.setSize(30, 6);
		
		
		mass=10000;
		friction=100;
		
		is_decor=true;
		is_AI=false;
		is_enemy=false;
		is_player=false;

		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
		
		type=EntityType.SYSTEM;
		//main_tex=Assets.rect_white;
		
		if (!texture_path.equals(""))
		{
			Helper.log("Main texture path is |"+texture_path+"|");
			main_tex=Assets.load(texture_path);
		}

	}
	


	
	

}
