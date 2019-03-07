/*

	Sieve of Eratosthenes: Print all the prime numbers lesser than equal to upper bound. 
	
	Example n = 10, 2,3,5,7
*/

import java.util.*;

public class EratosthenesPrime{

	private static void sieveOfEratosthenes(int n){
		boolean [] marked = new boolean[n+1];
		Arrays.fill(marked, false);

		for(int p=2; p*p <= n; p++){
			if(marked[p] == false){
				for(int i = p*p; i <= n; i += p){
					marked[i] = true;
				}
			}
		}

		for(int i=2; i<n;i++){
			if(marked[i] == false)
				System.out.println(i);
		}
	}

	public static void main(String [] args){
		sieveOfEratosthenes(50);
	}
}