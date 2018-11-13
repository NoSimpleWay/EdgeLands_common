package com.midfag.game.skills.shield_skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.skills.Skill;
import com.midfag.game.skills.weapon_skills.SkillFire;


//@SuppressWarnings("unused")
public class SkillShield_ValueHalfDamage_B_BetterShieldCondition extends Skill {
	public float damage_reduction=0.5f;
	public float shield_condition=0.85f;
	
	public SkillShield_ValueHalfDamage_B_BetterShieldCondition()
	{
		super();
		
		pos.x=75;
		pos.y=0;
		
		spr.setTexture(Assets.load("skill_value_half_damage"));
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		name="Усиленное укрепление: защита";
		info="Усиливает укрепление"+"\n"+"Урон уменьшается втрое";
	}
	
	@Override
	public void learn_action()
	{
			((SkillShield_ValueHalfDamage)parent).damage_reduction=0.333f;
	}
}
