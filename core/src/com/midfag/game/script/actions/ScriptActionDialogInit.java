package com.midfag.game.script.actions;

import com.midfag.game.GScreen;
import com.midfag.game.Localisation;
import com.midfag.game.GUI.ButtonDialogNext;
import com.midfag.game.GUI.GUIDialog;
import com.midfag.game.script.ScriptSystem;

public class ScriptActionDialogInit extends ScriptAction {
	

	public ScriptActionDialogInit() {
		// TODO Auto-generated constructor stub
//		name=_name;
		

	}
	
	@Override
	public void action()
	{
		//Helper.log("SCRIPT SAY <"+say+">");
		
		for (int i=0; i<GScreen.GUI_list.size(); i++)
		{
			if (GScreen.GUI_list.get(i) instanceof GUIDialog)
			{
				GScreen.GUI_list.remove(i);
				i--;
			}
		}
		
		ScriptSystem.last_dialog_gui=new GUIDialog();
		GScreen.GUI_list.add(ScriptSystem.last_dialog_gui);
		
		GScreen.main_control=false;
		GScreen.pl.active=false;
		
		GScreen.show_dialog=true;
		
		GScreen.Button_list.add(
								new ButtonDialogNext
									(
										500,
										17,
										ScriptSystem.last_dialog_gui,
										Localisation.get_value_from_id("button_next")
									)
								);
	}

}
