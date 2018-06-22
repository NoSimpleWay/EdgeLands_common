package com.midfag.entity.decorations;


import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Phys;
import com.midfag.game.Enums.EntityType;


public class DecorBuilding extends Entity {
	
	
	//private float alpha=1;

	public DecorBuilding(Vector2 _v) {
		
		super(_v);
		
		type=EntityType.BUILDING;
		
		custom_phys=true;
		
		id=this.getClass().getName();
		uid="59a1a175";
		
		is_decor=true;
		is_AI=false;

		
		
		spr.setTexture(Assets.building_wall_in);
		spr.setSize(spr.getTexture().getWidth(), spr.getTexture().getHeight());
		spr.setOrigin(100.0f, 5f);

		
		diagonal=true;
		path_x=1;
		path_y=0;
		//spr.setOrigin(10.0f, 65);
		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
	}
	

	
	@Override
	public void some_draw()
	{
	
	}
	
	@Override
	public void some_update(float _d)
	{
		/*
		if ((Math.abs(GScreen.pl.pos.x-pos.x)<100)&&(Math.abs(GScreen.pl.pos.y-pos.y-z)<70)&&(GScreen.pl.pos.y>pos.y-z))
		{
			alpha-=_d*5;
		}
		else
		{
			alpha+=_d*5;
		}
		
		if (alpha<0.10f) {alpha=0.10f;}
		if (alpha>1) {alpha=1;}
		spr.setAlpha(alpha);*/
	}
	@Override
	public void do_custom_phys()
	{

		
	}

}
