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
		_w.total_accuracy+=level*50;
		_w.total_accuracy+=_w.base_accuracy*level/100f;
	}
	
	@Override
	public String get_descr(Weapon _w) {
		// TODO Auto-generated method stub
		return "меткость +"+(level*50+_w.base_accuracy*level/100f)+" ед.";
	}
}
