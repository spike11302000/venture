package com.spikerex.venture.level.tile;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	
	public static Tile voidTile = new voidTile(Sprite.voidSprite);
	public static Tile grass = new grassTile(Sprite.grass);
	public static Tile rock = new rockTile(Sprite.rock);
	public static Tile redFlower = new redFlowerTile(Sprite.redFlower);
	public static Tile yellowFlower = new yellowFlowerTile(Sprite.yellowFlower);
	public static Tile sand = new sandTile(Sprite.sand);
	public static Tile water = new waterTile(Sprite.water);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	public void render(int x,int y,Screen screen){
		screen.renderTiles(x<<4, y<<4, this);
	}
	public void renderLast(int x,int y,Screen screen){
	}
	public boolean solid(){
		return false;
	}
}
