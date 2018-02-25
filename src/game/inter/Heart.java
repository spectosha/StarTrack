package game.inter;

import java.awt.Graphics2D;

import main.state.GameStateManager;
import main.state.LevelState;

public class Heart extends ModelInter {	
	
	public Heart(GameStateManager gsm, LevelState ls,DisplayWindow dw) {
		super(gsm,ls);
		height = 10;
		width = dw.getWidth();
		x = xStart = (int) dw.getX()+6;
		y = yStart = dw.getHeight()-height*2;
		setColor(
				255,0,0,
				200,0,0,
				150,0,0);
		objectPixels = new int[][]{
				{0,1,0,1,0},
				{1,1,1,2,3},
				{0,1,2,3,0},
				{0,0,3,0,0}};
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D g) {
		for(int i = 0; i<gsm.health;i++){
			if(i==10||i==20){
				y-=6;
				x = xStart;
			}
			drawPixels(g);
			x += 6;
		}
		x = xStart;
		y = yStart;
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReliased(int k) {
		// TODO Auto-generated method stub
		
	}
}
