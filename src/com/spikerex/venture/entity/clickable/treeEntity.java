package com.spikerex.venture.entity.clickable;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;

public class treeEntity extends ClickableEntity {
	  
	public treeEntity(int x,int y){
		this.x = x;
		this.y = y;
		this.width = 16;
		this.height = 32;
		
	}
	public void render(Screen screen){
		if(!this.isHoveded){
			screen.renderSprite(this.x, this.y-16, Sprite.treeTop);
			screen.renderSprite(this.x, this.y, Sprite.treeBottom);
		}else{
			
		screen.renderSpriteWhiten(this.x, this.y-16, Sprite.treeTop,.2f);
		screen.renderSpriteWhiten(this.x, this.y, Sprite.treeBottom,.2f);
		}
	}
	public void update(){
		super.update();
		if(this.isHoveded){
			
		}
		if(this.isClicked){
			remove();
		}
	}
}
