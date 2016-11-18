package com.mygdx.game;

import javax.swing.text.Position;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{
	 EvilPanGame evilPanGame;
	 World world;
	 WolrdRenderer worldRenderer;
	 private Texture chopsticksImg;
	 private Texture bgImg;
	 private Texture pauseImg;
	 private Texture gameOverImg;
	 private Texture startImg;
	 private BitmapFont font;
	 private BitmapFont font2;
	 public static int status_screen=1;
	 public static final int SCREEN_GAME = 0;
	 public static final int SCREEN_PAUSE = 2;
	 public static final int SCREEN_GAMEOVER = -1; 
	 public static final int SCREEN_GAMESTART = 1;
	 private static final float fontSize = 2;
	 public GameScreen(EvilPanGame evilPanGame) {
	        this.evilPanGame = evilPanGame;
	        startImg = new Texture("start.jpg");
	        chopsticksImg = new Texture("Chopsticks.png");
	        bgImg = new Texture("Bg.jpg");
	        world = new World(evilPanGame);
	        gameOverImg = new Texture("gameover.jpg");
	        pauseImg = new Texture("pause.jpg");
	        font = new BitmapFont();
	        font.getData().setScale(fontSize,fontSize);
	        font.setColor(1.0f,1.0f,1.0f,1.0f);
	        font2 = new BitmapFont();
	        font2.getData().setScale(fontSize-1,fontSize-1);
	        font2.setColor(1.0f,1.0f,1.0f,1.0f);
	        worldRenderer = new WolrdRenderer(evilPanGame, world);
	    }
	 @Override
	    public void render(float delta) {
		 	SpriteBatch batch = evilPanGame.batch;
		 	updateGameScreen();
		 	if(status_screen == SCREEN_GAME){
		 		update(delta);
		 		Gdx.gl.glClearColor(0, 0, 0, 1);
		 		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 		worldRenderer.render(delta);
	        }else if(status_screen == SCREEN_PAUSE){
		 		batch.begin();
		 		batch.draw(pauseImg, 0, 0);
		 		font2.draw(batch, "PRESS ENTER TO RESUME : " ,575,300);
		 		batch.end();
		 	}else if(status_screen == SCREEN_GAMEOVER){
		 		batch.begin();
		 		batch.draw(gameOverImg, 0, 0);
		 		worldRenderer.scoreBitmap.draw(batch, "Scores : " + world.getScore(),worldRenderer.scoresBitMap_positionX,worldRenderer.scoresBitMap_positionY);
		 		batch.end();
		 	}else if(status_screen == SCREEN_GAMESTART){
		 		batch.begin();
		 		batch.draw(startImg, 0, 0);
		 		font.draw(batch, "PRESS ENTER TO START : " ,475,300);
		 		batch.end();
		 	}
		 	
	    }
	  private void update(float delta) {
		  	world.update();
		    
	    }
	  private void updateGameScreen(){
		 
		  	if(world.getLife()<=0){
				  status_screen = SCREEN_GAMEOVER;
				  worldRenderer.scoresBitMap_positionX=575;
				  worldRenderer.scoresBitMap_positionY=300;
				  worldRenderer.fontSize=5;
			}else{
				 if(Gdx.input.isKeyPressed(Keys.ENTER)) {
					  status_screen = SCREEN_GAME;
				  }  
				  if(status_screen == SCREEN_GAME){
					  if(Gdx.input.isKeyPressed(Keys.P)){
					  status_screen = SCREEN_PAUSE;
					  }
				  } 
				  if(status_screen == SCREEN_PAUSE){
						  if(Gdx.input.isKeyPressed(Keys.ENTER)){
							  status_screen = SCREEN_GAME;
							  }
				  }
			}
	  
		  
	  }
	  
}
