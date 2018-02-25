package game.object.enemy;

import java.awt.Color;
import java.awt.Graphics2D;

import game.object.bonus.Accelerator;
import game.object.bonus.SkillProtector;
import main.Panel;
import main.state.LevelSetings;

public class BossOne extends Boss {

	private int shoutTimer = 30;

	private int s2t = 50, s2tMax = s2t;
	private int shortS2 = 18, shortS2Max = shortS2;

	private int newX = 48;
	private int newY = 80;
	
	public BossOne(LevelSetings ls, int frame) {
		super(ls, frame);
		common();
		vector[0] = 0.5f;
	}

	@Override
	public void common() {
		health = maxHealth = 40;
		x = 51;
		y = -10;
		width = 41;
		height = 19;
		usualColor();
		objectPixels = new int[][] {
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6, 0, 0, 0, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 3, 3, 6, 6, 6, 3, 3, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 3, 3, 3, 3, 3, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 3, 1, 3, 1, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 2, 1, 1, 1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 4, 4, 4, 0, 0, 0 },
				{ 0, 0, 4, 5, 2, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 2, 5, 1, 5, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						4, 5, 2, 2, 4, 0, 0 },
				{ 0, 0, 4, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 2, 5, 1, 5, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						4, 1, 1, 1, 4, 0, 0 },
				{ 0, 0, 4, 5, 2, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 2, 1, 1, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						4, 5, 2, 2, 4, 0, 0 },
				{ 0, 0, 4, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 1, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						4, 1, 1, 1, 4, 0, 0 },
				{ 0, 0, 4, 5, 2, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 1, 1, 1, 1, 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						4, 5, 2, 2, 4, 0, 0 },
				{ 0, 0, 4, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 1, 1, 1, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0,
						4, 1, 1, 1, 4, 0, 0 },
				{ 0, 6, 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 4, 4, 1, 1, 1, 1, 1, 1, 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 6,
						6, 6, 6, 6, 6, 6, 0 },
				{ 6, 6, 3, 3, 3, 3, 3, 6, 6, 0, 0, 0, 0, 0, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 6, 6,
						3, 3, 3, 3, 3, 6, 6 },
				{ 6, 3, 5, 5, 5, 5, 5, 3, 6, 4, 0, 0, 0, 0, 4, 4, 1, 5, 5, 5, 5, 5, 5, 5, 1, 4, 4, 0, 0, 0, 0, 4, 6, 3,
						5, 5, 5, 5, 5, 3, 6 },
				{ 6, 5, 5, 5, 5, 5, 5, 5, 6, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 6, 5,
						5, 5, 5, 5, 5, 5, 6 },
				{ 6, 5, 2, 2, 2, 2, 2, 5, 6, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 2, 2, 2, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 6, 5,
						2, 2, 2, 2, 2, 5, 6 },
				{ 6, 3, 2, 2, 2, 2, 2, 3, 6, 1, 1, 1, 1, 1, 1, 1, 5, 2, 2, 2, 2, 2, 2, 2, 5, 1, 1, 1, 1, 1, 1, 1, 6, 3,
						2, 2, 2, 2, 2, 3, 6 },
				{ 0, 6, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 3,
						3, 3, 3, 3, 3, 6, 0 },
				{ 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 3, 0, 0, 0, 0, 0 } };
	}

	public void usualColor() {
		setColor(255, 255, 255,
				40, 40, 180, 
				150, 0, 0, 
				200, 200, 200,
				20, 20, 140, 
				110, 0, 0);
	}

	@Override
	public void update() {
		super.update();
		if (frame > 0) {
			frame--;
			return;
		}
		bossHere = true;
		comeIn();
		if (bossAttac) {
			if (firstAttac) {
				firstAttac();
			} else {
				secondAttac();
			}

			x += vector[0];
			y += vector[1];

		}
	}

	@Override
	public void firstAttac() {
		if (x > 85) {
			vector[0] = -0.5f;
		} else if (x < 15) {
			vector[0] = 0.5f;
		}
		if (timeShout <= 0) {
			shout(14, 3, Color.MAGENTA, 0);
			shout(-14, 3, Color.MAGENTA, 0);
			shout(0, 8, Color.MAGENTA, 0);
			timeShout = shoutTimer;
		}
		timeShout--;

		if (s2t <= 0) {
			if (shortS2 == shortS2Max * 2 / 3) {
				shout((int) (vector[0] * 28), 12, Color.YELLOW, 1);
			} else if (shortS2 == shortS2Max / 3) {
				shout((int) (vector[0] * 28), 12, Color.YELLOW, 1);
			} else if (shortS2 == 0) {
				shout((int) (vector[0] * 28), 12, Color.YELLOW, 1);
				shortS2 = shortS2Max;
				s2t = s2tMax;
			}
			shortS2--;
		}
		s2t--;

		int mH = maxHealth / 2;

		if (health < mH) {
			//
			//Взрыв вставить сюда.
			//
			shoutTimer = timeShout = 5;
			firstAttac = false;
			color5 = new Color(150, 150, 0);
			color2 = new Color(220, 220, 0);
			waitAttac = waitAttacMax;
		}
	}

	@Override
	public void secondAttac() {
		if(laserTag&&laserToucs()&&ls.getPlayer().getTouch()){
			player.healthDec();
		}
		if(goToPosition(newX,newY)){
			if(waitAttac>0){
				waitAttac--;
				return;
			}
			if(laserTime>0){
				//Стреляй из лазера
				laserTag = true;
				laserTime--;
				laserX =  15;
				laserY = 10;
				if(laserTime<=0){
					newX = (int)(Math.random()*60)+20;
					newY = (int)(Math.random()*50)+70;
					laserTag = false;
				}
				
				if(laserTime<laserTimeMax*9/10&&laserX<laserXEnd){
					//Сведкние лазера
					int strong;
					if(health<5)strong = 4;
					else if(health<10)strong = 3;
					else if(health<16)strong = 2;
					else strong = 1;
					laserXEnd -= strong;
					if(laserX>=laserXEnd){
						//Лазер сведен. Один момент
						laserXEnd = laserX;
						newX = (int)(Math.random()*60)+20;
						newY = (int)(Math.random()*50)+70;
					}
				}else{
					//Запускает корабль когда лазеры сведены
					if(puskTitan>0){
						puskTitan--;
					}else{
						int f = (int)(Math.random()*16-8);
						puskTitan = puskTitanMax;
						ls.enemyContainer.add(new Titan(ls,0,((int)x-(Panel.WIDTH+1)/2)+f)).y = this.y+10;
					}
				}				
			}else{
				if(laserTimeWait>0){
					laserTimeWait--;
					laserTag=false;
					if (timeShout <= 0) {
						shout(14, 3, Color.MAGENTA, 0);
						shout(-14, 3, Color.MAGENTA, 0);
						shout(0, 8, Color.MAGENTA, 0);
						timeShout = shoutTimer;
					}
					timeShout--;
				}else
				{
					newX = (int)(Math.random()*60)+20;
					newY = (int)(Math.random()*50)+70;
					laserTime=laserTimeMax;
					laserXEnd = laserXMax;
					laserTimeWait = laserTimeWaitMax;
					puskTitan = puskTitanMax;
				}
			}
		}
	}

	private boolean laserToucs() {
		float k1 = (x+laserXEnd)-(x+laserX);
		float k2 = laserYEnd-(y+laserY);
		double G = Math.sqrt(k1*k1+k2*k2);
		float z1 = (float) (k1/G);
		float z2 = (float) (k2/G);
		for(int i = 0;i<G;i++){
			if(
					player.lasertTouch((int)(x+laserX+z1*i), (int)(z2*i+y+laserY))||
					player.lasertTouch((int)(x-laserX-z1*i), (int)(z2*i+y+laserY)))
			{
				return true;
			}
		}
		return false;
	}
	
	public void setHealth(int value){
		super.setHealth(value);
		if(health<=0){
			ls.bonusContainer.add(new SkillProtector(ls,0,(int)(xStart))).y = this.y;
		}
	}

	public void draw(Graphics2D g) {
		if(laserTag){
			g.setColor(new Color(200,50,50));
			g.drawLine((int)x-laserX, (int)y+laserY, (int)x-laserXEnd, laserYEnd);
			g.drawLine((int)x+laserX, (int)y+laserY, (int)x+laserXEnd, laserYEnd);
		}
		drawPixels(g);
		if (bossAttac) {
			g.setColor(Color.BLUE);
			g.drawRect(1, 1, Panel.WIDTH - 3, 5);
			g.setColor(Color.YELLOW);
			g.fillRect(2, 2, Panel.WIDTH - 4, 4);
			g.setColor(Color.RED);
			g.fillRect(2, 2, (Panel.WIDTH - 4) * health / maxHealth, 4);
		}
	}

}
