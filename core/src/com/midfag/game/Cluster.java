package com.midfag.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.midfag.entity.Entity;

public class Cluster {
	public List<Phys> Phys_list = new ArrayList<Phys>();
	public List<Entity> Entity_list = new ArrayList<Entity>();
	public Color col;
	
	//public Texture land_decor_400;
	
	public int ld400x=(int) (Math.random()*800-400);
	public int ld400y=(int) (Math.random()*800-400);
	
	public int ld800x=(int) (Math.random()*1600-800);
	public int ld800y=(int) (Math.random()*1600-800);
	
	public int ld1600x=(int) (Math.random()*3200-1600);
	public int ld1600y=(int) (Math.random()*3200-1600);
	
	public int variant=(int) (Math.random()*3);
	public int variant2=(int) (Math.random()*3);
	public int variant3=(int) (Math.random()*3);
	public Cluster()
	{
		//System.out.println("PCluster created");
		
		
	}
	
	public void draw(float _x, float _y)
	{	//GScreen.batch.draw	(Assets.terrain_decor_400, 					_x-75, 	_x-10f,	 0*150, 		0*150, 150, 150);
		//GScreen.batch.draw	(Assets.terrain_decor_400, 	_x+ld400x, 	_y+ld400y, 	variant, 0,		 800, 800);
		//GScreen.batch.draw	(Assets.terrain_decor_400, 	_x+ld800x, 	_y+ld800y, 	variant, 0,		 1600, 1600);
		GScreen.batch.setColor(1,1,1,0.2f);
		GScreen.batch.draw	(Assets.terrain_decor_400, _x-200+ld400x, _y-200+ld400y, 400, 400, 0.333f*variant, 0, 0.333f*variant+0.333f, 1);
		
		GScreen.batch.setColor(1,1,1,0.07f);
		if ((_x % 3 ==0)&&(_y % 3 ==0))
		GScreen.batch.draw	(Assets.terrain_decor_400, _x-400+ld800x, _y-400+ld800y, 800, 800, 0.333f*variant2, 0, 0.333f*variant2+0.333f, 1);
		
		GScreen.batch.setColor(1,1,1,0.07f);
		if ((_x % 6 ==0)&&(_y % 6 ==0))
		GScreen.batch.draw	(Assets.terrain_decor_400, _x-800+ld1600x, _y-800+ld1600y, 1600, 1600, 0.333f*variant3, 0, 0.333f*variant3+0.333f, 1);
	}
}
