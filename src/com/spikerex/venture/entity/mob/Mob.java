package com.spikerex.venture.entity.mob;

import com.spikerex.venture.entity.Entity;
import com.spikerex.venture.graphics.Sprite;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if(xa>0)direction=1;
		if(xa<0)direction=2;
		if(ya>0)direction=3;
		if(ya<0)direction=0;
		if (!collosion()) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	public boolean collosion() {
		return false;
	}

	public void render() {

	}
}
