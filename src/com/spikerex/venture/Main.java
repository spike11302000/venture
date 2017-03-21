package com.spikerex.venture;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.spikerex.venture.graphics.Screen;

public class Main extends Canvas implements Runnable {
	public final static int WIDTH = 300;
	public final static int HEIGHT = WIDTH / 16 * 9;
	public final static String TITLE = "Venture";
	public final static int SCALE = 3;
	public final static Random rand = new Random();

	private Thread thread;
	private boolean running = false;
	private boolean paused = false;
	private Screen screen;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private JFrame frame;
	private int time = 0;

	public static void main(String[] args) {
		Main game = new Main();
		game.frame = new JFrame();
		game.frame.setResizable(false);
		game.frame.setTitle(game.TITLE);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setLocationRelativeTo(null);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);

		game.start();

	}

	public Main() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		screen = new Screen(WIDTH, HEIGHT);
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
				if (!paused)
					update(delta);
				updates++;
				delta--;
			}

			render();
			frames++;

			while (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(TITLE + " | " + updates + " ups, " + frames + " fps");
				// level.updateTimer();
				frames = 0;
				updates = 0;
			}
		}

	}
	int x=0,y=0;
	int tick = 0;
	public void update(double delta) {
		tick++;
		x=(int) ((double)Math.sin(tick/500.0)*500);
		y=(int) ((double)Math.cos(tick/500.0)*500);;
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		screen.clear();
		screen.render(x,y);
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = screen.pixels[i];
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

}
