package com.midfag.entity.missiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midfag.game.Assets;


public class MissileChaos extends Missile {
	
	public MissileChaos(Vector2 _v,float _a, float _s, boolean _b)
	{
		super(_v, _a, _s, _b);
		
		spr.setTexture(Assets.load("missile_chaos"));
	}
	
	@Override
	public void preupdate(float _d)
	{
		//GScreen.tile_map_overlay[(int)(pos.x/30)][(int)(pos.y/30)]=9+(int)(Math.random()*3);
	}

}
