import java.util.*;

public class ArrayCycle{


	public static int number_of_cycles(List<Integer> arr) {
        int count = 0;
        int len = arr.size();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            if (!visited.contains(i)) { //i is not visited
                int curr = i;
                while (curr >= 0 && curr < len) { // a cycle only occur in this range
                    if (s.contains(curr)) { //find a visted index
                        count++;
                        break;
                    }
                    s.add(curr);
                    visited.add(curr);
                    curr = arr.get(curr);
                }
                s.clear();
            }
        }
        return count;
    }

    public static void main(String [] args){
    	ArrayList<Integer> arr = new ArrayList<>();
    	arr.add(1);
    	arr.add(0);
    	arr.add(2);
    	System.out.println(number_of_cycles(arr));
    }
}