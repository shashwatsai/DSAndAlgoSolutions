import java.util.*;


public class MagicString{

	public static int magicalStrings(int n) {
		HashMap<Character, List<Character>> map = new HashMap<>();

		map.put('a',new ArrayList<Character>(){{add('e');}});
		map.put('e',new ArrayList<Character>(){{add('a');add('i');}});
		map.put('i',new ArrayList<Character>(){{add('a');add('e');add('o');add('u');}});
		map.put('o',new ArrayList<Character>(){{add('i');add('u');}});
		map.put('u',new ArrayList<Character>(){{add('a');}});
 	
 		if( n == 1){
 			return map.size();
 		}

 		Set<Character> vowels = map.keySet();
 		int result = 0;
 		for(Character c : vowels){
 			result += bfs(c,n,map);
 		}
 		return result;
   	}

   	private static int bfs(Character c, int n, HashMap<Character, List<Character>> map){
   		
   		Queue<Character> queue = new LinkedList<>();
   		queue.offer(c);
   		queue.offer(null);

   		int level = 0;
   		int count = 0;
   		while(!queue.isEmpty()){
   			Character current = queue.poll();
   			if(level == n-1) {
   				count += queue.size();
   				return count;
   			}
   			if(current != null){
   				// get neighbours
   				for(Character nei: map.get(current)){
   					queue.add(nei);
   				}
   			}else{
   				//System.out.println(queue);
   				if(!queue.isEmpty()){
   					queue.offer(null);
   				}
   				level++;
   			}
   		}

   		return count;
   	}

      private static int doIt(int n){
         return (int)JustRecurse(n)%1000000007;
      }

   	private static long JustRecurse(int n){
         /*

         If you were to visit each node in the tree, either by bfs or dfs
         time complexity will be very high. Let us try to count the possibilities
         without actually going through each of them
       
         The inspiration is a tree structure only, the tree with height n has leaf nodes
         of all possible magicalstrings of length n.
         If the vowel must follow vowel condition wasn't there, we know that if you have F(n)
         possibile strings of length n, you just need to multiply 5*F(n) to get F(n+1).
       
         The only thing determing number of branches each leaf node of tree gets is which 
         specific vowel it is. So let us keep a track of the ending vowels of each F(n) separately.
       
         F(n) = total number of magical strings of length n 
       
         Let us count the number of words that end with a, e, i, o, u
         Lets call X(n) the number of words of length N ending with x
         So A(n) is the number of words of length N ending with a
       
         Here, F(n) = A(n) + E(n) + I(n) + O(n) + U(n)
       
         If n = 1, it is easy, 
         A(n) = E(n) = I(n) = O(n) = U(n) = 1
       
         What happens now?
         To find the number of words of length N = 2 ending with a, look at all the vowels 
         that can be followed by a. We have "e", "i" and "u".
         So total number of words of length N ending with "a" are 
         total number of words of length N - 1 ending with "e" , "i", or "u"
       
         So, we have 
         

         A(n) = E(n-1) + I(n-1) + U(n-1)
         E(n) = A(n-1) + I(n-1)
         I(n) = E(n-1) + O(n-1)
         O(n) = I(n-1)
         U(n) = I(n-1) + O(n-1)
         
       
         Let's use this recurrence relation to loop and count the numbers
         Let's call A(n-1) = Am and A(n) = An
       
         Let's start with n-1 (denoted as m) = 1

         */
    
         long Am = 1, Em = 1, Im = 1, Om = 1,Um = 1;
         //Also initialising Xn with same values
         long An = 1, En = 1, In = 1, On = 1, Un = 1;
         //We will try to maintain the invariant Xm = Xn after each loop
       
         //We have manually initialised the variables such that N = 1 is handled, 
         //now if N > 1
         for(int i=1; i<n; i++) {
            An = (Em + Im + Um)%(1000000007);
            En = (Am + Im)%(1000000007);
            In = (Em + Om)%(1000000007);
            On = Im%1000000007;
            Un = (Im + Om)%(1000000007);
       
            Am = An;
            Em = En;
            Im = In;
            Om = On;
            Um = Un;
         }
 
         return (An%1000000007 + En%1000000007 + In%1000000007 + On%1000000007 + Un%1000000007)%(1000000007);

   	} 

	public static void main(String [] args){
		System.out.println(doIt(10000));
	}
}