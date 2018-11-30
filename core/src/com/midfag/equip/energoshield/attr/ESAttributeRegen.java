package com.midfag.equip.energoshield.attr;

import com.midfag.equip.energoshield.Energoshield;
import com.midfag.game.Helper;

public class ESAttributeRegen extends ESAttribute {
	

	
	public ESAttributeRegen()
	{
		name="regeneration";
		uid="reg";
		cost=1.0f;
		max_level=10000;
	}
	
	@Override
	public void calculate(Energoshield _e)
	{
		_e.total_regen_speed+=_e.base_regen_speed*(level*0.05f)+level*0.35f+_e.base_regen_speed*(_e.level-1);
	}
	
	@Override
	public String get_descr(Energoshield _e) {
		// TODO Auto-generated method stub
		return "регенерация +"+Helper.round_to(_e.base_regen_speed*(level*0.05f)+level*0.35f+_e.base_regen_speed*(_e.level-1), 10f);
	}
}
