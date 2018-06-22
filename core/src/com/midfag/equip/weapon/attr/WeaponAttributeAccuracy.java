package com.midfag.equip.weapon.attr;

import com.midfag.equip.weapon.Weapon;

public class WeaponAttributeAccuracy extends WeaponAttribute {

	public WeaponAttributeAccuracy()
	{
		max_level=100;
		cost=1;
		
		name="accuracy";
		uid="attr_accuracy";
	}
	
	@Override
	public void calculate(Weapon _w)
	{
		//float bonus=1-level/(level+10);
		_w.total_dispersion=_w.base_dispersion*(1f-(level*1.5f)/(level*1.5f+10f));
	}
}
