package main.state;

import game.object.bonus.Accelerator;
import game.object.bonus.Aim;
import game.object.bonus.EmptyBonus;
import game.object.bonus.SkillProtector;
import game.object.bonus.TakeHealth;
import game.object.enemy.Ram2;
import game.object.enemy.Titan;

public class Level_4 extends LevelSetings {

	public Level_4(GameStateManager gsm) {
		super(gsm, "Level 4\n   Wall of the\nsheeps  ");
	}

	@Override
	public void go() {
		bonusContainer.add(new Accelerator(this, 20, 0, Accelerator.L)).setProtection(SHOUTER, 28, 48, -0.4f);
		bonusContainer.add(new EmptyBonus(this, 44, 0)).setProtection(SHOUTER, 14, 24, 0.8f);
		
		addRectangleEnemys(RAM, 140, 0, 10, 10, 140);

		enemyContainer.add(new Titan(this, 250, 0)).setProtection(RAM2, 4, 32, 3);

		enemyContainer.add(new Ram2(this, 260, 35, 1.5f));
		enemyContainer.add(new Ram2(this, 260, -35, 1.5f));

		bonusContainer.add(new Accelerator(this, 362, 0, Accelerator.L)).setProtection(RAM, 8, 35, 1.5f);
		addCircleEnemys(SHOUTER, 400, 12, 12, 0);
		addLineEnemys(TITAN, 400, 2, 20, 0);

		bonusContainer.add(new TakeHealth(this, 440, 0));
		addRectangleEnemys(RAM, 460, 0, 10, 8, 107);
		
		bonusContainer.add(new Aim(this, 520, 0)).setProtection(TITAN, 3, 22, 1);

		enemyContainer.add(new Titan(this, 600, 12));
		enemyContainer.add(new Titan(this, 620, -15));
		enemyContainer.add(new Titan(this, 640, -8));
		enemyContainer.add(new Titan(this, 660, 24));
		enemyContainer.add(new Titan(this, 680, 18));
		enemyContainer.add(new Titan(this, 700, -19));
		enemyContainer.add(new Titan(this, 720, 14));
		enemyContainer.add(new Titan(this, 740, -14));
		enemyContainer.add(new Titan(this, 760, -8));
		
		bonusContainer.add(new TakeHealth(this, 780, 0));
		addRectangleEnemys(RAM, 800, 0, 10, 6, 72);

		enemyContainer.add(new Ram2(this, 845, 0, 1f)).setProtection(SHOUTER, 6, 14, 1);
		addLineVertical(RAM, 890, 10, 9, 0);
		
		addLineVertical(RAM, 990, 18, 10, 0);
		int l;
		if(Math.random()>0.5){
			l = 1;
		}else{
			l = -1;
		}
		enemyContainer.add(new Ram2(this, 1140, -12*l, 1.5f));
		bonusContainer.add(new Accelerator(this, 1140, 12*l, Accelerator.M));
		
		bonusContainer.add(new TakeHealth(this, 1180, 0));
		addRectangleEnemys(RAM, 1200, 0, 10, 4, 31);

		enemyContainer.add(new Ram2(this, 1250, 7, 1f));
		enemyContainer.add(new Ram2(this, 1300, -7, 2f));

		enemyContainer.add(new Titan(this, 1350, -5));
		enemyContainer.add(new Titan(this, 1420, 5));
		
		bonusContainer.add(new SkillProtector(this, 1490, 0));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
