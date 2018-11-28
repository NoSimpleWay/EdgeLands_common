package com.midfag.game.screen_effect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.SoundLoader;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.midfag.equip.module.ModuleUnit;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.Main;

public class ScreenEffectWorldEXTERMINATION extends ScreenEffect {
	
	boolean played=false;
	public Texture planet_explosion=Assets.load("planet_explosion");
	public Texture planet_dead=Assets.load("planet_dead");
	public Texture error_screen=Assets.load("error_screen");
	public Texture critical_failure_sign=Assets.load("critical_failure_sign");
	
	float sign_cd;
	float incorrect_text_cd;
	boolean sign_black;
	
	float sound_cooldown=0;
	
	int incorrect_text_count=0;
		
	public Sound alarm=Gdx.audio.newSound(Gdx.files.internal("data/alarm.wav"));
	
	public boolean phase_zoom=false;
	
	
	public float progress=0;
	private float color_burn=1f;
	private long alarm_id;
	private float game_over_alpha;
	
	public ScreenEffectWorldEXTERMINATION()
	{
		//

		Main.font_dot_console.getData().setScale(1);
		
		
		Assets.main_music.stop();
		
		Helper.log("try stop Battle music");
		Assets.battle_music_00.setVolume(0.1f);
		Helper.log("Battle music stopped");
		
		
		//alarm.setLooping(alarm_id, true);
		
		GScreen.main_control=false;
		GScreen.main_control_is_locked=true;
		GScreen.time_speed=0.01f;
		//GScreen.need_zoom=8800;
		
		
		//GScreen.batch_static.setShader(Main.shader_time_slow);
		//Assets.music.setVolume(0.05f);
		
		//shader=Main.shader_time_slow;
	}
	
	@Override
	public void update(float _d,float _real_d)
	{
		//Helper.log(""+progress);
		progress+=_real_d;
		sign_cd-=_real_d;
		incorrect_text_cd-=_real_d;
		sound_cooldown-=_real_d;
		
		if (sign_cd<=0)
		{
			sign_cd+=0.2f;
			
			sign_black=!sign_black;
		}
		
		if (incorrect_text_cd<=0)
		{
			incorrect_text_cd+=0.1f;
			
			
			if (progress>9) {incorrect_text_count++;}
		}
		
		if ((sound_cooldown<=0)&&(progress<12))
		{
			sound_cooldown+=0.75f;
			
			
			alarm.play();
		}
		

		if (progress<12f)
		{
		GScreen.batch_static.setColor(0.5f,0.5f,0.5f,0.5f);
		GScreen.batch_static.draw(Assets.rect_white, 0, 0, GScreen.scr_w, GScreen.scr_h);
		
		GScreen.batch_static.setColor(Color.WHITE);
		GScreen.batch_static.draw(error_screen, (GScreen.scr_w-670f)/2f, (GScreen.scr_h-370f)/2f);
	
	
		if (sign_black)
		{GScreen.batch_static.setColor(Color.BLACK);}
		else
		{GScreen.batch_static.setColor(Color.WHITE);}
		
		
		
		GScreen.batch_static.draw(critical_failure_sign, (GScreen.scr_w-670f)/2f-220f, (GScreen.scr_h-370f)/2f+150);
		GScreen.batch_static.draw(critical_failure_sign, (GScreen.scr_w-670f)/2f+670f, (GScreen.scr_h-370f)/2f+150);
		}
		
		if (progress<9f)
		{
			
			
			Main.font_dot_console.setColor(Color.RED);
			Main.font_dot_console.draw(GScreen.batch_static, "ВНУТРЕННЯЯ ОШИБКА ЯДРА ОРУЖИЯ (STATUS DERC-S14719)", (GScreen.scr_w-670f)/2f+10f, (GScreen.scr_h-370f)/2f+350);
			
			Main.font_dot_console.setColor(Color.LIME);
			Main.font_dot_console.draw(GScreen.batch_static, "При опросе боевой единицы возникла необратимая ошибка"+"\n\n"+"Вызвано из: Критическое состояние ядра"+"\n\n"+"Вызвано из: Летальная динамика роста температуры", (GScreen.scr_w-670f)/2f+10f, (GScreen.scr_h-370f)/2f+250);
			
			if (progress>3)
			{
			
			Main.font_dot_console.setColor(Color.RED);
			Main.font_dot_console.draw(GScreen.batch_static, "Ядро будет перезагружено через: "+Math.round((8f-progress)*10f)/10f+" секунд", (GScreen.scr_w-670f)/2f+5f, (GScreen.scr_h-370f)/2f+55);
			}
		}
		
		if ((progress>=9f)&(progress<12f))
		{
			Main.font_dot_console.setColor(Color.RED);
			for (int i=0; i<incorrect_text_count; i++)
			{Main.font_dot_console.draw(GScreen.batch_static, "DERC сообщил о INCORRECT CONFIGURATION... попытка RETRY", (GScreen.scr_w-670f)/2f+5f, (GScreen.scr_h-370f)/2f+350-i*30);}
			//Main.font_dot_console.si
		}
		
		
		
		if ((progress>=10.4f)&(!phase_zoom))
		{
			phase_zoom=true;

			Helper.log("try play exterminate music");
			Assets.music_exterminate.play();
			Assets.music_exterminate.setLooping(true);
		}
		
		if (progress>=12f)
		{
			GScreen.need_zoom+=1f;
			GScreen.need_zoom*=1.0f+_real_d*5f;
			
			if (GScreen.need_zoom>8800) {GScreen.need_zoom=8800;}
		}
		
		
		if (progress>=20f)
		{
			
			//GScreen.batch_static.setColor(Color.WHITE);
			//GScreen.batch_static.draw(error_screen, (GScreen.scr_w-670f)/2f, (GScreen.scr_h-370f)/2f);
			
			/*GScreen.batch_static.setColor(0.5f,0.5f,0.5f,game_over_alpha/2f);
			GScreen.batch_static.draw(Assets.rect_white, 0, 0, GScreen.scr_w, GScreen.scr_h);*/
			
			game_over_alpha+=_real_d; if (game_over_alpha>1f) {game_over_alpha=1f;}
			Main.font_dot_console.setColor(1f,0f,0f,game_over_alpha);
			Main.font_dot_console.getData().setScale(10);
			

			Main.font_dot_console.setColor(0f,0f,0f,game_over_alpha);
			Main.font_dot_console.draw(GScreen.batch_static, "GAME"+"\n"+"OVER", (GScreen.scr_w-670f)/2f+100f, (GScreen.scr_h-370f)/2f+350);
			Main.font_dot_console.draw(GScreen.batch_static, "GAME"+"\n"+"OVER", (GScreen.scr_w-670f)/2f+10f+100f, (GScreen.scr_h-370f)/2f+350);
			
			Main.font_dot_console.draw(GScreen.batch_static, "GAME"+"\n"+"OVER", (GScreen.scr_w-670f)/2f+5+100f, (GScreen.scr_h-370f)/2f+350+5f);
			Main.font_dot_console.draw(GScreen.batch_static, "GAME"+"\n"+"OVER", (GScreen.scr_w-670f)/2f+5+100f, (GScreen.scr_h-370f)/2f+350-5f);
			
			Main.font_dot_console.setColor(1f,0f,0f,game_over_alpha);
			Main.font_dot_console.draw(GScreen.batch_static, "GAME"+"\n"+"OVER", (GScreen.scr_w-670f)/2f+5f+100f, (GScreen.scr_h-370f)/2f+350);
			
			
		}

		
		
		
	}
	
	@Override
	public void update_pre(float _d,float _real_d)
	{
		if (progress>14f)
		{
			color_burn-=_real_d/10f;
			
			if (color_burn<0f) {color_burn=0f;}
			//float color=(1f+(14f-progress)/15f); if (color<0) {color=0;}
			GScreen.batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			GScreen.batch.setColor(1f,1f,1f,1f-color_burn);
			GScreen.batch.draw(planet_dead, 5000-18000*243, 5000-18000*243, 36000*243,36000*243);
			
			GScreen.batch.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE);
			
			GScreen.batch.setColor(color_burn,color_burn,color_burn,1f);
			GScreen.batch.draw(planet_explosion, 5000-18000*243, 5000-18000*243, 36000*243,36000*243);
			
			/*
			GScreen.batch.setColor(color_burn,color_burn,color_burn,1f);
			GScreen.batch.draw(planet_explosion, 5000-18000*243*, 5000-18000*243*, 36000*243*,36000*243);*/
		}
	}
	
	@Override
	public void end_action() {
		// TODO Auto-generated method stub
		
	}
	
}
