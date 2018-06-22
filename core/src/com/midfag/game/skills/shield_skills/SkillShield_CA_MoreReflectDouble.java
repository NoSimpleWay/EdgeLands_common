package com.midfag.game.skills.shield_skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.midfag.entity.Entity;
import com.midfag.entity.missiles.Missile;
import com.midfag.game.Assets;
import com.midfag.game.skills.Skill;

public class SkillShield_CA_MoreReflectDouble extends Skill {
	public SkillShield_CA_MoreReflectDouble()
	{
		super();
		
		pos.x=35;
		pos.y=-67;
		
		spr.setTexture(Assets.load("skill_shield_reflect_double"));
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		name="��������";
		info="���������� ������� �������"+"\n"+"����������� ��������� ����";
	}
	
	@Override
	public void reflect_action(Missile _m, Entity _e) {
		// TODO Auto-generated method stub
		
		_m.damage*=2;
	}
}
