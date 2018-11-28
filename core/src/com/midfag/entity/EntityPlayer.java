package com.midfag.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.midfag.equip.energoshield.Energoshield;
import com.midfag.equip.energoshield.EnergoshieldSimple;
import com.midfag.equip.module.LegendaryModuleUnitEXPLOSIONS;
import com.midfag.equip.module.ModuleUnitPush;
import com.midfag.equip.module.ModuleUnitTimeSlow;
import com.midfag.equip.module.ModuleUnitTurret;
import com.midfag.equip.weapon.LegendaryWeaponBlender;
import com.midfag.equip.weapon.LegendaryWeaponChaos;
import com.midfag.equip.weapon.LegendaryWeaponPing;
import com.midfag.equip.weapon.WeaponSimpleFirle;
import com.midfag.equip.weapon.WeaponSimpleLaser;
import com.midfag.equip.weapon.WeaponSimpleMinigun;
import com.midfag.equip.weapon.WeaponSimpleShotgun;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.InputHandler;
import com.midfag.game.Main;
import com.midfag.game.skills.Skill;
import com.midfag.game.skills.shield_skills.SkillGodShield;
import com.midfag.game.skills.shield_skills.SkillGodShield_A_SuperValue;
import com.midfag.game.skills.shield_skills.SkillGodShield_B_SuperRegen;
import com.midfag.game.skills.shield_skills.SkillGodShield_C_SuperReflect;
import com.midfag.game.skills.shield_skills.SkillNoDeath;
import com.midfag.game.skills.shield_skills.SkillShield;
import com.midfag.game.skills.shield_skills.SkillShield_ValueHalfDamage;
import com.midfag.game.skills.shield_skills.SkillShield_ValueHalfDamage_A_BetterDamageReduction;
import com.midfag.game.skills.shield_skills.SkillShield_ValueHalfDamage_B_BetterShieldCondition;
import com.midfag.game.skills.shield_skills.SkillShield_AB_ValueHalfDamageTime;
import com.midfag.game.skills.shield_skills.SkillShield_MoreValue;
import com.midfag.game.skills.shield_skills.SkillShield_BA_WarmProtect;
import com.midfag.game.skills.shield_skills.SkillShield_BB_RestoreSpeed;
import com.midfag.game.skills.shield_skills.SkillShield_B_MoreRegen;
import com.midfag.game.skills.shield_skills.SkillShield_CA_MoreReflectDouble;
import com.midfag.game.skills.shield_skills.SkillShield_CB_MoreReflectRegen;
import com.midfag.game.skills.shield_skills.SkillShield_C_MoreReflect;
import com.midfag.game.skills.weapon_skills.SkillWeapon;
import com.midfag.game.skills.weapon_skills.SkillWeapon_AA_ReloadChance;
import com.midfag.game.skills.weapon_skills.SkillWeapon_AB_AmmoOrReload;
import com.midfag.game.skills.weapon_skills.SkillWeapon_A_FastReload;
import com.midfag.game.skills.weapon_skills.SkillWeapon_BA_TripleShot;
import com.midfag.game.skills.weapon_skills.SkillWeapon_BB_AdvancedBloodlust;
import com.midfag.game.skills.weapon_skills.SkillWeapon_B_Bloodlust;
import com.midfag.game.skills.weapon_skills.SkillWeapon_DA_WeaponExpert;
import com.midfag.game.skills.weapon_skills.SkillWeapon_D_WeaponMaster;
import com.midfag.game.skills.weapon_skills.SkillFire;
import com.midfag.game.skills.weapon_skills.SkillFire_A_ExplodingFire;

public class EntityPlayer extends Entity {

	//public float dead_time; 04.27.12 20.02.2017
	
	public float teleport_cooldown;
	
	//public Sprite leg=new Sprite(new Texture(Gdx.files.internal("leg.png")));
	//public Sprite foot=new Sprite(new Texture(Gdx.files.internal("foot.png")));
	//public Sprite foot_shadow=new Sprite(new Texture(Gdx.files.internal("foot_shadow.png")));
	
	public float leg1_anim;
	public float leg2_anim;
	
	public int leg_anim_mode=1;
	public int leg2_anim_mode=1;

	private float rotate_cooldown;
	
	private long engine_id;
	
	
	
	
	public EntityPlayer(Vector2 _v) {
		
		super(_v);
		
		have_module=true;
		id=this.getClass().getName();
		uid="player_mech";
		
		main_tex=Assets.load("mech_new");
		
		have_collision=true;
		default_collision_size=true;
		collision_size_x=30;
		collision_size_y=30;
		
		is_AI=false;
		is_player=true;
		is_enemy=false;
		time_slow_resist=0.5f;
		
		spr.setSize(100, 100);
		spr.setOrigin(45, 0);
		
		armored_module[0]=new ModuleUnitTimeSlow();
		armored_module[0].generate();

		
		speed=100*15.025f;
		friction=150.15f;

		have_ability=true;

		size=30;
		
		mass=1000;
		
		if (_v!=null)
		{
		
	
			

			
			
			
			
			
			
			
			
			//light_source.light_size=25;
			
			
			//ammo_count=(int) armored_weapon.total_ammo_size;
			
			Skill skill=new SkillShield();
			Skills_list.add(skill);
			
					//---
					//---
					
				Skill subskill=new SkillShield_B_MoreRegen();
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
					Skills_list.add(subskill.add_subskill(new SkillShield_BA_WarmProtect(), GScreen.pl));
					Skills_list.add(subskill.add_subskill(new SkillShield_BB_RestoreSpeed(), GScreen.pl));
			
				subskill=new SkillShield_C_MoreReflect();
				Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
					Skills_list.add(subskill.add_subskill(new SkillShield_CA_MoreReflectDouble(), GScreen.pl));
					Skills_list.add(subskill.add_subskill(new SkillShield_CB_MoreReflectRegen(), GScreen.pl));
			
					armored[0]=new WeaponSimpleFirle();
					armored[1]=null;
					
					armored[0].ammo=(int) armored[0].total_ammo_size;
					armored_shield=new EnergoshieldSimple();
	
					
				skill=new SkillShield_ValueHalfDamage();
				Skills_list.add(skill);	
						subskill=new SkillShield_ValueHalfDamage_A_BetterDamageReduction();
						Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
						
						subskill=new SkillShield_ValueHalfDamage_B_BetterShieldCondition();	
						Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
							
					
				skill=new SkillWeapon();
				Skills_list.add(skill);	
					subskill=new SkillWeapon_A_FastReload();
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
						Skills_list.add(subskill.add_subskill(new SkillWeapon_AA_ReloadChance(), GScreen.pl));
						Skills_list.add(subskill.add_subskill(new SkillWeapon_AB_AmmoOrReload(), GScreen.pl));
					subskill=new SkillWeapon_B_Bloodlust();	
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
						Skills_list.add(subskill.add_subskill(new SkillWeapon_BA_TripleShot(), GScreen.pl));
						Skills_list.add(subskill.add_subskill(new SkillWeapon_BB_AdvancedBloodlust(), GScreen.pl));
					subskill=new SkillWeapon_D_WeaponMaster();
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
						Skills_list.add(subskill.add_subskill(new SkillWeapon_DA_WeaponExpert(), GScreen.pl));
				
				skill=new SkillFire();
				Skills_list.add(skill);
					subskill=new SkillFire_A_ExplodingFire();
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
			
				skill=new SkillGodShield();
					subskill=new SkillGodShield_A_SuperValue();
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
					
					subskill=new SkillGodShield_B_SuperRegen();
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
					
					subskill=new SkillGodShield_C_SuperReflect();
					Skills_list.add(skill.add_subskill(subskill, GScreen.pl));
					
					
				Skills_list.add(skill);	
				
				
				
				skill=new SkillNoDeath();
				
				Skills_list.add(skill);	
				
				engine_id=Assets.engine.play();
				Assets.engine.setVolume(engine_id, 0.25f);
				Assets.engine.setLooping(engine_id, true);
			
		}
		// TODO Auto-generated constructor stub
	}
	
	public void draw_leg_horiz(float _x, float _y, int _dim)
	{
		float up=0;
		if (((leg_anim_mode>=0)&&(_dim==1))||((leg_anim_mode<0)&&(_dim==-1))){up=GScreen.sinR((1-leg1_anim)*90)*5;}
		
		/*leg.setScale(1, 1);
		leg.setRotation((leg1_anim*60*_dim));
		
		
		
		leg.setPosition(pos.x+5, pos.y+5+_y+1.2f);
		leg.draw(GScreen.batch);
		
		foot.setPosition(pos.x+leg1_anim*24*_dim+_x-7, pos.y+_y+up+10);
		foot.draw(GScreen.batch);
		
		foot_shadow.setPosition(pos.x+leg1_anim*24*_dim+_x-7, pos.y+_y+10);
		foot_shadow.draw(GScreen.batch);
		
		
		
		
		
		leg.setPosition(pos.x+5, pos.y+5+_y-1.2f);
		leg.draw(GScreen.batch);
		*/

	}
	
	public void draw_leg_vert(float _x, float _y, int _dim)
	{
		float up=0;
		if (((leg2_anim_mode>=0)&&(_dim==1))||((leg2_anim_mode<0)&&(_dim==-1))){up=GScreen.sinR((1-leg2_anim)*90)*5;}
		
		/*
		foot.setPosition(pos.x+_x-7, pos.y+_y+up+leg2_anim*24*_dim);
		foot.draw(GScreen.batch);
		
		foot_shadow.setPosition(pos.x+_x-7, pos.y+_y+leg2_anim*24*_dim);
		foot_shadow.draw(GScreen.batch);
		
		
		
		leg.setRotation(0);
		leg.setPosition(pos.x+5+_x, pos.y+5+_y);
		leg.setScale(1, 1-leg2_anim/2*_dim);
		leg.draw(GScreen.batch);
		*/
	}
	
	@Override
	public void draw_action(float _d) {
		
		float cold_rating=1.0f-buff_cold/(buff_cold+100.0f);
		spr.setColor(cold_rating*total_illum_R, cold_rating*total_illum_G, total_illum_B, 1);
		
		if (rotate_cooldown<=0)
		{
			rotate_cooldown=0.1f;
			
				//cold_rating=1-buff_cold/(buff_cold+100);
				//spr.setColor(cold_rating, 1, 1, 1);
				
				//if ((impulse.x>0)&&(bottom_draw>=0)&&(bottom_draw<=3)){bottom_draw++;}
				float c=(float) Math.toDegrees(Math.atan2(impulse.x, impulse.y));
				if (c<0){c=360+c;}
		    	
		    	if (c>360){c=c-360;}
		    	//pl.spr.setRotation(360-c);
		    	if (c>347)
				{bottom_draw=0;}
		    	else
		    	{bottom_draw=(int) Math.round(c/22.5);}
			
			
			
		}
		else
		{
			rotate_cooldown-=_d;
		}		

		//{GScreen.batch.draw	(main_tex, pos.x-45, pos.y,	   0,	   90,     90,90);}
		GScreen.batch_custom.setColor(total_illum_R,total_illum_G,total_illum_B,1f);
		if (main_tex!=null)
		{
			{GScreen.batch_custom.draw_with_light_atlas(main_tex, pos.x-64, pos.y-32,128,128,0.0625f*draw_sprite,1f,0.0625f*draw_sprite+0.0625f,0,128);}
		}
		

	}
	
	
	

	
	@Override
	public void some_update(float _d)
	{
		//if (impulse.x>0)
		float vol=(Math.abs(impulse.x)+Math.abs(impulse.y))/400f+0.5f;
		//Assets.engine.setPitch(engine_id, vol);
	
		

		Assets.engine.setVolume(engine_id, (vol-0.5f)/15f);

		
		//if (Gdx.input.isKeyPressed(106))
		//{
		//	System.out.println("Scroll lock is live!");
		//}
		
		if (GScreen.main_control)
		{
			if ((Gdx.input.isKeyPressed(Keys.NUM_1))&&(InputHandler.keyF_release)){use_module(0); InputHandler.keyF_release=false;}
			if ((Gdx.input.isKeyPressed(Keys.NUM_2))&&(InputHandler.keyF_release)){use_module(1); InputHandler.keyF_release=false;}
			if ((Gdx.input.isKeyPressed(Keys.NUM_3))&&(InputHandler.keyF_release)){use_module(2); InputHandler.keyF_release=false;}
			if ((Gdx.input.isKeyPressed(Keys.NUM_4))&&(InputHandler.keyF_release)){use_module(3); InputHandler.keyF_release=false;}
			if ((Gdx.input.isKeyPressed(Keys.NUM_5))&&(InputHandler.keyF_release)){use_module(4); InputHandler.keyF_release=false;}
		}
		
		if (Gdx.input.isKeyPressed(Keys.G))
		{
			/*
			if (Math.random()>0.33)
			{armored_weapon=new WeaponSimpleFirle();}
			else
			if (Math.random()>0.33)
			{armored_weapon=new WeaponSimpleShotgun();}
			else
			{armored_weapon=new WeaponSimpleMinigun();}*/
			
			//Assets.shoot03.stop(miso);
			
	        for (int i=0; i<30; i++)//;
	        {
	        	if (Math.random()>0.05)
	        	{
	        		switch ((int)GScreen.rnd(9))
		        	{
		        		case 0: inventory[i]=new WeaponSimpleFirle();		break;
		        		case 1: inventory[i]=new WeaponSimpleMinigun();		break;
		        		case 2: inventory[i]=new WeaponSimpleShotgun();		break;
		        		case 3: inventory[i]=new EnergoshieldSimple(); 		break;
		        		case 4: inventory[i]=new WeaponSimpleLaser(); 		break;
		        		case 5: inventory[i]=new ModuleUnitPush(); 			break;
		        		case 6: inventory[i]=new ModuleUnitTimeSlow(); 		break;
		        		case 7: inventory[i]=new ModuleUnitTurret(); 		break;
		        		case 8: inventory[i]=new LegendaryModuleUnitEXPLOSIONS(); 		break;
		        	}
	        	}
	        	else
	        	switch ((int)GScreen.rnd(3))
		        {
		       		case 0: inventory[i]=new LegendaryWeaponBlender();	break;
		       		case 1: inventory[i]=new LegendaryWeaponChaos();	break;
		       		case 2: inventory[i]=new LegendaryWeaponPing();		break;
		        }
	        	
	        	//if (inventory[i] instanceof Energoshield)
	        	//{
	        		//for (int i=0; i<Skill)
	        	//}
	        	
				for (int j=0; j<GScreen.pl.Skills_list.size();j++)
				{
					if (GScreen.pl.Skills_list.get(j).learned)
					if (inventory[i] instanceof Energoshield)
					{GScreen.pl.Skills_list.get(j).shield_gen_action((Energoshield) inventory[i]);}
				}
	        }
		}
		/*
		if ((teleport_cooldown<=0)&(Gdx.input.isKeyPressed(Keys.E)))
		{
			hard_move(GScreen.sinR(360-rot)*200,GScreen.cosR(360-rot)*200,1);
			
			teleport_cooldown=3;
			
			Assets.flash.play();
		}*/
		
		if (teleport_cooldown>0){teleport_cooldown-=_d;}
	}
	
	

}
