package PongCombat;



import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;



public class Game extends Canvas implements Runnable {
	
	
	public static JFrame frame;
	private Thread thread;
	private static boolean isRunning = false;
	private final int WIDTH = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 4;
	
	public Game ()
	{
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.start();

	}
	
	
	public synchronized void start ()
	{
		thread = new Thread(this);
		thread.start();
		setRunning(true);
		
	}
	
	
	public synchronized void stop ()
	{
		
	}
	
	
	
	public void initFrame()
	{
		frame = new JFrame("PongCombat");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void tick() 
	{
		
	}
	
	
	public void render()
	{
		
	}
	
	
	public void run()
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		
		while(isRunning()) {
			long now = System.nanoTime();
			delta+= (now - lastTime)/ns;
			
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		
	}

	public static boolean isRunning() {
		return isRunning;
	}

	public static void setRunning(boolean isRunning) {
		Game.isRunning = isRunning;
	}

}
