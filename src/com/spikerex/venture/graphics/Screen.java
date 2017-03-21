package com.spikerex.venture.graphics;

import java.awt.Graphics;

public class Screen {
	public int width, height;
	public int[] pixels;
	private Graphics g;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

	}

	public void graphics(Graphics g) {
		this.g = g;
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
}
