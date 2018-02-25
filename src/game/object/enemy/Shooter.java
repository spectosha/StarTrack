package game.object.enemy;



import main.Panel;
import main.state.LevelSetings;


public class Shooter extends Enemy {

	public Shooter(LevelSetings ls, int frame) {
		super(ls,frame);
		common();
	}
	
	public Shooter(LevelSetings ls, int frame, int xStart) {
		super(ls,frame,xStart);
		common();
	}

	@Override
	public void common() {
		width = 7;
		height = 5;
		vector[1] = 1f;
		timeShout = (int) (Math.random()*Panel.HEIGHT);
		setColor(250,250,0,
				200,0,150,
				190,190,0);
		objectPixels = new int[][]{
				{0,1,0,1,0,1,0},
				{1,1,3,0,3,1,1},
				{0,1,3,3,3,1,0},
				{0,0,3,2,3,0,0},
				{0,0,3,2,3,0,0}};
	}

	@Override
	public void update() {
		super.update();
		if(frame>0){
			frame--;
			return;
		}
		x+=vector[0];
		y+=vector[1];
		if(timeShout==0){
			shout();
		}
		timeShout--;
	}

	@Override
	public void usualColor() {
		// TODO Auto-generated method stub
		
	}

}
