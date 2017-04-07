package com.spikerex.venture;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.spikerex.venture.entity.clickable.treeEntity;
import com.spikerex.venture.entity.mob.Player;
import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.input.Keyboard;
import com.spikerex.venture.input.Mouse;
import com.spikerex.venture.level.Level;
import com.spikerex.venture.level.PerlinLevel;

public class Main extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3022930815135072191L;
	public final static int WIDTH = 300;
	public final static int HEIGHT = WIDTH / 16 * 9;
	public final static String TITLE = "Venture";
	public final static int SCALE = 3;
	public final static Random rand = new Random();

	private Thread thread;
	private boolean running = false;
	public Screen screen;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private JFrame frame;
	public Keyboard key;
	public Level level;
	public Player player;
	public Mouse mouse;
	public static Main game;
	public static void main(String[] args) {
		game = new Main();
		game.frame = new JFrame();
		game.frame.setResizable(false);
		game.frame.setTitle(Main.TITLE);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setLocationRelativeTo(null);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);

		game.start();

	}
	public static Main getGame(){
		return game;
	}
	public Main() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		screen = new Screen(WIDTH, HEIGHT);
		mouse = new Mouse();
		key = new Keyboard();
		level = new PerlinLevel(512, 512);
		level.setMouse(mouse);
		level.add(new treeEntity(256 * 16, 256 * 16));
		player = new Player(256*16,256*16,key,mouse);
		level.setPlayer(player);
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this, "GameThread");
		thread.start();
	}

	public synchronized void stop() {
		// Sound.stopAll();
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long lastTimer = System.currentTimeMillis();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			if (delta >= 1) {
				update();
				updates++;
				delta--;
			}

			render();
			frames++;

			while (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				//System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(TITLE + " | " + updates + " ups, " + frames + " fps | "+level.entities.size()+" Entities");
				// level.updateTimer();
				frames = 0;
				updates = 0;
			}
		}

	}

	int tick = 0;

	public void update() {
		tick++;
		key.update();
		player.update();
		level.update();
		//System.out.println(ImprovedNoise.noise(tick/100.0, 0.0, 0.0));
		//level.add(new testEntity());
		
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		level.renderEntities(xScroll, yScroll,screen);
		level.renderLast(xScroll, yScroll, screen);
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = screen.pixels[i];
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.fillRect(mouse.getX(), mouse.getY(), 16,16);
		g.dispose();
		bs.show();
	}

	

}
