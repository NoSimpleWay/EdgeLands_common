package com.midfag.equip.module;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.friends.EntityTurret;
import com.midfag.equip.energoshield.Energoshield;
import com.midfag.equip.energoshield.EnergoshieldRobo;
import com.midfag.equip.module.attr.ModuleAttributeExplosionIce;
import com.midfag.equip.weapon.Weapon;
import com.midfag.equip.weapon.WeaponSimpleFirle;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.SysConfig;
import com.midfag.game.Enums.Rarity;

public class ModuleUnitCubeDefender extends ModuleUnit {

	/*
	public float base_push_damage=50;
	public float total_push_damage=50;
	*/
	public Energoshield shield;
	public Entity bottom;
	public Entity wall_A;
	public Entity wall_B;

	public ModuleUnitCubeDefender()
	{
		name="Модуль Силовое поле";
		uid="modcubedefender";
		base_duration=10.0f;
		base_cooldown=25;

		
		//level=1;
		

		
		tex=Assets.load("icon_cube_guardian");
		indicate_tex=Assets.load("icon_indicate_cube_defender");

		rarity=Rarity.COMMON;
		
		Available_attribute_list.add(new ModuleAttributeExplosionIce());
		
		generate();
		update_stats();
		
		
		

	}
	
	@Override
	public String get_description()
	{
		return "Размещает на земле куб, обладающий силовым полем.";
	}
	
	@Override
	public void use(Entity _e)
	{
		duration=total_duration;
		
		Entity list_entity=SysConfig.get_entity_from_list("cube_guardian_bottom");
		bottom=Helper.get_object_from_id(list_entity.id);
		bottom.pos.x=_e.pos.x; bottom.pos.y=_e.pos.y;
		Entity.transfer_data(list_entity, bottom);
		GScreen.add_entity_to_map(bottom);
				
		list_entity=SysConfig.get_entity_from_list("cube_force_field");
		wall_A=Helper.get_object_from_id(list_entity.id);
		wall_A.pos.x=_e.pos.x; wall_A.pos.y=_e.pos.y-20;
		Entity.transfer_data(list_entity, wall_A);
		GScreen.add_entity_to_map(wall_A);
		
			
		list_entity=SysConfig.get_entity_from_list("cube_force_field");
		wall_B=Helper.get_object_from_id(list_entity.id);
		wall_B.pos.x=_e.pos.x; wall_B.pos.y=_e.pos.y+20;
		Entity.transfer_data(list_entity, wall_B);
		GScreen.add_entity_to_map(wall_B);
		
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
		shield=new EnergoshieldRobo();
		
		shield.base_value=1000;
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
				if (bottom.need_remove)
				{
					duration=0;
				}
				
				duration-=GScreen.real_delta;
				if (duration<=0)
				{
					duration=0; cooldown=total_cooldown;
					use_end_skill(_entity, _delta);	
					
					bottom.pre_death_action(true);
					bottom.dead_action(true);
					
					wall_A.pre_death_action(true);
					wall_A.dead_action(false);
					
					wall_B.pre_death_action(true);
					wall_B.dead_action(false);
				}
			}
	}
	
	
}
