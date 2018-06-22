package com.midfag.game.GUI.buttons;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.InputHandler;
import com.midfag.game.Main;
import com.midfag.game.GUI.GUI;
import com.midfag.game.GUI.GUISkillsWheel;
import com.midfag.game.skills.Skill;


public class ButtonSkill extends Button {

	private static final int info_x = 0;
	private static final int info_y = -250;
	public Skill skill;
	private int mov;
	public GUI gui;
	
	public float rotate;
	
	
	
	GlyphLayout layout = new GlyphLayout();
	//List<skill> skill_list = new ArrayList<Phys>();
	public ButtonSkill(float _x, float _y, Skill _s, GUI _gui)
	{
		super (_x, _y);
		
		spr.setTexture(Assets.load("skill_bg"));
		spr.setSize(50, 50);
		
		size_x=50;
		size_y=50;
		
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		skill=_s;
		
		gui=_gui;
		off_bg=true;
		
		rotate=(float) (Math.random()*360);
		
		
	}
	
	public void draw_info(String _s1, int _h)
	{
		draw_info(_s1, "",_h);
	}
	

	private void draw_info(String _s1) {
		// TODO Auto-generated method stub
		draw_info(_s1, "",18);
	}
	
	public void draw_info(String _s1, String _s2,int _h)
	{
		layout.setText(Main.font_big,_s1);
		Main.font_big.draw(GScreen.batch_static, _s1, info_x-layout.width/2+GScreen.skills_camera.position.x, info_y-mov+GScreen.skills_camera.position.y+160-(_h-layout.height)/2);
		//Main.font.draw(GScreen.batch_gui, _s2, info_x+100, info_y-mov);
		
		mov+=25;
	}
	
	@Override
	public void some_update(float _d)
	{
		if (!GScreen.show_skills_wheel)
		{
			need_remove=true;
		}
	}
	
	@Override
	public void second_update(float _d)
	{
		if (Math.abs(skill.pos_current.x-skill.pos.x)>_d*400f)
		{
			if (skill.pos_current.x>skill.pos.x) {skill.pos_current.x-=_d*400f;}
			if (skill.pos_current.x<skill.pos.x) {skill.pos_current.x+=_d*400f;}
		}
		else
		{
			skill.pos_current.x=skill.pos.x;
		}
		
		if (Math.abs(skill.pos_current.y-skill.pos.y)>_d*200f)
		{
		if (skill.pos_current.y>skill.pos.y) {skill.pos_current.y-=_d*400f;}
		if (skill.pos_current.y<skill.pos.y) {skill.pos_current.y+=_d*400f;}
		}
		else
		{
			skill.pos_current.y=skill.pos.y;
		}
		
		pos.x=skill.pos_current.x;
		pos.y=skill.pos_current.y;
		

		if (Gdx.input.isKeyPressed(Keys.ESCAPE))
		{
			((GUISkillsWheel)gui).main_skill_picked=false;
			skill.parent_overlap=false;
			
			//if (skill.parent!=null) {skill.reset_current_position();}
			
		}
		is_active=true;
		
		if ((((GUISkillsWheel)gui).main_skill_picked)&&(!skill.parent_overlap)){is_active=false;}
		
		if (skill.parent!=null)
		{
			is_active=skill.parent.learned;
			if (!(((GUISkillsWheel)gui).main_skill_picked)){is_active=false;}
			
			//skill.parent_ready=is_active;
		}
		
		if (!(((GUISkillsWheel)gui).main_skill_picked))
		{skill.parent_overlap=false;}
		
		if ((is_overlap())&&(is_active))
		{skill.parent_overlap=true;}
		
		if ((InputHandler.but==0)&&(is_overlap())&&(is_active))
		{
			
			
			
			if (
					(((GUISkillsWheel)gui).main_skill_picked)
					&&
					(
							(skill.parent==null)
							||
							(
									(skill.parent!=null)
									&&
									(!skill.parent.child_learned)
									&&
									(skill.parent.learned)
									&&
									(skill.parent.level>=skill.parent.maxlevel)
							)
					)
				)
			{
				if (skill.parent!=null)
				{
					skill.parent.child_learned=true;
				}
				skill.learned=true;
				
				
				skill.learn_action();
				
				/*
				spr.setColor(Color.LIME);
				skill.spr.setColor(Color.LIME);*/
				
			}
			
			if (skill.learned)
			{
				skill.level++;
				
				if (skill.level>skill.maxlevel)
				{
					skill.level=skill.maxlevel;
				}
				
				//Assets.select_sprite.setTexture(Assets.select_texture[skill.level-1]);
				skill.update_info();
			}
			
			InputHandler.but=-1;
			if ((skill.parent==null)&&(!((GUISkillsWheel)gui).main_skill_picked))
			{
				((GUISkillsWheel)gui).main_skill_picked=true;
				Helper.log("LIST SIZE:"+skill.child_list.size());
				if (skill.child_list.size()>0)
				{	
					
					for (Skill skl:skill.child_list)
					{skl.reset_current_position();}
				}
			
				((GUISkillsWheel)gui).skill_x=skill.pos.x;
				((GUISkillsWheel)gui).skill_y=skill.pos.y;
			}
		}
		
		if ((InputHandler.but==0)&&(!is_overlap())&&(is_active))
		{
			//gui.subskill_pick=false;
			//skill.parent_ready=false;
		}
		
		if (((GUISkillsWheel)gui).main_skill_picked)
		{
			if (skill.parent!=null)
			{
				is_active=skill.parent.parent_overlap;
				
				skill.parent_overlap=is_active;
			}
			else
			{is_active=skill.parent_overlap;}
		}
	}
	

	
	@Override
	public void after_draw()
	{

		if (is_active)
		{skill.spr.setPosition(pos.x-spr.getWidth()/2,pos.y-spr.getHeight()/2);
		skill.spr.draw(GScreen.batch_static);
		}

	}
	
	@Override
	public void second_draw()
	{
		skill.locked=false;
		skill.spr.setColor(Color.WHITE);
		
		//if (!is_overlap())
		{
			if ((!skill.learned)&&(skill.parent!=null)&&(skill.parent.level<skill.parent.maxlevel))
			{
				skill.spr.setColor(0.5f,0.5f,0.5f,0.75f);
			}
			
			if ((!skill.learned)&&(skill.parent!=null)&&(skill.parent.level<=0))
			{
				skill.spr.setColor(0.1f,0.1f,0.1f,0.75f);
			}
			
	
			
			
			
			if (skill.locked)
			{skill.spr.setColor(0.2f,0.1f,0.1f,0.5f);}
		}
		
		if ((skill.parent!=null)&&(skill.parent.learned)&&(skill.parent.child_learned)&&(!skill.learned))
		{skill.locked=true;}
		
		
		if ((skill.parent!=null)&&(skill.parent.locked))
		{skill.locked=true;}
		
		/*
		if ((skill.parent!=null)&&(!skill.parent.learned))
		{skill.locked=true;}*/
		
		if (skill.locked)
		{
			skill.spr.setColor(0.10f,0.08f, 0.076f,1f);
		//	skill.spr.setAlpha(0.50f);
		}
		/*
		if ((skill.parent!=null)&&(!skill.parent.learned))
		{skill.spr.setColor(Color.DARK_GRAY);}
		
		if ((skill.parent!=null)&&(skill.parent.learned)&&(skill.parent.child_learned)&&(!skill.learned))
		{skill.spr.setColor(Color.DARK_GRAY);}*/
		
		if ((is_overlap())&&(is_active))
		{
			mov=0;

			 
			
		 	Gdx.gl.glEnable(GL20.GL_BLEND);
	        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	        
	        /*
			Main.shapeRenderer_static.begin(ShapeType.Filled);
				Main.shapeRenderer_static.setColor(0.10f,0.10f,0.10f,0.95f);
				Main.shapeRenderer_static.rect(info_x-300+GScreen.skills_camera.position.x, info_y-375+300+GScreen.skills_camera.position.y,600,250);
			Main.shapeRenderer_static.end();*/
			
	       
	        GScreen.batch_static.setShader(Main.shader);
				Main.shader.setUniformf("x", 0);
				Main.shader.setUniformf("y", 0);
				
				Main.shader.setUniformf("uTime", GScreen.wave_time*77);
		    	Main.shader.setUniformf("zoom",1);
	        	GScreen.batch_static.draw(Assets.text_bg, info_x-462+GScreen.skills_camera.position.x, info_y-385+300+GScreen.skills_camera.position.y);
	        GScreen.batch_static.setShader(GScreen.batch.getShader());
	        
		
			
			
			mov=-5;
			Main.font_big.setColor(Color.GOLDENROD);
			draw_info(skill.name,30);
			mov+=10;
			
			Main.font_big.setColor(Color.SLATE);
			draw_info(skill.info,150);
			mov+=130;
			
			Main.font_big.setColor(0.1f,0.4f,0.2f,0.9f);
			if (!((GUISkillsWheel)gui).main_skill_picked)
			{
				if (skill.parent==null)
				{draw_info("������� �� ������, ��� �� ������ � ����� ��� ��������.");}
				
				
			}
			else
			{
				if ((skill.parent!=null)&&(!skill.parent.learned))
				{
					Main.font_big.setColor(Color.RED);
					draw_info("���������� ������� ������, ��� ��� <"+skill.parent.name+"> �� �������");;
					
				}
				else
				if ((skill.parent!=null)&&(skill.parent.learned)&&(skill.parent.child_learned)&&(!skill.learned))
				{
					Main.font_big.setColor(Color.RED);
					draw_info("���������� ������� ������, ��� ��� ������� ������ ����������� ������");;
					
				}
				else
				{
					if (!skill.learned){draw_info("������� �� ������, ��� �� ������� ���.");}}
			}
			Main.font_big.setColor(Color.WHITE);
			//GScreen.batch_gui.end();
		}
		
		if ((skill.learned)&(is_active))
		{

			/*
				if (skill.level==1) {Assets.select_sprite.setColor(Color.GREEN);}
				if (skill.level==2) {Assets.select_sprite.setColor(Color.BLUE);}
				if (skill.level==3) {Assets.select_sprite.setColor(Color.MAGENTA);}
				if (skill.level==4) {Assets.select_sprite.setColor(Color.ORANGE);}
				if (skill.level>=5) {Assets.select_sprite.setColor(Color.CYAN);}
				*/
				
			
			
				//Assets.select_sprite.setTexture(Assets.select_texture[skill.level-1]);
				if (skill.level>=skill.maxlevel)
				{Assets.select_sprite.setColor(Color.WHITE);}
				else
				{Assets.select_sprite.setColor(0.6f,0.6f,0.6f,0.6f);}
				
				Assets.select_sprite.setPosition(pos.x-78,pos.y-78);
				Assets.select_sprite.setRotation(rotate);
				Assets.select_sprite.draw(GScreen.batch_static);

			
			rotate+=GScreen.real_delta*5;
		}
		
		/*
		for (int i=0; i<skill.Sub_skill.size(); i++)
		{
			skill.Sub_skill.get(i).spr.setPosition(pos.x-skill.Sub_skill.get(i).spr.getWidth()/2+skill.Sub_skill.get(i).pos.x,pos.y-skill.Sub_skill.get(i).spr.getHeight()/2+skill.Sub_skill.get(i).pos.y);
			skill.Sub_skill.get(i).spr.draw(GScreen.batch_gui);
		}*/

	}

}
