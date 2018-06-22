package com.midfag.equip.weapon.attr;

import com.midfag.equip.weapon.Weapon;

public class WeaponAttributeReloadSpeed extends WeaponAttribute {

	public WeaponAttributeReloadSpeed()
	{
		max_level=50;
		cost=4;
		
		name="reload speed";
		uid="attr_reload_speed";
	}
	
	@Override
	public void calculate(Weapon _w)
	{
		//float bonus=1-level/(level+10);
		_w.total_reload_time=_w.base_reload_time*(1f-level/(level+10f));
	}
}
