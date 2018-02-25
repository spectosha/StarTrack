package game.container;

import main.state.GameStateManager;
import main.state.LevelState;

public class PlayerBulletContainer extends Container {

	//Поменять ArrayList<GameObject> на что то другое
	Container c;
	public PlayerBulletContainer(GameStateManager gsm,LevelState ls, Container c) {
		super(gsm, ls);
		this.c = c;
	}

	@Override
	public void update() {
		for(int i = 0; i<container.size();){
			if(i<0){
				i=0;
			}
			int counter = 1;
			container.get(i).update();
			if(container.get(i).getEdge()){
				delete(i);
				counter--;
			}else{
				for(int n = 0;n<c.size();){
					int counterEnemy = 1;
						if(i<container.size()&&collision(container.get(i),c.get(n))){
							delete(i);
							counter--;
							c.get(n).setHealth(-1);
							if(c.get(n).getHealth()<=0){
								c.delete(n);
								counterEnemy--;
							}
							break;
						}
					n+=counterEnemy;
				}
			}
			i+=counter;
		}
	}
}
