package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{
	 EvilPanGame evilPanGame;
	 private Texture chopsticksImg;
	 World world;
	 WolrdRenderer worldRenderer;
	 private Texture bgImg;
	 private Texture pauseImg;
	 private Texture gameOverImg;
	private Sound scream_sound;
	 
	 public static int status_screen=0;
	 public static final int SCREEN_GAME = 0;
	 public static final int SCREEN_PAUSE = 2;
	 public static final int SCREEN_GAMEOVER = -1; 
	 public static final int SCREEN_GAMESTART = 1;
	 public GameScreen(EvilPanGame evilPanGame) {
	        this.evilPanGame = evilPanGame;
	        chopsticksImg = new Texture("Chopsticks");
	        bgImg = new Texture("bg");
	        world = new World(evilPanGame);
	        gameOverImg = new Texture("GameOver.png");
	        pauseImg = new Texture("Pause.png");
	        worldRenderer = new WolrdRenderer(evilPanGame, world);
	        scream_sound = Gdx.audio.newSound(Gdx.files.internal("scream.mp3"));
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
		 		batch.end();
		 	}	else if(status_screen == SCREEN_GAMEOVER){
		 		batch.begin();
		 		batch.draw(gameOverImg, 0, 0);
		 		batch.end();
		 	}/*else if(status_screen == SCREEN_GAMESTART){
		 		batch.begin();
		 		batch.draw(gameOverImg, 0, 0);
		 		batch.end();
		 	}*/
		 	
	    }
	  private void update(float delta) {
		  	world.update();
		    
	    }
	  private void updateGameScreen(){
		  if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			  status_screen = SCREEN_GAMESTART;
		  }  
		  if(status_screen == SCREEN_GAME){
			  if(Gdx.input.isKeyPressed(Keys.P)){
			  status_screen = SCREEN_PAUSE;
			  }
		  } 
		  if(status_screen == SCREEN_PAUSE){
				  if(Gdx.input.isKeyPressed(Keys.SPACE)){
					  status_screen = SCREEN_GAME;
					  }
		  }
		  if(world.getLife()<=0){
				  status_screen = SCREEN_GAMEOVER;
				  }
	  
		  
	  }
	  
}
