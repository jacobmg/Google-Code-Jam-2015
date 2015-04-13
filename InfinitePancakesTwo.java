import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Jacob Gold submission to Google Code Jam 2015 as phoenicika
// https://code.google.com/codejam/contest/6224486/dashboard#s=p1

public class InfinitePancakesTwo {
	
	/* 
	 * Attempt to distribute pancakes such that each plate has at most n, for n ranging
	 * from 1 to the max number of pancakes on a single plate. Count the number of moves
	 * required to redistribute for each n, then add to n to find the total number of moves.
	 * Smallest total number of moves is the solution. 
	 */
	
	public static void main(String[] args){
		File file = new File("B-large.in");
		try{
			Scanner s = new Scanner(file);
			PrintWriter p = new PrintWriter("infinite_pancakes_out.txt", "UTF-8");
			int numTests = s.nextInt();
			for(int i = 0; i < numTests; i++){
				int numPlates = s.nextInt();
				//System.out.print(String.valueOf(numPlates));
				int max = 0;
				int[] moves = new int[1000];
				for(int j = 0; j < numPlates; j++){
					int pancakes = s.nextInt();
					//System.out.print(" " + String.valueOf(pancakes));
					if(max < pancakes){
						max = pancakes;
					}
					for(int k = 0; k < pancakes; k++){
						moves[k] += (pancakes - 1) / (k + 1);
					}
				}
				//System.out.print("\n");
				int min = 1000;
				for(int j = 0; j < 1000; j++){
					//System.out.print(String.valueOf(moves[j]) + " ");
					if(min > moves[j] + j + 1){
						min = moves[j] + j + 1;
					}
				}
				System.out.print("\n");
				p.println("Case #" + String.valueOf(i + 1) + ": " + String.valueOf(min));
			}
			s.close();
			p.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
