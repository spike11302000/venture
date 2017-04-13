package com.spikerex.venture.graphics.gui.elements;

import java.util.concurrent.Callable;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;

public class guiElement {
	private int x, y, width, height;
	private int def = 0xafafaf;
	private int hover = 0x000000;
	public guiElement(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void render(Screen screen){
		
	}
	public void update(){

	}
}
