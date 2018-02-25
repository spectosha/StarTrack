package game.object.bonus;

import java.awt.Graphics2D;

import main.state.LevelSetings;

public class TwoBullet extends Bonus {

	public TwoBullet(LevelSetings ls, int frame, int xStart) {
		super(ls, frame, xStart);
		setColor(
				220,0,0,
				250,250,250,
				180,0,0
				);
		width = height = 5;
		objectPixels = new int[][]{
			{3,0,0,0,3},
			{3,0,0,0,3},
			{3,2,0,2,3},
			{1,2,2,2,1},
			{0,1,2,1,0}
		};
	}

	@Override
	public void take() {
		player.incrementTwoBullet();
	}

	@Override
	public void usualColor() {
		
	}

	public void update(){
		super.update();
		if(frame>0){
			frame--;
			return;
		}
		y+=speed;
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

}
