package com.spikerex.venture.graphics;

public class textSprite {

	public static Sprite a = new Sprite(8, 1, 4, SpriteSheet.charSheet);
	public static Sprite b = new Sprite(8, 2, 4, SpriteSheet.charSheet);
	public static Sprite c = new Sprite(8, 3, 4, SpriteSheet.charSheet);
	public static Sprite d = new Sprite(8, 4, 4, SpriteSheet.charSheet);
	public static Sprite e = new Sprite(8, 5, 4, SpriteSheet.charSheet);
	public static Sprite f = new Sprite(8, 6, 4, SpriteSheet.charSheet);
	public static Sprite g = new Sprite(8, 7, 4, SpriteSheet.charSheet);
	public static Sprite h = new Sprite(8, 8, 4, SpriteSheet.charSheet);
	public static Sprite i = new Sprite(8, 9, 4, SpriteSheet.charSheet);
	public static Sprite j = new Sprite(8, 10, 4, SpriteSheet.charSheet);
	public static Sprite k = new Sprite(8, 11, 4, SpriteSheet.charSheet);
	public static Sprite l = new Sprite(8, 12, 4, SpriteSheet.charSheet);
	public static Sprite m = new Sprite(8, 13, 4, SpriteSheet.charSheet);
	public static Sprite n = new Sprite(8, 14, 4, SpriteSheet.charSheet);
	public static Sprite o = new Sprite(8, 15, 4, SpriteSheet.charSheet);
	public static Sprite p = new Sprite(8, 0, 5, SpriteSheet.charSheet);
	public static Sprite q = new Sprite(8, 1, 5, SpriteSheet.charSheet);
	public static Sprite r = new Sprite(8, 2, 5, SpriteSheet.charSheet);
	public static Sprite s = new Sprite(8, 3, 5, SpriteSheet.charSheet);
	public static Sprite t = new Sprite(8, 4, 5, SpriteSheet.charSheet);
	public static Sprite u = new Sprite(8, 5, 5, SpriteSheet.charSheet);
	public static Sprite v = new Sprite(8, 6, 5, SpriteSheet.charSheet);
	public static Sprite w = new Sprite(8, 7, 5, SpriteSheet.charSheet);
	public static Sprite x = new Sprite(8, 8, 5, SpriteSheet.charSheet);
	public static Sprite y = new Sprite(8, 9, 5, SpriteSheet.charSheet);
	public static Sprite z = new Sprite(8, 10, 5, SpriteSheet.charSheet);
	public static Sprite SPACE = new Sprite(8, 15, 1, SpriteSheet.charSheet);
	public static Sprite num0 = new Sprite(8,0,3,SpriteSheet.charSheet);
	public static Sprite num1 = new Sprite(8,1,3,SpriteSheet.charSheet);
	public static Sprite num2 = new Sprite(8,2,3,SpriteSheet.charSheet);
	public static Sprite num3 = new Sprite(8,3,3,SpriteSheet.charSheet);
	public static Sprite num4 = new Sprite(8,4,3,SpriteSheet.charSheet);
	public static Sprite num5 = new Sprite(8,5,3,SpriteSheet.charSheet);
	public static Sprite num6 = new Sprite(8,6,3,SpriteSheet.charSheet);
	public static Sprite num7 = new Sprite(8,7,3,SpriteSheet.charSheet);
	public static Sprite num8 = new Sprite(8,8,3,SpriteSheet.charSheet);
	public static Sprite num9 = new Sprite(8,9,3,SpriteSheet.charSheet);
	public static Sprite Qmark = new Sprite(8, 15, 3, SpriteSheet.charSheet);

	
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
		case '0':
			return num0;
		case '1':
			return num1;
		case '2':
			return num2;
		case '3':
			return num3;
		case '4':
			return num4;
		case '5':
			return num5;
		case '6':
			return num6;
		case '7':
			return num7;
		case '8':
			return num8;
		case '9':
			return num9;
		}
		return Qmark;
	}

	public static void print(int x,int y,String s,int color,Screen screen){
		int ii =0;
		for(int i = 0;i<s.length();i++){
			
			char c = s.charAt(i);
			if(c == '\n'){
				y+=8;
				ii=-1;
			}else
			screen.renderSprite(x+(8*ii), y, getSprite(c),color,true);
			
			ii++;
		}
	}
}
