package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	 EvilPanGame evilPanGame;
	 private Texture chopsticksImg;
	 public GameScreen(EvilPanGame evilPanGame) {
	        this.evilPanGame = evilPanGame;
	        chopsticksImg = new Texture("Chopsticks");
	    }
	 @Override
	    public void render(float delta) {
	        SpriteBatch batch =evilPanGame.batch;
	        batch.begin();
	        batch.draw(chopsticksImg, 100, 100);
	        batch.end();
	    }
}
