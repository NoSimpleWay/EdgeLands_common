package com.midfag.equip.module;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.Shd;
import com.midfag.entity.ShdMove;
import com.midfag.equip.module.attr.*;

import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Phys;
import com.midfag.game.Enums.Rarity;

public class ModuleUnitRefresher extends ModuleUnit {

	private float cooldown_multiplier;




	/*
	public float base_push_damage=50;
	public float total_push_damage=50;
	*/




	public ModuleUnitRefresher()
	{
		name="Модуль <рестарт>";
		uid="modrefresher";
		
		base_duration=0.1f;
		base_cooldown=1.0f;
		

		
		/*
		Available_attribute_list.add(new ModuleAttributePushDamage());
		Available_attribute_list.add(new ModuleAttributeExplosionFire());
		Available_attribute_list.add(new ModuleAttributeExplosionIce());
		*/
		model=Assets.load("module_push_model");

		
		tex=Assets.load("icon_module_refresh");
		indicate_tex=Assets.load("icon_indicate_heal");
		rarity=Rarity.COMMON;
		
		level=1;
		
		generate();
		update_stats();
		
		
	}
	
	@Override
	public void  get_available_attribute()
	{
		Available_attribute_list.clear();
		
		Available_attribute_list.add(new ModuleAttributeFastCooldown());

		
	}
	
	@Override
	public String get_description()
	{
		return "Обнуляет время перезарядки всех модулей, перезаряжаясь вместо них."+"\n"+"Перезарядка ускорена на "+((1f/cooldown_multiplier*100f)-100f)+"%";
	}
	
	@Override
	public void use(Entity _e)
	{
		
		
		total_cooldown=0;
		cooldown=0;
		
		for (int i=0; i<4; i++)
		{
			if ((_e.armored_module[i]!=null)&&(_e.armored_module[i]!=this))
			{
				total_cooldown+=_e.armored_module[i].cooldown*cooldown_multiplier;
				cooldown+=_e.armored_module[i].cooldown*cooldown_multiplier;
				_e.armored_module[i].cooldown=0.1f;
			}
		}
		

		//Assets.jet.play();
	}
	
	@Override
	public boolean can_use() {
		// TODO Auto-generated method stub
		return can_use_default();
	}
	

	@Override
	public void post_update_stats() {
		// TODO Auto-generated method stub
		
		cooldown_multiplier=1f-(1f-(total_cooldown))/10f;
	}
	

	
	
}
