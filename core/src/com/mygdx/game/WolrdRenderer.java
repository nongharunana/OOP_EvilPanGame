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
	private BitmapFont font;
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
    }
	public void render(float delta) {
		Vector2 position = world.getChopsticks().getPosition();
        batch.begin(); 
        batch.draw(bgImg, 0, 0);
        batch.draw(chopsticksImg, position.x,position.y);
        font.draw(batch, "score : " + world.getScore(), 200, 60);
        batch.end();

	}
}
