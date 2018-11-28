package com.midfag.equip.weapon.attr;

import com.midfag.equip.weapon.Weapon;

public class WeaponAttributeClipSizePlus extends WeaponAttribute {

	public WeaponAttributeClipSizePlus()
	{
		max_level=5;
		cost=3;
		
		name="clip size";
		uid="attr_clip_size_plus";
	}
	
	 //electro engine https://www.freesound.org/home/pending/ 21.02.2017 04^36^13
	
	
	public void calculate(Weapon _w)
	{
		_w.total_ammo_size=_w.base_ammo_size*(2f+1.0f*level);
		_w.total_reload_time+=0.05f*level+_w.base_reload_time*0.05f*level;
	}
}
