package com.midfag.equip.energoshield;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midfag.game.Assets;
import com.midfag.game.Localisation;

public class EnergoshieldStone extends Energoshield {
	

	
	public EnergoshieldStone()
	{
		base_value=650;
		base_regen_speed=8;
		base_reflect=5f;
		
		name=Localisation.get_value_from_id("name_shield_stone");
		uid="shstone";
		
		spr=new Sprite(Assets.load("icon_shield_stone"));
		
		generate();
		update_attributes_bonus();
		
	}
	

}
