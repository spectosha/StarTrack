package main.state;


import game.object.bonus.Accelerator;
import game.object.bonus.TakeHealth;
import game.object.enemy.Ram;
import game.object.enemy.Shooter;
import game.object.enemy.Titan;

public class Level_2 extends LevelSetings {

	public Level_2(GameStateManager gsm) {
		super(gsm, " Level 2\nBetween stars ");
	}

	@Override
	public void go() {

		int k = (int) (Math.random()*96-48);
		enemyContainer.add(new Titan(this,30,k));
		bonusContainer.add(new Accelerator(this,31,k,Accelerator.M));
		enemyContainer.add(new Ram(this,70));
		enemyContainer.add(new Ram(this,80));
		enemyContainer.add(new Ram(this,90));
		enemyContainer.add(new Ram(this,100));
		bonusContainer.add(new TakeHealth(this,150,0));
		addCircleEnemys(RAM, 150, 20, 8, 0);
		addCircleEnemys(RAM, 150, 14, 8, 0);
		addCircleEnemys(RAM, 205, 10, 13, -20);
		addCircleEnemys(RAM, 255, 10, 13, 20);
		
		addLineEnemys(SHOUTER, 300, 10, 10, 0);
		addLineEnemys(SHOUTER, 310, 10, 10, 0);
		
		bonusContainer.add(new Accelerator(this,31,k,Accelerator.M));
		
		enemyContainer.add(new Shooter(this,430,0));
		
		addLineEnemys(SHOUTER, 450, 2, 10, 45);
		addLineEnemys(SHOUTER, 450, 2, 10, -45);
		addLineEnemys(SHOUTER, 460, 2, 10, 45);
		addLineEnemys(SHOUTER, 460, 2, 10, -45);
		
		addLineEnemys(SHOUTER, 440, 2, 10, 0);
		addLineEnemys(SHOUTER, 450, 2, 20, 0);
		addLineEnemys(SHOUTER, 460, 2, 30, 0);
		addLineEnemys(SHOUTER, 470, 2, 40, 0);
		addLineEnemys(SHOUTER, 480, 2, 50, 0);
		addLineEnemys(SHOUTER, 490, 2, 60, 0);
		addLineEnemys(SHOUTER, 500, 2, 70, 0);
		addLineEnemys(SHOUTER, 510, 2, 80, 0);
		
		addCircleEnemys(RAM, 540, 12, 9, 0);
		addCircleEnemys(RAM, 540, 7, 9, 0);
		bonusContainer.add(new TakeHealth(this,540,0));
		enemyContainer.add(new Shooter(this,580));
		enemyContainer.add(new Shooter(this,590));
		enemyContainer.add(new Shooter(this,600));
		enemyContainer.add(new Shooter(this,610));
		enemyContainer.add(new Shooter(this,620));
		enemyContainer.add(new Shooter(this,630));
		enemyContainer.add(new Shooter(this,640));
		enemyContainer.add(new Shooter(this,650));
		enemyContainer.add(new Shooter(this,660));
		enemyContainer.add(new Shooter(this,670));
		enemyContainer.add(new Shooter(this,680));
		
		
		addLineEnemys(TITAN, 720, 3, 20, 0);
		
		//trap
		addLineEnemys(RAM, 730, 2, 60, 0);
	 	addLineEnemys(RAM, 740, 2, 60, 0);
	 	addLineEnemys(RAM, 750, 2, 60, 0);
	 	addLineEnemys(RAM, 760, 2, 60, 0);
	 	addLineEnemys(RAM, 770, 2, 60, 0);
	 	addLineEnemys(RAM, 780, 2, 60, 0);
	 	addLineEnemys(RAM, 790, 2, 60, 0);
	 	addLineEnemys(RAM, 800, 2, 60, 0);
	 	addLineEnemys(RAM, 810, 2, 60, 0);
	 	addLineEnemys(RAM, 820, 2, 60, 0);
	 	addLineEnemys(RAM, 830, 2, 60, 0);
	 	addLineEnemys(RAM, 840, 2, 60, 0);
	 	addLineEnemys(RAM, 850, 2, 60, 0);
	 	addLineEnemys(RAM, 860, 2, 60, 0);
	 	addLineEnemys(RAM, 870, 2, 60, 0);
	 	addLineEnemys(RAM, 880, 2, 60, 0);
	 	bonusContainer.add(new Accelerator(this,880,-40, Accelerator.M));
	 	bonusContainer.add(new Accelerator(this,880,40, Accelerator.M));
	 	addLineEnemys(SHOUTER, 890, 3, 8, -38);
	 	addLineEnemys(SHOUTER, 890, 3, 8, 38);
	 	addLineEnemys(SHOUTER, 900, 3, 8, -38);
	 	addLineEnemys(SHOUTER, 900, 3, 8, 38);
	 	addLineEnemys(SHOUTER, 910, 3, 8, -38);
	 	addLineEnemys(SHOUTER, 910, 3, 8, 38);
	 	addLineEnemys(SHOUTER, 920, 3, 8, -38);
	 	addLineEnemys(SHOUTER, 920, 3, 8, 38);
	 	
	 	k = (int) (Math.random()*96-48);
		enemyContainer.add(new Titan(this,970,k));
		bonusContainer.add(new Accelerator(this,970,k,Accelerator.M));
	}

	@Override
	public void init() {
		
	}

}
