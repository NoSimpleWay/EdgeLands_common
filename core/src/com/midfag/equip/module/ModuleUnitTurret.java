package com.midfag.equip.module;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.friends.EntityTurret;
import com.midfag.equip.energoshield.EnergoshieldRobo;
import com.midfag.equip.energoshield.EnergoshieldSimple;
import com.midfag.equip.module.attr.ModuleAttributeExplosionIce;
import com.midfag.equip.weapon.Weapon;
import com.midfag.equip.weapon.WeaponSimpleFirle;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Enums.Rarity;

public class ModuleUnitTurret extends ModuleUnit {

	/*
	public float base_push_damage=50;
	public float total_push_damage=50;
	*/
	public Entity turret;


	public ModuleUnitTurret()
	{
		name="������ '������'";
		uid="modturret";
		base_duration=10.0f;
		base_cooldown=25;

		
		//level=1;
		

		
		tex=Assets.load("icon_reload_chance");
		indicate_tex=Assets.load("icon_indicate_turret");

		rarity=Rarity.COMMON;
		
		weapon=new WeaponSimpleFirle();
		weapon.level=level;
		weapon.rarity=rarity;
		weapon.generate();
		
		shield=new EnergoshieldSimple();
		shield.level=level;
		//shield.base_value=500;
		shield.rarity=rarity;
		shield.generate();
		
		Available_attribute_list.add(new ModuleAttributeExplosionIce());
		
		generate();
		update_stats();
		
		
		

	}
	
	@Override
	public String get_description()
	{
		return "�������� ������, ������� ����� ��� ����������� ������.";
	}
	
	@Override
	public void use(Entity _e)
	{
		duration=total_duration;
		
		Entity en=new EntityTurret(new Vector2(_e.pos));
		en.armored[0]=weapon;
		turret=en;
		GScreen.add_entity_to_map(en);
		
		
		
		//GScreen.pl=en;
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
		weapon.rarity=rarity;
		weapon.level=level;
		weapon.generate();
		weapon.update_attributes_bonus();
		
		
		shield.rarity=rarity;
		shield.level=level;
		shield.generate();
		shield.update_attributes_bonus();
	}
	
	@Override
	public void update(Entity _entity, float _delta)
	{
			cooldown-=_delta;
			if (cooldown<=0){cooldown=0;}
			if (duration>0)
			{
				duration-=GScreen.real_delta;
				if (duration<=0)
				{
					duration=0; cooldown=total_cooldown;
					use_end_skill(_entity, _delta);	
					turret.pre_death_action(true);
					turret.dead_action(true);
				}
			}
	}
	
	
}
