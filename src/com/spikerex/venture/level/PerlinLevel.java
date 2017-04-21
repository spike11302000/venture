package com.spikerex.venture.level;

import java.util.Random;

import com.spikerex.venture.entity.clickable.treeEntity;
import com.spikerex.venture.util.ImprovedNoise;

public class PerlinLevel extends Level {
	private static final Random random = new Random();
	private long seed;
	public PerlinLevel(int width, int height,long seed) {
		super(width, height);
		this.seed = seed;
		random.setSeed(seed);
	}

	protected void generateLevel() {
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int n = ((int) (ImprovedNoise.noise((double) x / 30.0, (double) y / 30.0, 0.0) * 100));
				random.setSeed(Math.abs(n));
				n += 40;
				String tile = "";
				if (n > 50) {
					tile = "grass";
				} else if (n > 45) {
					tile = "sand";
				} else {
					tile = "water";
				}
				if (tile.equals("grass")) {
					if (random.nextInt(20) < 1)
						add(new treeEntity(x * 16, y * 16));

					if (random.nextInt(20) < 1) {
						switch (random.nextInt(3)) {
						case 0:
							tile = "rock";
							break;
						case 1:
							tile = "red flower";
							break;
						case 2:
							tile = "yellow flower";
							break;
						}
					}
				}
				tiles[x + y * width] = this.getIdByName(tile);
			}
		}
	}

}
