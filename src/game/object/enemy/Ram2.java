package game.object.enemy;




import main.state.LevelSetings;


public class Ram2 extends Enemy {

	/**
	 * Enemy(GameStateManager, frame В каком кадре появится враг, xStart от -46 до 46)
	 */
	@Override
	public void common() {
		width = 7;
		height = 9;
		vector[1] = speed;
		usualColor();
		objectPixels = new int[][]{
				{0,2,1,0,1,2,0},
				{2,2,3,3,3,2,2},
				{1,1,3,0,3,1,1},
				{0,0,3,3,3,0,0},
				{1,0,3,3,3,0,1},
				{3,2,3,0,2,2,3},
				{3,2,3,3,3,2,3},
				{0,1,1,2,1,1,0},
				{0,0,2,2,2,0,0}};
		health = 4;
	}
	
	/**
	 * 
	 * @param ls
	 * @param frame
	 * @param speed
	 */
	public Ram2( LevelSetings ls,  int frame, float speed) {
		super(ls,frame);
		common();
		vector[1]=speed;
	}
	
	public Ram2( LevelSetings ls,  int frame, int xStart, float speed) {
		super(ls,frame,xStart);
		common();
		vector[1]=speed;
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
		setColor(
				0,190,200,
				0,165,100,
				0,140,150);
	}

	
}
