package game.object.enemy;

import main.state.LevelSetings;

public class ProtectorBall extends Enemy {

		public ProtectorBall(LevelSetings ls, int frame, int xStart, int health) {
			super(ls, frame, xStart);
			common();
			this.health = health;
			if(health>10||health<1){
				health = 1;
			}
			setColor(
					health*15+100,255-(health*25),255/(health),
					(health*15+100)*3/4,(255-(health*25))*3/4,(255/(health))*3/4,
					(health*15+100)*2/4,(255-(health*25))*2/4,(255/(health))*2/4);
		}

		@Override
		public void common() {
			width = 5;
			height = 5;
			vector[1] = 1f;
			setColor(
					0,200,200,
					0,175,100,
					0,150,150);
			objectPixels = new int[][]{
					{0,3,1,3,0},
					{3,2,2,2,3},
					{1,2,3,2,1},
					{3,2,2,2,3},
					{0,3,1,3,0}};
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
