package com.midfag.game.skills;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.entity.missiles.Missile;
import com.midfag.equip.energoshield.Energoshield;
import com.midfag.equip.module.ModuleUnit;
import com.midfag.equip.weapon.Weapon;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Main;
import com.midfag.game.Phys;

@SuppressWarnings("unused")
public class Skill {
	public Sprite spr=new Sprite(Assets.load("button"));
	public String name="some skill";
	public Texture indicate_tex;
	
	
	public int level=0;
	public int maxlevel=1;
	public boolean learned=false;
	public boolean blocked=false;
	
	public Vector2 pos=new Vector2();
	public Vector2 pos_current=new Vector2();
	public String info;
	
	public Skill skill_a;
	
	public boolean parent_overlap=false;
	
	//public List<Skill> Sub_skill = new ArrayList<Skill>();
	
	public List<Skill> child_list = new ArrayList<Skill>();
	public Skill parent;
	
	public boolean child_learned=false;
	public boolean need_to_indicate=false;
	public boolean locked=false;
	
	public float cooldown_base;
	public float cooldown;
	
	public float duration_base;
	public float duration;
	
	public float highlight_value=0f;
	
	public String indicate_text="";
	
	
	
	public Skill()
	{
		spr.setSize(44, 44);
		
		spr.setOrigin(25, 25);
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//pos_current.set(pos);
	}
	
	public Skill add_sub_skillf(Skill _s)
	{
		
		return _s;
	}
	
	public void draw_sub_skill()
	{
		spr.setPosition(pos.x-20, pos.y-20);
		spr.draw(GScreen.batch_static);
		
		

	}
	
	public void child_learned()
	{
		
	}
	
	public Skill add_subskill(Skill _s, Entity _e)
	{
		child_list.add(_s);
		_s.parent=this;
		_s.pos.add(pos);
		return _s;
	}
	
	public void shield_gen_action(Energoshield _e)
	{
		
	}
	
	public void weapon_gen_action(Weapon _e)
	{
		
	}
	
	public void learn_action()
	{
		
	}
	
	public void weapon_start_reload_action(Entity _e, int _i)
	{
		
	}
	
	public float damage_action(Object _o, float _damage)
	{
		return _damage;
	}
	
	public void prefire_action(Entity _e)
	{
		
	}
	

	public void indicate(float _x, float _y, float _d)
	{
		

		GScreen.batch_static.draw(indicate_tex, _x-22, _y-22);
		
		if (indicate_text.length()>0)
		{
			GScreen.batch_static.draw(Assets.indicate_bg, _x-25, _y+20);
			Main.font.draw(GScreen.batch_static, indicate_text, _x-15, _y+37);
		}
		
		if (cooldown_base>0)
		{
			//GScreen.batch_static.setColor(Color.RED);
			GScreen.batch_static.draw(Assets.icon_cooldown, _x-25, _y-25+25*(1-cooldown/cooldown_base),50f,50f*cooldown/cooldown_base);
		}
		
		if (duration_base>0)
		{
			//GScreen.batch_static.setColor(Color.RED);
			GScreen.batch_static.draw(Assets.icon_duration, _x-25, _y-25+25*(1-duration/duration_base),50f,50f*duration/duration_base);
		}
		
		if (highlight_value>0)
		{
			float col=1f-Math.abs(0.25f-highlight_value)*4f;
					
			GScreen.batch_static.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE);
			
			GScreen.batch_static.setColor(col, col, col, 1);
			highlight_value-=_d;
			GScreen.batch_static.draw(Assets.highlight, _x-50, _y-50);
			GScreen.batch_static.setColor(Color.WHITE);
					
			GScreen.batch_static.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		}
		
		
	}
	
	public void time_action(float _d)
	{
		if (cooldown>0)
		{
			cooldown-=_d;
			
			if ((cooldown<=0)&&(duration_base>0))
			{
				cooldown=0;
				duration=duration_base;
			}
		}
		
		if (duration>0)
		{
			duration-=_d;
			
			if ((duration<=0)&&(cooldown_base>0))
			{
				duration=0;
				
				cooldown=cooldown_base;
			}
		}
		
		
	}

	public float warm_damage_action(Entity _e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void prereflect_action(Missile _m, Entity _e) {
		// TODO Auto-generated method stub
		

		
	}

	public void reflect_action(Missile _m, Entity _e) {
		// TODO Auto-generated method stub
		
	}

	public void module_gen_action(ModuleUnit _m) {
		// TODO Auto-generated method stub
		
	}

	public void missile_hit_action(Entity master, Entity near_entity, Missile _mis) {
		// TODO Auto-generated method stub
		
	}

	public void update_info() {
		// TODO Auto-generated method stub
		
	}

	public void reset_current_position() {
		
		Helper.log("HEH");
		pos_current.set(parent.pos_current);
		
		if (child_list.size()>0)
		{	
			
			for (Skill skl:child_list)
			{skl.reset_current_position();}
		}
		//if (skill_a!=null) {skill_a.reset_current_position();}		//if (child!=null) {}
		//if (parent!=null)
		// TODO Auto-generated method stub
		
	}
}
