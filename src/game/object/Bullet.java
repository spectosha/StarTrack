package game.object;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Panel;
import main.state.LevelState;

public class Bullet extends GameObject {

	private GameObject go;
	public LevelState ls;
	
	public Bullet(LevelState ls, GameObject go, int x, int y) {
		this.ls = ls;
		this.go = go;
		this.x = x;
		this.y = y;
		width = 1;
		height = 1;
		color = Color.WHITE;
	}
	
	public void update() {
		y+=go.bulletDirrection*2+multiply;
	}

	public boolean getEdge(){
		return y>Panel.HEIGHT||y<0||x>Panel.WIDTH||x<0;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 1, 1);
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
