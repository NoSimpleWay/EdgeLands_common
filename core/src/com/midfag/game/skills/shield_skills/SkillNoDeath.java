package com.midfag.game.skills.shield_skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.midfag.equip.energoshield.Energoshield;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.skills.Skill;

public class SkillNoDeath extends Skill {
	
	

	public SkillNoDeath()
	{
		super();
		
		pos.x=670;
		pos.y=615;
		
		spr.setTexture(Assets.load("skill_no_death"));
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		name="���������� ��� �������";
		info=	"+640 000 ����";
		
		//skill_a=new SkillShield_A_MoreValue();
		
	}
	
	@Override
	public void shield_gen_action(Energoshield _e)
	{
		_e.total_value+=+640000;
	}
	
	@Override
	public void learn_action()
	{
		
		System.out.println("!@#$%^&");
		GScreen.pl.armored_shield.update_attributes_bonus(GScreen.pl);
		
		for (int i=0; i<GScreen.pl.inventory.length; i++)
		{
			if (GScreen.pl.inventory[i] instanceof Energoshield)
			{
				((Energoshield)GScreen.pl.inventory[i]).update_attributes_bonus();
			}
		}
	}
	
}
