package game.object.bonus;

import game.object.GameObject;

import main.Panel;
import main.state.LevelSetings;

public abstract class Bonus extends GameObject {
	
	public String name = "Name";
	
	public Bonus(LevelSetings ls, int frame, int xStart) {
		this.ls = ls;
		this.player = ls.getPlayer();
		this.frame = frame;
		this.xStart = xStart;
		x = xStart+(Panel.WIDTH+1)/2;
		y = yStart;
	}
	
	public void update(){
		super.update();
	}
	
	public abstract void take();
}
