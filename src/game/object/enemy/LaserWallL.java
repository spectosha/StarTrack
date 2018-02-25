package game.object.enemy;

import java.awt.Color;
import java.awt.Graphics2D;

import game.object.bonus.Accelerator;
import main.Panel;
import main.state.LevelSetings;

public class LaserWallL extends Enemy {

	private Component component;
	public int timeForLaser = 40;
	public float longer;
	public int laserX;
	public int laserYStart;
	public int laserYEnd;
	
	public int timeForEnd;
	
	public boolean letMove = true;

	public LaserWallL(LevelSetings ls,  int frame, int xStart, int timeForEnd) {
		super(ls,frame,xStart-8);
		this.xStart = xStart;
		this.timeForEnd = timeForEnd;
		common();
	}

	public void common() {
		y = -12;
		usualColor();
		health = 14;
		width = 27;
		height = 11;
		objectPixels = new int[][]{
			{0,4,4,4,4,4,4,4,0,4,4,0,4,4,4,0,0,0,0,0,4,0,4,0,0,0,0},
			{4,1,1,6,6,6,1,1,4,1,1,4,1,1,1,4,0,0,4,4,1,4,1,4,4,0,0},
			{4,1,6,2,2,2,6,6,6,6,1,1,5,1,4,0,0,4,1,1,1,4,1,1,1,4,0},
			{4,1,6,2,2,2,6,3,3,3,6,1,5,1,1,4,0,4,1,1,4,4,4,1,1,4,0},
			{4,1,1,6,6,6,1,1,1,1,6,1,1,1,1,4,4,1,1,4,2,2,2,4,1,1,4},
			{0,4,4,4,4,4,4,4,4,1,1,6,6,6,4,0,0,4,4,4,2,2,2,4,4,4,0},
			{4,1,1,1,1,1,1,1,1,4,1,1,6,1,1,4,4,1,1,4,2,2,2,4,1,1,4},
			{4,1,1,6,1,1,3,1,1,4,1,1,6,1,4,0,0,4,1,1,4,2,4,1,1,4,0},
			{4,1,1,6,1,1,3,1,1,4,6,6,1,1,1,4,0,4,1,1,1,2,1,1,1,4,0},
			{4,1,1,1,1,1,1,1,1,4,1,1,1,1,1,4,0,0,4,4,1,2,1,4,4,0,0},
			{0,4,4,4,4,4,4,4,4,0,4,4,4,4,4,0,0,0,0,0,4,0,4,0,0,0,0}
		};
		component = (Component) ls.enemyContainer.add(new Component(ls,0,xStart));
		component.speed = 0;
	}

	public void usualColor() {
		setColor(
				255,255,255,
				200,0,0,
				0,120,240,
				200,200,200,
				200,0,0,
				0,75,150);
		
	}
	
	public void setHealth(int value){
		super.setHealth(value);
		if(health<=0){
			ls.bonusContainer.add(new Accelerator(ls,0,(int)(xStart),Accelerator.M)).y = this.y;
			component.setHealth(-component.getHealth()+1);
			component.speed = 1;
		}
	}

	public void update(){
		super.update();
		frame--;
		if (frame > 0) {
			return;
		}
		if (timeForLaser < 0) {
			letMove = false;
			if (component.y < Panel.HEIGHT - 7) {
				component.y += 2f;
			}
			if (frame < -timeForEnd) {
				y+=speed;
			}
			laserX = (int) (x + 8);
			laserYStart = (int) (y + 5);
			laserYEnd = (int) (component.y - 2);
			if(laserYEnd-laserYStart<2){
				letMove = true;
			}
			
			//
			if (player.x - (player.width - 1) / 2 < laserX + 1 && player.x + (player.width - 1) / 2 > laserX - 1
					&& player.y - (player.height - 1) / 2 < laserYEnd
					&& player.y + (player.height - 1) / 2 > laserYStart && ls.getPlayer().getTouch()) {
				player.healthDec();
			}
		} else {
			if(y<8){
				y+=speed;
			}
			timeForLaser--;
			component.y = y + 9;
		}
		if(letMove){
			component.y = y+9;
		}
	}
	
	public void draw(Graphics2D g){
		super.draw(g);
		if(timeForLaser<0){
			g.setColor(new Color(200,50,50));
			g.drawLine(laserX, laserYStart, laserX, laserYEnd);
		}
	}
}
