package main.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import main.Panel;

public class Menu extends GameState{
	
	private int currentState = 0;
	private String[] currentChoise = {
			"Start",
			"Help",
			"Quit"};
	private Color tileColor;
	private Font tileFont;
	
	private Font font;
	
	private int redChangeColor;
	private boolean sideColor;
	
	public Menu(GameStateManager gsm){
		this.gsm = gsm;
		redChangeColor = 100;
		sideColor = true;
		tileColor =  new Color(255, 255, 255);
		tileFont = new Font(
				"Arial",
				Font.PLAIN,
				12);
		font = new Font(
				"Arial",
				Font.PLAIN,
				10);
	}

	public void init(){
		
	}

	public void update(){
		if(sideColor==true){
			redChangeColor+=30;
		}else{
			redChangeColor-=30;
		}
		if(redChangeColor>255){
			sideColor = false;
			redChangeColor = 255;
		}else if(redChangeColor<100){
			sideColor = true;
			redChangeColor = 100;
		}
	}

	public void draw(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
		g.setFont(tileFont);
		g.setColor(tileColor);
		g.drawString("Startrack", 25, 60);
		g.setFont(font);
		for(int i = 0; i<currentChoise.length;i++){
			if(i==currentState){
				g.setColor(new Color(redChangeColor,0,0));
			}else{
				g.setColor(tileColor);
			}
			g.drawString(currentChoise[i], 38, 100+i*10);
		}
		
	}

	void select(){
		if(currentState == 0){
			gsm.newLevel();
			gsm.setStates(GameStateManager.LEVEL_1);
		}else if(currentState == 1){
			//help
		}else if (currentState == 2){
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}else if(k == KeyEvent.VK_UP){
			if(currentState>0) currentState--;
			else currentState = 2;
		}else if (k == KeyEvent.VK_DOWN){
			if(currentState<2) currentState++;
			else currentState = 0;
		}
	}

	@Override
	public void keyReliased(int k) {
		
	}
}
