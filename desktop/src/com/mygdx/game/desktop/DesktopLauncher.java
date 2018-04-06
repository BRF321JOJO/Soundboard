package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {

		//Controls if a borderless window
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//If window is resizable or not
		config.resizable=true;
		//Sets values the window's values for width and height
		config.height = MyGdxGame.V_HEIGHT;
		config.width = MyGdxGame.V_WIDTH;
		//FPS setting
		config.foregroundFPS=60;
		//VSync stuffs
		config.vSyncEnabled=true;

		//Names the window it runs it
		config.title = "Soundboard";
		//Makes the window image icon desired image
		//config.addIcon("pixelcat.jpg", Files.FileType.Internal);

		new LwjglApplication(new MyGdxGame(),config);

	}
}
