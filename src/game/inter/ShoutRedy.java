package game.inter;

import java.awt.Color;
import java.awt.Graphics2D;

import main.state.GameStateManager;
import main.state.LevelState;

public class ShoutRedy extends ModelInter {

	public ShoutRedy(GameStateManager gsm, LevelState ls,DisplayWindow  dw) {
		super(gsm,ls);
		height = 10;
		width = dw.getWidth()-1;
		x = dw.getX();
		y = dw.getHeight()-height;
	}

	@Override
	public void update() {
		//width = gsm.timeMiddleShoutFinal-gsm.timeMiddleShout;
	}

	@Override
	public void draw(Graphics2D g) {
		float otn = (float)width/(float)gsm.timeMiddleShoutFinal;
		float le = (float)gsm.TMSF/(float)gsm.timeMiddleShoutFinal;
		color = Color.BLUE;
		g.setColor(color);
		g.drawRect((int)x+1, (int)y, width-1, height);
		if(gsm.timeMiddleShout==0)
			color = Color.GREEN;
		else color = Color.RED;
		g.setColor(color);
		g.fillRect((int)x+2, (int)y+1,  (int) ((gsm.timeMiddleShoutFinal-gsm.timeMiddleShout*le)*otn)-2, height-2);
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
