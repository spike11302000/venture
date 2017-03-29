package com.spikerex.venture.level;

import java.util.ArrayList;
import java.util.List;

import com.spikerex.venture.entity.Entity;
import com.spikerex.venture.entity.clickable.ClickableEntity;
import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.level.tile.Tile;
import com.spikerex.venture.input.Mouse;

public class Level {
	protected int width, height;
	protected int[] tiles;
	public List<Entity> entities = new ArrayList<Entity>();
	public Mouse mouse;
	public int offsetX, offsetY;

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

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public void update() {
		// System.out.println(offsetX);
		for (Entity ent : entities) {
			if (ent.isRemoved()) {
				remove(ent);
				break;
			}
			ent.update();
		}
		for (int i = entities.size() - 1; i > 0; i--) {
			Entity ent = entities.get(i);
			if (ent instanceof ClickableEntity) {
				((ClickableEntity) ent).isHoveded = false;
				((ClickableEntity) ent).isClicked = false;
				if ((ent.x - offsetX) < (mouse.getX() / 3) && (ent.x - offsetX + ent.width) > (mouse.getX() / 3)
						&& (ent.y - offsetY) - 16 < (mouse.getY() / 3)
						&& (ent.y - offsetY + ent.height) - 16 > (mouse.getY() / 3)) {
					if (mouse.getButton() != -1) {
						((ClickableEntity) ent).Clicked();
						((ClickableEntity) ent).isClicked = true;

					}
					((ClickableEntity) ent).isHoveded = true;
					((ClickableEntity) ent).Hovered();

				}
			}
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		this.offsetX = xScroll;
		this.offsetY = yScroll;
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

	}

	public void renderLast(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = (xScroll >> 4) - 16;
		int x1 = (xScroll + screen.width + 32) >> 4;
		int y0 = (yScroll >> 4) - 16;
		int y1 = (yScroll + screen.height + 32) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).renderLast(x, y, screen);
			}
		}

	}

	public void renderEntities(int xScroll, int yScroll, Screen screen) {
		for (Entity ent : entities) {
			if ((ent.x - xScroll) + ent.width > 0 && ent.x - xScroll < screen.width
					&& (ent.y - yScroll) + ent.height > 0 && (ent.y - yScroll) - ent.height < screen.height)
				ent.render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void remove(Entity e) {
		entities.remove(e);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		switch (tiles[x + y * width]) {
		case 0:
			return Tile.grass;
		case 1:
			return Tile.rock;
		case 2:
			return Tile.redFlower;
		case 3:
			return Tile.yellowFlower;
		case 4:
			return Tile.sand;
		case 5:
			return Tile.water;
		}
		return Tile.voidTile;
	}
}
