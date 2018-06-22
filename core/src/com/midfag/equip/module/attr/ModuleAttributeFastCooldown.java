package com.midfag.equip.module.attr;

import com.midfag.equip.module.ModuleUnit;

public class ModuleAttributeFastCooldown extends ModuleAttribute {


	//public
	
	public ModuleAttributeFastCooldown()
	{
		cost=1;
		
		max_level=1000;
		uid="mafscd";
		name="��������� �����������";;
	}
	
	@Override
	public void calculate(ModuleUnit _m)
	{
		System.out.println("CALCULATED");
		_m.total_cooldown/=1f+(level/50f);
		//_m.total_cooldown+=_m.base_cooldown*(level/25.0f);
	}
	
	@Override
	public String get_descr()
	{
		return 	"�������� ����������� ������ �� "+2*level+"%";
	}
	
}
