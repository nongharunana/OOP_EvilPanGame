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
	 World world;
	 WolrdRenderer worldRenderer;
	 private Texture bgImg;
	 public GameScreen(EvilPanGame evilPanGame) {
	        this.evilPanGame = evilPanGame;
	        chopsticksImg = new Texture("Chopsticks");
	        bgImg = new Texture("bg");
	        world = new World(evilPanGame);
	        worldRenderer = new WolrdRenderer(evilPanGame, world);
	      
	    }
	 @Override
	    public void render(float delta) {
		 	update(delta);
	        Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        worldRenderer.render(delta);
	    }
	  private void update(float delta) {
		    if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	            world.getChopsticks().move(world.getChopsticks().DIRECTION_LEFT); 
	        }
	        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	        	world.getChopsticks().move(world.getChopsticks().DIRECTION_RIGHT);
	        }   
	    }
}
