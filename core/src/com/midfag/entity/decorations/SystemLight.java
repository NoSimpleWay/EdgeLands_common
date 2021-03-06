package com.midfag.entity.decorations;

import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.LightSource;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Enums.EntityType;

public class SystemLight extends Entity {

	public SystemLight(Vector2 _v) {
		super(_v);
		
		custom_phys=true;
		have_collision=false;
		
		id=this.getClass().getName();
		uid="syslight";
		Helper.log("package path "+id);
		type=EntityType.SYSTEM;
		
		main_tex=Assets.light;
		icon=Assets.light;
		
		spr.setSize(spr.getTexture().getWidth(), spr.getTexture().getHeight());
		spr.setOrigin(spr.getTexture().getWidth()/2f, 00f);

		is_AI=false;
		is_decor=true;
		
		armored_shield.value=999999;
		armored_shield.total_value=999999;
		armored_shield.total_regen_speed=999;
		
		light_source=new LightSource();
		light_source.R=1;
		light_source.G=1;
		light_source.B=1;
		light_source.light_power=3;
		
		
		
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
	
	@Override
	public void draw_action(float _d) {
		
		if (GScreen.show_edit)
		{
			GScreen.batch_custom.draw(main_tex, pos.x-main_tex.getWidth()/2f, pos.y-main_tex.getHeight()/2f);
		}

	}

}
