package game.object.bonus;


import java.awt.Graphics2D;


import main.state.LevelSetings;

public class Aim extends Bonus {

	public Aim(LevelSetings ls, int frame, int xStart) {
		super(ls,frame,xStart);
		setColor(
				255,255,0,
				180,180,0,
				0,100,100);
		objectPixels = new int[][]{
			{0,1,1,1,0},
			{1,0,2,0,1},
			{1,2,2,2,1},
			{1,0,2,0,1},
			{0,1,1,1,0}};
		width = height = 5;
		speed = 1;
	}

	@Override
	public void take() {
		player.incrementAim();
		
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
		this.drawPixels(g);
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
