package com.spikerex.venture.entity.clickable;

import com.spikerex.venture.entity.Entity;
import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;

public class ClickableEntity extends Entity {
	public boolean isHoveded, isClicked;
	public Sprite sprite;
	public int health = 0;
	public ClickableEntity(){
		this.sprite = Sprite.voidSprite;
	}
	public ClickableEntity(int x,int y,Sprite s){
		this.x = x;
		this.y = y;
		this.sprite = s;
		this.height = s.SIZE;
		this.width = s.SIZE;
	}

	public void render(Screen screen) {
		if (!this.isHoveded) {
			screen.renderSprite(this.x, this.y, this.sprite,false);
		} else {
			screen.renderSpriteWhiten(this.x, this.y, this.sprite, .2f);
		}
	}

	public void Clicked() {

	}

	public void Hovered() {

	}
	public boolean getTargetable(){
		return true;
	}
	public void attack(){
		
	}
}
