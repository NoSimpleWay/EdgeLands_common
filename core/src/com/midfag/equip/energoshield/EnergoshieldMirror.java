package com.midfag.equip.energoshield;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midfag.game.Assets;
import com.midfag.game.Localisation;

public class EnergoshieldMirror extends Energoshield {
	

	
	public EnergoshieldMirror()
	{
		base_value=400;
		base_regen_speed=10;
		base_reflect=20;
		
		name=Localisation.get_value_from_id("name_shield_mirror");
		uid="shmirr";
		
		spr=new Sprite(Assets.load("icon_shield_mirror"));
		
		generate();
		update_attributes_bonus();
		
	}
	

}
