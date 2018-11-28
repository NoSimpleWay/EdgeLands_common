package com.midfag.equip.weapon;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.missiles.Missile;
import com.midfag.entity.missiles.MissileSimple;

import com.midfag.equip.weapon.attr.WeaponAttribute;
import com.midfag.equip.weapon.attr.WeaponAttributeAccuracy;
import com.midfag.equip.weapon.attr.WeaponAttributeAttackSpeed;
import com.midfag.equip.weapon.attr.WeaponAttributeClipSize;
import com.midfag.equip.weapon.attr.WeaponAttributeClipSizePlus;
import com.midfag.equip.weapon.attr.WeaponAttributeColdDamage;
import com.midfag.equip.weapon.attr.WeaponAttributeDamage;
import com.midfag.equip.weapon.attr.WeaponAttributeDamagePlus;
import com.midfag.equip.weapon.attr.WeaponAttributeFireDamage;
import com.midfag.equip.weapon.attr.WeaponAttributeReloadSpeed;
import com.midfag.equip.weapon.attr.WeaponAttributeStability;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Enums.Rarity;
import com.midfag.game.script.ScriptTimer;

public class Weapon {

	public String uid="base"; 
	public float base_damage=777;
	public float base_missile_count;
	public float base_shoot_cooldown;
	
	public float base_accuracy;
	public float base_accuracy_additional;
	
	public float base_ammo_size;
	public float base_reload_time;
	
	public float total_damage;
	public float total_missile_count;
	public float total_shoot_cooldown;
	
	public float total_accuracy;
	public float total_minus_accuracy;
	
	public float total_ammo_size;
	public float total_reload_time;
	
	public float level=1.0f;
	
	public float attr_point;
	public float attr_count;
	
	public float need_warm;
	public float warm;
	
	public int ammo;
	public float cd;
	public float disp;
	public float add_dispZ;
	public float reload_timer;
	
	public Sprite spr=new Sprite(Assets.load("icon_firle"));
	public Sprite model=new Sprite(Assets.load("icon_firle"));
	
	public String name;
	
	public boolean gennable=true;
	
	public List<WeaponAttribute> Available_attribute_list = new ArrayList<WeaponAttribute>();
	
	//public List<WeaponAttribute> Attribute_list_heap = new ArrayList<WeaponAttribute>();
	
	//public Missile missile=new Missile();
	
	public List<WeaponAttribute> Attribute_list = new ArrayList<WeaponAttribute>();
	
	public Rarity rarity;
	public float missile_speed=1555;
	
	public float total_fire_damage;
	public float base_fire_damage;
	
	public float total_cold_damage;
	public float base_cold_damage;
	
	public boolean is_rotate_reset_charge=false;
	public String red_text="";
	public float fire_multiplier=0f;
	public float attr_point_indicate;
	
	public float shoot_volume=0.15f;
	public float additional_recoil;
	
	
	
		public Weapon()
		{
			super();

			
			
			//update_stats();
			//generate();
			//update_attributes_bonus();
			/*
			if (rarity.ordinal()==0){spr.setColor(Color.WHITE);}
			if (rarity.ordinal()==1){spr.setColor(Color.GREEN);}
			if (rarity.ordinal()==2){spr.setColor(Color.CYAN);}
			if (rarity.ordinal()==3){spr.setColor(Color.MAGENTA);}
			if (rarity.ordinal()==4){spr.setColor(Color.ORANGE);}*/
			
			rarity=Rarity.COMMON;
			
			//System.out.println("Parent class");
		
		}
		
		
		public void get_available_attribute()
		{
			Available_attribute_list.clear();
			Available_attribute_list.add(new WeaponAttributeDamage());
			Available_attribute_list.add(new WeaponAttributeAttackSpeed());
			Available_attribute_list.add(new WeaponAttributeAccuracy());
			Available_attribute_list.add(new WeaponAttributeStability());
			Available_attribute_list.add(new WeaponAttributeClipSize());
			Available_attribute_list.add(new WeaponAttributeReloadSpeed());
			
			Available_attribute_list.add(new WeaponAttributeFireDamage());
			Available_attribute_list.add(new WeaponAttributeColdDamage());
			
			Available_attribute_list.add(new WeaponAttributeClipSizePlus());
			Available_attribute_list.add(new WeaponAttributeDamagePlus());
		}
		
		public void update_attributes_bonus()
		{
			update_attributes_bonus(null);
		}
		
		public void update_attributes_bonus(Entity _e)
		{
			
			
			total_damage=base_damage*level;
			
			total_fire_damage=base_fire_damage*level;
			total_cold_damage=base_cold_damage*level;
			
			total_missile_count=base_missile_count;
			total_shoot_cooldown=base_shoot_cooldown;
			total_accuracy=base_accuracy;
			total_minus_accuracy=base_accuracy_additional;
			total_ammo_size=base_ammo_size;
			total_reload_time=base_reload_time;
			
			//System.out.println("base_damage="+base_damage);
			
			for (int i=0; i<Attribute_list.size(); i++)
			{
				Attribute_list.get(i).calculate(this);
			}
			
			//update_attributes_bonus();
			//System.out.println("damage^ "+total_damage);
			//System.out.println("damage^ "+total_damage);
			
			if (_e!=null)
			{
				for (int i=0; i<_e.Skills_list.size();i++)
				{
					if (_e.Skills_list.get(i).learned)
					{_e.Skills_list.get(i).weapon_gen_action(this);}
				}
			}
			
			
			spr.setColor(Color.WHITE);
			
			/*if (rarity==Rarity.COMMON){spr.setColor(Color.WHITE);}
			if (rarity==Rarity.UNCOMMON){spr.setColor(Color.GREEN);}
			if (rarity==Rarity.RARE){spr.setColor(Color.ROYAL);}
			if (rarity==Rarity.ELITE){spr.setColor(Color.MAGENTA);}
			if (rarity==Rarity.LEGENDARY){spr.setColor(Color.ORANGE);}
			if (rarity==Rarity.ANOMALY){spr.setColor(Color.CYAN);}*/
			
			ammo=(int) total_ammo_size;
			
		}
		
		public Missile get_missile(Entity pl)
		{
			return new MissileSimple(
					new Vector2(pl.pos.x+pl.offset.x,pl.pos.y+pl.offset.y),
					(float) Math.toRadians(360f-pl.rot+get_dispersion()),
					(GScreen.rnd(missile_speed/10f)+missile_speed),
					pl.is_enemy);
		}
		
		public Sound get_shoot_sound()
		{
			return null;
		}
		
		public void reload_start()
		{
			
		}
		
		public void generate()
		{
			Helper.log("=======GENERATOR======= ["+name+"]");
			get_available_attribute();
			
			total_damage=base_damage*level;
			
			Attribute_list.clear();
			int r=0;
			//Helper.log("IM GENERATED!");
			
			
			
			attr_point=(float) (level*10f*(Math.pow(1.26f,rarity.ordinal())));
			attr_point_indicate=attr_point;
			
			attr_count=(int) (GScreen.rnd(3)+1);
			
			get_available_attribute();
			for (int i=0; i<attr_count; i++)
			if (!Available_attribute_list.isEmpty()) 
			{
				//select random attribute from list
				int random_selected=(int)(Math.random()*Available_attribute_list.size());
			
				//set attribute
				Attribute_list.add(Available_attribute_list.get(random_selected));
				
				//remove attribute
				Available_attribute_list.remove(random_selected);
			}
			
			float total_density=0;
			
			for (WeaponAttribute alist:Attribute_list )
			{
				alist.density=(int)(Math.random()*100+10);
				total_density+=alist.density;
			}
			
			for (WeaponAttribute alist:Attribute_list )
			{
				alist.level=alist.density/total_density*attr_point;
			}
			
			
			
			
			
			update_attributes_bonus(null);
			
		}
		
		public String get_name()
		{
			return name;
		}
		
		public float get_dispersion()
		{
			float degr=get_dispersion_by_rating(total_accuracy)+additional_recoil;
			degr=GScreen.rnd(degr)-(degr)/2f;
			
			return degr;
		}
		
		public void equip()
		{
		
		}
		
		public void unequip()
		{
			
		}
		
		public void ability_hit(Missile _m, Entity _target)
		{

		}
		
		public void update( Entity _target, float _d)
		{
			
		}
		//public void
		
		public static float get_accuracy_rating_by_degrees(float _degrees)
		{
			if (_degrees>360) {return 0;}
			if (_degrees<=0) {return 123456789f;}
			
			return 1f/(_degrees/360f)*100f-100f;
				
			//34 028 235.0
			
		}
		
		public static float get_dispersion_by_rating(float _rating)
		{
			if (_rating<=0) {return 360f;}
			return 1/(_rating/100f+1f)*360f;
		}
}
