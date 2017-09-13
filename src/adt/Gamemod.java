package adt;

import java.util.Arrays;

public class Gamemod {
	private static Board p1;
	private static Board p2;
	private static boolean turn; //true if 2nd players turn false otherwise
	
	public static void Game_innit(Board one, Board two){
		p1 = one;
		p2 = two;
		turn = false;
	}
	
	public static int Game_hit(int x, int y){//used to attack on coordinate with player turn alternating
		int result;
		if (turn){
			result = p2.hit(x, y);
		}
		else{
			result = p1.hit(x, y);
		}
		turn = !turn;
		return result;
		
	}
	public static boolean Game_p2turn(){
		return turn;
	}
	public static int Game_won(){
		if (p1.lose()){
			return 2;
		}
		else if (p2.lose()){
			return 1;
		}
		else return 0;
	}
	public static int Game_view(int x, int y){
		if (turn){
			return p2.Checkcell(x, y);
		}
		else return p1.Checkcell(x, y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		Ship test6 = new Ship(1,2,2,false);
		System.out.println(Arrays.toString(test1.span()));
		System.out.println(Arrays.toString(test1.span()));
		
		Ship test7 = new Ship(3,3,3,true);
		System.out.println(Arrays.toString(test2.span()));
		
		Ship test8 = new Ship(7,6,3,false);
		System.out.println(Arrays.toString(test3.span()));
		
		Ship test9 = new Ship(2,7,4,false);
		System.out.println(Arrays.toString(test4.span()));
		
		Ship test10 = new Ship(4,1,5,true);
		System.out.println(Arrays.toString(test5.span()));
		
		Ship[] tests2 = {test6, test7, test8, test9, test10};
		
		Board p2 = new Board(tests2);
		
		Gamemod.Game_innit(p1,p2);
		System.out.println(Gamemod.Game_p2turn());
		System.out.println(Gamemod.Game_hit(9, 11));
		System.out.println(Gamemod.Game_p2turn());
		System.out.println(Gamemod.Game_hit(7, 4));
		System.out.println(Gamemod.Game_p2turn());
		System.out.println(Gamemod.Game_view(5, 5));
		System.out.println(Gamemod.Game_view(7, 4));
		
		System.out.println(Gamemod.Game_p2turn());
		System.out.println(Gamemod.Game_view(9, 11));
		System.out.println(Gamemod.Game_won());
	}

}
