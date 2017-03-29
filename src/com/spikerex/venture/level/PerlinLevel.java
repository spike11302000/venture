package com.spikerex.venture.level;

import java.util.Random;

import com.spikerex.venture.entity.clickable.treeEntity;
import com.spikerex.venture.util.ImprovedNoise;

public class PerlinLevel extends Level {
	private static final Random random = new Random();

	public PerlinLevel(int width, int height) {
		super(width, height);
	}

	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int tile = ((int) (ImprovedNoise.noise((double) x / 30.0, (double) y / 30.0, 0.0) * 100));
				tile += 50;
				if (tile > 50) {
					tile = 0;
				} else if (tile > 47) {
					tile = 4;
				} else {
					tile = 5;
				}
				if (tile == 0) {
					if (random.nextInt(20) < 1)
						add(new treeEntity(x * 16, y * 16));

					if (random.nextInt(20) < 1)
						tile = random.nextInt(3) + 1;
				}
				tiles[x + y * width] = tile;
			}
		}
	}


}
