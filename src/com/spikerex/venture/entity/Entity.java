package com.spikerex.venture.entity;

import java.util.Random;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.level.Level;
import com.spikerex.venture.level.tile.Tile;

public abstract class Entity {
	public int x,y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	public void render(Screen screen){
	}
	public void remove(){
		removed = true;
	}
	public boolean isRemoved(){
		return removed;
	}
	
}
