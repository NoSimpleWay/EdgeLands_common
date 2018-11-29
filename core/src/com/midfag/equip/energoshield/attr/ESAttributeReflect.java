package com.midfag.equip.energoshield.attr;

import com.midfag.equip.energoshield.Energoshield;


public class ESAttributeReflect extends ESAttribute {
	

	
	public ESAttributeReflect()
	{
		name="reflection";
		uid="refl";
		cost=1;
		max_level=10000;
	}
	
	@Override
	public void calculate(Energoshield _e)
	{
		_e.total_reflect+=_e.base_reflect*level*0.03f;
		_e.total_reflect+=level*0.5f;

	}
	
	@Override
	public String get_descr() {
		// TODO Auto-generated method stub
		return "+"+level*3f+"%/+"+level*0.5+" уровень отражения";
	}
}
