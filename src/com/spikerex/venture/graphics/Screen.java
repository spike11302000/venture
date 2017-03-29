package com.spikerex.venture.graphics;

import com.spikerex.venture.level.tile.Tile;

public class Screen {
	public int width, height;
	public int[] pixels;
	public int xOffset, yOffset;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTiles(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				if (tile.sprite.pixels[x + y * tile.sprite.SIZE] != 0xffff00ff)
					pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				if (sprite.pixels[x + y * sprite.SIZE] != 0xffff00ff)
					pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite, float o) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				if (sprite.pixels[x + y * sprite.SIZE] != 0xffff00ff) {
					int sr = (sprite.pixels[x + y * sprite.SIZE] >> 16) & 0xFF;
					int sg = (sprite.pixels[x + y * sprite.SIZE] >> 8) & 0xFF;
					int sb = (sprite.pixels[x + y * sprite.SIZE] >> 0) & 0xFF;
					
					int pr = (pixels[xa + ya * width] >> 16) & 0xFF;
					int pg = (pixels[xa + ya * width] >> 8) & 0xFF;
					int pb = (pixels[xa + ya * width] >> 0) & 0xFF;
					
					int r = (int)lerp(pr,sr,o);
					int b = (int)lerp(pb,sb,o);
					int g = (int)lerp(pb,sg,o);
					int color = r;
					
					color = (color<<8)+g;
					color = (color<<8)+b;

					
					pixels[xa + ya * width]  = color;
				}
				
			}
		}
	}
	public void renderSpriteWhiten(int xp, int yp, Sprite sprite, float o) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				if (sprite.pixels[x + y * sprite.SIZE] != 0xffff00ff) {
					int sr = (sprite.pixels[x + y * sprite.SIZE] >> 16) & 0xFF;
					int sg = (sprite.pixels[x + y * sprite.SIZE] >> 8) & 0xFF;
					int sb = (sprite.pixels[x + y * sprite.SIZE] >> 0) & 0xFF;
					
					int pr = (pixels[xa + ya * width] >> 16) & 0xFF;
					int pg = (pixels[xa + ya * width] >> 8) & 0xFF;
					int pb = (pixels[xa + ya * width] >> 0) & 0xFF;
					
					int r = (int)lerp(sr,0xff,o);
					int b = (int)lerp(sb,0xff,o);
					int g = (int)lerp(sg,0xff,o);
					int color = r;
					
					color = (color<<8)+g;
					color = (color<<8)+b;

					
					pixels[xa + ya * width]  = color;
				}
				
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 16; y++) {
			int ya = y + yp;
			for (int x = 0; x < 16; x++) {
				int xa = x + xp;
				if (xa < -16 || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.pixels[x + y * 16];
				if (col != 0xffff00ff)
					pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public float lerp(float a, float b, float u) {
		return (1 - u) * a + u * b;
	}
}
