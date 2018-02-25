package main.state;

import game.object.bonus.Accelerator;
import game.object.bonus.TakeHealth;
import game.object.enemy.BossOne;
import game.object.enemy.Ram;
import game.object.enemy.Ram2;
import game.object.enemy.Titan;

public class Level_3 extends LevelSetings {

	public Level_3(GameStateManager gsm) {
		super(gsm, "Level 3 \nWarning!  \nIt's danger!");
	}

	@Override
	public void go() {
		
		addCircleEnemys(SHOUTER, 52, 25, 13, 0);
		enemyContainer.add(new Ram2(this,60,0,1.1f));
		bonusContainer.add(new TakeHealth(this,50,-35));
		bonusContainer.add(new Accelerator(this,50,35,Accelerator.M));
		
		addLineEnemys(TITAN, 140, 2, 70,0);
		
		addRectangleEnemys(RAM, 180, 0, 10, 5, 5);
		enemyContainer.add(new Titan(this,200,0));
		bonusContainer.add(new TakeHealth(this,210,0));
		enemyContainer.add(new Ram(this,240,15)).setProtection(RAM,5,15,3);
		enemyContainer.add(new Ram(this,260,-15)).setProtection(RAM,5,15,3);;
		addLineEnemys(SHOUTER, 320, 1, 10, 0);
		addLineEnemys(SHOUTER, 330, 2, 10, 0);
		addLineEnemys(SHOUTER, 340, 3, 10, 0);
		addLineEnemys(SHOUTER, 350, 4, 10, 0);
		addLineEnemys(SHOUTER, 360, 5, 10, 0);
		addLineEnemys(SHOUTER, 370, 6, 10, 0);
		addLineEnemys(SHOUTER, 380, 7, 10, 0);
		addLineEnemys(SHOUTER, 390, 8, 10, 0);
		addLineEnemys(SHOUTER, 400, 10, 10, 0);
		addLineEnemys(SHOUTER, 410, 10, 10, 0);
		
		enemyContainer.add(new Ram2(this,500,-40,1.4f));
		enemyContainer.add(new Ram2(this,500,-20,1.2f));
		enemyContainer.add(new Ram2(this,500,0,1.0f));
		enemyContainer.add(new Ram2(this,500,20,1.2f));
		enemyContainer.add(new Ram2(this,500,40,1.4f));
		enemyContainer.add(new Ram(this,480,-30));
		enemyContainer.add(new Ram(this,480,-10));
		enemyContainer.add(new Ram(this,480,30));
		enemyContainer.add(new Ram(this,480,10));
		bonusContainer.add(new Accelerator(this,510,0,Accelerator.M));
		enemyContainer.add(new Ram(this,550));
		enemyContainer.add(new Ram(this,555));
		enemyContainer.add(new Ram(this,560));
		enemyContainer.add(new Ram(this,565));
		enemyContainer.add(new Ram(this,570));
		enemyContainer.add(new Ram(this,575));
		enemyContainer.add(new Ram(this,580));
		enemyContainer.add(new Ram(this,585));
		enemyContainer.add(new Ram(this,590));
		enemyContainer.add(new Ram(this,595));
		enemyContainer.add(new Ram(this,600));
		enemyContainer.add(new Ram(this,605));
		enemyContainer.add(new Ram(this,610));
		enemyContainer.add(new Ram(this,615));
		enemyContainer.add(new Ram(this,620));
		enemyContainer.add(new Ram(this,625));
		enemyContainer.add(new Ram(this,630));
		enemyContainer.add(new Ram(this,635));
		enemyContainer.add(new Ram(this,640));
		enemyContainer.add(new Ram(this,645));
		enemyContainer.add(new Ram(this,650));
		
		int l;
		if(Math.random()>0.5){
			l = 1;
		}else{
			l = -1;
		}
		
		addLineEnemys(SHOUTER, 680, 10, 8, 10*l);
		addLineEnemys(SHOUTER, 690, 10, 8, 10*l);
		addLineEnemys(SHOUTER, 700, 10, 8, 10*l);
		addLineEnemys(RAM, 710, 10, 8, 10*l);
		addLineVertical(RAM,720,11,10, 46*l);
		
		addLineVertical(RAM,710,2,10, -46*l);
		addLineEnemys(RAM, 730, 10, 8, -10*l);
		addLineVertical(RAM,740,7,10, 26*l);
		
		addLineEnemys(RAM, 810, 10, 8, -10*l);
		addLineEnemys(RAM, 830, 10, 8, 10*l);
		addLineVertical(RAM,820,2,10, -46*l);
		addLineEnemys(RAM, 840, 10, 8, 10*l);
		addLineEnemys(RAM, 850, 10, 8, 10*l);
		addLineEnemys(RAM, 860, 10, 8, 10*l);
		
		bonusContainer.add(new Accelerator(this,735,-12*l, Accelerator.L)).setProtection(RAM,18,32,-1.2f);
		//Подкрепление

		int s = 3;
		enemyContainer.add(new BossOne(this,1100)).setProtection(TITAN,s,34,1);
		for(int i = 0;i<s;i++){
			enemyContainer.get(enemyContainer.size()-1-i).timeShout = 1200;
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
