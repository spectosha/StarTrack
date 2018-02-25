package game.object;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Panel;
import main.state.GameStateManager;
import main.state.LevelState;

public abstract class DrawObject {

	public LevelState ls;
	public GameStateManager gsm;
	public Player player;
	public int frame = 0;
	public float x = 0;
	public float y = 0;
	public int width = 0;
	public int height = 0;
	public int xStart = 0;
	public int yStart = -5;
	public int[][] objectPixels = new int[0][0];
	public Color color;// = Color.WHITE;
	public Color color2;// = Color.GRAY;
	public Color color3;// = Color.BLACK;
	public Color color4;
	public Color color5;
	public Color color6;
	
	public int white = 0;
	public int whiteMax = 5;
	
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void keyReliased(int k);

	public int[][] getPixels() {
		return objectPixels;
	}
	
	public void setColor(
			int r1, int g1, int b1,
			int r2, int g2, int b2,
			int r3, int g3, int b3){
		color = new Color(
				r1+((250-r1)/whiteMax)*white,
				g1+((250-g1)/whiteMax)*white,
				b1+((250-b1)/whiteMax)*white);
		color2 = new Color(
				r2+((250-r2)/whiteMax)*white,
				g2+((250-g2)/whiteMax)*white,
				b2+((250-b2)/whiteMax)*white);
		color3 = new Color(
				r3+((250-r3)/whiteMax)*white,
				g3+((250-g3)/whiteMax)*white,
				b3+((250-b3)/whiteMax)*white);
	}
	

	public void setColor(int r1, int g1, int b1, int r2, int g2, int b2, int r3, int g3, int b3, int r4, int g4, int b4,
			int r5, int g5, int b5, int r6, int g6, int b6) {
		color = new Color(
				r1+((250-r1)/whiteMax)*white,
				g1+((250-g1)/whiteMax)*white,
				b1+((250-b1)/whiteMax)*white);
		color2 = new Color(
				r2+((250-r2)/whiteMax)*white,
				g2+((250-g2)/whiteMax)*white,
				b2+((250-b2)/whiteMax)*white);
		color3 = new Color(
				r3+((250-r3)/whiteMax)*white,
				g3+((250-g3)/whiteMax)*white,
				b3+((250-b3)/whiteMax)*white);
		color4 = new Color(
				r4+((250-r4)/whiteMax)*white,
				g4+((250-g4)/whiteMax)*white,
				b4+((250-b4)/whiteMax)*white);
		color5 = new Color(
				r5+((250-r5)/whiteMax)*white,
				g5+((250-g5)/whiteMax)*white,
				b5+((250-b5)/whiteMax)*white);
		color6 = new Color(
				r6+((250-r6)/whiteMax)*white,
				g6+((250-g6)/whiteMax)*white,
				b6+((250-b6)/whiteMax)*white);
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public boolean getEdge(){
		return y>Panel.HEIGHT+height||x>Panel.WIDTH||x<0;
	}

	public void drawPixels(Graphics2D g){
		for(int i = 0;i<objectPixels.length;i++){
			for(int n = 0;n<objectPixels[i].length;n++){
				if(objectPixels[i][n]>0){
					if(objectPixels[i][n]==1)
						g.setColor(color);
					else if(objectPixels[i][n]==2)
						g.setColor(color2);
					else if(objectPixels[i][n]==3)
						g.setColor(color3);
					g.fillRect(n+(int)x, i+(int)y, 1, 1);
				}
			}
		}
	}
	
}
