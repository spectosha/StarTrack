package main.state;



import java.awt.Color;
import java.awt.Graphics2D;

import game.container.*;
import game.inter.InterGame;
import game.object.Bullet;
import game.object.GameObject;
import game.object.Player;
import main.Panel;

public abstract class LevelState extends GameState{

	public InterGame inter;
	public Player player;
	public EnemyContainer enemyContainer;
	public BulletContainer bulletContainer;
	public PlayerBulletContainer playerBulletContainer;
	public BonusContainer bonusContainer;
	public String name;
	
	public abstract void go();
	
	public LevelState(GameStateManager gsm, String name){
		this.gsm = gsm;
		this.name = name;
		player = new Player(gsm, this);
		inter = new InterGame(gsm,this);
		enemyContainer  = new EnemyContainer(gsm,this);
		bulletContainer = new BulletContainer(gsm,this);
		playerBulletContainer = new PlayerBulletContainer(gsm,this,enemyContainer);
		bonusContainer = new BonusContainer(gsm,this);
	}
	
	public void update(){
		player.update();
		bulletContainer.update();
		playerBulletContainer.update();
		bonusContainer.update();
		enemyContainer.update();
		inter.update();
		if(enemyContainer.size()==0&&bonusContainer.size()==0){
			player.setEnd();
		}
	}
	
	public void draw(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
		player.draw(g);
		bulletContainer.draw(g);
		playerBulletContainer.draw(g);
		bonusContainer.draw(g);
		enemyContainer.draw(g);
		inter.draw(g);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void addBullet(GameObject go, int x, int y){
		bulletContainer.add(new Bullet(this, go, x, y));
	}
	
	public void addPlayerBullet(GameObject go, int x, int y){
		playerBulletContainer.add(new Bullet(this, go, x, y));
	}
	
	@Override
	public void keyPressed(int k) {
		player.keyPressed(k);
		
	}

	@Override
	public void keyReliased(int k) {
		player.keyReliased(k);
	}

}
