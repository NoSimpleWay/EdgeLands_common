package com.midfag.equip.energoshield;

import java.util.ArrayList;
import java.util.List;

import com.midfag.game.Localisation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midfag.entity.Entity;
import com.midfag.equip.energoshield.attr.ESAttribute;
import com.midfag.equip.energoshield.attr.ESAttributeReflect;
import com.midfag.equip.energoshield.attr.ESAttributeRegen;
import com.midfag.equip.energoshield.attr.ESAttributeValue;
import com.midfag.equip.weapon.attr.WeaponAttribute;
import com.midfag.game.GScreen;
import com.midfag.game.Assets;
import com.midfag.game.Enums.Rarity;


public class Energoshield {
	public String uid;
	public float base_value;
	public float base_regen_speed;
	public float base_reflect;
	
	public float total_value;
	public float total_regen_speed;
	public float total_reflect;
	
	//public float charge;
	public float value;
	public float warm;
	
	public int attr_count;
	
	public boolean gennable=true;
	
	//public Sprite spr=New;
	public Sprite spr=new Sprite(Assets.load("icon_shield"));
	
	public List<ESAttribute> Available_attribute_list = new ArrayList<ESAttribute>();
	
	//public List<WeaponAttribute> Attribute_list_heap = new ArrayList<WeaponAttribute>();
	
	public List<ESAttribute> Attribute_list = new ArrayList<ESAttribute>();
	public float attr_point;
	public float level=1.0f;
	public String name;
	
	public Rarity rarity;
	public float attr_point_indicate;
	
	
	public String red_text;
	
	
	
	public Energoshield()
	{

		//Available_attribute_list.add(new ESAttributeCharge());
		
		name="Simple shield";
		
		rarity=Rarity.COMMON;
		
		get_available_attribute();
	}
	
	public void update(float _d)
	{
		
	}
	
	public void get_available_attribute()
	{
		Available_attribute_list.clear();
		
		Available_attribute_list.add(new ESAttributeValue());
		Available_attribute_list.add(new ESAttributeRegen());
		Available_attribute_list.add(new ESAttributeReflect());
	}
	
	public void update_attributes_bonus()
	{
		
		
		
		total_value=base_value*level;
		total_regen_speed=base_regen_speed*level;
		total_reflect=base_reflect*level;

		
		for (int i=0; i<Attribute_list.size(); i++)
		{
			Attribute_list.get(i).calculate(this);
		}

		
		value=total_value;
		
		/*
		if (rarity==Rarity.COMMON){spr.setColor(Color.WHITE);}
		if (rarity==Rarity.UNCOMMON){spr.setColor(Color.GREEN);}
		if (rarity==Rarity.RARE){spr.setColor(Color.ROYAL);}
		if (rarity==Rarity.ELITE){spr.setColor(Color.MAGENTA);}
		if (rarity==Rarity.LEGENDARY){spr.setColor(Color.ORANGE);}
		if (rarity==Rarity.ANOMALY){spr.setColor(Color.CYAN);}*/
	}
	
	public void update_attributes_bonus(Entity _e)
	{
		update_attributes_bonus();
		
		for (int i=0; i<_e.Skills_list.size();i++)
		{
			if (_e.Skills_list.get(i).learned)
			{_e.Skills_list.get(i).shield_gen_action(this);}
		}
		
		value=total_value;
	}
	
	
	public void generate()
	{
		if (gennable)
		{
			get_available_attribute();
			
			Attribute_list.clear();
			
			//base_value*=level;
			
			int r=0;
			if (rarity.ordinal()==0)
			{
				for (int i=0; i<6; i++)
				{
					r=i;
					
					if (Math.random()>0.5f){break;}
				}
				
				if (r==0) {rarity=Rarity.COMMON;}
				if (r==1) {rarity=Rarity.UNCOMMON;}
				if (r==2) {rarity=Rarity.RARE;}
				if (r==3) {rarity=Rarity.ELITE;}
				if (r==4) {rarity=Rarity.LEGENDARY;}
				if (r==5) {rarity=Rarity.ANOMALY;}
			}
			
				
			attr_point=(float) (level*10f*(Math.pow(1.25f,rarity.ordinal())));
			attr_point_indicate = attr_point;
			
			attr_count=(int) (GScreen.rnd(3)+2);
			
			if (attr_count>Available_attribute_list.size())
			{attr_count=Available_attribute_list.size();}
			
			get_available_attribute();
			for (int i=0; i<attr_count; i++)
			if (!Available_attribute_list.isEmpty()) 
			{
				//select random attribute from list
				int random_selected=(int)(Math.random()*Available_attribute_list.size());
			
				//set attribute
				Attribute_list.add(Available_attribute_list.get(random_selected));
				
				//remove attribute
				Available_attribute_list.remove(random_selected);
			}
			
			float total_density=0;
			
			for (ESAttribute alist:Attribute_list )
			{
				alist.density=(int)(Math.random()*100+10)*alist.weigth;
				total_density+=alist.density;
			}
			
			for (ESAttribute alist:Attribute_list )
			{
				alist.level=alist.density/total_density*attr_point;
			}
		}
		//value=total_value;
	}
	
	public void damage_action(Entity _master, float _damage)
	{
		
	}

}
