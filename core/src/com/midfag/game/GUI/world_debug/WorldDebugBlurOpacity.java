package com.midfag.game.GUI.world_debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.midfag.game.GScreen;

public class WorldDebugBlurOpacity extends WorldDebug  {

	boolean release=false;
	
	@Override
	public String get_debug_text()
	{
		return "blur opacity="+GScreen.blur_opacity;
	}
	
	@Override
	public void update(float _d)
	{
		if (
				(!Gdx.input.isKeyPressed(Keys.DOWN))
				&&
				(!Gdx.input.isKeyPressed(Keys.UP))
				&&
				(!Gdx.input.isKeyPressed(Keys.LEFT))
				&&
				(!Gdx.input.isKeyPressed(Keys.RIGHT))
			)
			{release=true;}
		
		if (Gdx.input.isKeyPressed(Keys.DOWN)&(release))
		{
			GScreen.blur_opacity-=0.01;
			GScreen.blur_opacity=Math.max(0, GScreen.blur_opacity);
			
			release=false;
			
			GScreen.need_light_update=true;
			GScreen.need_static_light_update=true;
			GScreen.need_pixmap_update=true;
			GScreen.need_shadow_update=true;
		}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)&(release))
		{
			GScreen.blur_opacity-=0.05;
			GScreen.blur_opacity=Math.max(0, GScreen.blur_opacity);
			
			release=false;
			
			GScreen.need_light_update=true;
			GScreen.need_static_light_update=true;
			GScreen.need_pixmap_update=true;
			GScreen.need_shadow_update=true;
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP)&(release))
		{
			GScreen.blur_opacity+=0.01f;
			GScreen.blur_opacity=Math.min(1, GScreen.blur_opacity);
			
			release=false;
			
			GScreen.need_light_update=true;
			GScreen.need_static_light_update=true;
			GScreen.need_pixmap_update=true;
			GScreen.need_shadow_update=true;
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)&(release))
		{
			GScreen.blur_opacity+=0.05f;
			GScreen.blur_opacity=Math.min(1, GScreen.blur_opacity);
			
			release=false;
			
			GScreen.need_light_update=true;
			GScreen.need_static_light_update=true;
			GScreen.need_pixmap_update=true;
			GScreen.need_shadow_update=true;
		}

	}
	
}
