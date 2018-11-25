package com.midfag.entity.decorations;

import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.LightSource;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Enums.EntityType;

public class SystemLightRandom extends Entity {

	public SystemLightRandom(Vector2 _v) {
		super(_v);
		
		custom_phys=true;
		have_collision=false;
		
		id=this.getClass().getName();
		uid="syslightrandom";
		Helper.log("package path "+id);
		type=EntityType.SYSTEM;
		
		spr.setTexture(Assets.light);
		icon=Assets.light;
		
		spr.setSize(spr.getTexture().getWidth(), spr.getTexture().getHeight());
		spr.setOrigin(spr.getTexture().getWidth()/2f, 00f);

		is_AI=true;
		is_decor=false;
		is_enemy=false;
		have_collision=true;
		
		armored_shield.value=999999;
		armored_shield.total_value=999999;
		armored_shield.total_regen_speed=999;
		
		light_source=new LightSource();
		light_source.R=1-(float) (Math.random()*Math.random());
		light_source.G=1-(float) (Math.random()*Math.random());
		light_source.B=1-(float) (Math.random()*Math.random());
		light_source.light_power=1.5f;
		
		
		
		diagonal=true;
		//spr.setOrigin(10.0f, 65);
		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void do_custom_phys()
	{
		//DO NOTHING
	}
	


}
