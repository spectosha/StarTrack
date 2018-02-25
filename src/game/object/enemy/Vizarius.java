package game.object.enemy;

import main.state.LevelSetings;

public class Vizarius extends Boss {

	float radiusBoss = (float) (Math.random()*25+10);
	
	public Vizarius( LevelSetings ls,  int frame) {
		super(ls,frame);
		common();
	}

	@Override
	public void common() {
		width = 11;
		height = 13;
		x = 51;
		y = -10;
		health = maxHealth = 30;
		vector[1] = 1f;
		usualColor();
		objectPixels = new int[][]{
				{4,0,0,0,0,0,0,0,0,0,4},
				{0,4,4,0,0,0,0,0,4,4,0},
				{0,0,4,5,2,0,2,5,4,0,0},
				{0,0,0,5,5,2,5,5,0,0,0},
				{0,0,0,0,2,1,2,0,0,0,0},
				{0,0,0,0,2,1,2,0,0,0,0},
				{0,4,4,1,2,5,2,1,4,4,0},
				{4,4,2,1,5,5,5,1,2,4,4},
				{0,0,0,2,2,3,2,2,0,0,0},
				{0,0,0,1,1,3,1,1,0,0,0},
				{0,0,0,5,2,2,2,5,0,0,0},
				{0,0,0,0,5,2,5,0,0,0,0},
				{0,0,0,0,0,5,0,0,0,0,0}};
	}

	@Override
	public void update() {
		super.update();
		if (frame > 0) {
			frame--;
			return;
		}
		bossHere = true;
		comeIn();
		if (bossAttac) {
			if (firstAttac) {
				firstAttac();
			} else {
				secondAttac();
			}

			//x += vector[0];
			//y += vector[1];

		}
	}

	@Override
	public void usualColor() {
		setColor(
				0, 200, 200,
				0, 175, 100,
				0, 150, 100, 
				0, 100,200,
				50, 100, 200, 
				20, 20, 200);
	}

	@Override
	public void firstAttac() {
		if(setRadiusProtection(radiusBoss)){
			radiusBoss = (float) (Math.random()*25+10);
		}
	}

	@Override
	public void secondAttac() {
		// TODO Auto-generated method stub
		
	}

}
