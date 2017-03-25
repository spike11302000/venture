package com.spikerex.venture.entity;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;

public class treeEntity extends Entity {
	public treeEntity(int x,int y){
		this.x = x;
		this.y = y;
		this.width = 16;
		this.height = 32;
	}
	public void render(Screen screen){
		screen.renderSprite(this.x, this.y-16, Sprite.treeTop);
		screen.renderSprite(this.x, this.y, Sprite.treeBottom);
	}
}
