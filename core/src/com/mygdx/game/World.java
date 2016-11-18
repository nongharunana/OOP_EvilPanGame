package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

public class World {
	public Human[] humans_leveln;
	private Chopsticks chopsticks;
    private EvilPanGame evilPanGame;
    public Bomb[] bombsleveln;
    public int score;
    public int life =3;
    public int level=1;
    public int timer=0;
    public int humans_size;
	public boolean spacePress;
	public boolean oldSpacePress;
    World(EvilPanGame evilPanGame) {
        this.evilPanGame = evilPanGame;
        score = 0;
        chopsticks = new Chopsticks(this);
        bombsleveln = new Bomb[2];       
        humans_leveln = new Human[100];
    }
    public void levelUp(){
    	level++;
    	timer+=50;
    }
    public int levelOfHuman(){
    	if(level<600){
    		return 3;
    	}else if(level<2500&&level >=600){
    		return 5;
    	}else {
    		return 10;
    	}
   }
    public void update() {
		chopsticks.update();
		levelOfHuman();
		updateHuman(levelOfHuman());
		updateBomb();
		GenBomb();
		reserveHuman();
		if(checkDoubleSpace()){
			catchingHuman();
		}
		tochingBomb();
		deathhuman();
		updateDoubleSpace();
		deleteBomb();
		oldSpacePress = spacePress;
		levelUp();
	}
    public void reserveHuman(){
    	int position = findExist(levelOfHuman());
    		if(position >= 0){
    			humans_leveln[position] = new Human(chopsticks);
    		}
    }
    public int getScore() {
    		if(score<0){
    			score=0;
    		}
        return score;
    }
	public void increaseScore(int time) {
        if(time < Human.BURN2){
        	score += 5;
        }else if(time < Human.DEATH && time >= Human.BURN2){
        	score += 3;
        }
    }
    Chopsticks getChopsticks() {
        return chopsticks;
    }
    public void GenBomb(){
    		int position = emtryBomb();
    		if(position >= 0){
    			bombsleveln[position] = new Bomb(chopsticks);
    		}
    }
    public int findExist(int n){
    	for(int i=0 ;i<n;i++){
    		if(humans_leveln[i]==null){
    			return i;
    		}
    }
    	return -1;
    }
    public int emtryBomb(){
    	for(int i=0 ;i<bombsleveln.length;i++){
    		if(bombsleveln[i]==null){
    			return i;
    		}
    	}
    	return -1;
    }
	private boolean checkDoubleSpace() {
		if(oldSpacePress == true && spacePress == true){
			return false;
		}
		return true;
	}
	private void updateDoubleSpace() {
		if(Gdx.input.isKeyPressed(Keys.SPACE)){
			spacePress = true;
		}
		else{
			spacePress = false;
		}
		oldSpacePress = spacePress;
	}
	private void deathhuman() {
		for(int i=0;i<humans_leveln.length;i++){
			if(humans_leveln[i]!=null){
				if(humans_leveln[i].getTime() >= Human.DEATH){
					life--;
					killHuman(i);
					decreaseScore();
				}
			}
		}
	}
	public int getLife(){
		return life;
	}
	private void killHuman(int i) {
		humans_leveln[i] = null;
		score -= 10 ;
		life--;
	}
	private void catchingHuman() {
		for(int i=0;i<humans_leveln.length;i++){
			if(humans_leveln[i]!=null){
				if(humans_leveln[i].isCatch()){
					increaseScore(humans_leveln[i].getTime());
					deleteHuman(i);
				}
			}
		}
	}
	private void tochingBomb() {
		for(int i=0;i<bombsleveln.length;i++){
			if(bombsleveln[i]!=null){
				if(bombsleveln[i].isCatch()){
					decreaseScore();
					life--;
					deleteBombs(i);
				}
			}
		}
	}
	private void deleteBombs(int i) {
		bombsleveln[i]=null;
	}
	private void decreaseScore() {
		score-=10;
	}
	private void deleteHuman(int i) {
		humans_leveln[i]=null;
	}
	private void updateHuman(int n) {
		for(int i=0 ; i<n;i++){
			if(humans_leveln[i] != null){
				humans_leveln[i].update();
			}
		}
	}
	private void updateBomb() {
		for(int i=0 ; i<bombsleveln.length;i++){
			if(bombsleveln[i] != null){
				bombsleveln[i].update();
			}
		}
	}
	private void deleteBomb() {
		for(int i=0;i<bombsleveln.length;i++){
			if(bombsleveln[i]!=null){
				if(bombsleveln[i].getTimeOfBomb() >= Bomb.bombMove){
					deleteBombs(i);
				}
			}
		}
	}
}
