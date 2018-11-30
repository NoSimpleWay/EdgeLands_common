package com.midfag.equip.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.midfag.game.Assets;

public class WeaponSimpleShotgun extends Weapon {
	
	
	
		public WeaponSimpleShotgun()
		{
			uid="weapon_simple_shotgun";
			
			base_damage=12;
			base_missile_count=10;
			base_shoot_cooldown=1.2f;
			
			base_accuracy=get_accuracy_rating_by_degrees(7f);
			base_accuracy_additional=get_accuracy_rating_by_degrees(5f);
			
			base_ammo_size=7;
			base_reload_time=3;
			
			fire_multiplier=base_shoot_cooldown/base_missile_count;
			
			missile_speed=1000;
			
			name="Стандартный дробовик";
			
			spr.setTexture(Assets.load("icon_shotgun"));
			spr.setSize(75, 40);
			
			model.setTexture(Assets.load("model_shotgun"));
			model.setSize(200, 90);
		}
		

		@Override
		public Sound get_shoot_sound()
		{
			return Assets.shoot02;
		}
		
		
		//public void
}
