package com.midfag.equip.energoshield.attr;

import com.midfag.entity.Entity;
import com.midfag.equip.energoshield.Energoshield;

public class ESAttribute {
	
	public float cost;
	
	public float level;
	public float max_level;
	
	public boolean need_remove=false;
	
	public String name;
	
	public boolean base=true;

	public String uid;

	public float density;
	public float weigth=1.0f;
	
	
	public ESAttribute(float _w)
	{
		level=1;
		weigth=_w;
	}
	
	public ESAttribute()
	{
		level=1;
	}
	
	public ESAttribute set_weigth(float _w) {
		// TODO Auto-generated method stub
		
		weigth=_w;
		return this;
	}

	
	public void calculate(Energoshield _e)
	{
		
	}
	
	public void update(float _d, Entity _e)
	{
		
	}
	
	
	public void get_attr_descr()
	{
		
	}

	public String get_attr_value() {
		// TODO Auto-generated method stub
		return "";
		
	}

	public String get_descr(Energoshield _e) {
		// TODO Auto-generated method stub
		return "";
	}
}
