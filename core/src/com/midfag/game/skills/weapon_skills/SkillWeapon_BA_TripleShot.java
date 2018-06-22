package com.midfag.game.skills.weapon_skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.skills.Skill;

public class SkillWeapon_BA_TripleShot extends Skill {
	
	

	public SkillWeapon_BA_TripleShot()
	{
		super();
		
		pos.x=-50;
		pos.y=0;
		
		spr.setTexture(Assets.load("icon_triple_shot"));
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		name="��������";
		info=	"20% ���� ���������� ����� ������ ��������";
		
		//skill_a=new SkillShield_A_MoreValue();
		
	}
	

	@Override
	public void prefire_action(Entity _e)
	{
		if (Math.random()<0.2f){_e.multiply_missile_count+=2;}
	}
	
	
	
}
