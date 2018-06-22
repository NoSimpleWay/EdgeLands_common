package com.midfag.entity.decorations;


import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.LightSource;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Phys;
import com.midfag.game.Enums.EntityType;

public class DecorRabitz extends Entity {

	private int dir=-1;

	public DecorRabitz(Vector2 _v) {
		
		super(_v);

		uid="015a590c";
		
		custom_phys=true;
		type=EntityType.WALL;
		is_AI=false;
		is_player=false;
		
		path_x=1;
		path_y=0;
		
		collision_size_x=60;
		collision_size_y=20;
		
		size=60;
		mass=999999999;
		
		spr.setTexture(Assets.rabitz_01);
		icon=Assets.rabitz_01_icon;
		
		armored_shield.value=10000;
		armored_shield.total_value=10000;
		armored_shield.total_regen_speed=0;
		armored_shield.total_reflect=0;
		
		is_decor=true;
		diagonal=false;
		
		
		spr.setSize(spr.getTexture().getWidth(), spr.getTexture().getHeight());
		spr.setOrigin(spr.getTexture().getWidth()/2f, 3);
		id=this.getClass().getName();
		
		path=true;
		
		/*
		light_source=new LightSource();
		
		light_source.R=0.0f;
		light_source.G=0.0f;
		light_source.B=1.0f;
		*/
		
		//light_source.light_size=30;
		//light_source.light_power=10f;
		
		
		
		
		//shield=999999;
		// TODO Auto-generated constructor stub
	}
	

	
	
	

	
	@Override
	public void default_interact_action(float delta) {
		// TODO Auto-generated method stub
		
		dir*=-1;
		

			if (dir==1) {constant_move_z=60-z;} else {constant_move_z=z;}
			constant_speed_z=30*dir;
		
		
		

	}
	
	@Override
	public void do_custom_phys()
	{

		
	}
	


}
