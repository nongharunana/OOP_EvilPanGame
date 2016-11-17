package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

public class World {
	private Chopsticks chopsticks;
    private EvilPanGame evilPanGame;
    public Bomb[] bombs;
    public int score;
    private int life =3;
    private int timer=0;
    Human[] humans;
	public boolean spacePress;
	public boolean oldSpacePress;
    World(EvilPanGame evilPanGame) {
        this.evilPanGame = evilPanGame;
        score = 0;
        chopsticks = new Chopsticks(this);
        bombs = new Bomb[3];
        humans = new Human[10];
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
	
    public void reserveHuman(){
    	int position = findExist();
    	if(position >= 0){
    		humans[position] = new Human(chopsticks);
    	}
    }
    public void GenBomb(){
    	int position = emtryBomb();
    	if(position >= 0){
    		bombs[position] = new Bomb(chopsticks);
    	}
    }
    public int findExist(){
    	for(int i=0 ;i<humans.length;i++){
    		if(humans[i]==null)
    			return i;
    	}
    	return -1;
    }
    public int emtryBomb(){
    	for(int i=0 ;i<bombs.length;i++){
    		if(bombs[i]==null)
    			return i;
    	}
    	return -1;
    }
	public void update() {
		chopsticks.update();
		updateHuman();
		updateBomb();
		GenBomb();
		reserveHuman();
		if(checkDoubleSpace()){
		catchingHuman();
		}
		tochingBomb();
		deathhuman();
		updateDoubleSpace();
		oldSpacePress = spacePress;
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
		for(int i=0;i<humans.length;i++){
			if(humans[i]!=null){
				if(humans[i].getTime() > Human.DEATH){
					killHuman(i);
				}
			
			}
		}
		
	}
	public int getLife(){
		return life;
	}
	private void killHuman(int i) {
		humans[i] = null;
		score -= 10 ;
		life--;
	}
	private void catchingHuman() {
		for(int i=0;i<humans.length;i++){
			if(humans[i]!=null){
				if(humans[i].isCatch(/*chopsticks.getPosition()*/)){
					increaseScore(humans[i].getTime());
					deleteHuman(i);
				}
			}
		}
		
	}
	private void tochingBomb() {
		for(int i=0;i<bombs.length;i++){
			if(bombs[i]!=null){
				if(bombs[i].isCatch(/*chopsticks.getPosition()*/)){
					decreaseScore();
					life--;
					deleteBombs(i);
				}
			}
		}
		
	}
	private void deleteBombs(int i) {
		
		bombs[i]=null;
	}
	private void decreaseScore() {
		score-=10;
	}
	private void deleteHuman(int i) {
		humans[i]=null;
		
	}
	private void updateHuman() {
		
		for(int i=0 ; i<humans.length;i++){
			if(humans[i] != null){
				humans[i].update();
			}
		}
	}
private void updateBomb() {
		
		for(int i=0 ; i<bombs.length;i++){
			if(bombs[i] != null){
				bombs[i].update();
			}
		}
	}
private void deleteBomb() {
	for(int i=0;i<bombs.length;i++){
		if(bombs[i]!=null){
			if(bombs[i].getTimeOfBomb() > Bomb.bombMove){
				killHuman(i);
			}
		
		}
	}
	
}

}
