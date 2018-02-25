package main.state;



import game.object.bonus.Accelerator;
import game.object.bonus.Aim;
import game.object.bonus.EmptyBonus;
import game.object.bonus.SkillProtector;
import game.object.bonus.TakeHealth;
import game.object.bonus.TwoBullet;
import game.object.enemy.LaserWallL;
import game.object.enemy.Ram;
import game.object.enemy.Ram2;
import game.object.enemy.Shooter;
import game.object.enemy.Titan;

public class Level_6 extends LevelSetings{

	public Level_6(GameStateManager gsm) {
		super(gsm, " Level 6\n Dirty war");
	}

	@Override
	public void go() {
		enemyContainer.add(new Ram(this,0,0));
		
		bonusContainer.add(new EmptyBonus(this, 50, 0)).setProtectionOfBalls(6, 48, -1f, 1);
		bonusContainer.add(new EmptyBonus(this, 58, 0)).setProtectionOfBalls(6, 40, -1.05f, 1);
		bonusContainer.add(new EmptyBonus(this, 66, 0)).setProtectionOfBalls(6, 32, -1.1f, 1);
		bonusContainer.add(new EmptyBonus(this, 74, 0)).setProtectionOfBalls(6, 24, -1.15f, 1);
		bonusContainer.add(new EmptyBonus(this, 82, 0)).setProtectionOfBalls(6, 16, -1.2f, 1);
		bonusContainer.add(new EmptyBonus(this, 90, 0)).setProtectionOfBalls(6, 8,  -1.25f, 1);
		enemyContainer.add(new Shooter(this, 102, 0));
		
		
		bonusContainer.add(new EmptyBonus(this, 196, -20)).setProtection(RAM2, 6, 40, -1f);
		bonusContainer.add(new EmptyBonus(this, 204, -20)).setProtection(RAM2, 6, 32, -1f);
		bonusContainer.add(new EmptyBonus(this, 212, -20)).setProtection(RAM2, 6, 24, -1f);
		bonusContainer.add(new EmptyBonus(this, 220, -20)).setProtection(RAM2, 6, 16, -1f);
		bonusContainer.add(new EmptyBonus(this, 228, -20)).setProtection(RAM2, 6, 8, -1f);
		
		enemyContainer.add(new LaserWallL(this, 250, 25, 330));
		
		bonusContainer.add(new Accelerator(this, 330, 37, Accelerator.L));
		enemyContainer.add(new Ram2(this, 380, 42,	0.5f));
		enemyContainer.add(new Ram2(this, 380, 32,	0.5f));
		enemyContainer.add(new Ram2(this, 400, 42,	0.5f));
		enemyContainer.add(new Ram2(this, 400, 32,	0.5f));
		enemyContainer.add(new Ram2(this, 420, 42,	0.5f));
		enemyContainer.add(new Ram2(this, 420, 32,	0.5f));
		enemyContainer.add(new Ram2(this, 440, 42,	0.5f));
		enemyContainer.add(new Ram2(this, 440, 32,	0.5f));
		enemyContainer.add(new Ram2(this, 460, 42,	0.5f));
		enemyContainer.add(new Ram2(this, 460, 32,	0.5f));

		addRectangleEnemys(RAM,335, -13, 9, 8, 25);
		addCircleEnemys(TITAN, 380, 4, 20, -13);
		addRectangleEnemys(SHOUTER, 420, -13, 10, 5, 13);
		
		enemyContainer.add(new Ram2(this, 565, -11,1f));
		enemyContainer.add(new Ram2(this, 565, -29,1f));
		enemyContainer.add(new Ram2(this, 565, -47,1f));
		
		bonusContainer.add(new TakeHealth(this, 565, -37));
		bonusContainer.add(new Accelerator(this, 565, -19, Accelerator.M));
		bonusContainer.add(new Aim(this, 565, -2));
		
		enemyContainer.add(new Ram(this, 600, 20));
		enemyContainer.add(new Ram(this, 630, 24));
		enemyContainer.add(new Ram(this, 660, 16));
		
		addRectangleEnemys(RAM,582, -17, 9, 7, 25);
		bonusContainer.add(new Accelerator(this, 592, -25, Accelerator.M)).setProtectionOfBalls(3, 12, -4f, 3);
		bonusContainer.add(new Accelerator(this, 627, -7, Accelerator.M)).setProtectionOfBalls(3, 12, 4f, 3);
		bonusContainer.add(new Accelerator(this, 662, -25, Accelerator.M)).setProtectionOfBalls(3, 12, -4f, 3);
		bonusContainer.add(new Accelerator(this, 697, -7, Accelerator.M)).setProtectionOfBalls(3, 12, 4f, 3);
		bonusContainer.add(new Accelerator(this, 732, -25, Accelerator.M)).setProtectionOfBalls(3, 12, -4f, 3);
		
		addRectangleEnemys(RAM,690, 37, 9, 3, 13);
		enemyContainer.add(new Ram2(this, 750,20,1.5f));
		enemyContainer.add(new Ram2(this, 760,20,1.5f));
		enemyContainer.add(new Ram2(this, 770,20,1.5f));
		enemyContainer.add(new Ram2(this, 780,20,1.5f));
		
		bonusContainer.add(new Accelerator(this, 726, 37, Accelerator.S));
		bonusContainer.add(new Accelerator(this, 735, 37, Accelerator.S));
		bonusContainer.add(new Accelerator(this, 744, 37, Accelerator.S));
		bonusContainer.add(new Accelerator(this, 753, 37, Accelerator.S));
		bonusContainer.add(new Accelerator(this, 762, 37, Accelerator.S));
		
		bonusContainer.add(new TwoBullet(this, 900, 0));
		
		enemyContainer.add(new Ram2(this,1000,-28,1f)).setProtectionOfBalls(20, 20, -4f, 5);
		enemyContainer.add(new Ram2(this,1000,28,1f)).setProtectionOfBalls(20, 20, 4f, 5);
		addRectangleEnemys(RAM,1100, 0, 10, 10, 16);
		addRectangleEnemys(RAM,1110, 0, 10, 8, 14);
		addRectangleEnemys(RAM,1120, 0, 10, 6, 12);
		addRectangleEnemys(RAM,1130, 0, 10, 4, 10);
		addRectangleEnemys(RAM,1140, 0, 10, 2, 8);
		
		enemyContainer.add(new Titan(this,1350,0)).setProtectionOfBalls(20, 200, -0.8f, 1);
		bonusContainer.add(new SkillProtector(this, 1360, 0)).setProtectionOfBalls(20, 190, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1380,0)).setProtectionOfBalls(20, 170, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1400,0)).setProtectionOfBalls(20, 150, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1410,0)).setProtectionOfBalls(20, 140, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1420,0)).setProtectionOfBalls(20, 130, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1440,0)).setProtectionOfBalls(20, 110, -0.8f, 1);
		
		bonusContainer.add(new EmptyBonus(this,1450,0)).setProtectionOfBalls(20, 100, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1460,0)).setProtectionOfBalls(20, 90, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1470,0)).setProtectionOfBalls(20, 80, -0.8f, 1);
		bonusContainer.add(new EmptyBonus(this,1480,0)).setProtectionOfBalls(20, 70, -0.8f, 1);
		
		addCircleEnemys(SHOUTER, 1950, 7, 10, -37);
		addCircleEnemys(SHOUTER, 1950, 3, 10, -37);
		addCircleEnemys(SHOUTER, 1950, 7, 10, 37);
		addCircleEnemys(SHOUTER, 1950, 3, 10, 37);
		
		addRectangleEnemys(RAM2, 1900, 0, 10, 5, 12);
		addRectangleEnemys(RAM2, 1910, 0, 10, 3, 10);
		addLineEnemys(RAM2, 2020, 5, 10, 0);
		bonusContainer.add(new TakeHealth(this, 1950, 0));
		bonusContainer.add(new Accelerator(this, 1960, 0, Accelerator.M));
		bonusContainer.add(new Aim(this, 1970, 0));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
