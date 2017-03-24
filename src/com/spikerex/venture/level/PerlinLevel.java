package com.spikerex.venture.level;

import java.util.Random;

import com.spikerex.venture.entity.treeEntity;
import com.spikerex.venture.util.ImprovedNoise;

public class PerlinLevel extends Level {
	private static final Random random = new Random();

	public PerlinLevel(int width, int height) {
		super(width, height);
	}

	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int tile = ((int)(ImprovedNoise.noise((double)x/10.0, (double)y/10.0, 0.0)*100));
				if(tile<0)tile=0;
				if(tile==0){
					if (random.nextInt(10) < 2) {
						add(new treeEntity(y * 16, x * 16));
					}
				}
				tiles[x + y * width] = tile;
			}
		}
	}

	public void generateTrees() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
			}
		}
	}

}
