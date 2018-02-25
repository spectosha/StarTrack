package game.object.bonus;

import java.awt.Graphics2D;

import main.state.LevelSetings;

public class EmptyBonus extends Bonus {

	public EmptyBonus(LevelSetings ls, int frame, int xStart) {
		super(ls,frame,xStart);
		width = height = 5;
	}

	@Override
	public void take() {
		
	}

	public void update(){
		super.update();
		if(frame<0){
			y+=speed;
		}else{
			frame--;
		}
	}
	@Override
	public void draw(Graphics2D g) {
		
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
