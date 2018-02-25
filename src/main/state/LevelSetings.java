package main.state;

import game.object.enemy.Enemy;
import game.object.enemy.ProtectorBall;
import game.object.enemy.Ram;
import game.object.enemy.Ram2;
import game.object.enemy.Shooter;
import game.object.enemy.Titan;

public abstract class LevelSetings extends LevelState {

	public final int RAM = 0;
	public final int SHOUTER = 1;
	public final int TITAN = 2;
	public final int RAM2 = 3;
	public final int BALL = 4;
	public LevelSetings(GameStateManager gsm, String name) {
		super(gsm, name);
	}
	
	/**
	 * ������� ����������� ������� �� �����.
	 * addCircleEnemys(int type, int time, int number, int step, int offset)
	 * @param type ��� ���������� �������
	 * @param time - ����� ��������� ������
	 * @param number - ���������� ������ � �����
	 * @param step - ��� ����� �������� ������� �� ����������
	 * @param offset - �������� �� X
	 */
	public void addCircleEnemys(int type, int time, int number, int step, int offset){
		int longAround = step*number;
		float angle = (float) (Math.PI*2/number);
		float radius = (float) (longAround/(2*Math.PI));
		for(int i = 0;i<number;i++){
			int xSet = (int) (Math.cos(i*angle+Math.PI/2)*radius);
			int ySet = (int) (Math.sin(i*angle+Math.PI/2)*radius);
			enemyContainer.add(getType(type,time-ySet,offset-xSet));
		}
	}
	
	/**
	 * ������� ����������� ������� � ����� gj ujhbpjynfkb.
	 * addLineEnemys(int type, int frame,int number, int step, int middle)
	 * @param type - ��� �������
	 * @param frame - ����� ���������
	 * @param number - ���������� ������ � �����
	 * @param step - ���������� ����� ���������
	 * @param middle - ����� �����
	 */
	public void addLineEnemys(int type, int frame,int number, int step, int middle){
		int bothLength = (number*step)/2-(int)(step*0.5);
		for(int i = 0;i<number;i++){
			enemyContainer.add(getType(type,frame,middle+(i*step)-bothLength));
		}
	}
	
	/**
	 * ������� ����������� ������� � ����� �� ���������.
	 * addLineEnemys(int type, int frame,int number, int step, int middle)
	 * @param type - ��� �������
	 * @param frame - ����� ��������� ������� �������
	 * @param number - ���������� ������ � �����
	 * @param step - ���������� ����� ���������
	 * @param offset- ����� �����
	 */
	public void addLineVertical(int type, int frame,int number, int step, int offset){
		for(int i = 0;i<number;i++){
			enemyContainer.add(getType(type,frame+step*i,offset));
		}
	}
	/**
	 * 
	 * @param type
	 * @param frame
	 * @param number
	 * @param step
	 * @param xStart
	 * @param xEnd
	 */
	public void addFreeLine(int type, int frame, int step, int xStart,int xEnd, int yEnd){
		float W = xEnd-xStart;
		float H = yEnd;
		float G = (float)Math.sqrt(H*H+W*W);
		int number = Math.round(G/step);
		float xSet = W/G;
		float ySet = H/G;
		for(int i = 0; i<number; i++){
			int yP = (int)(frame+ySet*i*step);
			int xP = (int)(xStart+xSet*step*i);
			enemyContainer.add(getType(type,yP,xP));
		}
	}
	
	/**
	 * 
	 * @param type - ��� ��������
	 * @param frame - ����
	 * @param offset - ��������
	 * @param step - ��� ��������
	 * @param width - ������
	 * @param height - ������
	 */
	public void addRectangleEnemys(int type, int frame, int offset, int step, int width, int height){
		int bothLength = (width*step)/2-(int)(step*0.5);
		for(int i = 0;i<width;i++){
			enemyContainer.add(getType(type,frame+(height-1)*step,offset+(i*step)-bothLength));
			enemyContainer.add(getType(type,frame,offset+(i*step)-bothLength));
		}
		for(int i = 1;i<height-1;i++){
			enemyContainer.add(getType(type,frame+i*step,offset-bothLength));
			enemyContainer.add(getType(type,frame+i*step,offset+bothLength));
		}
	}
	
	public Enemy getType(int type, int frame, int xStart){
		if(type == RAM){
			return new Ram(this,frame,xStart);
		}else if(type == SHOUTER){
			return new Shooter(this,frame,xStart);
		}else if(type == TITAN){
			return new Titan(this,frame,xStart);
		}else if(type == RAM2){
			return new Ram2(this,frame,xStart,1f);
		}else if(type == BALL){
			return new ProtectorBall(this,frame,xStart,1);
		}
		return null;
	}
	
	@Override
	public abstract void go();
	public abstract void init();
}
