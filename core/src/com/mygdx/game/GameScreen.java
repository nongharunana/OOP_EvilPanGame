package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	 EvilPanGame evilPanGame;
	 private int x;
	 private int y;
	 private Texture chopsticksImg;
	 public GameScreen(EvilPanGame evilPanGame) {
	        this.evilPanGame = evilPanGame;
	        chopsticksImg = new Texture("Chopsticks");
	        x = 100;
	        y = 100;
	    }
	 @Override
	    public void render(float delta) {
	        update(delta);
		 	SpriteBatch batch =evilPanGame.batch;
		 	Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        batch.begin();
	        batch.draw(chopsticksImg, x, y);
	        batch.end();
	    }
	  private void update(float delta) {
		  if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	            x -= 10;
	        }
	        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	            x += 10;
	        }   
	    }
}
