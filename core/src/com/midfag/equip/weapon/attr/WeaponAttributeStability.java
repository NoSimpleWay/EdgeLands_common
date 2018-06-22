package com.midfag.equip.weapon.attr;

import com.midfag.equip.weapon.Weapon;

public class WeaponAttributeStability extends WeaponAttribute {

	public WeaponAttributeStability()
	{
		max_level=100;
		cost=1;
		
		name="stability";
		uid="attr_stability";
	}
	
	@Override
	public void calculate(Weapon _w)
	{
		//float bonus=1-level/(level+10);
		_w.total_dispersion_additional=_w.base_dispersion_additional*(1f-level/(level+10f));
	}
}
