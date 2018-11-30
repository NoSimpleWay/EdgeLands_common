package com.midfag.equip.energoshield;

import com.midfag.game.Localisation;

public class EnergoshieldSimple extends Energoshield {
	

	
	public EnergoshieldSimple()
	{
		base_value=500;
		base_regen_speed=15;
		base_reflect=9;
		
		name=Localisation.get_value_from_id("name_shield_balanced");
		uid="shsimple";
		
		generate();
		update_attributes_bonus();
		
	}
	

}
