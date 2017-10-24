package com.spikerex.venture.level;

import java.util.ArrayList;
import java.util.List;

import com.spikerex.venture.entity.Entity;
import com.spikerex.venture.entity.clickable.*;
import com.spikerex.venture.entity.mob.Player;
import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.input.Mouse;
import com.spikerex.venture.level.tile.Tile;

public class Level {
	protected int width, height;
	protected int[] tiles;
	public List<Entity> entities = new ArrayList<Entity>();
	protected float[] biome;
	public Mouse mouse;
	public int offsetX, offsetY;
	public Player player;
	Screen screen;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		biome = new float[width * height];
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

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void update(int tick) {
		// System.out.println(offsetX);
		for (Entity ent : entities) {

			if (ent.isRemoved()) {
				remove(ent);
				break;
			}
			ent.update(tick);
		}
		for (int i = entities.size() - 1; i > 0; i--) {
			Entity ent = entities.get(i);
			if (ent instanceof ClickableEntity) {
				((ClickableEntity) ent).isHoveded = false;
				((ClickableEntity) ent).isClicked = false;
				if (ent instanceof treeEntity) {
					if ((ent.x - offsetX) < (mouse.getGX()) && (ent.x - offsetX + ent.width) > (mouse.getGX())
							&& (ent.y - offsetY) - 16 < (mouse.getGY())
							&& (ent.y - offsetY + ent.height) - 16 > (mouse.getGY())) {
						if (mouse.getButton() != -1) {
							player.setTarget((ClickableEntity) ent);
							((ClickableEntity) ent).Clicked();
							((ClickableEntity) ent).isClicked = true;
							if (((ClickableEntity) ent).getTargetable())
								player.setTarget((ClickableEntity) ent);

						}
						((ClickableEntity) ent).isHoveded = true;
						((ClickableEntity) ent).Hovered();

					}
				} else {
					if ((ent.x - offsetX) < (mouse.getGX()) && (ent.x - offsetX + ent.width) > (mouse.getGX())
							&& (ent.y - offsetY) < (mouse.getGY())
							&& (ent.y - offsetY + ent.height) > (mouse.getGY())) {
						if (mouse.getButton() != -1) {
							player.setTarget((ClickableEntity) ent);
							((ClickableEntity) ent).Clicked();
							((ClickableEntity) ent).isClicked = true;
							if (((ClickableEntity) ent).getTargetable())
								player.setTarget((ClickableEntity) ent);

						}
						((ClickableEntity) ent).isHoveded = true;
						((ClickableEntity) ent).Hovered();
					}
				}

			}
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		this.offsetX = xScroll;
		this.offsetY = yScroll;
		this.screen = screen;
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
		e.setLevel(this);
		entities.add(e);

	}

	public void remove(Entity e) {
		entities.remove(e);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return getTileByName("void");
		/*
		 * switch (tiles[x + y * width]) { case 0: return Tile.grass; case 1:
		 * return Tile.rock; case 2: return Tile.redFlower; case 3: return
		 * Tile.yellowFlower; case 4: return Tile.sand; case 5: return
		 * Tile.water; }
		 */
		return Tile.Tiles.get(tiles[x + y * width]);
	}

	public Tile getTileByName(String name) {
		for (Tile t : Tile.Tiles) {
			if (t.getName().toLowerCase().contains(name.toLowerCase()))
				return t;
		}
		return Tile.Tiles.get(0);
	}

	public int getIdByName(String name) {
		for (int i = 0; i < Tile.Tiles.size(); i++) {
			Tile t = Tile.Tiles.get(i);
			if (t.getName().toLowerCase().contains(name.toLowerCase()))
				return i;
		}
		return 0;
	}
}
