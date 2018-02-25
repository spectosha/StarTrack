package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.state.GameStateManager;

public class Panel extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 99;
	public static final int HEIGHT = 200;
	public static final int LET_AREA_WIDTH = 170;
	public static final int SCALE = 3;
	
	private Thread thread;
	private boolean running = false;
	
	private GameStateManager gsm;
	
	private BufferedImage image;
	private Graphics2D g;
	
	public static int FPS = 20;
	private long targetTime = 1000/FPS;
	
	public Panel(){
		super();
		setPreferredSize(new Dimension(LET_AREA_WIDTH*SCALE+1, HEIGHT*SCALE+1));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify(){
		super.addNotify();
		if(thread==null){
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init(){
		image = new BufferedImage(
				LET_AREA_WIDTH,HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		
		gsm = new GameStateManager();
	}
	
	public void run(){
		init();
		
		long start;
		long elated;
		long wait;
		
		while(running){
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			
			elated = System.nanoTime()-start;
			wait = targetTime-elated/1000000;
			if(wait<0){
				wait = 5;
			}
			try{
				Thread.sleep(wait);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void update(){
		gsm.update();
	}
	
	private void draw(){
		gsm.draw(g);
	}
	
	private void drawToScreen(){
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, LET_AREA_WIDTH*SCALE, HEIGHT*SCALE, null);
		g2.dispose();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent key) {
		gsm.keyReliased(key.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
}
