package com.midfag.equip.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.missiles.Missile;
import com.midfag.entity.missiles.MissileChaos;
import com.midfag.equip.weapon.attr.WeaponAttributeAccuracy;
import com.midfag.equip.weapon.attr.WeaponAttributeAttackSpeed;
import com.midfag.equip.weapon.attr.WeaponAttributeChaos;
import com.midfag.equip.weapon.attr.WeaponAttributeClipSize;
import com.midfag.equip.weapon.attr.WeaponAttributeColdDamage;
import com.midfag.equip.weapon.attr.WeaponAttributeDamage;
import com.midfag.equip.weapon.attr.WeaponAttributeFireDamage;
import com.midfag.equip.weapon.attr.WeaponAttributeReloadSpeed;
import com.midfag.equip.weapon.attr.WeaponAttributeStability;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;


public class LegendaryWeaponChaos extends Weapon {
	
	
	public float chaos_time=0.2f;
	
		public LegendaryWeaponChaos()
		{
			super();
			
			uid="weapon_chaos";
			
			base_damage=10;
			base_missile_count=2;
			base_shoot_cooldown=0.3f;
			base_dispersion=10;
			base_dispersion_additional=5;
			base_ammo_size=20;
			base_reload_time=3;
			
			fire_multiplier=base_shoot_cooldown/base_missile_count;
			
			need_warm=0;
			
			name="c h a o s";
			
			//gennable=false;
			
			spr.setTexture(Assets.load("icon_legendary_chaos_shotgun"));
			spr.setSize(75, 40);
			
			model.setTexture(Assets.load("model_shotgun_chaos"));
			model.setSize(200, 90);
			
			Attribute_list.add(new WeaponAttributeChaos());

			
			red_text="--- ERROR ERROR ERROR ERROR ERROR ---";
		}
		
		@Override
		public void get_available_attribute()
		{
			Available_attribute_list.clear();

			
			Available_attribute_list.add(new WeaponAttributeChaos());
		}
		

		@Override
		public Missile get_missile(Entity pl)
		{
			return new MissileChaos(
					new Vector2(pl.pos.x,pl.pos.y),
					(float) Math.toRadians(360-pl.rot+get_dispersion()+GScreen.rnd(add_disp)-add_disp/2),
					(GScreen.rnd(200)+400.0f),
					pl.is_AI);
		}
		
		@Override
		public Sound get_shoot_sound()
		{
			return Assets.shoot75523235;
		}
		
		@Override
		public String get_name()
		{

			
			if (chaos_time>0)
			{
				chaos_time-=0.017f;
				
				if (chaos_time<=0)
				{
					chaos_time+=0.1f;
					

					String s="";
					//char ch;
					for (int i=0; i<10; i++)
					{
						
						s+=(char)((int)(Math.random()*256));
					}
					
					name=s;
					
					if (Math.random()<0.015d)
					{
						chaos_time=0.37f;
						name="-� � � �-";
						return name;
					}
					//return name;
					
				}
			}
			

			
			{return name;}
		}

		
		//public void
}
