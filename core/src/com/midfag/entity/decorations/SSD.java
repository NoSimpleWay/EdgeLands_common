package com.midfag.entity.decorations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Main;
import com.midfag.game.Enums.EntityType;

public class SSD extends Entity {
public SSD(Vector2 _v) {
		
		super(_v);

		id=this.getClass().getName();
		
		is_player=false;
		is_AI=false;
		//foot.setSize(30, 6);
		
		have_collision=false;
		

		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
		
		type=EntityType.SYSTEM;
		//main_tex=Assets.rect_white;
		
		if (!texture_path.equals(""))
		{
			Helper.log("Main texture path is |"+texture_path+"|");
			main_tex=Assets.load(texture_path);
		}

	}
	

	@Override
	public void draw_action(float _d)
	{
		if (main_tex!=null)
		{
			//Helper.log("Color_total_A "+color_total_A);
			
			GScreen.batch_custom.setColor(total_illum_R,total_illum_G,total_illum_B,total_alpha);
			GScreen.batch_custom.draw_with_light(main_tex, pos.x+texture_offset_x-main_tex.getWidth()/2f, pos.y+texture_offset_y-main_tex.getHeight()/2f,main_tex.getWidth());
		}
	}	
	
	

}
