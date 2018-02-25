package game.container;

import main.state.GameStateManager;
import main.state.LevelState;

public class BulletContainer extends Container {

	public BulletContainer(GameStateManager gsm, LevelState ls) {
		super(gsm, ls);
	}

	@Override
	public void update() {
		for(int i = 0; i<container.size();){
			int counter = 1;
			container.get(i).update();
			if(container.get(i).getEdge()){
				delete(i);
				counter--;
			}
			else if(collision(container.get(i),ls.getPlayer())){
				if(ls.getPlayer().getTouch()){
					delete(i);
					counter--;
					player.healthDec();
				}
			}
			i+=counter;
		}		
	}
}
