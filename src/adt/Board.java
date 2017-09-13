package adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
	private static final int SIZEX = 11;
	private static final int SIZEY = 9;
	private static final int[] SHIPSIZES = { 2, 3, 3, 4, 5 };

	private Ship[] allships;
	private List<Coordinate> hits;

	public Board(Ship[] ships) {// throws setuperror{
		allships = ships;
		hits = new ArrayList<Coordinate>();

	}

	public int hit(int x, int y) {// throws hit error
		// saving coordinates in hit
		int result = Ship.MISS;
		boolean coordused = false;
		// check if coordinate is already used once
		for (Coordinate n : hits){ 
			if ((n.x() == x && n.y() == y)) {
				
				coordused = true;
			}
		}
		// checking if hit coords are within the span of any ships
		if (!(coordused)){		
			hits.add(new Coordinate(x,y));
				for (Ship i : allships) {
					int[] shiptemp = i.span();
					System.out.println("----" + Arrays.toString(i.span()));
					
					for (int n = 0; n < shiptemp.length; n = n + 2) {
						if (shiptemp[n] == x && shiptemp[n + 1] == y) {
							result = i.hit();
							break;
					}
					}
				}
			}
		else result = 0;//if coordinates are already used
		
		
		return result;
	}

	public int Checkcell(int x, int y) {
		int result = Ship.MISS;
		boolean coordused = false;
		// check if coordinate is already used once
		for (Coordinate n : hits){ 
			if ((n.x() == x && n.y() == y)) {
				
				coordused = true;
			}
		}
		for (Ship i : allships) {
			int[] shiptemp = i.span();
			for (int n = 0; n < shiptemp.length; n = n + 2) {
				// if coords are within ships coords and if coords  are in hits array
				if (shiptemp[n] == x && shiptemp[n + 1] == y && coordused) { 
						result = Ship.HIT;
						break;
				}	
						
				else if (!(coordused)) { // if coords are not in hits array
					result = Ship.EMPTY;
					}
				}
			}
		
		return result;

	}


	public boolean lose() {
		boolean lost = true;
		for (Ship i : allships) {
			if (!(i.size() == i.partsdestroyed())) {
				//if there is any ship that has not been destroyed
				lost = false;
			}
		}
		return lost;

	}

	public static void main(String[] args) {
		
		Ship test1 = new Ship(1,2,2,false);
		System.out.println(Arrays.toString(test1.span()));
		System.out.println(Arrays.toString(test1.span()));
		
		Ship test2 = new Ship(3,3,3,true);
		System.out.println(Arrays.toString(test2.span()));
		
		Ship test3 = new Ship(7,6,3,false);
		System.out.println(Arrays.toString(test3.span()));
		
		Ship test4 = new Ship(2,7,4,false);
		System.out.println(Arrays.toString(test4.span()));
		
		Ship test5 = new Ship(4,1,5,true);
		System.out.println(Arrays.toString(test5.span()));
		
		Ship[] tests = {test1, test2, test3, test4, test5};
		
		Board p1 = new Board(tests);
		System.out.println(p1.hit(2, 1)); 
		System.out.println(p1.hit(1, 1));
		System.out.println(p1.hit(1, 1));
		System.out.println(p1.hit(4, 1));
		System.out.println(p1.hit(3, 5));
		System.out.println(p1.Checkcell(4, 1));
		System.out.println(p1.Checkcell(2, 1));
		System.out.println(p1.Checkcell(5, 8));
		System.out.println(p1.hit(1, 2));
		System.out.println(p1.lose());
	}

}
