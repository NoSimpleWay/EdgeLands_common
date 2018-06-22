package com.midfag.game.skills.shield_skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.midfag.entity.Entity;
import com.midfag.entity.missiles.Missile;
import com.midfag.game.Assets;
import com.midfag.game.skills.Skill;

public class SkillShield_CB_MoreReflectRegen extends Skill {
	public SkillShield_CB_MoreReflectRegen()
	{
		super();
		
		pos.x=-35;
		pos.y=-67;
		
		spr.setTexture(Assets.load("skill_shield_reflect_regen"));
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		name="����������";
		info="20% �� ����������� �����"+"\n"+"��������������� ���������";
		
		
	}
	
	@Override
	public void prereflect_action(Missile _m, Entity _e) {
		// TODO Auto-generated method stub
		_e.armored_shield.value+=_m.damage*0.2f;

		
	}
}
