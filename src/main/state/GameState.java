package main.state;

import java.awt.Graphics2D;

public abstract class GameState {

	public GameStateManager gsm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void keyReliased(int k);
}
