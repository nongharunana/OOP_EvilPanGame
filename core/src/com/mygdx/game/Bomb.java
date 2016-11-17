package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Bomb {
	public Vector2 position;
	private static final int SPEED = 3 ;
	public static final int bombMove=300;
	public Texture bombImg;
	private World world;
	public int timeOfBomb=0; 
	private Chopsticks chopsticks;
	public Bomb(Chopsticks chopsticks){
		this.chopsticks = chopsticks;
		float y = EvilPanGame.HEIGHT-100;
		float x = (int)(Math.random()*850)+200;
		position = new Vector2(x,y);
		bombImg = new Texture("bomb");
	}
	public void timer(){
    	
		timeOfBomb++;
    	
	}
	public int getTimeOfBomb(){
		return timeOfBomb;
	}
	public void update(){
		if(position.y >= chopsticks.position.y-20){
			position.y -= SPEED;
		}
		timer();
		
	}
	public boolean isCatch(/*Vector2 chopPosition*/){
		
		if(chopsticks.position.x>=position.x && chopsticks.position.x <= position.x+bombImg.getWidth() ){
			
			if(chopsticks.position.y>=position.y && chopsticks.position.y <= position.y+bombImg.getHeight() ){
					return true;
			}
		}
		
		return false;
	}
}
