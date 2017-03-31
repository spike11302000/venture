package com.spikerex.venture.entity;

import java.util.Random;

import com.spikerex.venture.Main;
import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.level.Level;

public abstract class Entity {
	public int x,y,width,height;
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
	public void setLevel(Level l){
		level = l;
	}
	
}
