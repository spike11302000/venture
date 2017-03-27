package com.spikerex.venture.level;

import java.util.Random;

import com.spikerex.venture.entity.clickable.treeEntity;

public class RandomLevel extends Level {
	private static final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
	}

	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x + y * width] = random.nextInt(3);
			}
		}
	}

	public void generateTrees() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if(random.nextInt(10)<2){
					add(new treeEntity(y*16,x*16));
				}
			}
		}
	}
}
