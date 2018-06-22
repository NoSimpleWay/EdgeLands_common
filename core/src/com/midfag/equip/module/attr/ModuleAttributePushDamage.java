package com.midfag.equip.module.attr;

import com.midfag.equip.module.ModuleUnit;
import com.midfag.equip.module.ModuleUnitPush;

public class ModuleAttributePushDamage extends ModuleAttribute {


	//public
	
	public ModuleAttributePushDamage()
	{
		cost=1;
		
		max_level=100;
		uid="mapuda";
		name="�������� �����";
	}
	
	@Override
	public void calculate(ModuleUnit _m)
	{
		System.out.println("CALCULATED");
		((ModuleUnitPush)_m).total_push_damage+=((ModuleUnitPush)_m).base_push_damage*(level/20.0f);
	}
	
	@Override
	public String get_descr()
	{
		return 	"�������� ���� �� ������������ �� "+5*level+"%";
	}
}
