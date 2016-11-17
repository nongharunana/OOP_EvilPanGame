package com.mygdx.game;

import java.awt.TextArea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Human {
		public Vector2 position;
		private static final int SPEED = 3 ;
		public Texture humanImg;
		private World world; 
		private Texture deathImg;
		private Texture normalImg;
		private Texture burnImg;
		private int time=0;
	    private static final int BURN = 200;
	    static final int BURN2 = 400;
	    static final int DEATH = 600;
		public Human(){
			float y = EvilPanGame.HEIGHT-100;
			float x = (int)(Math.random()*1100)+100;
			position = new Vector2(x,y);
			deathImg = new Texture("boy3");
	        normalImg = new Texture("normal.png");
	        burnImg = new Texture ("burn.png");
			humanImg = normalImg;
		}
		public int getTime(){
			return time;
		}
		public void timer(){
	    	time++;
	    	updateImg();  		
	    }
		private void updateImg() {
			if (time<DEATH && time>=BURN2){
				humanImg = deathImg;
			}else if(time<BURN2 && time>BURN){
				humanImg = burnImg;
			}
		}
		public void update(){
			if(position.y>=100){
				position.y -= SPEED;
			}
			timer();
		}
		public boolean isCatch(Vector2 chopPosition){
			if(chopPosition.x>position.x && chopPosition.x < position.x+humanImg.getWidth() ){
				if(chopPosition.y>position.y && chopPosition.y < position.y+humanImg.getHeight() ){
					if(Gdx.input.isKeyPressed(Keys.SPACE)){
					return true;
					}
				}
			}
			return false;
		}
}
