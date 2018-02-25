package game.object.bonus;

import java.awt.Color;
import java.awt.Graphics2D;


import main.state.LevelSetings;

public class AutoShooting extends Bonus {

	public AutoShooting(LevelSetings ls, int frame, int xStart) {
		super(ls,frame,xStart);
		color = Color.RED;
		width=height=5;
		objectPixels = new int[][]{
			{0,0,1,0,0},
			{0,0,1,0,0},
			{0,1,1,1,0},
			{1,0,1,0,1},
			{1,0,0,0,1}};
	}

	@Override
	public void take() {
		player.incrementAutoShooting();
	}

	@Override
	public void update() {
		super.update();
		if(frame<0){
			y+=speed;
		}else{
			frame--;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		drawPixels(g);
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReliased(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void usualColor() {
		// TODO Auto-generated method stub
		
	}

}
