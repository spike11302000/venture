package com.spikerex.venture.graphics;

public class character {

	public static Sprite a = new Sprite(16, 1, 2, SpriteSheet.charSheet);
	public static Sprite b = new Sprite(16, 2, 2, SpriteSheet.charSheet);
	public static Sprite c = new Sprite(16, 3, 2, SpriteSheet.charSheet);
	public static Sprite d = new Sprite(16, 4, 2, SpriteSheet.charSheet);
	public static Sprite e = new Sprite(16, 5, 2, SpriteSheet.charSheet);
	public static Sprite f = new Sprite(16, 6, 2, SpriteSheet.charSheet);
	public static Sprite g = new Sprite(16, 7, 2, SpriteSheet.charSheet);
	public static Sprite h = new Sprite(16, 8, 2, SpriteSheet.charSheet);
	public static Sprite i = new Sprite(16, 9, 2, SpriteSheet.charSheet);
	public static Sprite j = new Sprite(16, 10, 2, SpriteSheet.charSheet);
	public static Sprite k = new Sprite(16, 11, 2, SpriteSheet.charSheet);
	public static Sprite l = new Sprite(16, 12, 2, SpriteSheet.charSheet);
	public static Sprite m = new Sprite(16, 13, 2, SpriteSheet.charSheet);
	public static Sprite n = new Sprite(16, 14, 2, SpriteSheet.charSheet);
	public static Sprite o = new Sprite(16, 15, 2, SpriteSheet.charSheet);
	public static Sprite p = new Sprite(16, 0, 3, SpriteSheet.charSheet);
	public static Sprite q = new Sprite(16, 1, 3, SpriteSheet.charSheet);
	public static Sprite r = new Sprite(16, 2, 3, SpriteSheet.charSheet);
	public static Sprite s = new Sprite(16, 3, 3, SpriteSheet.charSheet);
	public static Sprite t = new Sprite(16, 4, 3, SpriteSheet.charSheet);
	public static Sprite u = new Sprite(16, 5, 3, SpriteSheet.charSheet);
	public static Sprite v = new Sprite(16, 6, 3, SpriteSheet.charSheet);
	public static Sprite w = new Sprite(16, 7, 3, SpriteSheet.charSheet);
	public static Sprite x = new Sprite(16, 8, 3, SpriteSheet.charSheet);
	public static Sprite y = new Sprite(16, 9, 3, SpriteSheet.charSheet);
	public static Sprite z = new Sprite(16, 10, 3, SpriteSheet.charSheet);
	public static Sprite SPACE = new Sprite(16, 0, 0, SpriteSheet.charSheet);
	public static Sprite Qmark = new Sprite(16, 15, 1, SpriteSheet.charSheet);

	public static Sprite getSprite(char ch) {
		ch = Character.toUpperCase(ch);
		// System.out.println(ch);
		switch (ch) {
		case 'A':
			return a;
		case 'B':
			return b;
		case 'C':
			return c;
		case 'D':
			return d;
		case 'E':
			return e;
		case 'F':
			return f;
		case 'G':
			return g;
		case 'H':
			return h;
		case 'I':
			return i;
		case 'J':
			return j;
		case 'K':
			return k;
		case 'L':
			return l;
		case 'M':
			return m;
		case 'N':
			return n;
		case 'O':
			return o;
		case 'P':
			return p;
		case 'Q':
			return q;
		case 'R':
			return r;
		case 'S':
			return s;
		case 'T':
			return t;
		case 'U':
			return u;
		case 'V':
			return v;
		case 'W':
			return w;
		case 'X':
			return x;
		case 'Y':
			return y;
		case 'Z':
			return z;
		case ' ':
			return SPACE;
		}
		return Qmark;
	}
}
