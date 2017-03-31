package com.spikerex.venture.entity;

import java.util.Random;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;

public class testEntity extends Entity {
	private Random random = new Random();

	public testEntity() {
		this.x = random.nextInt(64 * 4);
		this.y = random.nextInt(64 * 4);
	}

	public testEntity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
	}

	public void render(Screen screen) {
		screen.renderSprite(this.x, this.y, Sprite.testEntity);
	}
}
