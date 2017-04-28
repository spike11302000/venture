package com.spikerex.venture.graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	
	//Tiles
	public static Sprite voidSprite = new Sprite(16,0x000000);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite sand = new Sprite(16,4,0,SpriteSheet.tiles);
	public static Sprite water = new Sprite(16,5,0,SpriteSheet.tiles);
	
	//clickables
	//Tree
	public static Sprite treeTop = new Sprite(16,3,0,SpriteSheet.clickable);
	public static Sprite treeBottom = new Sprite(16,4,0,SpriteSheet.clickable);
	//misc
	public static Sprite rock = new Sprite(16,0,0,SpriteSheet.clickable);
	public static Sprite redFlower = new Sprite(16,1,0,SpriteSheet.clickable);
	public static Sprite yellowFlower = new Sprite(16,2,0,SpriteSheet.clickable);
	
	//Player
	public static Sprite player_f = new Sprite(16,0,0,SpriteSheet.player);
	public static Sprite player_r = new Sprite(16,1,0,SpriteSheet.player);
	public static Sprite player_b = new Sprite(16,2,0,SpriteSheet.player);
	public static Sprite player_l = new Sprite(16,3,0,SpriteSheet.player);
	
	public static Sprite player_f1 = new Sprite(16,0,1,SpriteSheet.player);
	public static Sprite player_r1 = new Sprite(16,1,1,SpriteSheet.player);
	public static Sprite player_b1 = new Sprite(16,2,1,SpriteSheet.player);
	public static Sprite player_l1 = new Sprite(16,3,1,SpriteSheet.player);
	
	public static Sprite player_f2 = new Sprite(16,0,2,SpriteSheet.player);
	public static Sprite player_r2 = new Sprite(16,1,2,SpriteSheet.player);
	public static Sprite player_b2 = new Sprite(16,2,2,SpriteSheet.player);
	public static Sprite player_l2 = new Sprite(16,3,2,SpriteSheet.player);
	
	public static Sprite player_f3 = new Sprite(16,0,3,SpriteSheet.player);
	public static Sprite player_r3 = new Sprite(16,1,3,SpriteSheet.player);
	public static Sprite player_b3 = new Sprite(16,2,3,SpriteSheet.player);
	public static Sprite player_l3 = new Sprite(16,3,3,SpriteSheet.player);
	
	//Mobs
	
	//Entity
	public static Sprite testEntity = new Sprite(16,0xffff00);
	//User Interface
	public static Sprite uiHotBar = new Sprite(16,0,0,SpriteSheet.ui);
	
	//items
	public static Sprite logItem = new Sprite(8,0,0,SpriteSheet.items);
	public static Sprite redFlowerItem = new Sprite(8,1,0,SpriteSheet.items);
	public static Sprite yellowFlowerItem = new Sprite(8,2,0,SpriteSheet.items);
	public static Sprite acronItem = new Sprite(8,3,0,SpriteSheet.items);
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
