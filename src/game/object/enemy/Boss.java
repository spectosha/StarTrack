package game.object.enemy;

import java.awt.Color;

import main.Panel;
import main.state.LevelSetings;

public abstract class Boss extends Enemy {



	public int maxHealth;

	public float step = 1.4f;
	public float startSpeed = 1f;
	//Выход боса
	public boolean bossHere = false;
	//Бос начинает движение и атаку
	public boolean bossAttac = false;
	//Переключение между двумя типами аттаки
	public boolean firstAttac = true;
	//Небольшее ожидание между атаками
	public int waitAttac = 20,waitAttacMax = waitAttac;
	
	public int puskTitan = 50, puskTitanMax = puskTitan;
	
	//Стрельба из лазера
	public boolean laserTag = false;
	//Время стрельбы из лазера
	public int laserTime = 300, laserTimeMax = laserTime;
	//Время до следующей стрельбы из лазера
	public int laserTimeWait = 80, laserTimeWaitMax = laserTimeWait;
	public int laserXMax = 80;
	public int laserX, laserXEnd = laserXMax;
	public int laserY, laserYEnd = Panel.HEIGHT;

	public Boss(LevelSetings ls, int frame) {
		super(ls, frame);
		common();
	}

	public void comeIn() {
		if (step > 0.05) {
			y += step;
			step -= 0.01f;
			player.resolutionMove = false;
		} else {
			player.resolutionMove = true;
			bossAttac = true;
		}
	}

	public boolean setRadiusProtection(float value) {
		if (radiusProtection >= value-2 && radiusProtection <= value+2 || radiusProtection >= 50 || radiusProtection <= 10) {
			return true;
		}else{
			radiusChange((value-radiusProtection)*0.03f);
			return false;
		}
	}
	
	public boolean goToPosition(int xEnd, int yEnd) {
		if (x<xEnd+2&&x>xEnd-2&&y<yEnd+2&&y>yEnd-2) {
			vector[0] = 0;
			vector[1] = 0;

			return true;
		}else{
			float k1 = xEnd-x;
			float k2 = yEnd-y;
			double G = Math.sqrt(k1*k1+k2*k2);
			vector[0] = (float) (k1/G*speed);
			vector[1] = (float) (k2/G*speed);
			return false;
		}
	}

	public abstract void firstAttac();

	public abstract void secondAttac();

	@Override
	public abstract void common();

	public void update(){
		super.update();
	}
}
