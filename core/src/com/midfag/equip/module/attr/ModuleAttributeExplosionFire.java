package com.midfag.equip.module.attr;

import java.util.List;

import com.midfag.entity.AnimationEffectExpl;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;

public class ModuleAttributeExplosionFire extends ModuleAttribute {


	//public
	
	public ModuleAttributeExplosionFire()
	{
		cost=1;
		
		max_level=100;
		uid="maexfi";
		name="����� �������";
	}
	
	@Override
	public void end_action(Entity _e, float _d)
	{
		Assets.expl.play();
		
		List<Entity> l=GScreen.get_entity_list(_e.pos);
		_e.Effect.add(new AnimationEffectExpl(_e.pos,0,0));
		
		for (int i=0; i<l.size(); i++)
		if (l.get(i).is_enemy!=_e.is_enemy)
		{
			l.get(i).burn_it(		2f*level/(1f+_e.pos.dst(l.get(i).pos)/100f)		);
		}
	}
	
	@Override
	public String get_descr()
	{
		return 	"��������� ��������� ����������� � �����"+1*level+" ��� ���������� �������� ������";
	}
	
	
}
