package com.midfag.game.GUI.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.midfag.equip.energoshield.Energoshield;
import com.midfag.equip.energoshield.EnergoshieldFast;
import com.midfag.equip.energoshield.EnergoshieldMirror;
import com.midfag.equip.energoshield.EnergoshieldSimple;
import com.midfag.equip.energoshield.EnergoshieldStone;
import com.midfag.equip.module.ModuleUnit;
import com.midfag.equip.module.ModuleUnitPush;
import com.midfag.equip.module.ModuleUnitTimeSlow;
import com.midfag.equip.module.ModuleUnitTurret;
import com.midfag.equip.weapon.Weapon;
import com.midfag.equip.weapon.LegendaryWeaponBlender;
import com.midfag.equip.weapon.LegendaryWeaponChaos;
import com.midfag.equip.weapon.LegendaryWeaponPing;
import com.midfag.equip.weapon.WeaponSimpleFirle;
import com.midfag.equip.weapon.WeaponSimpleLaser;
import com.midfag.equip.weapon.WeaponSimpleMinigun;
import com.midfag.equip.weapon.WeaponSimpleShotgun;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.InputHandler;
import com.midfag.game.Assets;
import com.midfag.game.Enums.EquipGenerationType;
import com.midfag.game.Enums.Rarity;

public class ButtonChangeQuality extends Button {

	public Rarity rar;
	public Texture tex;
	
	public ButtonChangeQuality(float _x, float _y, Rarity _rar) {
		super(_x, _y);
		
		size_x=44;
		size_y=24;
		
		spr.setSize(44, 24);
		
		
		rar=_rar;
		if (!GScreen.show_equip){need_remove=true;}
		
		if (rar==Rarity.COMMON)	{tex=Assets.load("rarity_common"); 			description="Меняет редкость предметов на обычный.";}
		if (rar==Rarity.UNCOMMON)	{tex=Assets.load("rarity_uncommon");	description="Меняет редкость предметов на необычный.";}
		if (rar==Rarity.RARE)	{tex=Assets.load("rarity_rare");			description="Меняет редкость предметов на редкий.";}
		if (rar==Rarity.ELITE)	{tex=Assets.load("rarity_elite");			description="Меняет редкость предметов на элитный.";}
		if (rar==Rarity.LEGENDARY)	{tex=Assets.load("rarity_legendary");	description="Меняет редкость предметов на легендарный.";}
		if (rar==Rarity.ANOMALY)	{tex=Assets.load("rarity_anomaly");		description="Меняет редкость предметов на сверхестественный.";}
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void after_draw()
	{
		GScreen.batch_static.setColor(Color.WHITE);
		GScreen.batch_static.draw(tex, pos.x-20, pos.y-19);
	}
	
	public void some_update(float _d)
	{
		if ((is_overlap())&&(InputHandler.but==0))
		{
				InputHandler.but=-1;
					
					Helper.invenory_rarity=rar;

					for (int i=0; i<30; i++)//;
			        {
						
						if (GScreen.pl.inventory[i] instanceof Energoshield)
						{
							((Energoshield)GScreen.pl.inventory[i]).rarity=Helper.invenory_rarity;
							((Energoshield)GScreen.pl.inventory[i]).generate();
							((Energoshield)GScreen.pl.inventory[i]).update_attributes_bonus(GScreen.pl);
						}
						
						if (GScreen.pl.inventory[i] instanceof Weapon)
						{
							((Weapon)GScreen.pl.inventory[i]).rarity=Helper.invenory_rarity;
							((Weapon)GScreen.pl.inventory[i]).generate();
							((Weapon)GScreen.pl.inventory[i]).update_attributes_bonus(GScreen.pl);
						}
						
						if (GScreen.pl.inventory[i] instanceof ModuleUnit)
						{
							((ModuleUnit)GScreen.pl.inventory[i]).rarity=Helper.invenory_rarity;
							((ModuleUnit)GScreen.pl.inventory[i]).generate();
							((ModuleUnit)GScreen.pl.inventory[i]).update_attributes_bonus(GScreen.pl);
						}
			        }
					
					if (GScreen.pl.armored[0]!=null){GScreen.pl.armored[0].rarity=rar;}
					if (GScreen.pl.armored[1]!=null){GScreen.pl.armored[1].rarity=rar;}
					
					if (GScreen.pl.armored_shield!=null){GScreen.pl.armored_shield.rarity=rar;}
					
					if (GScreen.pl.armored_module[0]!=null){GScreen.pl.armored_module[0].rarity=rar;}
					if (GScreen.pl.armored_module[1]!=null){GScreen.pl.armored_module[1].rarity=rar;}
					if (GScreen.pl.armored_module[2]!=null){GScreen.pl.armored_module[2].rarity=rar;}
					if (GScreen.pl.armored_module[3]!=null){GScreen.pl.armored_module[3].rarity=rar;}
		}
			
		}
	}


