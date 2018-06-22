package com.midfag.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.midfag.game.Main;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width=1000;
		config.height=700;
		config.samples=4;
		
		new LwjglApplication(new Main(true), config);
	}
}
