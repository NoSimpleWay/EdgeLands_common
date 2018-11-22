package com.midfag.entity.decorations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Enums.EntityType;

public class SSD extends Entity {
public SSD(Vector2 _v) {
		
		super(_v);

		id=this.getClass().getName();
		
		is_player=false;
		is_AI=false;
		//foot.setSize(30, 6);
		
		

		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
		
		type=EntityType.SYSTEM;
		main_tex=Assets.rect_white;

	}
	

	@Override
	public void draw_action(float _d)
	{
		if (main_tex!=null)
		{
			GScreen.batch_custom.setColor(1,1,1,1f);
			GScreen.batch_custom.draw_with_light(main_tex, pos.x+texture_offset_x-main_tex.getWidth()/2f, pos.y+texture_offset_y-main_tex.getHeight()/2f,main_tex.getWidth());
		}
	}	
	
	

}
