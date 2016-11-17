package com.mygdx.game;

public class World {
	private Chopsticks chopsticks;
    private EvilPanGame evilPanGame;
 
    World(EvilPanGame evilPanGame) {
        this.evilPanGame = evilPanGame;
 
       chopsticks = new Chopsticks(100,100,this);
    }
    
    
 
    Chopsticks getChopsticks() {
        return chopsticks;
    }
}
