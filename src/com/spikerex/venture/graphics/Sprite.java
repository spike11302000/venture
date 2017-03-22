package com.spikerex.venture.graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	
	//Tiles
	public static Sprite voidSprite = new Sprite(16,0x000000);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	
	//Player
	public static Sprite player0 = new Sprite(16,0,0,SpriteSheet.player);
	public static Sprite player1 = new Sprite(16,1,0,SpriteSheet.player);
	public static Sprite player2 = new Sprite(16,2,0,SpriteSheet.player);
	public static Sprite player3 = new Sprite(16,3,0,SpriteSheet.player);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
