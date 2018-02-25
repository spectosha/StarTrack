package game.object.bonus;

import java.awt.Graphics2D;

import main.state.LevelSetings;

public class TakeHealth extends Bonus {
	
	/**
	 * 
	 * @param player
	 * @param frame
	 * @param xStart
	 */
	public TakeHealth(LevelSetings ls, int frame, int xStart) {
		super(ls,frame,xStart);
		width = 5;
		height = 4;
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
	public void take() {
		player.incrementHealth();
	}

	@Override
	public void update() {
		super.update();
		if(frame<0){
			y+=speed;
		}else{
			frame--;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		drawPixels(g);
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
