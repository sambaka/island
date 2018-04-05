package sambaka.ua.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import sambaka.ua.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=600;
		config.height=600;
		config.resizable=false;
		config.foregroundFPS=30;
		new LwjglApplication(new Main(), config);
	}
}
