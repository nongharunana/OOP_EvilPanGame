package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.EvilPanGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = EvilPanGame.WIDTH ;
        config.height = EvilPanGame.HEIGHT;
        new LwjglApplication(new EvilPanGame(), config);
    }
}