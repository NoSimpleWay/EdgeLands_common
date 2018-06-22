package com.midfag.entity.decorations;


import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.LightSource;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Phys;
import com.midfag.game.Enums.EntityType;

public class DecorRabitz2 extends Entity {

	public DecorRabitz2(Vector2 _v) {
		
		super(_v);

		custom_phys=true;
		
		uid="87f59cab";
		type=EntityType.WALL;
		is_AI=false;
		is_player=false;
		
		spr.setTexture(Assets.rabitz_02);
		icon=Assets.rabitz_02_icon;
		
		armored_shield.value=10000;
		armored_shield.total_value=10000;
		armored_shield.total_regen_speed=0;
		armored_shield.total_reflect=0;
		
		is_decor=true;
		diagonal=false;
		
		
		spr.setSize(spr.getTexture().getWidth(), spr.getTexture().getHeight());
		spr.setOrigin(spr.getTexture().getWidth()/2f, 50);
		id=this.getClass().getName();
		
		path=true;
		
		/*
		light_source=new LightSource();
		
		light_source.R=1.0f;
		light_source.G=0.0f;
		light_source.B=0.0f;
		
		//light_source.light_size=30;
		light_source.light_power=10f;
		*/
		
		//shield=999999;
		// TODO Auto-generated constructor stub
	}
	

	
	
	

	
	@Override
	public void do_custom_phys()
	{

		
	}
	


}
