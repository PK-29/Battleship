package adt;

import java.util.Arrays;

public class Ship {

	public static final int MISS = -1;
	public static final int EMPTY = 0;
	public static final int HIT = 1;
	public static final int DESTROYED = 2;

	private int x; // leftmost corner
	private int y; // topmost corner
	private int s; // size of ship
	private boolean h; // horizontal or not
	private int d;

	public Ship(int xn, int yn, int sn, boolean hn) { // throws
														// shiperrorexception {
		x = xn;
		y = yn;
		s = sn;
		h = hn;
	}

	public int[] span() {
		int[] coords = new int[s * 2];
		int xold = x;
		int yold = y;
			// spanning set of coordinates for horizontal ship
			for (int i = 0; i < s * 2; i++) {
				if (h) {
					if (!(i % 2 == 0)) {
						coords[i] = y;
					} 
					else if (i%2==0) {
						coords[i] = x;
						x = x + 1;
					}
				}
				else {
					// spanning for vertical ship
					
						if (i % 2 == 0) {
							coords[i] = x;
							
						} 
						else if (!(i%2==0)) {
							coords[i] = y;
							y = y - 1;
						}
					
				}
			}
			x = xold;
			y = yold;
			return coords;
	}
		 
	

	public int hit() {
		if (d == s) {
			return DESTROYED;
		}
		else{
			d = d + 1;
			return HIT;
		}
	}

	public int posx() {
		return x;
	}

	public int posy() {
		return y;
	}

	public boolean hor() {
		return h;
	}

	public int size() {
		return s;
	}

	public int partsdestroyed() {
		return d;
	}

	public static void main(String[] args) {
		Ship test = new Ship(2, 3, 3, true);
		System.out.println(Arrays.toString(test.span()));
		System.out.println(test.hit());
		System.out.println(test.hit());
		System.out.println(test.hit());
		System.out.println(test.hit());

	}

}
