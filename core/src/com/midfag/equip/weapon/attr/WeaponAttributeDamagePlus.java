package com.midfag.equip.weapon.attr;

import com.midfag.equip.weapon.Weapon;

public class WeaponAttributeDamagePlus extends WeaponAttribute {

	public WeaponAttributeDamagePlus()
	{
		max_level=100;
		cost=1;
		
		name="damage";
		uid="attr_damage_plus";
	}
	
	public void calculate(Weapon _w)
	{
		_w.total_damage+=(_w.base_damage*_w.level)*(0.02f*level);
		_w.total_accuracy-=level*10;
		//_w.total_damage=_w.base_damage;
	}
}
