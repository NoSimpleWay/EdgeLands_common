package com.midfag.equip.energoshield;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midfag.equip.energoshield.attr.ESAttributeReflect;
import com.midfag.equip.energoshield.attr.ESAttributeRegen;
import com.midfag.equip.energoshield.attr.ESAttributeValue;
import com.midfag.game.Assets;
import com.midfag.game.Localisation;


public class EnergoshieldFast extends Energoshield {
	

	
	

	public EnergoshieldFast()
	{
		base_value=380;
		base_regen_speed=22;
		base_reflect=3f;
		
		name=Localisation.get_value_from_id("name_shield_fast");
		uid="shfast";
		
		
		spr=new Sprite(Assets.load("icon_shield_fast"));
		
		generate();
		update_attributes_bonus();
		
	}
	
	@Override
	public void get_available_attribute()
	{
		Available_attribute_list.clear();
		
		Available_attribute_list.add(new ESAttributeValue().set_weigth(0.5f));
		Available_attribute_list.add(new ESAttributeRegen().set_weigth(1.0f));
		Available_attribute_list.add(new ESAttributeReflect().set_weigth(0.5f));
	}
	

}
