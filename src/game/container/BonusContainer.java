package game.container;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.object.bonus.Bonus;
import main.state.GameStateManager;
import main.state.LevelState;

public class BonusContainer extends Container {

	public ArrayList<Bonus> container;
	
	public BonusContainer(GameStateManager gsm, LevelState ls) {
		super(gsm, ls);
		container = new ArrayList<Bonus>();
	}

	@Override
	public void update() {
		for(int i = 0;i<container.size();){
			int counter = 1;
			container.get(i).update();
			if(container.get(i).getEdge()){
				delete(i);
				counter--;
			}else if(collision(container.get(i),ls.getPlayer())&&ls.getPlayer().getTouch()){
				container.get(i).take();
				delete(i);
				counter--;
			}
			i+=counter;
		}
	}
	
	public Bonus add(Bonus b) {
		container.add(b);
		return b;
	}
	
	public int size(){
		return container.size();
	}
	
	public void delete(int i){
		container.remove(i);
	}
	
	public void draw(Graphics2D g){
		for(int i = 0;i<container.size();i++){
			container.get(i).draw(g);
		}
	}

}
