package game.object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import game.container.EnemyContainer;
import main.Panel;
import main.state.GameStateManager;
import main.state.LevelSetings;
import main.state.LevelState;

public class Player extends GameObject{

	private boolean touch = true;
	private boolean invis = false;
	private int timeTouch = 48;
	private int timeMig = 2;
	private int timer;
	private int mig;
	
	private boolean right = false;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	private boolean shout = false;
	private int yStart = 175;
	private int xStart = 49;
	
	private boolean bottomStart = true;
	private boolean topEnd = false;
	public boolean resolutionMove = true;
	
	private float step = 1.03f;
	private float startSpeed = 1f;
	
	public boolean redTag = false;
	public boolean letAutoShooting = false;
	public int letMaxShootingSpeed = 4;
	
	public Player(GameStateManager gsm, LevelState ls) {
		this.ls = (LevelSetings) ls;
		this.gsm = gsm;
		bulletDirrection = -1;
		x = xStart;
		y = Panel.HEIGHT+10;
		width = 7;
		height = 5;
		usualColor();
		whiteMax = 48;
		color2 = new Color(200,0,50);
		objectPixels = new int[][]{
				{0,0,0,2,0,0,0},
				{0,0,2,0,2,0,0},
				{0,0,2,0,2,0,0},
				{0,2,0,1,0,2,0},
				{2,2,1,1,1,2,2}};
	}

	public boolean getTouch(){
		return touch;
	}
	
	public void healthDec(){
		white = whiteMax;
		if(gsm.skillProtector>0){
			gsm.skillProtector--;
		}else{
			gsm.twoBullet = false;
			gsm.skillProtector = 0;
			gsm.health--;
			gsm.timeMiddleShoutFinal = gsm.timeMiddleShout = gsm.timeMiddleShoutFinal+gsm.fineTimeMSF;
			if(gsm.timeMiddleShoutFinal>gsm.TMSF){
				gsm.timeMiddleShoutFinal = gsm.timeMiddleShout = gsm.TMSF;
			}
			if(gsm.aim>0){
				gsm.aim--;
			}
			gsm.skillAutoShooting = false;
		}
		
		
		y = yStart;
		x = xStart;
		mig = timeMig;
		timer = timeTouch;
		touch = false;
		if(gsm.health<=0){
			gsm.setStates(GameStateManager.MENU);
		}
	}
	
	public void setEnd(){
		topEnd=true;
	}
	
	public void incrementHealth(){
		if(gsm.health<gsm.healthMax){
			gsm.health ++;
		}
		
	}
	
	public void incrementSkillProtector(){
		gsm.skillProtector+=1;
	}
	public void incrementTwoBullet(){
		gsm.twoBullet = true;
	}
	
	public void incrementSpeedShooting(int value){
		if(gsm.timeMiddleShoutFinal-value>=4){
			gsm.timeMiddleShoutFinal-=value;
			if(gsm.timeMiddleShoutFinal<gsm.timeMiddleShout){
				gsm.timeMiddleShout = gsm.timeMiddleShoutFinal;
			}
		}else{
			gsm.timeMiddleShoutFinal = letMaxShootingSpeed;
		}
	}
	
	public void incrementAim(){
		gsm.aim += 1;
	}
	
	public void incrementAutoShooting(){
		gsm.skillAutoShooting = true;
		letAutoShooting = true;
	}
	
	@Override
	public void update() {
		super.update();
		if(gsm.timeMiddleShout>0){
			gsm.timeMiddleShout--;
		}else if((shout&&resolutionMove)||(gsm.skillAutoShooting&&redTag&&letAutoShooting)){
			if(gsm.twoBullet){
				ls.addPlayerBullet(this,(int)(x)+2,(int)y);
				ls.addPlayerBullet(this,(int)(x)-2,(int)y);
			}else{
				ls.addPlayerBullet(this,(int)(x),(int)y);
			}
			gsm.timeMiddleShout = gsm.timeMiddleShoutFinal;
		}
		//gsm.twoBullet
		
		if(bottomStart){
			y-=startSpeed;
			startSpeed/=step;
			if(startSpeed<0.1){
				ls.go();
				bottomStart=false;
				topEnd=false;
			}else{
				return;
			}
		}if(topEnd){
			invis=false;
			y-=startSpeed;
			startSpeed*=step;
			if(y<-20){
				topEnd = false;
				gsm.nextLevel();
			}else{
				return;
			}
		}
		vector[0]=vector[1]=0;
		if(resolutionMove){
			if(right == true && x<Panel.WIDTH)vector[0]=speed;
			if(left == true && x>0)vector[0]=-speed;
			if(up == true && y > 0)	vector[1]=-speed;
			if(down == true && y< Panel.HEIGHT-(width-1)/2) vector[1]=speed;
		}
		
		x+=vector[0];
		y+=vector[1];
		
		if(touch==false){
			mig--;timer--;
			if(mig<=0){invis = !invis; mig = timeMig;}
			if(timer<0){touch = true; invis = false;}
			}
	}

	@Override
	public void draw(Graphics2D g) {
		if(gsm.aim>0){
			EnemyContainer enemy = ls.enemyContainer;
			int length = 0;
			for(int i = 0;i<enemy.size();i++){
				if(
						x>=enemy.get(i).getX()-(enemy.get(i).getWidth()-1)/2 &&
						x<=enemy.get(i).getX()+(enemy.get(i).getWidth()-1)/2){
					if(length<enemy.get(i).getY()&&y-enemy.get(i).getY()>0){
						length = (int) enemy.get(i).getY();
					}
				}
			}
			if(gsm.aim==2&&length>0){
					g.setColor(new Color(30,10,10));
					redTag = true;
			}else if(gsm.aim>=3&&gsm.timeMiddleShout<=0){
				if(length>0){
					g.setColor(new Color(40,10,10));
					redTag = true;
				}else{
					g.setColor(new Color(10,40,10));
					redTag = false;
				}
			}else{
				g.setColor(new Color(20,20,20));
				redTag = false;
			}
				
				g.drawLine((int)x, (int)y-3, (int)x, length);
		}
		if(invis==false){
			if(gsm.timeMiddleShout==0){
				g.setColor(new Color(0,255,0));
				g.fillRect((int)x-1, (int)y-1, 3, 4);
			}
			drawPixels(g);
		}
		
	}
	
	public boolean lasertTouch(int xV, int yV){
		int ax = (width-1)/2;
		int ay = (width-1)/2;
		if(
				x-ax-1 < xV &&
				x+ax+1 > xV &&
				y-ay-1 < yV &&
				y+ay+1 > yV)
		{
			return true;
		}
		return false;
	}
	
	

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_Z && gsm.skillAutoShooting){
			letAutoShooting = !letAutoShooting;
		}
		if(k == KeyEvent.VK_SPACE||k == KeyEvent.VK_ENTER){
			shout = true;
		}
		if(k == KeyEvent.VK_D|| k == KeyEvent.VK_RIGHT){
			right = true;
		}
		if(k == KeyEvent.VK_A|| k == KeyEvent.VK_LEFT){
			left = true;
		}
		if(k == KeyEvent.VK_W|| k == KeyEvent.VK_UP){
			up = true;
		}
		if(k == KeyEvent.VK_S|| k == KeyEvent.VK_DOWN){
			down = true;
		}
	}

	@Override
	public void keyReliased(int k) {
		if(k == KeyEvent.VK_SPACE||k == KeyEvent.VK_ENTER){
			shout = false;
		}
		if(k == KeyEvent.VK_D|| k == KeyEvent.VK_RIGHT){
			right = false;                         
		}                                          
		if(k == KeyEvent.VK_A|| k == KeyEvent.VK_LEFT){
			left = false;                          
		}                                          
		if(k == KeyEvent.VK_W|| k == KeyEvent.VK_UP){
			up = false;                            
		}                                          
		if(k == KeyEvent.VK_S|| k == KeyEvent.VK_DOWN){
			down = false;
		}
	}

	@Override
	public void usualColor() {
		setColor(
				255,255,255,
				200,0,50,
				0,50,150
				);
	}
}
