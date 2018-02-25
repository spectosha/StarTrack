package game.object.enemy;

import main.state.LevelSetings;

public class EmptyEnemy extends Enemy {

	public EmptyEnemy(LevelSetings ls, int frame) {
		super(ls, frame);
		common();
	}
	public EmptyEnemy(LevelSetings ls, int frame, int offset) {
		super(ls, frame, offset);
		common();
	}

	@Override
	public void common() {
		width = 0;
		height = 0;
		vector[1] = 1f;
	}
	
	public void update(){
		super.update();
		if(frame>0){
			frame--;
			return;
		}
		x+=vector[0];
		y+=vector[1];
	}

	@Override
	public void usualColor() {
		
	}

	
}
