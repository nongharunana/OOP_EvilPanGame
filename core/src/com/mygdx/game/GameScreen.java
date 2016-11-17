package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{
	 EvilPanGame evilPanGame;
	 
	 private Texture chopsticksImg;
	 private Chopsticks chopsticks;
	 public GameScreen(EvilPanGame evilPanGame) {
	        this.evilPanGame = evilPanGame;
	        chopsticksImg = new Texture("Chopsticks");
	        chopsticks = new Chopsticks(100, 100);
	      
	    }
	 @Override
	    public void render(float delta) {
	        update(delta);
		 	SpriteBatch batch =evilPanGame.batch;
		 	Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        batch.begin();
	        Vector2 position = chopsticks.getPosition();
	        batch.draw(chopsticksImg, position.x,position.y);
	        batch.end();
	    }
	  private void update(float delta) {
		    if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	            chopsticks.move(chopsticks.DIRECTION_LEFT); 
	        }
	        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	           chopsticks.move(chopsticks.DIRECTION_RIGHT);
	        }   
	    }
}
