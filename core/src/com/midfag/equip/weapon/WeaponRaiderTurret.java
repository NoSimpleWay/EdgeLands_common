package com.midfag.equip.weapon;

import com.badlogic.gdx.audio.Sound;
import com.midfag.game.Assets;

public class WeaponRaiderTurret extends Weapon {
	
	
	
		public WeaponRaiderTurret()
		{
			base_damage=100;
			base_missile_count=1;
			base_shoot_cooldown=1.0f;
			
			base_accuracy=get_accuracy_rating_by_degrees(3f);
			base_accuracy_additional=get_accuracy_rating_by_degrees(3f);
			
			base_ammo_size=5;
			base_reload_time=5.0f;
			missile_speed=2350;
			
			shoot_volume=1f;
			
			fire_multiplier=base_shoot_cooldown/base_missile_count;
			
			/*generate();
			update			generate();
			update_attributes_bonus();*/
			
			generate();
			update_attributes_bonus();
			//update_stats();
		}
		

		@Override
		public Sound get_shoot_sound()
		{
			return Assets.shoot_raider_turret;
		}
		
		//public void
}
