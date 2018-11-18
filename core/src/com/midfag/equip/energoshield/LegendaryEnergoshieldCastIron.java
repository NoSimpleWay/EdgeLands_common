package com.midfag.equip.energoshield;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midfag.game.Assets;

public class LegendaryEnergoshieldCastIron extends Energoshield {
	

	
	public LegendaryEnergoshieldCastIron()
	{
		base_value=2150;
		base_regen_speed=4;
		base_reflect=1f;
		
		name="Чугун";
		uid="shcastiron";
		
		spr=new Sprite(Assets.load("icon_shield_rock_mountain"));
		
		generate();
		update_attributes_bonus();
		
	}
	

}
