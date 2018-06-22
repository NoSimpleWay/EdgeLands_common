package com.midfag.game.skills.weapon_skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.skills.Skill;

public class SkillWeapon_AA_ReloadChance extends Skill {
	
	public int chance_stack;
	

	public SkillWeapon_AA_ReloadChance()
	{
		super();
		
		pos.x=-0;
		pos.y=50;
		
		spr.setTexture(Assets.load("icon_reload_chance"));
		spr.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

		
		name="�������� ���";
		info=	"��� ����������� ������ �� ��������� 10% ����"+"\n"+
				"������������ ������ ���������. ������ ������������."+"\n"+
				"������ ��� ������� ��� �������� ������������";
		
		need_to_indicate=true;
		//skill_a=new SkillShield_A_MoreValue();
		indicate_tex=Assets.load("icon_reload_chance");
		indicate_text="0%";
		
	}
	
	@Override
	public void weapon_start_reload_action(Entity _e, int _i)
	{
		chance_stack++;
		
		
		if (Math.random()<chance_stack/10.0f)
		{
			if (_e.armored[_i]!=null){_e.armored[_i].reload_timer=0.1f; chance_stack=0;}
			highlight_value=0.5f;
			
		}
		
		indicate_text=chance_stack*10+"%";
	}

	
	
	
}
