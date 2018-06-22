package com.midfag.equip.module;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.midfag.entity.Entity;
import com.midfag.equip.module.attr.ModuleAttributeExplosionIce;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Enums.Rarity;

public class ModuleUnitTimeSlow extends ModuleUnit {

	/*
	public float base_push_damage=50;
	public float total_push_damage=50;
	*/
	public float base_time_slow;
	public float total_time_slow;



	public ModuleUnitTimeSlow()
	{
		name="������ '����������� �������'";
		uid="modtislow";
		
		base_duration=5.0f;
		base_cooldown=15;
		base_time_slow=0.5f;
		
		level=5;
		

		
		tex=Assets.load("icon_time_control");
		indicate_tex=Assets.load("icon_indicate_time_slow");
		
		rarity=Rarity.COMMON;
		
		Available_attribute_list.add(new ModuleAttributeExplosionIce());
		
		generate();
		update_stats();
	}
	
	@Override
	public String get_description()
	{
		return "��������� ����� �� 50%.";
	}
	
	@Override
	public void use(Entity _e)
	{
		duration=total_duration;
	}
	
	@Override
	public boolean can_use() {
		// TODO Auto-generated method stub
		return can_use_default();
	}
	

	public String get_descr()
	{
		return "";
	}
	
	@Override
	public void additional_update_stats()
	{
		total_time_slow=base_time_slow;
	}
	
	@Override
	public void update(Entity _entity, float _delta)
	{
			cooldown-=_delta;
			if (cooldown<=0){cooldown=0;}
			if (duration>0)
			{
				GScreen.time_speed_value*=0.5f;
				duration-=GScreen.real_delta;
				if (duration<=0)
				{
					duration=0; cooldown=total_cooldown;
					use_end_skill(_entity, _delta);		
				}
			}
	}
	
	
}
