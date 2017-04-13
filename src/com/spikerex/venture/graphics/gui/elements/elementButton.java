package com.spikerex.venture.graphics.gui.elements;

import java.util.concurrent.Callable;

import com.spikerex.venture.graphics.Screen;

public class elementButton extends guiElement {
	private Callable<Void> action;

	public elementButton(int x, int y, int width, int height, Callable<Void> action) {
		super(x, y, width, height);
		this.action = action;
	}
	@Override
	public void render(Screen screen){
		
	}
	@Override
	public void update() {
		try {
			this.action.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
