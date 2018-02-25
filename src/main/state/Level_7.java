package main.state;

import game.object.bonus.Accelerator;
import game.object.bonus.Aim;
import game.object.bonus.AutoShooting;
import game.object.bonus.EmptyBonus;
import game.object.bonus.SkillProtector;
import game.object.bonus.TakeHealth;
import game.object.bonus.TwoBullet;
import game.object.enemy.EmptyEnemy;
import game.object.enemy.LaserWallR;
import game.object.enemy.Ram;
import game.object.enemy.Ram2;
import game.object.enemy.Titan;
import game.object.enemy.Vizarius;

public class Level_7 extends LevelSetings{

	public Level_7(GameStateManager gsm) {
		super(gsm, "Level 7\n I have\na greencard ");
	}

	@Override
	public void go() {
		/*
		enemyContainer.add(new Ram2(this,0,20,1f)).setProtectionOfBalls(40, 20, 5, 3);
		enemyContainer.add(new Ram2(this,50,-15,1.3f)).setProtectionOfBalls(40, 20, 3, 2);
		enemyContainer.add(new Ram2(this,100,35,1.6f)).setProtectionOfBalls(40, 20, -2, 6);
		
		addFreeLine(SHOUTER,140,9,-35,-10,0);
		addFreeLine(RAM2,150,10,-45,35,80);
		addFreeLine(RAM2,150,10,-5,55,63);
		addFreeLine(RAM2,240,10,50,-20,70);
		addFreeLine(RAM2,230,10,25,-55,80);
		addFreeLine(SHOUTER,310,9,-40,-15,0);
		
		enemyContainer.add(new Ram(this, 330));
		enemyContainer.add(new Ram(this, 335));
		enemyContainer.add(new Ram(this, 340));
		enemyContainer.add(new Ram(this, 345));
		enemyContainer.add(new Ram(this, 350));
		enemyContainer.add(new Ram(this, 355));
		enemyContainer.add(new Ram(this, 360));
		enemyContainer.add(new Ram(this, 365));
		enemyContainer.add(new Ram(this, 370));
		enemyContainer.add(new Ram(this, 375));
		enemyContainer.add(new Ram(this, 380));
		enemyContainer.add(new Ram(this, 385));
		enemyContainer.add(new Ram(this, 390));
		enemyContainer.add(new Ram(this, 395));
		enemyContainer.add(new Ram(this, 400));
		enemyContainer.add(new Ram(this, 405));
		
		bonusContainer.add(new EmptyBonus(this, 412, -28)).setProtection(RAM2, 6, 24, -1.5f);
		bonusContainer.add(new EmptyBonus(this, 420, -28)).setProtection(RAM2, 6, 16, -1.5f);
		bonusContainer.add(new EmptyBonus(this, 428, -28)).setProtection(RAM2, 6, 8, -1.5f);
		
		bonusContainer.add(new Aim(this,440,0));

		bonusContainer.add(new EmptyBonus(this, 412, 28)).setProtection(RAM2, 6, 24, 1.5f);
		bonusContainer.add(new EmptyBonus(this, 420, 28)).setProtection(RAM2, 6, 16, 1.5f);
		bonusContainer.add(new EmptyBonus(this, 428, 28)).setProtection(RAM2, 6, 8, 1.5f);
		
		
		bonusContainer.add(new EmptyBonus(this, 496, 25)).setProtection(RAM2, 6, 40, 2f);
		bonusContainer.add(new EmptyBonus(this, 504, 25)).setProtection(RAM2, 6, 32, 2f);
		bonusContainer.add(new EmptyBonus(this, 512, 25)).setProtection(RAM2, 6, 24, 2f);
		bonusContainer.add(new EmptyBonus(this, 520, 25)).setProtection(RAM2, 6, 16, 2f);
		bonusContainer.add(new EmptyBonus(this, 528, 25)).setProtection(RAM2, 6, 8, 2f);
		
		bonusContainer.add(new EmptyBonus(this, 572, -13)).setProtection(RAM2, 6, 32, -2f);
		bonusContainer.add(new EmptyBonus(this, 580, -13)).setProtection(RAM2, 6, 24, -2f);
		bonusContainer.add(new EmptyBonus(this, 588, -13)).setProtection(RAM2, 6, 16, -2f);
		bonusContainer.add(new EmptyBonus(this, 596, -13)).setProtection(RAM2, 6, 8, -2f);
		
		bonusContainer.add(new EmptyBonus(this, 636, 25)).setProtection(RAM2, 6, 40, 2f);
		bonusContainer.add(new EmptyBonus(this, 644, 25)).setProtection(RAM2, 6, 32, 2f);
		bonusContainer.add(new EmptyBonus(this, 652, 25)).setProtection(RAM2, 6, 24, 2f);
		bonusContainer.add(new EmptyBonus(this, 660, 25)).setProtection(RAM2, 6, 16, 2f);
		bonusContainer.add(new EmptyBonus(this, 668, 25)).setProtection(RAM2, 6, 8, 2f);
		
		int k = (int) (Math.random()*98-44);
		bonusContainer.add(new Accelerator(this,800,k,Accelerator.X));
		enemyContainer.add(new Titan(this,800,k));
		
		bonusContainer.add(new EmptyBonus(this, 882, 0)).setProtectionOfBalls(40, 48, -1f, 1);
		bonusContainer.add(new EmptyBonus(this, 890, 0)).setProtection(RAM2, 3, 40, 2f);
		bonusContainer.add(new EmptyBonus(this, 898, 0)).setProtection(RAM2, 3, 32, 2f);
		bonusContainer.add(new EmptyBonus(this, 906, 0)).setProtection(RAM2, 3, 24, 2f);
		bonusContainer.add(new EmptyBonus(this, 914, 0)).setProtection(RAM2, 3, 16, 2f);
		bonusContainer.add(new EmptyBonus(this, 922, 0)).setProtection(RAM2, 3, 8, 2f);
		
		bonusContainer.add(new AutoShooting(this,1030,-5));
		bonusContainer.add(new EmptyBonus(this, 1010, 0)).setProtection(TITAN, 2, 20, 2f);
		bonusContainer.add(new TwoBullet(this,1030,5));
		
		addRectangleEnemys(BALL, 1150, 0, 6, 15, 15);
		bonusContainer.add(new TakeHealth(this,1190 , -5));
		bonusContainer.add(new TakeHealth(this,1190 , 5));
		
		enemyContainer.add(new Ram(this, 1260)).setProtection(RAM, 2, 10, 0.5f);
		enemyContainer.add(new Ram(this, 1265)).setProtection(RAM, 2, 10, -0.5f);;
		enemyContainer.add(new Ram(this, 1270)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1275)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1280)).setProtection(RAM, 2, 10, -0.5f);;
		enemyContainer.add(new Ram(this, 1285)).setProtection(RAM, 2, 10, -0.5f);;
		enemyContainer.add(new Ram(this, 1290)).setProtection(RAM, 2, 10, 0.8f);;
		enemyContainer.add(new Ram(this, 1295)).setProtection(RAM, 2, 10, 0.8f);;
		enemyContainer.add(new Ram(this, 1300)).setProtection(RAM, 2, 10, -0.5f);;
		enemyContainer.add(new Ram(this, 1305)).setProtection(RAM, 2, 10, -0.5f);;
		enemyContainer.add(new Ram(this, 1330)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1335)).setProtection(RAM, 2, 10, -0.8f);;
		enemyContainer.add(new Ram(this, 1340)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1345)).setProtection(RAM, 2, 10, -0.5f);;
		enemyContainer.add(new Ram(this, 1350)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1355)).setProtection(RAM, 2, 10, -0.8f);;
		enemyContainer.add(new Ram(this, 1360)).setProtection(RAM, 2, 10, -0.8f);;
		enemyContainer.add(new Ram(this, 1365)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1370)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1375)).setProtection(RAM, 2, 10, -0.8f);;
		enemyContainer.add(new Ram(this, 1380)).setProtection(RAM, 2, 10, 0.9f);;
		enemyContainer.add(new Ram(this, 1385)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1390)).setProtection(RAM, 2, 10, -0.5f);;
		enemyContainer.add(new Ram(this, 1395)).setProtection(RAM, 2, 10, 0.5f);;
		enemyContainer.add(new Ram(this, 1400)).setProtection(RAM, 2, 10, -0.4f);;
		enemyContainer.add(new Ram(this, 1405)).setProtection(RAM, 2, 10, -0.5f);;
		
		bonusContainer.add(new SkillProtector(this,1500 , 0));
		
		enemyContainer.add(new EmptyEnemy(this, 1700, 0)).setProtectionOfBalls(20, 40, -0.8f, 1);
		enemyContainer.add(new EmptyEnemy(this, 1710, 0)).setProtectionOfBalls(12, 30, 0.8f, 1);
		enemyContainer.add(new EmptyEnemy(this, 1720, 0)).setProtectionOfBalls(8, 20, -0.8f, 1);
		enemyContainer.add(new EmptyEnemy(this, 1730, 0)).setProtectionOfBalls(4, 10, 0.8f, 1);
		
		enemyContainer.add(new EmptyEnemy(this, 1810, -20)).setProtectionOfBalls(8, 10, 0.8f, 8);
		enemyContainer.add(new EmptyEnemy(this, 1840, 29)).setProtectionOfBalls(4, 20, -0.8f, 5);
		
		bonusContainer.add(new Accelerator(this, 1890, 34, Accelerator.X)).setProtectionOfBalls(4, 30, -0.8f, 3);
		bonusContainer.add(new TakeHealth(this, 1930, -12)).setProtectionOfBalls(3, 15, 0.4f, 4);
		
		enemyContainer.add(new Ram(this,1600,45)).setProtectionOfBalls(20, 200, -0.7f, 10);
		enemyContainer.add(new Ram(this,1600,-45)).setProtectionOfBalls(20, 200, 0.7f, 10);
		*/
		enemyContainer.add(new Vizarius(this, 0)).setProtectionOfBalls(30, 20, 5f, 2);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
