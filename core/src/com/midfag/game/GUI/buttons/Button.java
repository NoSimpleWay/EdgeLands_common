package com.midfag.game.GUI.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.CustomSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.InputHandler;
import com.midfag.game.Main;

public class Button {
	public Vector2 pos=new Vector2();
	public Sprite spr=new Sprite(Assets.load("button"));
	
	public boolean need_remove=false;
	
	public boolean overlaped=false;
	
	public boolean off_bg=false;
	
	public boolean is_active=true;
	
	public int size_x=80;
	public int size_y=40;
	public Color standart_color=Color.WHITE;
	private Color color_overlapped=Color.GREEN;
	public String description="";
	
	public Button(float _x, float _y)
	{
		pos.x=_x;
		pos.y=_y;
	}
	
	public void draw()
	{

		if ((!need_remove)&&(!off_bg)&&(is_active))
		{
			//spr.setPosition(pos.x-(int)(spr.getWidth()/2),(int)(pos.y-spr.getHeight()/2));
			//spr.draw(GScreen.batch_static);
			
			GScreen.batch_static.draw(spr.getTexture(), pos.x-(int)(spr.getWidth()/2),(int)(pos.y-spr.getHeight()/2));
		}
		after_draw();

	}
	
	public void after_draw()
	{
		
	}
	
	public void second_draw()
	{
		
	}

	public void update(float delta)
	{
		if (is_active)
		{
			some_update(delta);
			
			if (is_overlap())
			{
				//Helper.log("WTF???");
				if (!overlaped)
				{
					entry();
				}
				overlaped=true;
				
			}
			else
			{
				if (overlaped)
				{
					leave();
				}
				
				overlaped=false;
			}
			//if (is_overlap())
			//{
			//	System.out.println("zzz");
			//}
		}
		
	}
	
	public void some_update(float _d)
	{
		
	}
	
	public void entry()
	{
		System.out.println("Entry!");
	}
	
	public void leave()
	{
		System.out.println("Leave!");
	}
	public boolean is_overlap()
	{	//		0<10						0+40>10
		
		spr.setColor(standart_color);
		if ((pos.x-size_x/2f<InputHandler.sposx)&&(pos.x+size_x/2f>InputHandler.sposx)&&(pos.y-size_y/2f<InputHandler.sposy)&&(pos.y+size_y/2>InputHandler.sposy))
		{
			spr.setColor(color_overlapped);
			return true;
		}
		
		
		
		return false;
	}

	public void second_update(float _d) {
		// TODO Auto-generated method stub
		
	}

	public void text_pass(SpriteBatch _b) {
		_b.setColor(1f,1f,1f,0.9f);
		
		Main.font.setColor(Color.DARK_GRAY);
		
		if (!description.equals("")&&(is_overlap()))
		{
			_b.draw(Assets.rect_white, pos.x+size_x, pos.y-20,500,30);
			Main.font.draw(_b,description, pos.x+size_x, pos.y);
		}
		
		_b.setColor(Color.WHITE);
		// TODO Auto-generated method stub
		
	}
	
	
}
