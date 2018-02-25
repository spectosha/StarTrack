package main.state;

import game.object.bonus.Accelerator;
import game.object.bonus.Aim;
import game.object.bonus.AutoShooting;
import game.object.bonus.TakeHealth;
import game.object.enemy.LaserWallL;
import game.object.enemy.LaserWallR;
import game.object.enemy.Ram;
import game.object.enemy.Ram2;
import game.object.enemy.Titan;

public class Level_5 extends LevelSetings {

	public Level_5(GameStateManager gsm) {
		super(gsm, "  Level 5\nLaser tag.");
	}

	@Override
	public void go() {
		
		bonusContainer.add(new Aim(this, 0, 30));

		{// RIGHT AND LEFT
			enemyContainer.add(new LaserWallR(this, 20, 0, 430));

			enemyContainer.add(new Titan(this, 165, 34));
			addCircleEnemys(SHOUTER, 165, 8, 10, 34);
			enemyContainer.add(new Titan(this, 250, 20));
			addCircleEnemys(SHOUTER, 250, 8, 10, 20);
			enemyContainer.add(new Ram2(this, 300, 10, 1f));
			enemyContainer.add(new Ram2(this, 300, 21, 1.15f));
			enemyContainer.add(new Ram2(this, 300, 26, 1.25f));
			enemyContainer.add(new Ram2(this, 300, 32, 1.15f));
			enemyContainer.add(new Ram2(this, 300, 43, 1f));

			enemyContainer.add(new Ram(this, 370, 27)).setProtection(TITAN, 3, 18, 1f);
			;

			enemyContainer.add(new Ram(this, 200, -21));
			enemyContainer.add(new Ram(this, 210, -11));
			enemyContainer.add(new Ram(this, 220, -25));
			enemyContainer.add(new Ram(this, 240, -42));
			enemyContainer.add(new Ram(this, 250, -9));
			enemyContainer.add(new Ram(this, 270, -31));
			enemyContainer.add(new Titan(this, 290, -25));
		}
		{// RIGHT AND LEFT
			enemyContainer.add(new LaserWallR(this, 480, -30, 470));
			enemyContainer.add(new LaserWallL(this, 510, 30, 400));
			//MIDDLE
			enemyContainer.add(new Titan(this,530,0)).setProtection(TITAN, 3, 21, -0.5f);
			enemyContainer.add(new Titan(this,650,0));
			addCircleEnemys(TITAN, 650, 6, 15, 0);
			addLineEnemys(RAM2, 650, 2, 46, 0);
			
			enemyContainer.add(new Ram(this,690,18)).setProtection(SHOUTER, 1, 10, -1f);
			enemyContainer.add(new Ram(this,710,-2)).setProtection(SHOUTER, 1, 8, 1.2f);
			enemyContainer.add(new Ram(this,730,8)).setProtection(SHOUTER, 1, 12, -0.8f);
			enemyContainer.add(new Ram(this,750,-13)).setProtection(SHOUTER, 1, 14, 2f);
			enemyContainer.add(new Ram(this,770,-8)).setProtection(SHOUTER, 1, 9, -1.5f);
			enemyContainer.add(new Ram(this,790,18)).setProtection(SHOUTER, 1, 9, 0.7f);
			enemyContainer.add(new Ram(this,810,5)).setProtection(SHOUTER, 1, 12, 0.5f);
			enemyContainer.add(new Ram(this,830,-20)).setProtection(SHOUTER, 1, 13, -2.1f);
			enemyContainer.add(new Ram(this,850,18)).setProtection(SHOUTER, 1, 10, -1f);
			enemyContainer.add(new Ram(this,870,-2)).setProtection(SHOUTER, 1, 8, 1.2f);
			enemyContainer.add(new Ram(this,890,8)).setProtection(SHOUTER, 1, 12, -0.8f);
			enemyContainer.add(new Ram(this,910,-13)).setProtection(SHOUTER, 1, 14, 2f);
			
			//RIGHT
			enemyContainer.add(new Ram2(this,550,44,1f));
			enemyContainer.add(new Ram2(this,570,37,1f));
			enemyContainer.add(new Ram2(this,590,44,1f));
			enemyContainer.add(new Ram2(this,610,37,1f));
			enemyContainer.add(new Ram2(this,630,44,1f));
			enemyContainer.add(new Ram2(this,650,37,1f));
			
			addLineEnemys(RAM, 670, 3, 6, 40);
			addLineEnemys(RAM, 680, 3, 6, 40);
			addLineEnemys(RAM, 690, 3, 6, 40);
			addLineEnemys(RAM, 700, 3, 6, 40);
			addLineEnemys(RAM, 710, 3, 6, 40);
			addLineEnemys(RAM, 720, 3, 6, 40);
			addLineEnemys(RAM, 730, 3, 6, 40);
			
			bonusContainer.add(new Accelerator(this, 770, 40, Accelerator.X));
			//LEFT
			enemyContainer.add(new Titan(this,560,-44));
			enemyContainer.add(new Titan(this,600,-37));
			enemyContainer.add(new Titan(this,640,-44));
			                                      
			addLineEnemys(RAM, 670, 3, 6, -40);
			addLineEnemys(RAM, 680, 3, 6, -40);
			addLineEnemys(RAM, 690, 3, 6, -40);
			addLineEnemys(RAM, 700, 3, 6, -40);
			addLineEnemys(RAM, 710, 3, 6, -40);
			addLineEnemys(RAM, 720, 3, 6, -40);
			addLineEnemys(RAM, 730, 3, 6, -40);
			
			bonusContainer.add(new TakeHealth(this, 770, -40));
		}
		enemyContainer.add(new LaserWallR(this, 950, 25, 127));
		enemyContainer.add(new LaserWallL(this, 1050, -25, 127));
		enemyContainer.add(new LaserWallL(this, 1150, 29, 127));
		enemyContainer.add(new LaserWallR(this, 1250, -16, 307));
		enemyContainer.add(new LaserWallR(this, 1350, -44, 127));
		enemyContainer.add(new LaserWallR(this, 1550, -44, 127));
		enemyContainer.add(new LaserWallL(this, 1550, 36, 247));
		enemyContainer.add(new LaserWallR(this, 1650, -8, 127));
		enemyContainer.add(new LaserWallR(this, 1750, -40, 127));
		
		enemyContainer.add(new LaserWallR(this, 2000, 12, 247));
		enemyContainer.add(new LaserWallR(this, 2030, -16, 187));
		enemyContainer.add(new LaserWallR(this, 2060, -44, 127));
		enemyContainer.add(new Ram2(this, 2170, 42, 1f));
		enemyContainer.add(new Ram2(this, 2185, 42, 1f));
		enemyContainer.add(new Ram2(this, 2200, 42, 1f));
		
		enemyContainer.add(new LaserWallL(this, 2340, -14, 247));
		enemyContainer.add(new LaserWallL(this, 2370, 14, 187));
		enemyContainer.add(new LaserWallL(this, 2400, 42, 127));
		enemyContainer.add(new Ram2(this, 2510, -42, 1f));
		enemyContainer.add(new Ram2(this, 2525, -42, 1f));
		enemyContainer.add(new Ram2(this, 2540, -42, 1f));
		
		bonusContainer.add(new AutoShooting(this, 2650, 0));	
	}

	public void init() {

	}
}
