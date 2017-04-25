package com.spikerex.venture.entity.clickable;

import com.spikerex.venture.Main;
import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;

public class treeEntity extends ClickableEntity {
	private int shake = 0;
	private int sh = 0;
	public treeEntity(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 16;
		this.height = 32;
		this.shake = 0;
		this.health = 10;
	}

	public void render(Screen screen) {
		if (!this.isHoveded) {
			screen.renderSprite(this.x+sh, this.y - 16, Sprite.treeTop,false);
			screen.renderSprite(this.x+sh, this.y, Sprite.treeBottom,false);
		} else {
			screen.renderSpriteWhiten(this.x+sh, this.y - 16, Sprite.treeTop, .2f);
			screen.renderSpriteWhiten(this.x+sh, this.y, Sprite.treeBottom, .2f);
		}
	}
	public void attack(){
		shake = 2;
		health--;
	}
	public void update(int tick) {
		sh = (int)(Math.sin(tick)*(double)shake);
		if(shake >0){
			shake--;
		}
		if (this.isHoveded) {

		}
		if (this.isClicked) {
			//remove();
		}
		if(health<0)
			remove();
		
	}
}
