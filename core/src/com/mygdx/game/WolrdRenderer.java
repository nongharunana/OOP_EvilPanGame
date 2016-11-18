package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WolrdRenderer {
	private EvilPanGame evilPanGame;
	private World world;
	private Texture chopsticksImg;
	private SpriteBatch batch;
	private Texture bgImg;
	private Texture boyImg;
	private Texture burnBoyImg;
	private Texture bombImg;
	public BitmapFont scoreBitmap;
	public int fontSize=2;
	private int countBg =0;
	public BitmapFont font;
	public int scoresBitMap_positionX=590;
	public int scoresBitMap_positionY=550;
	public WolrdRenderer(EvilPanGame evilPanGame, World world) {
        this.evilPanGame = evilPanGame;
        batch = evilPanGame.batch;
        this.world = world;
        bgImg = new Texture("Bg.jpg");
        boyImg = new Texture("normal.png");
        burnBoyImg = new Texture("burn.png");
        chopsticksImg = new Texture("Chopsticks.png");
        bombImg = new Texture("bomb.png");
        scoreBitmap = new BitmapFont();
        font = new BitmapFont();
        scoreBitmap.getData().setScale(fontSize,fontSize);
        scoreBitmap.setColor(1.0f,1.0f,1.0f,1.0f);
	}
	public void render(float delta) {
		Vector2 position = world.getChopsticks().getPosition();
        batch.begin(); 
        batch.draw(bgImg, 0, 0);
        batch.draw(chopsticksImg, position.x,position.y);
        for(int i=0;i<world.humans_leveln.length;i++){
        	if(world.humans_leveln[i]!=null){
        		batch.draw(world.humans_leveln[i].humanImg,world.humans_leveln[i].position.x, world.humans_leveln[i].position.y);
        	}
        }
        for(int i=0;i<world.bombsleveln.length;i++){
        	if(world.bombsleveln[i]!=null){
        		batch.draw(world.bombsleveln[i].bombImg,world.bombsleveln[i].position.x, world.bombsleveln[i].position.y);
        	}
        }
        if(GameScreen.status_screen != GameScreen.SCREEN_GAMEOVER){
        	scoreBitmap.draw(batch, "scores : " + world.getScore(),scoresBitMap_positionX,scoresBitMap_positionY);
        	font.draw(batch, "Life : " + world.life,1200,50);
        }
        batch.end();
	}
}
