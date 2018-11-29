package com.midfag.equip.energoshield;

import com.midfag.equip.energoshield.attr.ESAttributeReflect;
import com.midfag.equip.energoshield.attr.ESAttributeRegen;
import com.midfag.equip.energoshield.attr.ESAttributeValue;

public class EnergoshieldRobo extends Energoshield {
	

	
	public EnergoshieldRobo()
	{
		super();
		base_value=400;
		value=400;
		base_regen_speed=30;
		base_reflect=3;
		
		name="Roboshield";
		uid="shrobo";
		gennable=false;
		
		generate();
		update_attributes_bonus();

	}
	
	@Override
	public void get_available_attribute()
	{
		Available_attribute_list.clear();
		
		Available_attribute_list.add(new ESAttributeValue());
		Available_attribute_list.add(new ESAttributeRegen());
		Available_attribute_list.add(new ESAttributeReflect());
	}
	

}
