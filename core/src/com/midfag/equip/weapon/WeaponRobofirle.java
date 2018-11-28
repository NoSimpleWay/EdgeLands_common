package com.midfag.equip.weapon;

import com.badlogic.gdx.audio.Sound;
import com.midfag.game.Assets;

public class WeaponRobofirle extends Weapon {
	
	
	
		public WeaponRobofirle()
		{
			name="NPC weapon";
			base_damage=75;
			base_missile_count=1;
			base_shoot_cooldown=1.0f;
			
			base_accuracy=get_accuracy_rating_by_degrees(3f);
			base_accuracy_additional=get_accuracy_rating_by_degrees(1f);
			
			base_ammo_size=15;
			base_reload_time=3.0f;
			missile_speed=1350;
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
			return Assets.shoot00;
		}
		
		//public void
}
