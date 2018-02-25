package game.inter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import main.Panel;
import main.state.GameStateManager;
import main.state.LevelState;

public class DisplayWindow extends ModelInter {

	private Font font = new Font(
			"Arial",
			Font.PLAIN,
			10);
	
	private int[][] accelerator = {{0,0,1,0,0},{0,1,1,2,0},{1,1,1,2,3},{0,2,2,3,0},{0,0,3,0,0}};
	private int[][] aim = {{0,1,1,1,0},{1,0,2,0,1},{1,2,2,2,1},{1,0,2,0,1},{0,1,1,1,0}};
	private int[][] autoShooting = {{0,0,1,0,0},{0,0,1,0,0},{0,1,1,1,0},{1,0,1,0,1},{1,0,0,0,1}};
	private int[][] protector = {{3,3,3,3,3},{3,1,2,2,3},{3,1,2,2,3},{0,3,2,3,0},{0,0,3,0,0}};
	private int[][] twoBullet = {{3,0,0,0,3},{3,0,0,0,3},{3,2,0,2,3},{1,2,2,2,1},{0,1,2,1,0}};
	
	private Color interfaceColor = new Color(128,128,128);
	private Color interfaceColor2 = new Color(90,90,90);
	private Color strigColor = new Color(150,0,150);
	
	private int xDraw = 110;
	
	private ShoutRedy shoutRedy;
	private Heart heart;
	
	public DisplayWindow(GameStateManager gsm,LevelState ls) {
		super(gsm,ls);
		x = Panel.WIDTH;
		y = 0;
		width = Panel.LET_AREA_WIDTH-Panel.WIDTH;
		height = Panel.HEIGHT;
		shoutRedy = new ShoutRedy(gsm,ls,this);
		heart = new Heart(gsm,ls,this);
	}

	@Override
	public void update() {
		shoutRedy.update();
	}

	@Override
	public void draw(Graphics2D g) {
		int le = 14;
		
		g.setFont(font);
		g.setColor(interfaceColor);
		g.fillRect((int)x,(int)y,width,height);
		g.setColor(interfaceColor2);
		g.drawLine((int)x, (int)y, (int)x, height);
		
		//AIM
		if(gsm.aim==0) setColor(
				110,110,110,
				110,110,110,
				110,110,110);
		else  setColor(
				255,255,0,
				180,180,0,
				0,100,100);
		drawPixels(g,aim,xDraw,5);
		g.setColor(color);
		g.drawString(String.valueOf(gsm.aim), xDraw-8, 15);
		if(gsm.aim>0)g.drawString("Aim", xDraw-8, 25);
		g.setColor(strigColor);
		if(gsm.aim==3)g.drawString("max", xDraw+le, 15);
		if(gsm.aim>3)g.drawString("reserve", xDraw+le, 15);
		
		
		//AUTOSHOOTING
		if(gsm.skillAutoShooting==false)  setColor(
				110,110,110,
				110,110,110,
				110,110,110);
		else color = new Color(200,0,0);
		drawPixels(g,autoShooting,xDraw,29);
		g.setColor(color);
		if(gsm.skillAutoShooting==true)g.drawString("Autoshooting", xDraw-8, 49);
		g.setColor(strigColor);
		if(gsm.skillAutoShooting==true&&player.letAutoShooting==false&&gsm.aim>1)g.drawString("press \" z \"", xDraw+le, 39);
		else if(gsm.skillAutoShooting==true&&player.letAutoShooting&&gsm.aim>1)g.drawString("on", xDraw+le, 39);
		else if(gsm.skillAutoShooting==true&&player.letAutoShooting&&gsm.aim<=1)g.drawString("need aim", xDraw+le, 39);
		
		//ACCELERATOR
		setColor(
			255,150,0,
			200,100,0,
			150,50,0);
		drawPixels(g,accelerator,xDraw,53);
		g.setColor(color);
		g.drawString("Accelerator", xDraw-8,73);
		g.setColor(strigColor);
		String formattedDouble = new DecimalFormat("#0.00").format((float)gsm.timeMiddleShoutFinal/(float)Panel.FPS);
		String s = " sec";
		if(gsm.timeMiddleShoutFinal<=player.letMaxShootingSpeed)
			s = " max";
		g.drawString(formattedDouble+s, xDraw+le,63);
		
		//TWO BUULET
		if(gsm.twoBullet)
		{
			setColor(220,0,0,250,250,250,180,0,0);
		}
		else
		{
			setColor(110,110,110,110,110,110,110,110,110);
		}
		drawPixels(g,twoBullet,xDraw,77);
		g.setColor(Color.WHITE);
		if(gsm.twoBullet){
			g.setColor(Color.WHITE);
			g.drawString("Double gun", xDraw-8,97);
		}
		
		//SKILS PROTECTION
		 if(gsm.skillProtector>0)
		 {
			 setColor(0,255,255,0,160,160,0,100,100);
		 }
		 else
		 {
		 	setColor(110,110,110,110,110,110,110,110,110);
		 }
		 drawPixels(g,protector,xDraw,125);
		 g.setColor(color);
		 g.drawString(String.valueOf(gsm.skillProtector), xDraw-8, 135);
		 if(gsm.skillProtector>0){
		 	g.setColor(color);
		 	g.drawString("Skils protector", xDraw-8,145);
		 }
		
		shoutRedy.draw(g);
		heart.draw(g);
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReliased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	public void drawPixels(Graphics2D g, int[][] op, int xDraw, int yDraw){
		for(int i = 0;i<op.length;i++){
			for(int n = 0;n<op[i].length;n++){
				if(op[i][n]>0){
					if(op[i][n]==1)
						g.setColor(color);
					else if(op[i][n]==2)
						g.setColor(color2);
					else if(op[i][n]==3)
						g.setColor(color3);
					g.fillRect(n*2+xDraw, i*2+yDraw, 2, 2);
				}
			}
		}
	}

}
