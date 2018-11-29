package com.midfag.game.GUI.edit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.InputHandler;
import com.midfag.game.GUI.buttons.Button;

public class ButtonSaveMap extends Button {

	public int[][] tile_map;
	public int[][] tile_map_overlay;
	
	public Texture tex;
	
	public ButtonSaveMap(float _x, float _y)
	{
		super(_x,_y);
		pos.x=_x;
		pos.y=_y;
		
		tex=Assets.load("button_save_map");
	}
	
	@Override
	public void second_draw()
	{
		
	}
	
	@Override
	public void after_draw()
	{
		GScreen.batch_static.setColor(Color.WHITE);
		GScreen.batch_static.draw(tex, pos.x-22, pos.y-22);
	}
	
	//@SuppressWarnings("static-access")
	@Override
	public void some_update(float _d)
	{
		if (!GScreen.show_edit)
		{
			need_remove=true;
			//GScreen.Button_list.remove(this);
		}
		
		if ((InputHandler.but==0)&&(is_overlap()))
		{
			InputHandler.but=-1;
			
			System.out.println("SAVED");
			FileHandle file = Gdx.files.local("data/level_data/z.txt");
			
			System.out.println("LOCAL: "+Gdx.files.getLocalStoragePath());
			System.out.println("EXTERNAL: "+Gdx.files.getExternalStoragePath());
			
			String s="";
			    // if file doesnt exists, then create it
			
			for (int i=0; i<30; i++)
			for (int j=0; j<30; j++)
			{
				for (int k=0; k<GScreen.cluster[j][i].Entity_list.size(); k++)
				{	
					Entity e=GScreen.cluster[j][i].Entity_list.get(k);
					s+="###ENTITY"+"\r\n";
					s+=e.uid+"\r\n";
					
					s+="pos.x"+"\r\n";
					s+=Math.round(e.pos.x)+"\r\n";
					
					s+="pos.y"+"\r\n";
					s+=Math.round(e.pos.y)+"\r\n";
					
					if (!e.default_collision_size)
					{
					s+="collision_size_x"+"\r\n";
					s+=Math.round(e.collision_size_x)+"\r\n";
					
					s+="collision_size_y"+"\r\n";
					s+=Math.round(e.collision_size_y)+"\r\n";
					}
					
					if (!e.default_path_size)
					{
					s+="path_size_x"+"\r\n";
					s+=Math.round(e.path_x)+"\r\n";
					
					s+="path_size_y"+"\r\n";
					s+=Math.round(e.path_y)+"\r\n";
					}
					
					
					s+="y"+"\r\n";
					s+=Math.round(e.z)+"\r\n";
					
					s+="angle"+"\r\n";
					s+=Math.round(e.spr.getRotation())+"\r\n";
					
					if (!e.id_for_script.equals(""))
					{s+="script_id"+"\r\n";
					s+=e.id_for_script+"\r\n";}
					
					if (!e.interact_entry_point.equals(""))
					{s+="interact_entry_point"+"\r\n";
					s+=e.interact_entry_point+"\r\n";}
					
					if (e.light_source!=null)
					{
						s+="LightSource"+"\r\n";
						s+="LiR"+"\r\n";
						s+=""+e.light_source.R+"\r\n";
						
						s+="LiG"+"\r\n";
						s+=""+e.light_source.G+"\r\n";
						
						s+="LiB"+"\r\n";
						s+=""+e.light_source.B+"\r\n";
						
						s+="LiP"+"\r\n";
						s+=""+e.light_source.light_power+"\r\n";
						
						s+="LightReady"+"\r\n";
					}
					
					for (int f=0; f<2; f++){
					if (e.armored[f]!=null)
					{
							s+="ArmoredWeapon"+"\r\n"+f+"\r\n";
							//s+="weapon_uid"+"\r\n";
							s+=""+e.armored[f].uid+"\r\n";
							
							s+="weapon_rarity"+"\r\n";
							s+=""+e.armored[f].rarity.ordinal()+"\r\n";
							
							s+="weapon_level"+"\r\n";
							s+=""+e.armored[f].level+"\r\n";
							for (int attr=0; attr<e.armored[f].Attribute_list.size(); attr++)
							{
								s+="WeaponAttr"+"\r\n";
								s+=e.armored[f].Attribute_list.get(attr).uid+"\r\n";
								s+="weapon_attr_level"+"\r\n";//s+="WeaponAttrLevel"+"\r\n";
								s+=e.armored[f].Attribute_list.get(attr).level+"\r\n";
								s+="WeaponAttrReady"+"\r\n";
							}
							s+="WeaponReady"+"\r\n";
						}
					}
					
					for (int f=0; f<4; f++){
					if (e.armored_module[f]!=null)
					{
							s+="ArmoredModule"+"\r\n"+f+"\r\n";
							//s+="weapon_uid"+"\r\n";
							s+=""+e.armored_module[f].uid+"\r\n";
							
							s+="module_rarity"+"\r\n";
							s+=""+e.armored_module[f].rarity.ordinal()+"\r\n";
							
							s+="module_level"+"\r\n";
							s+=""+e.armored_module[f].level+"\r\n";
							for (int attr=0; attr<e.armored_module[f].Attribute_list.size(); attr++)
							{
								s+="ModuleAttr"+"\r\n";
								s+=e.armored_module[f].Attribute_list.get(attr).uid+"\r\n";
								s+="module_attr_level"+"\r\n";//s+="WeaponAttrLevel"+"\r\n";
								s+=e.armored_module[f].Attribute_list.get(attr).level+"\r\n";
								s+="ModuleAttrReady"+"\r\n";
							}
							s+="ModuleReady"+"\r\n";
						}
					}
					
					
					
					if (e.armored_shield!=null)
					{
							s+="ArmoredShield"+"\r\n";
							//s+="weapon_uid"+"\r\n";
							s+=""+e.armored_shield.uid+"\r\n";
							
							s+="shield_rarity"+"\r\n";
							s+=""+e.armored_shield.rarity.ordinal()+"\r\n";
							
							s+="shield_level"+"\r\n";
							s+=""+e.armored_shield.level+"\r\n";
							

							
							
							
							/*shrobo
							shield_rarity
							0
							module_level*/
							for (int attr=0; attr<e.armored_shield.Attribute_list.size(); attr++)
							{
								s+="ShieldAttr"+"\r\n";
								s+=e.armored_shield.Attribute_list.get(attr).uid+"\r\n";
								s+="shield_attr_level"+"\r\n";//s+="WeaponAttrLevel"+"\r\n";
								s+=e.armored_shield.Attribute_list.get(attr).level+"\r\n";
								s+="ShieldAttrReady"+"\r\n";
							}
							s+="ShieldReady"+"\r\n";
							
							s+="shield_value"+"\r\n";
							s+=""+e.armored_shield.value+"\r\n";
							
							s+="shield_total_value"+"\r\n";
							s+=""+e.armored_shield.total_value+"\r\n";
						
					}
					
					s+="PUT"+"\r\n";
					
					s+="\r\n";
					
					
				}
			}
			
			file.writeString(s, false);
			
			tile_map=GScreen.tile_map;
			tile_map_overlay=GScreen.tile_map_overlay;
			
			
			
			s="";
			String ss="";
		
			file = Gdx.files.local("data/level_data/z_tile.txt");
			for (int i=0; i<100; i++)
			{
				//System.out.println ("READY: "+i/3f+"% "+_d*1000);
				ss="";
				
				for (int j=0; j<100; j++)
				{
					if (tile_map[j][i]<0) {ss+="no";}
					else
					{
						//if (tile_map[j][i]<100){ss+="0";}
						if (tile_map[j][i]<10){ss+="0";}
						ss+=tile_map[j][i];
						
						//ss+="|";
					}
				}
				s+=ss;
				
				s+="\r\n";
			}
			file.writeString(s, false);
			
			s="";
			file = Gdx.files.local("data/level_data/z_tile_overlay.txt");
			for (int i=0; i<100; i++)
			{
				//System.out.println ("READY: "+i/3f+"% "+_d*1000);
				ss="";
				
				for (int j=0; j<100; j++)
				{
					if (tile_map_overlay[j][i]<0) {ss+="no";}
					else
					{
						//if (tile_map[j][i]<100){ss+="0";}
						if (tile_map_overlay[j][i]<10){ss+="0";}
						ss+=tile_map_overlay[j][i];
						
						//ss+="|";
					}
				}
				s+=ss;
				
				s+="\r\n";
			}
			file.writeString(s, false);
			
		
		}
		
	}
}
