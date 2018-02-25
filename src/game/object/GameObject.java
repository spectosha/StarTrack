package game.object;

import java.awt.Graphics2D;

import game.object.enemy.Enemy;
import game.object.enemy.ProtectorBall;
import main.Panel;
import main.state.LevelSetings;

public abstract class GameObject extends DrawObject {

	public LevelSetings ls;
	
	public float speed = 1f;
	protected int health;
	protected float[] vector = {0,0};
	protected boolean forDeleted = false;
	protected int bulletDirrection = 1;
	protected int timeMiddleShout,timeMiddleShoutFinal;
	
	public int timeShout;
	public int timeShoutReset;
	
	
	
	public Enemy[] protection = new Enemy[0];
	public float angleProtection = 0;
	public float radiusProtection;
	public float speedRotation;
	public float speeding;
	
	protected boolean protectorsDied = false;
	
	public float plusEdge = 0;
	
	protected int multiply = 0;
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int value){
		health += value;
		white = whiteMax;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public float[] getVector(){
		return vector;
	}
	
	public boolean getEdge(){
		return y>Panel.HEIGHT+height+plusEdge;
	}
	
	public void radiusChange(float value){
		plusEdge = radiusProtection += value;
	}
	
	public void update(){
		for(int i = 0;i<protection.length;i++){
			if(protection[i]!=null){
				float xSet = (float) (Math.cos((i*angleProtection)+speeding+Math.PI/2)*radiusProtection);
				float ySet = (float) (Math.sin((i*angleProtection)+speeding+Math.PI/2)*radiusProtection);
				protection[i].x = this.x+xSet;
				protection[i].y = this.y+ySet;
				protection[i].plusEdge = radiusProtection*2;
			}
		}
		speeding+=speedRotation;
		if(white>0){
			white--;
			usualColor();
		}
	}
	
	public abstract void usualColor();
	
	//удалить
	public void drawPixels(Graphics2D g){
		for(int i = 0;i<objectPixels.length;i++){
			for(int n = 0;n<objectPixels[i].length;n++){
				if(objectPixels[i][n]>0){
					if (objectPixels[i][n] == 1)
						g.setColor(color);
					else if (objectPixels[i][n] == 2)
						g.setColor(color2);
					else if (objectPixels[i][n] == 3)
						g.setColor(color3);
					else if (objectPixels[i][n] == 4)
						g.setColor(color4);
					else if (objectPixels[i][n] == 5)
						g.setColor(color5);
					else if (objectPixels[i][n] == 6)
						g.setColor(color6);
					g.fillRect(n + (int) (x - (width - 1) / 2), i + (int) (y - (height - 1) / 2), 1, 1);
				}
			}
		}
	}

	public void setProtection(int type, int number, int radius, float speed) {
		y=-(radius+height+3);
		speedRotation = (float) ((speed*Math.PI)/180);
		angleProtection = (float) (Math.PI*2/number);
		plusEdge = radiusProtection = radius;
		protection = new Enemy[number];
		for(int i = 0;i<number;i++){
			//float xSet = (float) (Math.cos((i*angleProtection)+speeding+Math.PI/2)*radiusProtection);
			//float ySet = (float) (Math.sin((i*angleProtection)+speeding+Math.PI/2)*radiusProtection);
			ls.enemyContainer.add(ls.getType(type, (int)y, (int)x)).plusEdge = radius;
			protection[i] = (Enemy) ls.enemyContainer.get(ls.enemyContainer.size()-1);
		}
	}
	
	public void setProtectionOfBalls(int number, int radius, float speed, int m) {
		y=-(radius+height+3);
		speedRotation = (float) ((speed*Math.PI)/180);
		angleProtection = (float) (Math.PI*2/number);
		plusEdge = radiusProtection = radius;
		protection = new Enemy[number];
		for(int i = 0;i<number;i++){
			//float xSet = (float) (Math.cos((i*angleProtection)+speeding+Math.PI/2)*radiusProtection);
			float ySet = (float) (Math.sin((i*angleProtection)+speeding+Math.PI/2)*radiusProtection);
			ls.enemyContainer.add(new ProtectorBall(ls, frame, (int)x, m)).plusEdge = radius;//.frame=this.frame+(int)ySet;
			protection[i] = (Enemy) ls.enemyContainer.get(ls.enemyContainer.size()-1);
		}
	}

	public void setSpeed(int speed2) {
		multiply = speed2;
	}
}
