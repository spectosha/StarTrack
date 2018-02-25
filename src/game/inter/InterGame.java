package game.inter;

import java.awt.Graphics2D;

import game.object.DrawObject;
import main.state.GameStateManager;
import main.state.LevelState;

public class InterGame extends DrawObject{

	private LevelName levelName;
	private DisplayWindow displayWindow;
	
	public InterGame(GameStateManager gsm, LevelState ls) {
		this.gsm = gsm;
		levelName = new LevelName(gsm, ls);
		displayWindow = new DisplayWindow(gsm,ls);
	}

	@Override
	public void update() {
		levelName.update();
		displayWindow.update();
	}

	@Override
	public void draw(Graphics2D g) {
		levelName.draw(g);
		displayWindow.draw(g);
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
