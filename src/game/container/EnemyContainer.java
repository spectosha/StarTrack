package game.container;


import main.state.GameStateManager;
import main.state.LevelState;

public class EnemyContainer extends Container{


	public EnemyContainer(GameStateManager gsm, LevelState ls) {
		super(gsm, ls);
	}

	
	public void update(){
		for(int i = 0; i<container.size();){
			int counter = 1;
			container.get(i).update();
			if(container.get(i).getEdge()){
				delete(i);
				counter--;
			}else if(collision(ls.getPlayer(),container.get(i))){
				if(ls.getPlayer().getTouch()){
					container.get(i).setHealth(-3);
					if(container.get(i).getHealth()<=0){
						delete(i);
						counter--;
					}
					ls.getPlayer().healthDec();
				}
			}
			i+=counter;
		}
	}
}
