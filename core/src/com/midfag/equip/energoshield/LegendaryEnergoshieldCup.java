package com.midfag.equip.energoshield;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midfag.game.Assets;
import com.midfag.game.Localisation;

public class LegendaryEnergoshieldCup extends Energoshield {
	

	
	

	public LegendaryEnergoshieldCup()
	{
		base_value=470;
		base_regen_speed=50;
		base_reflect=7f;
		
		name=Localisation.get_value_from_id("name_shield_cup");
		
		red_text="Ќаполовину пуста, или наполовину полна€?";
		
		uid="shlegcup";
		
		
		spr=new Sprite(Assets.load("icon_cup_shield"));
		
		generate();
		update_attributes_bonus();
		
	}
	
	@Override
	public void update(float _d)
	{
		if (value>=total_value)
		{
			value=total_value/2f;
		}
	}
	

}
