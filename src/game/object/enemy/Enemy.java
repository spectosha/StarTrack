package game.object.enemy;

import java.awt.Color;
import java.awt.Graphics2D;

import game.object.GameObject;
import main.Panel;
import main.state.LevelSetings;

public abstract class Enemy extends GameObject {
		
	public int Xlicense = (Panel.WIDTH-1)/2;

	//public Enemy[] protection = new Enemy[0];
	
	public abstract void common();
	
	public Enemy(LevelSetings ls, int frame){
		this.ls = ls;
		this.player = ls.getPlayer();
		this.frame = frame;
		health = 1;
		x = (float) (Math.random()*(Panel.WIDTH-5)+2);
		y=yStart;
	}
	
	public Enemy(LevelSetings ls, int frame, int xStart){
		this.ls = ls;
		this.player = ls.getPlayer();
		this.xStart = xStart;
		this.frame = frame;
		health = 1;
		if(xStart>Xlicense) xStart=Xlicense;
		if(xStart<-Xlicense) xStart=-Xlicense;
		x = xStart+Xlicense+1;
		y=yStart;
	}
	
	

	@Override
	public void update(){
		super.update();
	}
	
	public void shout(){
		ls.addBullet(this,(int)(x),(int)y);
	}
	
	public void shout(int offset){
		ls.addBullet(this,(int)(x+offset),(int)y);
	}
	
	public void shout(int offset,int ySet, Color newColor,int speed){
		ls.addBullet(this,(int)(x+offset),(int)y+ySet);
		ls.bulletContainer.get(ls.bulletContainer.size()-1).color = newColor;
		ls.bulletContainer.get(ls.bulletContainer.size()-1).setSpeed(speed);
	}
	
	@Override
	public void draw(Graphics2D g) {
		drawPixels(g);
	}

	@Override
	public void keyPressed(int k) {
	
	}

	@Override
	public void keyReliased(int k) {

	}
}
