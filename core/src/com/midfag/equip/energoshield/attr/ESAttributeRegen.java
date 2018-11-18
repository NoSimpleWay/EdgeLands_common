package com.midfag.equip.energoshield.attr;

import com.midfag.equip.energoshield.Energoshield;

public class ESAttributeRegen extends ESAttribute {
	

	
	public ESAttributeRegen()
	{
		name="regeneration";
		uid="reg";
		cost=2.0f;
		max_level=10000;
	}
	
	@Override
	public void calculate(Energoshield _e)
	{
		_e.total_regen_speed+=_e.base_regen_speed*(level*0.025f)+level*0.15f+_e.base_regen_speed*(_e.level-1);
	}
	
	@Override
	public String get_descr() {
		// TODO Auto-generated method stub
		return "+"+level*2.5f+"% скорость регенерации +"+level*0.15f+"/сек скорость регенерации";
	}
}
