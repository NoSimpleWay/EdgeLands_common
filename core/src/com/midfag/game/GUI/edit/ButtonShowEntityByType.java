package com.midfag.game.GUI.edit;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.Enums.EntityType;
import com.midfag.game.GScreen;
import com.midfag.game.InputHandler;
import com.midfag.game.SysConfig;
import com.midfag.game.GUI.GUI;
import com.midfag.game.GUI.buttons.Button;

public class ButtonShowEntityByType extends Button {

	public int[][] tile_map;
	public int[][] tile_map_overlay;
	
	public EntityType type;
	
	public Texture tex;
	public GUI gui;
	public List<Entity> e;
	
	public ButtonShowEntityByType(float _x, float _y, EntityType _et, GUI _gui, List<Entity> _e)
	{
		super(_x,_y);
		pos.x=_x;
		pos.y=_y;
		type=_et;
		gui=_gui;
		e=_e;
		
		size_x=54; size_y=54;
		spr.setSize(54, 54);
		
		
		
		if (type==EntityType.ENTITY) {tex=Assets.load("button_entity_type_enemy");}
		if (type==EntityType.BUILDING) {tex=Assets.load("button_entity_type_building");}
		if (type==EntityType.INDUSTRIAL) {tex=Assets.load("button_entity_type_industrial");}
		if (type==EntityType.VEHICLE) {tex=Assets.load("button_entity_type_vehicle");}
		if (type==EntityType.WALL) {tex=Assets.load("button_entity_type_wall");}
		if (type==EntityType.DECORATION) {tex=Assets.load("button_entity_type_decor");}
		if (type==EntityType.PLANTS) {tex=Assets.load("button_entity_type_plants");}
		if (type==EntityType.SYSTEM) {tex=Assets.load("button_entity_type_system");}
	}
	
	@Override
	public void second_draw()
	{
		
	}
	
	@Override
	public void after_draw()
	{
		GScreen.batch_static.setColor(Color.WHITE);
		GScreen.batch_static.draw(tex, pos.x-24, pos.y-24);
	}
	
	//@SuppressWarnings("static-access")
	@Override
	public void some_update(float _d)
	{
		if ((!GScreen.show_edit)||(!((GUIEdit)gui).entity_mode))
		{
			need_remove=true;
			//GScreen.Button_list.remove(this);
		}
		
		if ((InputHandler.but==0)&&(is_overlap()))
		{
			InputHandler.but=-1;
			

				e.clear();
				
				for (int i=0; i<SysConfig.EntityRegisterer.size(); i++)
				{
					if (SysConfig.EntityRegisterer.get(i).type==type)
					{
						e.add(SysConfig.EntityRegisterer.get(i));
					}
				}
			
			//System.out.println("SAVED");
			
		}
		
	}
}
