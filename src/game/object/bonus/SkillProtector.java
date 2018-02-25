package game.object.bonus;

import java.awt.Graphics2D;

import main.state.LevelSetings;

public class SkillProtector extends Bonus {

	public SkillProtector(LevelSetings ls, int frame, int xStart) {
		super(ls, frame, xStart);
		setColor(
				0,255,255,
				0,160,160,
				0,100,100);
		width = height = 5;
		objectPixels = new int[][]{
			{3,3,3,3,3},
			{3,1,2,2,3},
			{3,1,2,2,3},
			{0,3,2,3,0},
			{0,0,3,0,0}
		};
	}

	@Override
	public void take() {
		player.incrementSkillProtector();
	}

	@Override
	public void usualColor() {
		// TODO Auto-generated method stub
		
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
