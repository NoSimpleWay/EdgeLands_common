package com.midfag.entity.missiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midfag.game.Assets;

public class MissileExplosion extends Missile {

	
	public float rotate_speed=(float) (Math.random()*2-1.0f);;
	
	public MissileExplosion(Vector2 _v, float _a, float _s, boolean _b) {
		super(_v, _a, _s, _b);
		
		spr.setTexture(Assets.diod);
		
		lifetime=0.5f;
		
		
		spr.setTexture(Assets.load("explosion"));

		
		spr.setSize((float)(Math.random()*5+20),(float)(Math.random()*5+20));
		
		is_decor=true;

		//tex.setSize(100, 200);
		// TODO Auto-generated constructor stub
	}
	
	
	public void time_action(float _d)
	{
		spr.setOrigin(spr.getScaleX()/2f, spr.getScaleY()/2f);
		
		spr.setColor(1, 1, 1, Math.max(0, lifetime));
		spr.setScale(spr.getScaleX()*(1+_d));
		
		
		
		spr.rotate(10f*rotate_speed);
	}
	
	
}
