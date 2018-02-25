package main.state;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameStateManager {

	private ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int MENU = 0;
	public static final int HELP = 1;
	public static final int LEVEL_1 = 2;
	
	public int health;
	public final int healthMax = 30;
	public final int TMSF = 15;
	public int timeMiddleShout;
	public int timeMiddleShoutFinal;
	public int fineTimeMSF = 3;
	public int aim;
	public int skillProtector;
	public boolean skillAutoShooting;
	public boolean twoBullet;
	
	public GameStateManager(){
		gameStates = new ArrayList<GameState>();
		currentState = GameStateManager.MENU;
		gameStates.add(new Menu(this));
		gameStates.add(new Menu(this));
	}
	
	private void startOrReset(){
		timeMiddleShoutFinal = timeMiddleShout = TMSF;
		health = 300;
		aim = 2;
		skillProtector = 4;
		twoBullet = true;
		skillAutoShooting = true;
		gameStates.clear();
		gameStates.add(new Menu(this));
		gameStates.add(new Menu(this));
		gameStates.add(new Level_1(this));
		gameStates.add(new Level_2(this));
		gameStates.add(new Level_3(this));
		gameStates.add(new Level_4(this));
		gameStates.add(new Level_5(this));
		gameStates.add(new Level_6(this));
		gameStates.add(new Level_7(this));
	}
	public void setStates(int state){
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public int getCurrentState(){
		return currentState;
	}
	
	public void nextLevel(){
		if(health<=healthMax)health++;
		currentState++;
		gameStates.get(currentState).init();
	}
	
	public void newLevel(){
		startOrReset();
	}
	
	public void update(){
		gameStates.get(currentState).update();
	}
	
	public void draw(Graphics2D g){
		gameStates.get(currentState).draw(g);
	}
	
	public void keyPressed(int k){
		gameStates.get(currentState).keyPressed(k);
		if(k == KeyEvent.VK_1){startOrReset();setStates(2);
		}else if(k == KeyEvent.VK_2){startOrReset();setStates(3);
		}else if(k == KeyEvent.VK_3){startOrReset();setStates(4);
		}else if(k == KeyEvent.VK_4){startOrReset();setStates(5);
		}else if(k == KeyEvent.VK_5){startOrReset();setStates(6);
		}else if(k == KeyEvent.VK_6){startOrReset();setStates(7);
		}else if(k == KeyEvent.VK_7){startOrReset();setStates(8);
		}else if(k == KeyEvent.VK_8){startOrReset();setStates(9);
		}else if(k == KeyEvent.VK_9){startOrReset();setStates(10);
		}
	}
	public void keyReliased(int k){
		gameStates.get(currentState).keyReliased(k);
	}
}
