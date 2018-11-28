package com.midfag.equip.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.missiles.Missile;

import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.screen_effect.ScreenEffectWorldEXTERMINATION;

public class SupernaturalWeaponEXTERMINATOR extends Weapon {
	
	
	
		public SupernaturalWeaponEXTERMINATOR()
		{
			uid="exterminator";
			
			base_damage=10;
			base_fire_damage=0.1f;
			
			base_missile_count=2;
			base_shoot_cooldown=0.025f;
			
			base_accuracy=get_accuracy_rating_by_degrees(5f);
			base_accuracy_additional=get_accuracy_rating_by_degrees(0.5f);
			
			base_ammo_size=120;
			base_reload_time=10;
			
			fire_multiplier=base_shoot_cooldown/base_missile_count;
			
			need_warm=3;
			
			name="Э-К-С-Т-Е-Р-М-И-Н-А-Т-О-Р";
			
			missile_speed=1500;
			
			
			
			spr.setTexture(Assets.load("icon_exterminator"));
			spr.setSize(spr.getTexture().getWidth(), spr.getTexture().getHeight());
			
			red_text="Да чё ты очкуешь, там шанс один на миллион!";
		}
		

		@Override
		public Missile get_missile(Entity pl)
		{
			return new Missile(
					new Vector2(pl.pos.x,pl.pos.y),
					(float) Math.toRadians(360-pl.rot+get_dispersion()),
					(GScreen.rnd(200)+missile_speed),
					pl.is_AI);
		}
		
		@Override
		public Sound get_shoot_sound()
		{
			if ((int)(Math.random()*10000)==0)
			{
			if (GScreen.screen_effect!=null)
			{
				GScreen.screen_effect.end_action();
			}
			
				GScreen.show_equip=false;
				GScreen.screen_effect=new ScreenEffectWorldEXTERMINATION();
				
				/*
				for (int i=0; i<5; i++)
				{
					if (
							(GScreen.pl.armored_module[i]!=null)
							&&
							(GScreen.pl.armored_module[i].can_be_locked)
						)
					{GScreen.pl.armored_module[i].lock=true;}
				}
				 */
			}
			return Assets.shoot02;
		}
		
		//public void
}
