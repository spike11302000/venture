package com.spikerex.venture.entity.mob;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;
import com.spikerex.venture.input.Keyboard;

public class Player extends Mob {
	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		if (xa != 0 || ya != 0)
			move(xa, ya);
	}

	/*
	 * if(xa>0)direction=1; if(xa<0)direction=2; if(ya>0)direction=3;
	 * if(ya<0)direction=0;
	 */
	public void render(Screen screen) {
		if (direction == 0)
			screen.renderPlayer(x, y, Sprite.player0);
		if (direction == 1)
			screen.renderPlayer(x, y, Sprite.player1);
		if (direction == 3)
			screen.renderPlayer(x, y, Sprite.player2);
		if (direction == 2)
			screen.renderPlayer(x, y, Sprite.player3);
	}
}
