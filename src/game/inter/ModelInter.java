package game.inter;

import game.object.DrawObject;
import main.state.GameStateManager;
import main.state.LevelState;

public abstract class ModelInter extends DrawObject {

	public ModelInter(GameStateManager gsm,LevelState ls){
		this.gsm = gsm;
		this.ls = ls;
		this.player = ls.getPlayer();
	}
	
}
