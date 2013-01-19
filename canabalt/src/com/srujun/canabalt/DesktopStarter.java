package com.srujun.canabalt;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopStarter {

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Canabalt";
		config.useGL20 = true;
		config.vSyncEnabled = true;
		config.width = 960;
		config.height = 640;

		new LwjglApplication(new Canabalt(), config);
	}

}
