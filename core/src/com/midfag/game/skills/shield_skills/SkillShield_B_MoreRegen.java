package com.midfag.game.skills.shield_skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.midfag.equip.energoshield.Energoshield;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.skills.Skill;

public class SkillShield_B_MoreRegen extends Skill {
	public SkillShield_B_MoreRegen()
	{
		super();
		
		pos.x=-60;
		pos.y=60;
		
		spr.setTexture(Assets.load("skill_shield_regen"));
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		name="��������";
		info="������������� �����������"+"\n"+"�������� ����������� ���� 25%";
	}
	
	@Override
	public void shield_gen_action(Energoshield _e)
	{
		_e.total_regen_speed+=_e.base_regen_speed*0.25f;
	}
	
	@Override
	public void learn_action()
	{
		
		
		GScreen.pl.armored_shield.update_attributes_bonus(GScreen.pl);
		
		for (int i=0; i<GScreen.pl.inventory.length; i++)
		{
			if (GScreen.pl.inventory[i] instanceof Energoshield)
			{
				((Energoshield)GScreen.pl.inventory[i]).update_attributes_bonus(GScreen.pl);
			}
		}
	}
}
