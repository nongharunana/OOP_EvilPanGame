package com.mygdx.game;

public class World {
	private Chopsticks chopsticks;
    private EvilPanGame evilPanGame;
    private int score;
    World(EvilPanGame evilPanGame) {
        this.evilPanGame = evilPanGame;
        score = 0;
        chopsticks = new Chopsticks(100,100,this);
    }
    public int getScore() {
        return score;
    }
    
    public void increaseScore() {
        score += 5;
    }
 
    Chopsticks getChopsticks() {
        return chopsticks;
    }
}
