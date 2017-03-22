package com.spikerex.venture.level;

import java.util.ArrayList;
import java.util.List;

import com.spikerex.venture.entity.Entity;
import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.level.tile.Tile;

public class Level {
	protected int width, height;
	protected int[] tiles;
	public List<Entity> entities = new ArrayList<Entity>();

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {

	}

	private void loadLevel(String path) {

	}

	public void update() {
		for (Entity ent : entities) {
			ent.update();
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (Entity ent : entities) {
			ent.render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		switch (tiles[x + y * width]) {
		case 0:
			return Tile.grass;
		}
		return Tile.voidTile;
	}
}
