package com.midfag.game.GUI;

import java.util.ArrayList;
import java.util.List;

import com.midfag.game.GScreen;
import com.midfag.game.GUI.buttons.Button;

public class GUI {
	
	public List<Button> Button_list = new ArrayList<Button>();

	public GUI()
	{
		
	}
	
	public void update(float _d)
	{
		sub_update(_d);
		
		for (int i=0; i<Button_list.size(); i++)
		{
			Button_list.get(i).draw();
		}
	}

	public void sub_update(float _d) {
		
		
	}

	public void update2(float _d)
	{
		// TODO Auto-generated method stub
		for (int i=0; i<Button_list.size(); i++)
		{
			if (!Button_list.get(i).need_remove)
			{
				Button_list.get(i).update(_d);
				Button_list.get(i).second_update(_d);
				Button_list.get(i).second_draw();
				Button_list.get(i).text_pass(GScreen.batch_static);
			}
			else
			{Button_list.remove(i); i--;}
		}
	}
	
	public void remove_this()
	{
		GScreen.GUI_list.remove(this);
	}
}
