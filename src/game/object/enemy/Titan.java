package game.object.enemy;


import main.state.LevelSetings;

public class Titan extends Enemy{

	@Override
	public void common() {
		width = 9;
		height = 7;
		usualColor();
		health = 3;
		vector[1] = speed;
		timeShout = timeShoutReset = (int)(Math.random()*20+20);
		objectPixels = new int[][]{
				{0,0,3,0,1,0,3,0,0},
				{0,3,3,1,1,1,3,3,0},
				{2,3,1,1,1,1,1,3,2},
				{2,2,0,1,1,1,0,2,2},
				{0,2,0,1,0,1,0,2,0},
				{0,2,0,1,0,1,0,2,0},
				{0,0,0,1,1,1,0,0,0}};
	}
	
	public Titan(LevelSetings ls, int frame) {
		super(ls,frame);
		common();
	}
	
	public Titan(LevelSetings ls, int frame, int xStart) {
		super(ls,frame,xStart);
		common();
	}
	
	public Titan(LevelSetings ls, int frame, int xStart, int timeShout) {
		super(ls,frame,xStart);
		common();
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
		
		if(timeShout<0){
			timeShout = timeShoutReset;
			shout(3);
			shout(-3);
		}else{
			timeShout--;
		}
		
	}

	@Override
	public void usualColor() {
		setColor(190,190,255,
				220,50,50,
				200,0,0);
	}

}
