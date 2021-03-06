package com.midfag.entity.decorations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Enums.EntityType;

public class SystemCollision extends Entity {

	public SystemCollision(Vector2 _v) {
		super(_v);
		
		custom_phys=true;
		have_collision=true;
		
		id=this.getClass().getName();
		
		uid="syscollision";
		
		Helper.log("package path "+id);
		type=EntityType.SYSTEM;
		
		spr.setTexture(Assets.helper_wall);
		main_tex=Assets.helper_wall;
		icon=Assets.helper_wall;
		


		is_AI=false;
		is_decor=true;
		
		armored_shield.value=999999;
		armored_shield.total_value=999999;
		armored_shield.total_regen_speed=999;
		
		collision_size_x=100;
		collision_size_y=100;
		
		diagonal=true;
		
		mass=10000;
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
	
	@Override
	public void always_draw(float _d)
	{
		if (GScreen.show_edit)
		{

			
			
			GScreen.batch_custom.setColor(total_illum_R,total_illum_G,total_illum_B,total_alpha);
			GScreen.batch_custom.draw(Assets.rect_white, pos.x-collision_size_x, pos.y-collision_size_y, collision_size_x*2f, collision_size_y*2f);
		}
	}
	
	@Override
	public void draw_action(float _d) {
		
		if (GScreen.show_edit)
		{
			GScreen.batch_custom.draw(main_tex, pos.x-main_tex.getWidth()/2f, pos.y-main_tex.getHeight()/2f);
		}
	}

}
