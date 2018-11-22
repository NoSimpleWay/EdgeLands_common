package com.midfag.equip.energoshield;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.Localisation;

public class LegendaryEnergoshieldOptimusAdaptius extends Energoshield {
	
	public float bonus_multiplier;
	
	public LegendaryEnergoshieldOptimusAdaptius()
	{
		base_value=500;
		base_regen_speed=15;
		base_reflect=4;
		
		name=Localisation.get_value_from_id("name_shield_optimus_adaptimus");
		
		red_text="От известной студии";
		
		uid="shoptimusadaptimus";
		spr=new Sprite(Assets.load("icon_shield_optimus_adaptius"));
		
		generate();
		update_attributes_bonus();
		
		bonus_multiplier=(float) (level*10f*(Math.pow(1.26f,rarity.ordinal())))*level;
		
	}
	
	@Override
	public void damage_action(Entity _master, float _damage)
	{
		total_value+=_damage*150f/total_value*bonus_multiplier;
		total_regen_speed+=_damage*15f/total_value*bonus_multiplier;
		total_reflect+=_damage*7.5f/total_value*bonus_multiplier;
	}
	
	@Override
	public void update(float _d)
	{
		float pow=(float) Math.pow(0.97f, _d);
		
		total_value*=pow;
		total_regen_speed*=pow;
		total_reflect*=pow;
	}
	

}
