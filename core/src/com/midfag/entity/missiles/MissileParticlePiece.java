package com.midfag.entity.missiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midfag.game.Assets;

public class MissileParticlePiece extends Missile {

	
	public float rotate_speed=(float) (Math.random()*2-1.0f);;
	
	public MissileParticlePiece(Vector2 _v, float _a, float _s, boolean _b) {
		super(_v, _a, _s, _b);
		
		spr.setTexture(Assets.diod);
		
		lifetime=(float) Math.random()*2;
		
		if (Math.random()<0.5)
		{spr.setTexture(Assets.load("particle"));}
		else
		{spr.setTexture(Assets.load("particle2"));}
	
		spr.setSize((float)(Math.random()*100+5),(float)(Math.random()*100+5));
		
		is_decor=true;
		//tex.setSize(100, 200);
		// TODO Auto-generated constructor stub
	}
	
	
	public void preupdate(float _d)
	{
		speed*=Math.pow(0.5f, _d);
		speed-=_d;
		spr.setScale(spr.getScaleX()/(1+_d));
		spr.rotate(speed*5f);
	}
	
	
}
