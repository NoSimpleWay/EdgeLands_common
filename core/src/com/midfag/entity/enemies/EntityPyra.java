package com.midfag.entity.enemies;




import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;


import com.midfag.equip.weapon.*;


import com.midfag.game.Assets;
import com.midfag.game.GScreen;


public class EntityPyra extends Entity {
	
	//Sprite spr=new Sprite(new Texture(Gdx.files.internal("barrel.png")));
	

	private float rotate_cooldown;
	private float body_rotate_cooldown;
	//private int body_rotate;
	
	public EntityPyra(Vector2 _v)
	{
		super (_v);
		
		//spr.setTexture(Assets.pyra_body[0]);
		pos=_v;
		
		id=this.getClass().getName();
		uid="46da9c16";
		//Helper.log ("THIS ID="+id);
		icon=Assets.entity_pyra_icon;
		
		armored[0]=new WeaponRobofirle();
		armored[0].generate();
		armored[1]=null;
		
		if (armored[0]!=null)
		{
			armored[0].cd=(float) (Math.random()*1);
			armored[0].ammo=(int) armored[0].total_ammo_size;
		}
		
		if (armored[1]!=null)
		{
			armored[1].cd=(float) (Math.random()*1);
			armored[1].ammo=(int) armored[1].total_ammo_size;
		}	
		
		spr.setOrigin(50, 0);
		offset.y=10;
		can_rotate=false;
		
		friction=0.25f;
		speed*=5f;
		
		friction=100;
	}
	
	@Override
	public void draw_action(float _d) {

		

		
		if (!is_enemy)
		{
			spr.setColor(Color.GREEN);
		}
		
		if (rotate_cooldown<=0)
		{
			rotate_cooldown=0.1f;
			
			if ((is_see)&&(target!=null))
			{
				float dst=pos.dst(target.pos);
				
				float a=target.pos.x+target.impulse.x*dst/750f-(pos.x);
		    	float b=target.pos.y+target.impulse.y*dst/750f-(pos.y)-offset.y;
		    	//float c=(float) Math.sqrt((a*a)+(b*b));
		    	float c=(float) Math.toDegrees(Math.atan2(a, b));
		    	rot=180-c+180;
			
				//if ((impulse.x>0)&&(bottom_draw>=0)&&(bottom_draw<=3)){bottom_draw++;}
				if (c<0){c=360+c;}
		    	
		    	if (c>360){c=c-360;}
		    	//pl.spr.setRotation(360-c);
		    	if (c>347)
				{bottom_draw=0;}
		    	else
		    	{bottom_draw=(int) Math.round(c/22.5);}
			}
			
			
		}
		else
		{
			rotate_cooldown-=_d;
		}
		
		if (body_rotate_cooldown<=0)
		{
			draw_sprite+=1;
			if (draw_sprite>15) {draw_sprite=0;}
			
			body_rotate_cooldown=0.2f;
		}
		else
		{
			body_rotate_cooldown-=_d;
		}
		
		float cold_rating=1.0f-buff_cold/(buff_cold+100.0f);
		
		
		GScreen.batch_custom.setColor(1,1,1,0.1f);
		GScreen.batch_custom.draw(Assets.shadow,pos.x-25f,pos.y-25f,50,50);
		
		
		GScreen.batch_custom.setColor(Color.BLACK);
		
		GScreen.batch_custom.draw_with_light(Assets.pyra_body[draw_sprite], pos.x-Assets.pyra_body[draw_sprite].getWidth()/2f, pos.y,Assets.pyra_body[draw_sprite].getWidth());
		GScreen.batch_custom.draw_with_light(Assets.pyra_head[bottom_draw], pos.x-Assets.pyra_head[bottom_draw].getWidth()/2f, pos.y,Assets.pyra_head[bottom_draw].getWidth());
		//spr.draw(GScreen.batch_custom);
		
		
		draw_hp();
		
		

	}
	

	
	
	
	
}
