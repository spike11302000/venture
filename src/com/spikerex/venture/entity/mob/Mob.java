package com.spikerex.venture.entity.mob;

import com.spikerex.venture.entity.Entity;
import com.spikerex.venture.graphics.Sprite;

public abstract class Mob extends Entity{
	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;
	
	public void move(){
		
	}
	public void update(){
		
	}
	public boolean collision(){
		return false;
	}
}
