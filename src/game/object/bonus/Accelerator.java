package game.object.bonus;

import java.awt.Color;
import java.awt.Graphics2D;


import main.state.LevelSetings;

public class Accelerator extends Bonus {

	private int force;
	
	public static int S = 1;
	public static int M = 3;
	public static int L = 5;
	public static int X = 8;
	
	public Accelerator(LevelSetings ls, int frame, int xStart,int force) {
		super(ls,frame,xStart);
		this.force = force;
		
		objectPixels = new int[][]{
			{0,0,1,0,0},
			{0,1,1,2,0},
			{1,1,1,2,3},
			{0,2,2,3,0},
			{0,0,3,0,0}
		};
		width = height = 5;
		if(force==S){
			color = new Color(0,100,60);
			setColor(
					200,200,200,
					150,150,150,
					100,100,100);
		}else if(force==M){
			color = new Color(0,100,60);
			setColor(
					0,200,200,
					0,150,150,
					0,100,100);
		}else if(force==L){
			color = new Color(0,150,60);
			setColor(
					0,180,0,
					0,130,0,
					0,110,0);
		}else if(force==X){
			color = new Color(0,255,0);
			setColor(
					255,150,0,
					200,100,0,
					150,50,0);
		}
	}

	@Override
	public void take() {
		player.incrementSpeedShooting(force);
	}

	@Override
	public void update() {
		super.update();
		if(frame-->0){
			return;
		}
		y+=speed;
	}

	@Override
	public void draw(Graphics2D g) {
		//if(frame<0){
		//	g.setColor(color);
			drawPixels(g);
		//}
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
