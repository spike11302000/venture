package com.spikerex.venture;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {
	public final static int WIDTH = 300;
	public final static int HEIGHT = WIDTH / 16 * 10;
	public final static String TITLE = "Venture";
	public final static int SCALE = 3;

	private Thread thread;
	private boolean running = false;
	private boolean paused = false;
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
		// TODO Auto-generated method stub
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
					update();
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

	public void update() {

	}

	public void render() {

	}

}
