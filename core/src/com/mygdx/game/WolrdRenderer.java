package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WolrdRenderer {
	private Texture[] fireBg;
	private EvilPanGame evilPanGame;
	private World world;
	private Texture chopsticksImg;
	private SpriteBatch batch;
	private Texture bgImg;
	private Texture boyImg;
	private Texture burnBoyImg;
	private Texture bombImg;
	private BitmapFont font;
	private int countBg =0;
	public WolrdRenderer(EvilPanGame evilPanGame, World world) {
        this.evilPanGame = evilPanGame;
        batch = evilPanGame.batch;
        this.world = world;
        bgImg = new Texture("bg");
        boyImg = new Texture("boy");
        burnBoyImg = new Texture("boy3");
        chopsticksImg = new Texture("Chopsticks");
        bombImg = new Texture("Bomb");
        font = new BitmapFont();
        fireBg = new Texture[25];
        fireBg[0] = new Texture("fire1.png");
        fireBg[1] = new Texture("fire2.png");
        fireBg[2] = new Texture("fire3.png");
        fireBg[3] = new Texture("fire4.png");
        fireBg[4] = new Texture("fire5.png");
        fireBg[5] = new Texture("fire6.png");
        fireBg[6] = new Texture("fire7.png");
        fireBg[7] = new Texture("fire8.png");
        fireBg[8] = new Texture("fire9.png");
        fireBg[9] = new Texture("fire10.png");
        fireBg[10] = new Texture("fire11.png");
        fireBg[11] = new Texture("fire12.png");
        fireBg[12] = new Texture("fire13.png");
        fireBg[13] = new Texture("fire14.png");
        fireBg[14] = new Texture("fire15.png");
        fireBg[15] = new Texture("fire16.png");
        fireBg[16] = new Texture("fire17.png");
        fireBg[17] = new Texture("fire18.png");
        fireBg[18] = new Texture("fire19.png");
        fireBg[19] = new Texture("fire20.png");
        fireBg[20] = new Texture("fire21.png");
        fireBg[21] = new Texture("fire22.png");
        fireBg[22] = new Texture("fire23.png");
        fireBg[23] = new Texture("fire24.png");
        fireBg[24] = new Texture("fire25.png"); 
    }
	public void drawBg(){
		batch.draw(fireBg[countBg%fireBg.length],0,0); 
		batch.draw(fireBg[countBg%fireBg.length],fireBg[0].getWidth(),0); 
		batch.draw(fireBg[countBg%fireBg.length],fireBg[0].getWidth()*2,0); 
		countBg++;
		
		
	}
	public void render(float delta) {
		Vector2 position = world.getChopsticks().getPosition();
        batch.begin(); 
        drawBg();
        batch.draw(bgImg, 0, 0);
        batch.draw(chopsticksImg, position.x,position.y);
        for(int i=0;i<world.humans.length;i++){
        	if(world.humans[i]!=null){
        		batch.draw(world.humans[i].humanImg,world.humans[i].position.x, world.humans[i].position.y);
        	}
        }
        font.draw(batch, "score : " + world.getScore(), 100, 500);
        
        batch.end();

	}
}
