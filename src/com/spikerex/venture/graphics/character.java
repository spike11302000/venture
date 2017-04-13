package com.spikerex.venture.graphics;

public class character{
	public SpriteSheet charSheet = new SpriteSheet("/textures/charSheet.png",512);
	
	public Sprite a = new Sprite(16, 1, 0, charSheet);
	public Sprite b = new Sprite(16, 2, 2, charSheet);
	public Sprite c = new Sprite(16, 3, 2, charSheet);
	public Sprite d = new Sprite(16, 4, 2, charSheet);
	public Sprite e = new Sprite(16, 5, 2, charSheet);
	public Sprite f = new Sprite(16, 6, 2, charSheet);
	public Sprite g = new Sprite(16, 7, 2, charSheet);
	public Sprite h = new Sprite(16, 8, 2, charSheet);
	public Sprite i = new Sprite(16, 9, 2, charSheet);
	public Sprite j = new Sprite(16, 10, 2, charSheet);
	public Sprite k = new Sprite(16, 11, 2, charSheet);
	public Sprite l = new Sprite(16, 12, 2, charSheet);
	public Sprite m = new Sprite(16, 13, 2, charSheet);
	public Sprite n = new Sprite(16, 14, 2, charSheet);
	public Sprite o = new Sprite(16, 15, 2, charSheet);
	public Sprite p = new Sprite(16, 0, 3, charSheet);
	public Sprite q = new Sprite(16, 1, 3, charSheet);
	public Sprite r = new Sprite(16, 2, 3, charSheet);
	public Sprite s = new Sprite(16, 3, 3, charSheet);
	public Sprite t = new Sprite(16, 4, 3, charSheet);
	public Sprite u = new Sprite(16, 5, 3, charSheet);
	public Sprite v = new Sprite(16, 6, 3, charSheet);
	public Sprite w = new Sprite(16, 7, 3, charSheet);
	public Sprite x = new Sprite(16, 8, 3, charSheet);
	public Sprite y = new Sprite(16, 9, 3, charSheet);
	public Sprite z = new Sprite(16, 10, 3, charSheet);
	public Sprite SPACE = new Sprite(16, 0, 0, charSheet);
	
	public Sprite getChar(char c){
		c = Character.toUpperCase(c);
		switch(c){
			case 'A' :
			return a;
		}
		return null;
	}
}
