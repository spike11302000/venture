package com.spikerex.venture.entity.mob;

import com.spikerex.venture.graphics.Screen;
import com.spikerex.venture.graphics.Sprite;
import com.spikerex.venture.input.Keyboard;
import com.spikerex.venture.input.Mouse;

public class Player extends Mob {
	private Keyboard input;
	private Mouse mouse;

	private int anim = 0;
	private boolean walking = false;
	private boolean goingto = false;

	public int gotoX, gotoY;

	public Player(Keyboard input,Mouse mouse) {
		this.input = input;
		this.mouse = mouse;
	}

	public Player(int x, int y, Keyboard input,Mouse mouse) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		
		int xa = 0, ya = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		walking = false;
		if (xa == 0 && ya == 0)
			goingto = false;

		if (goingto) {
			if (x > gotoX) {
				xa = -1;
			} else if (x < gotoX) {
				xa = 1;
			} else if (y > gotoY) {
				ya = -1;
			} else if (y < gotoY) {
				ya = 1;
			}
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		}

	}

	public void gotoLoc(int x, int y) {
		goingto = true;
		gotoX = x;
		gotoY = y;
	}

	public boolean finishedGoto() {
		return x == gotoX && y == gotoY;
	}

	/*
	 * if(xa>0)direction=1; if(xa<0)direction=2; if(ya>0)direction=3;
	 * if(ya<0)direction=0;
	 */
	public void render(Screen screen) {
		int xx = x - 8, yy = y - 8;
		if (direction == 0) {
			this.sprite = Sprite.player_f;
			if (walking) {
				if (anim % 30 > 10)
					this.sprite = Sprite.player_f1;
				if (anim % 30 > 20)
					this.sprite = Sprite.player_f2;
				if (anim % 30 > 30)
					this.sprite = Sprite.player_f3;
			}
		}
		if (direction == 1) {
			this.sprite = Sprite.player_r;
			if (walking) {
				if (anim % 30 > 10)
					this.sprite = Sprite.player_r1;
				if (anim % 30 > 20)
					this.sprite = Sprite.player_r2;
				if (anim % 30 > 30)
					this.sprite = Sprite.player_r3;
			}
		}
		if (direction == 3) {
			this.sprite = Sprite.player_b;
			if (walking) {
				if (anim % 30 > 10)
					this.sprite = Sprite.player_b1;
				if (anim % 30 > 20)
					this.sprite = Sprite.player_b2;
				if (anim % 30 > 30)
					this.sprite = Sprite.player_b3;
			}
		}
		if (direction == 2) {
			this.sprite = Sprite.player_l;
			if (walking) {
				if (anim % 30 > 10)
					this.sprite = Sprite.player_l1;
				if (anim % 30 > 20)
					this.sprite = Sprite.player_l2;
				if (anim % 30 > 30)
					this.sprite = Sprite.player_l3;
			}
		}
		screen.renderPlayer(xx, yy, this.sprite);
	}
}
