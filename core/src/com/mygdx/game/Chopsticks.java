package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Chopsticks {
	private Vector2 position;
	private World world;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0; 
    public static final int SPEED = 10;
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    public Chopsticks(int x, int y,World world) {
    	this.world = world;
        position = new Vector2(x,y);
    }    
    
    
    public Vector2 getPosition() {
        return position;    
    }
    public void move(int dir) { 
        position.x += SPEED * DIR_OFFSETS[dir][0];
    }


	public void update() {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            world.getChopsticks().move(Chopsticks.DIRECTION_LEFT); 
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	world.getChopsticks().move(Chopsticks.DIRECTION_RIGHT);
        }   
		
	}
}
