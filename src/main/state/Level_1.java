package main.state;


import game.object.bonus.Accelerator;
import game.object.bonus.TakeHealth;
import game.object.enemy.BossOne;
import game.object.enemy.Ram;

public class Level_1 extends LevelSetings {

	public Level_1(GameStateManager gsm) {
		super(gsm, "Level 1\nBegining ");
	}

	public void go(){

		//enemyContainer.add(new Vizarius(this,0,0));
		
		 	addLineEnemys(RAM, 50, 2, 20, 0);
		 	addLineEnemys(RAM, 110, 2, 40, 0);
		 	addLineEnemys(RAM, 125, 2, 70, 0);
		 	
		 	addLineEnemys(RAM, 140, 2, 50, 0);
		 	addLineEnemys(RAM, 150, 2, 70, 0);
			
			enemyContainer.add(new Ram(this,180));
			enemyContainer.add(new Ram(this,200));
			enemyContainer.add(new Ram(this,220));
		
			enemyContainer.add(new Ram(this,240));
			enemyContainer.add(new Ram(this,260));
			enemyContainer.add(new Ram(this,280));
			
			bonusContainer.add(new TakeHealth(this,400,0));
			addCircleEnemys(RAM, 400, 8, 8, 0);
			//trap
			addLineEnemys(RAM, 490, 2, 60, 0);
		 	addLineEnemys(RAM, 400, 2, 60, 0);
		 	addLineEnemys(RAM, 410, 2, 60, 0);
		 	addLineEnemys(RAM, 420, 2, 60, 0);
		 	addLineEnemys(RAM, 430, 2, 60, 0);
		 	addLineEnemys(RAM, 440, 2, 60, 0);
		 	addLineEnemys(RAM, 450, 2, 60, 0);
		 	addLineEnemys(RAM, 460, 2, 60, 0);
		 	addLineEnemys(RAM, 470, 2, 60, 0);
		 	addLineEnemys(RAM, 480, 2, 60, 0);
		 	addLineEnemys(RAM, 490, 2, 60, 0);
		 	addLineEnemys(RAM, 500, 2, 60, 0);
		 	addLineEnemys(RAM, 510, 2, 60, 0);
		 	addLineEnemys(RAM, 520, 2, 60, 0);
		 	addLineEnemys(RAM, 530, 2, 60, 0);

			bonusContainer.add(new Accelerator(this,590,0, Accelerator.M));
			addLineEnemys(SHOUTER, 570, 1, 10, 0);
			addLineEnemys(SHOUTER, 580, 2, 10, 0);
			addLineEnemys(SHOUTER, 590, 2, 20, 0);
			addLineEnemys(SHOUTER, 600, 4, 10, 0);
			addLineEnemys(SHOUTER, 610, 5, 10, 0);
			
			enemyContainer.add(new Ram(this,640,11));
			enemyContainer.add(new Ram(this,645,22));
			enemyContainer.add(new Ram(this,650,-5));
			enemyContainer.add(new Ram(this,670,-18));
			enemyContainer.add(new Ram(this,675,16));
			enemyContainer.add(new Ram(this,680,-30));
			
			addCircleEnemys(SHOUTER, 700, 4, 12, 0);
			addCircleEnemys(SHOUTER, 717, 4, 12, -35);
			addCircleEnemys(SHOUTER, 717, 4, 12, 35);
			bonusContainer.add(new Accelerator(this,740,0, Accelerator.M));
			
			enemyContainer.add(new Ram(this,750,-37));
			addLineEnemys(SHOUTER, 758, 2, 8, -37);
			enemyContainer.add(new Ram(this,780,20));
			addLineEnemys(SHOUTER, 788, 2, 8, 20);
			enemyContainer.add(new Ram(this,810,-10));
			addLineEnemys(SHOUTER, 818, 2, 8, -10);
			enemyContainer.add(new Ram(this,840,40));
			addLineEnemys(SHOUTER, 848, 2, 8, 40);
			enemyContainer.add(new Ram(this,870,20));
			addLineEnemys(SHOUTER, 878, 2, 8, 20);
			enemyContainer.add(new Ram(this,900,-15));
			addLineEnemys(SHOUTER, 908, 2, 8, -15);
			
			enemyContainer.add(new Ram(this,925,0));
			addLineEnemys(SHOUTER, 933, 2, 8, 0);
			
			addLineEnemys(RAM, 920, 2, 12, 0);
			addLineEnemys(RAM, 926, 2, 42, 0);
			addLineEnemys(RAM, 940, 2, 72, 0);

			//bonusContainer.add(new Accelerator(this,955,0, Accelerator.M));
			
			addCircleEnemys(SHOUTER, 970, 20, 8, 0);
			addCircleEnemys(SHOUTER, 970, 10, 8, 0);
			
			
			enemyContainer.add(new Ram(this,1000,-42));
			addLineEnemys(SHOUTER, 1008, 2, 8, -42);
			enemyContainer.add(new Ram(this,1000,42));
			addLineEnemys(SHOUTER, 1008, 2, 8, 42);
	}                                                   
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

}
