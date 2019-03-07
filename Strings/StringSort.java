import java.util.*;

public class StringSort{

	static String electionWinner(String[] votes) {

	       HashMap<String, Integer> map = new HashMap<>();

	       for(int i=0; i<votes.length; i++){
	           int count =0;
	           String temp = votes[i];
	           if(map.containsKey(temp))
	               count = map.get(temp);

	           map.put(temp,++count);
	       }

	   int max=Integer.MIN_VALUE; String result= "";

	   List<String> list = new ArrayList<>();

	   System.out.println(map);

	   for(Map.Entry<String, Integer> entry : map.entrySet()) {
	       int currentValue = entry.getValue();

	       if(currentValue >max){
	           list.clear();
	           list.add(entry.getKey());
	           max = currentValue;

	       }else if(currentValue == max){
	           list.add(entry.getKey());
	       }
	   }
	   List<String> names = new ArrayList<String>(){{add("chaku");add("chandan");add("chamoli");add("challan");add("chakundar");}};
	   Collections.sort(list, Collections.reverseOrder());

	   return list.get(0);
	}


	public static void main(String [] args){
		// List<String> names = new ArrayList<String>(){{add("chaku");add("chandan");add("chamoli");add("challan");add("chakundar");}};
		// Collections.sort(names);
		// System.out.println(names);

		String [] arr = new String []{"Alex","Michael","Harry","Dave","Michael","Victor","Harry","Alex","Mary","Mary"};
		System.out.println(electionWinner(arr));
	}
}


