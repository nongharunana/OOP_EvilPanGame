package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

public class World {
	private Chopsticks chopsticks;
    private EvilPanGame evilPanGame;
    private int score;
    private int life =3;
    Human[] humans;
	
    World(EvilPanGame evilPanGame) {
        this.evilPanGame = evilPanGame;
        score = 0;
        chopsticks = new Chopsticks(100,100,this);
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
    		humans[position] = new Human();
    	}
    }
    public int findExist(){
    	for(int i=0 ;i<humans.length;i++){
    		if(humans[i]==null)
    			return i;
    	}
    	return -1;
    }
	public void update() {
		chopsticks.update();
		updateHuman();
		reserveHuman();
		catchingHuman();
		deathhuman();
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
				if(humans[i].isCatch(chopsticks.getPosition())){
					increaseScore(humans[i].getTime());
					deleteHuman(i);
				}
			}
		}
		
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

}
