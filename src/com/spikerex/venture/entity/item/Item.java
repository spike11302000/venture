package com.spikerex.venture.entity.item;

import com.spikerex.venture.entity.Entity;
import com.spikerex.venture.graphics.Sprite;

public class Item extends Entity {
	
	public Sprite sprite;
	public Item(int x,int y,Sprite sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
}
