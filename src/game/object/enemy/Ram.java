package game.object.enemy;




import main.state.LevelSetings;

public class Ram extends Enemy {

	/**
	 * Enemy(GameStateManager, frame В каком кадре появится враг, xStart от -46 до 46)
	 */
	
	@Override
	public void common() {
		width = 5;
		height = 7;
		vector[1] = 1f;
		setColor(
				0,200,200,
				0,175,100,
				0,150,150);
		objectPixels = new int[][]{
				{3,3,3,3,3},
				{1,2,1,2,1},
				{0,1,3,1,0},
				{1,0,3,0,1},
				{2,2,3,2,2},
				{0,3,3,3,0},
				{0,0,3,0,0}};
	}
	
	public Ram(LevelSetings ls,  int frame) {
		super(ls,frame);
		common();
	}
	
	public Ram(LevelSetings ls,  int frame, int xStart) {
		super(ls,frame,xStart);
		common();
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
