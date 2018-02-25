package game.inter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.Panel;
import main.state.GameStateManager;
import main.state.LevelState;

public class LevelName extends ModelInter {

	private Font font;
	private int sizeFont = 6;
	
	private String[] s;
	private int[] xInt;
	private int colorPoint = 255;
	
	public LevelName(GameStateManager gsm, LevelState ls) {
		super(gsm,ls);
		font = new Font(
				"Arial",
				Font.PLAIN,
				sizeFont*2
				);
		frame = 75;
		x = 0;
		y = 50;
		s = ls.name.split("\n");
		xInt = new int[s.length];
		for(int i = 0;i<s.length;i++){
			xInt[i] = (Panel.WIDTH-(sizeFont*s[i].length()))/2+4;
		}

	}

	@Override
	public void update() {
		frame--;
		color = new Color(colorPoint,colorPoint,colorPoint);
		if(frame<15&&frame>0){
			colorPoint-=colorPoint/frame;
		}
		
	}

	@Override
	public void draw(Graphics2D g) {
		if(frame>0){
			g.setFont(font);
			g.setColor(color);
			for(int i = 0;i<xInt.length;i++){
				g.drawString(s[i],x+xInt[i], y+i*12);
			}
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReliased(int k) {
		// TODO Auto-generated method stub
		
	}

}
