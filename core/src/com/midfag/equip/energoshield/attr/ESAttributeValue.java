package com.midfag.equip.energoshield.attr;

import com.midfag.equip.energoshield.Energoshield;
import com.midfag.game.Helper;

public class ESAttributeValue extends ESAttribute {
	

	
	public ESAttributeValue()
	{
		name="shield";
		uid="val";
		cost=2;
		max_level=10000;
	}
	


	@Override
	public void calculate(Energoshield _e)
	{
		_e.total_value+=_e.base_value*level*0.02f;
		_e.total_value+=level*1f;
	}
	
	@Override
	public String get_descr(Energoshield _e) {
		// TODO Auto-generated method stub
		return "ёмкость +"+Helper.round_to(_e.base_value*level*0.02f+level*1f, 10f);
	}




}
