package com.midfag.game.GUI.edit;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;

import com.midfag.game.Assets;
import com.midfag.game.Cluster;
import com.midfag.game.Enums.TextInputMode;
import com.midfag.game.GScreen;
import com.midfag.game.Helper;
import com.midfag.game.InputHandler;
import com.midfag.game.Main;
import com.midfag.game.TextInput;
import com.midfag.game.GUI.GUI;
import com.midfag.game.GUI.buttons.Button;

public class GUIEdit extends GUI {
	
	public List<Button> Button_list = new ArrayList<Button>();
	public List<TilePattern> Pattern_list = new ArrayList<TilePattern>();
	//public GScreen G=Main.screen;
	public Entity indicate_entity=null;
	public static List<Entity> Object_list = new ArrayList<Entity>();
	
	public String id;
	public int tile=-1;
	
	public static Entity selected_object;
	public static Cluster selected_cluster;

	public boolean top_layer=false;
	
	public boolean entity_mode=false;
	public boolean tile_mode=false;
	public boolean pattern_mode=false;
	public boolean pattern_edit=false;
	
	public Vector2 pattern_first_point=new Vector2(-777,-777);
	public Vector2 temp_vector=new Vector2(0,0);
	public TilePattern indicate_pattern;
	public int id_offset;
	
	public TextInput listener;
	public boolean release_key_C=false;
	
	public int array_count=1;
	public float array_x;
	public float array_y;
	private ButtonSlider color_r_watcher;
	private ButtonSlider color_g_watcher;
	private ButtonSlider color_b_watcher;
	private ButtonSlider color_power_watcher;
	 
	public GUIEdit()
	{
		//indicate_entity=new Entity(new Vector2());
		//G=GScreen.get_this();
		
		for (int k=0; k<5; k++)
		{
			TilePattern tp=new TilePattern();
			
			tp.size_x=5;
			tp.size_y=5;
			for (int i=0; i<tp.size_x;i++)
			for (int j=0; j<tp.size_y;j++)	
			{
				tp.layer_main[j][i]=(int)(Math.random()*15);
				
				tp.layer_top[j][i]=-1;
			}
			Pattern_list.add(tp);
		}
	}
	
	//@Switcher
	
	
	public void clear_sliders()
	{
		GScreen.Button_list.remove(color_r_watcher);
		GScreen.Button_list.remove(color_g_watcher);
		GScreen.Button_list.remove(color_b_watcher);
		
		color_r_watcher=null;
		color_g_watcher=null;
		color_b_watcher=null;
		color_power_watcher=null;
	}
	
	@Override
	public void sub_update(float _d) 
	{
		
		if(!GScreen.show_edit){GScreen.GUI_list.remove(this);}
		
		int mod=3;
		
		if ((color_r_watcher!=null)&&(color_r_watcher.change)) {selected_object.light_source.R=color_r_watcher.value; GScreen.need_light_update=true; GScreen.need_pixmap_update=true; GScreen.need_static_light_update=true;}
		if ((color_g_watcher!=null)&&(color_g_watcher.change)) {selected_object.light_source.G=color_g_watcher.value; GScreen.need_light_update=true; GScreen.need_pixmap_update=true; GScreen.need_static_light_update=true;}
		if ((color_b_watcher!=null)&&(color_b_watcher.change)) {selected_object.light_source.B=color_b_watcher.value; GScreen.need_light_update=true; GScreen.need_pixmap_update=true; GScreen.need_static_light_update=true;}
		if ((color_power_watcher!=null)&&(color_power_watcher.change)) {selected_object.light_source.light_power=color_power_watcher.value; GScreen.need_light_update=true; GScreen.need_pixmap_update=true; GScreen.need_static_light_update=true;}
			
		
		
		//open property editor
		if ((Gdx.input.isKeyPressed(Keys.P)&&(InputHandler.key_release)&&(selected_object!=null)&&(selected_object.light_source!=null)))
		{
			InputHandler.key_release=false;
			
			//selected_object.standart_slider();
			color_r_watcher=new ButtonSlider(100,100,0f,1f,0.005f);
			color_g_watcher=new ButtonSlider(100,150,0f,1f,0.005f);
			color_b_watcher=new ButtonSlider(100,200,0f,1f,0.005f);
			color_power_watcher=new ButtonSlider(100,250,0f,10f,0.005f);
			
			color_r_watcher.col.set(1f,0.8f,0.8f,1f);
			color_g_watcher.col.set(0.8f,1.0f,0.8f,1f);
			color_b_watcher.col.set(0.8f,0.8f,1.0f,1f);
			color_power_watcher.col.set(1.0f,1.0f,1.0f,1f);
			
			color_r_watcher.value=selected_object.light_source.R;
			color_g_watcher.value=selected_object.light_source.G;
			color_b_watcher.value=selected_object.light_source.B;
			color_power_watcher.value=selected_object.light_source.light_power;
			
			GScreen.Button_list.add(color_r_watcher);
			GScreen.Button_list.add(color_g_watcher);
			GScreen.Button_list.add(color_b_watcher);
			GScreen.Button_list.add(color_power_watcher);
		}
		
		//delete action
		if (Gdx.input.isKeyPressed(112)&&(selected_object!=null)){selected_object.need_remove=true; selected_object=null; clear_sliders(); }
		
		//clone
		if ((Gdx.input.isKeyPressed(Keys.V))&&(selected_object!=null))
		{
			indicate_entity=Helper.get_object_from_id(selected_object.id);
			indicate_entity.z=selected_object.z;
			
			selected_object=null;
			clear_sliders();
		}
		
		//change alteration
		if ((selected_object!=null)&&(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)))
		{
			selected_object.z+=InputHandler.scroll_amount*5;
			//selected_object.move(0, -InputHandler.scroll_amount, 1);
			mod=1;
		}
		
		/*
			if (InputHandler.key==Keys.COMMA){e.spr.rotate(-15);InputHandler.key=-1;}	
			else
			if (InputHandler.key==Keys.PERIOD){e.spr.rotate(15);InputHandler.key=-1;}	
			*/
		
		
		if ((InputHandler.key_release)||(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)))
		{
			if (InputHandler.key==Keys.COMMA){top_layer=false; array_count--; if (array_count<1) {array_count=1;} InputHandler.key_release=false;}
			if (InputHandler.key==Keys.PERIOD){top_layer=true; array_count++; if (array_count>100) {array_count=100;} InputHandler.key_release=false;}
		}
		
		
		//name for script
		if ((InputHandler.key==Keys.X)&&(listener==null)&&(selected_object!=null))
		{
	    	listener = new TextInput(this,selected_object,TextInputMode.SCRIPT_ID);
	    	
	    	Gdx.input.getTextInput(listener, "������� ��� ��� ������", selected_object.id_for_script, "");
	    	
		}
		
		//entry point
		if ((InputHandler.key==Keys.E)&&(listener==null)&&(selected_object!=null))
		{
	    	listener = new TextInput(this,selected_object,TextInputMode.INTERACT_ENTRY);
	    	
	    	Gdx.input.getTextInput(listener, "����� ����� ��������������", selected_object.interact_entry_point, "");
	    	
		}
		
			
		float xx=(int)(InputHandler.posx/mod)*mod;
		float yy=(int)(InputHandler.posy/mod)*mod;
		

		
		GScreen.batch.begin();
			if (pattern_edit)
				{GScreen.batch.draw(Assets.point_start,(int)(InputHandler.posx/30)*30,(int)(InputHandler.posy/30)*30);}
			
			if (indicate_pattern!=null)
			{
				GScreen.batch.setColor(1, 1.0f, 1.0f, 0.5f);
				
				for (int i=0; i<indicate_pattern.size_y; i++)
				for (int j=0; j<indicate_pattern.size_x; j++)
				{
					if (indicate_pattern.layer_main[j][i]>=0)
					{	
						int ty=(int)indicate_pattern.layer_main[j][i]/8;
						int tx=indicate_pattern.layer_main[j][i]-ty*8;
					
					
						GScreen.batch.draw 
							(
							GScreen.tile_texture,
							(int)(InputHandler.posx/30f)*30f+j*30f-15f,
							(int)(InputHandler.posy/30f)*30f+i*30f-15f,
							60,
							60,
							(tx*60f+tx+1)*0.001953f,
							(ty*60f+ty+61)*0.001953f,
							(tx*60f+tx+61)*0.001953f,
							(ty*60f+ty+1)*0.001953f
							);;
					}
				}
				
				for (int i=0; i<indicate_pattern.size_y; i++)
				for (int j=0; j<indicate_pattern.size_x; j++)
					{
						if (indicate_pattern.layer_top[j][i]>=0)
						{	
							int ty=(int)indicate_pattern.layer_top[j][i]/8;
							int tx=indicate_pattern.layer_top[j][i]-ty*8;
						
						
							GScreen.batch.draw 
								(
								GScreen.tile_texture,
								(int)(InputHandler.posx/30f)*30f+j*30f-15f,
								(int)(InputHandler.posy/30f)*30f+i*30f-15f,
								60,
								60,
								(tx*60f+tx+1)*0.001953f,
								(ty*60f+ty+61)*0.001953f,
								(tx*60f+tx+61)*0.001953f,
								(ty*60f+ty+1)*0.001953f
								);;
						}
					}
				

				
				for (int i=0; i<indicate_pattern.elist.size(); i++)
				{
					indicate_pattern.elist.get(i).spr.setPosition
							(
								indicate_pattern.elist.get(i).pos.x+InputHandler.posx-indicate_pattern.elist.get(i).spr.getOriginX(),
								indicate_pattern.elist.get(i).pos.y+InputHandler.posy-indicate_pattern.elist.get(i).spr.getOriginY()
							);
					
					indicate_pattern.elist.get(i).spr.setColor(1, 1, 1, 0.5f);
					indicate_pattern.elist.get(i).draw_action(_d,1);
					indicate_pattern.elist.get(i).spr.setColor(1, 1, 1, 1.0f);

				}
				
				/*
				for (int i=0; i<indicate_pattern.size_y; i++)
				for (int j=0; j<indicate_pattern.size_x; j++)
				{
					if (indicate_pattern.layer_top[j][i]>=0)
					GScreen.batch.draw(GScreen.tile[indicate_pattern.layer_top[j][i]],(int)(InputHandler.posx/30)*30+j*30-15,(int)(InputHandler.posy/30)*30+i*30-15);
				}*/
				
				GScreen.batch.setColor(1, 1, 1, 1);
			}
			
			GScreen.batch.draw(Assets.point_start,(int)(pattern_first_point.x/30f)*30f,(int)(pattern_first_point.y/30.0f)*30f);
			
			//GScreen.batch.draw(Assets.point_start,(pattern_first_point.x+InputHandler.posx)/2f-15,(pattern_first_point.y+InputHandler.posy)/2f-15);
			if (pattern_first_point.x>0)
			{GScreen.batch.draw(Assets.rama,pattern_first_point.x,pattern_first_point.y,InputHandler.posx-pattern_first_point.x,InputHandler.posy-pattern_first_point.y);}
			
		GScreen.batch.end();
		
		boolean have_button_overlap=false;
		
		for (int i=0; i<GScreen.Button_list.size(); i++)
		{
			if (GScreen.Button_list.get(i).is_overlap()) {have_button_overlap=true;}
			
			if (have_button_overlap) { i=99999; break;}
		}
		
		
		
		if ((InputHandler.realy>7)&&(InputHandler.realy<GScreen.scr_h-7)&&(!have_button_overlap))
		{
			if (
					(InputHandler.but==0)
					&&
					(indicate_entity!=null)
					&&
					(!indicate_entity.id.equals(""))
				)
			{
			
				InputHandler.but=-1;
				
				//if (InputHandler.realx<800)
				for (int i=0; i<array_count; i++)
				{
					Entity en=Helper.get_object_from_id(indicate_entity.id);
					
					
					if (en!=null)
					{
						en.pos.x=xx+array_x*i;
						en.pos.y=yy+array_y*i;
						
						en.spr.setRotation(indicate_entity.spr.getRotation());
						//en.init("gui edit");
						GScreen.add_entity_to_map(en);
						
						en.z=indicate_entity.z;
						en.pos.y-=indicate_entity.z;
						en.fill_path();
					}
				}
			}
			
			if ((InputHandler.but==0)&&(pattern_edit))
			{
				if (pattern_first_point.x==-777)
				{
					pattern_first_point.x=(int)(InputHandler.posx);
					pattern_first_point.y=(int)(InputHandler.posy);
				}
				//if (1)
			}
			
			if ((InputHandler.but==0)&&(indicate_pattern!=null))
			{
				for (int i=0; i<indicate_pattern.size_y; i++)
				for (int j=0; j<indicate_pattern.size_x; j++)
				{
					GScreen.tile_map[(int)(InputHandler.posx/30)+j][(int)(InputHandler.posy/30)+i]=indicate_pattern.layer_main[j][i];
					GScreen.tile_map_overlay[(int)(InputHandler.posx/30)+j][(int)(InputHandler.posy/30)+i]=indicate_pattern.layer_top[j][i];
					
					
				}
				
				System.out.println("PUT_PATTERN");
				
				if (indicate_pattern.elist.size()>0)
				{
					InputHandler.but=-1;
					
					
					for (int i=0; i<indicate_pattern.elist.size(); i++)
					{
						Entity el=indicate_pattern.elist.get(i);
						Entity en=Helper.get_object_from_id(el.id);
						
						en.pos.x=el.pos.x+InputHandler.posx-el.spr.getOriginX()*0;
						en.pos.y=el.pos.y+InputHandler.posy-el.spr.getOriginY()*0;
						
						GScreen.add_entity_to_map(en);
					}
				}
			}
			
			if ((InputHandler.but!=0)&&(pattern_edit)&&(pattern_first_point.x>0))
			{
				int sx=(int)(pattern_first_point.x/30.0f);
				int sy=(int)(pattern_first_point.y/30.0f);
				
				int ex=(int)(InputHandler.posx/30f);
				int ey=(int)(InputHandler.posy/30f);
				
				int swap=0;
				
				if (sx>ex)
				{
					swap=sx;
					sx=ex;
					ex=swap;
				}
				
				if (sy>ey)
				{
					swap=sy;
					sy=ey;
					ey=swap;
				}
				
				for (int i=0; i<15;	i++)
				for (int j=0; j<15;	j++)
				{
					Pattern_list.get(0).layer_main[j][i]=-1;
					Pattern_list.get(0).layer_top[j][i]=-1;
				}
				
				for (int i=0; i<=ex-sx;	i++)
				for (int j=0; j<=ey-sy;	j++)
				{
					Pattern_list.get(0).layer_main[i][j]=GScreen.tile_map[sx+i][sy+j];
					Pattern_list.get(0).layer_top[i][j]=GScreen.tile_map_overlay[sx+i][sy+j];
					//GScreen.tile_map[sx+i][sy+j]=15;
				}
				
				List<Entity> l=GScreen.get_entity_list(temp_vector.set(InputHandler.posx, InputHandler.posy));
				
				Helper.log("ENTITY ON LIST="+l.size());
				
				Pattern_list.get(0).elist.clear();
				
				if (l.size()>0)
				{
					float cx=(pattern_first_point.x+InputHandler.posx)/2f;
					float cy=(pattern_first_point.y+InputHandler.posy)/2f;
					
					float dx=Math.abs(pattern_first_point.x-InputHandler.posx);
					float dy=Math.abs(pattern_first_point.y-InputHandler.posy);
					
					try {
						
						for (int i=0; i<l.size(); i++)
						{
							if (
									(Math.abs(l.get(i).pos.x-cx)<dx/2f)
									&&
									(Math.abs(l.get(i).pos.y-cy)<dy/2f)
								)
							{

								Entity enn=Helper.get_object_from_id(l.get(i).id);
								
								enn.pos.x=l.get(i).pos.x-pattern_first_point.x;
								enn.pos.y=l.get(i).pos.y-pattern_first_point.y;
								
								Pattern_list.get(0).elist.add(enn);
								Helper.log("ELIST ADDED ["+i+"]");
							}
						}
						
						
					} 
					 catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Pattern_list.get(0).size_x=ex-sx+1;
				Pattern_list.get(0).size_y=ey-sy+1;
				pattern_first_point.x=-777;
				pattern_edit=false;
			}
			
			//if (InputHandler.realx<850)
			{
				if (!top_layer) {Main.font.setColor(0.5f, 0.5f, 0.5f, 0.5f);}else{Main.font.setColor(0.25f, 1.0f, 0.5f, 1.0f);}
				Main.font.draw(GScreen.batch_static, "TOP LAYER: ", 170, 530);
			}
			
			if (
					(InputHandler.but==0)
					&&
					(tile>=0)
					
				)
				
				
				{
					//System.out.println("PUT TILE!");
					if (((int)(InputHandler.posx/30)>=0)&&((int)(InputHandler.posy/30)>=0)&&((int)(InputHandler.posx/30)<300)&&((int)(InputHandler.posy/30)<300))
					if (!top_layer)
					{GScreen.tile_map[(int)(InputHandler.posx/30)][(int)(InputHandler.posy/30)]=tile;}
					else
					{GScreen.tile_map_overlay[(int)(InputHandler.posx/30)][(int)(InputHandler.posy/30)]=tile;}
					
					
				}
			
				if ((InputHandler.key==112))
				{
					GScreen.tile_map_overlay[(int)(InputHandler.posx/30)][(int)(InputHandler.posy/30)]=-1;
				}
				


				
			if ((InputHandler.but==1))
			{
				if (selected_object!=null){selected_object.spr.setColor(Color.WHITE); selected_object.selected=false;}
				
				indicate_entity=null;
				
				int cx=(int)(xx/300f);
				int cy=(int)(yy/300f);
				
				GScreen.batch.begin();
					
					GScreen.batch.draw(Assets.mech_foot,xx,yy);
				GScreen.batch.end();
				
				float near_dist=9999;
				
				GScreen.temp_vectorA.x=xx;
				GScreen.temp_vectorA.y=yy;
				

				
				selected_object=null;
				selected_cluster=null;
				
				
				GScreen.batch.begin();
				for (int i=cx-1; i<=cx+1; i++)
				for (int j=cy-1; j<=cy+1; j++)
				if ((i>=0)&&(j>=0))
				{
					
					
						GScreen.batch.draw(Assets.mech_foot,cx*300+150,cy*300+150);
					
					if ((j<30)&&(j>=0)&&(i<30)&&(i>=0))
					for (int k=0; k<GScreen.cluster[i][j].Entity_list.size(); k++)
					{
						GScreen.temp_vectorA.y=yy-GScreen.cluster[i][j].Entity_list.get(k).z;
						if (GScreen.temp_vectorA.dst(GScreen.cluster[i][j].Entity_list.get(k).pos)<near_dist)
						{
							near_dist=GScreen.temp_vectorA.dst(GScreen.cluster[i][j].Entity_list.get(k).pos);
							
							selected_object=GScreen.cluster[i][j].Entity_list.get(k);
							clear_sliders();
							selected_cluster=GScreen.cluster[i][j];
						}
					}
				}
				GScreen.batch.end();
				
				if (selected_object!=null){selected_object.spr.setColor(Color.GREEN); selected_object.spr.setAlpha(0.5f); selected_object.selected=true;}
			}
		}
		
		if ((InputHandler.key==Keys.X)&&(selected_object!=null))
		{
			InputHandler.key=-1;
			
			selected_object.order++;
			if (selected_object.order>2){selected_object.order=0;}
			

			/*selected_cluster.Entity_list.remove(selected_object);
			selected_cluster.Entity_list.add(selected_object);*/
		}
		
		if ((InputHandler.key==Keys.C)&&(selected_object!=null))
		{
			release_key_C=true;
			
			//selected_object.hard_move(xx-selected_object.pos.x, yy-selected_object.pos.y, 1);
			selected_object.reposition(xx, yy);
			

			
			
			/*for (int k=0; k<150; k++)
			for (int i=0; i<300; i++)
			for (int j=0; j<300; j++)
			{
				GScreen.light_mask_B[j][i]=0;
			}*/
		}
		
		if ((InputHandler.key!=Keys.C)&&(release_key_C))
		{
			release_key_C=false;
			
			
			    	
		}
		
		if ((InputHandler.key_release)||(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)))
		{
			float am=1; if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {am=_d*60f;}
			
			if (InputHandler.key==Keys.SLASH){array_count=1; array_x=0; array_y=0; InputHandler.key_release=false;}
			
			if (InputHandler.key==Keys.UP){array_y+=am;		InputHandler.key_release=false;}
			if (InputHandler.key==Keys.DOWN){array_y-=am;	InputHandler.key_release=false;}
			if (InputHandler.key==Keys.LEFT){array_x-=am; 	InputHandler.key_release=false;}
			if (InputHandler.key==Keys.RIGHT){array_x+=am; 	InputHandler.key_release=false;}
		}
				
		if (indicate_entity!=null)
		{GScreen.batch.begin();
			for (int i=0; i<array_count; i++)
			{
				indicate_entity.spr.setPosition(xx-indicate_entity.spr.getOriginX()+array_x*i, yy-indicate_entity.spr.getOriginY()+array_y*i);
				//GScreen.batch.draw(edit_spr.getTexture(), edit_spr.getVertices(), 10, 20);
				//indicate_entity.spr.draw(GScreen.batch);
				indicate_entity.pos.set(xx+array_x*i,yy+array_y*i);
				indicate_entity.draw_action(_d);
			}
		GScreen.batch.end();}
		
	}
}
