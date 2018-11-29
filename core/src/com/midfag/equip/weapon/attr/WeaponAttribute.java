package com.midfag.equip.weapon.attr;

import com.midfag.entity.Entity;
import com.midfag.equip.weapon.Weapon;

public class WeaponAttribute {
	
	public String uid="base";
	public float cost;
	
	public float level;
	public float max_level;
	
	public int density;
	
	public boolean need_remove=false;
	
	public String name;
	
	public WeaponAttribute()
	{
		
	}
	
	public void calculate(Weapon _w)
	{
		
	}
	
	public void update(float _d, Entity pl, Weapon _w)
	{
		
	}

	public String get_descr(Weapon _w) {
		// TODO Auto-generated method stub
		return name+" ["+level+"]";
	}
}
