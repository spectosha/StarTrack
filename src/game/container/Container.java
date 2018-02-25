package game.container;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.object.GameObject;
import game.object.Player;
import main.state.GameStateManager;
import main.state.LevelState;

public abstract class Container{

	public ArrayList<GameObject> container;
	
	protected LevelState ls;
	protected Player player;
	protected GameStateManager gsm;
	public Container(GameStateManager gsm, LevelState ls) {
		this.gsm = gsm;
		this.ls = ls;
		this.player = ls.getPlayer();
		container = new ArrayList<GameObject>();
	}
	
	public abstract void update();
	
	public GameObject add(GameObject g) {
		container.add(g);
		return g;
	}
	
	public void draw(Graphics2D g){
		for(int i = 0;i<container.size();i++){
			container.get(i).draw(g);
		}
	}
	
	public int size(){
		return container.size();
	}
	
	public GameObject get(int i){
		return container.get(i);
	}
	
	public boolean collision(GameObject obj, GameObject sub){
		if(
				obj.getWidth()==0 ||
				obj.getHeight()==0 ||
				sub.getWidth()==0 ||
				sub.getHeight()==0){
			return false;
		}
		int ax = (obj.getWidth()-1)/2;
		int bx = (sub.getWidth()-1)/2;
		int ay = (obj.getHeight()-1)/2;
		int by = (sub.getHeight()-1)/2;
		if(
				obj.getX()-ax < sub.getX()+bx+1 &&
				obj.getX()+ax+1 > sub.getX()-bx &&
				obj.getY()-ay < sub.getY()+by+1 &&
				obj.getY()+ay+1 > sub.getY()-by)
		{
			return true;
		}
		return false;
	}
	
	public void delete(int i){
		container.remove(i);
	}
}
