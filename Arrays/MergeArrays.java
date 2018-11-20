import java.util.*;

public class MergeArrays{

	public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b){
		List<Integer> result = new ArrayList<>();

		if(a.size() == 0){
			return b;
		}

		if(b.size() == 0){
			return a;
		}

		int i = 0, j = 0, k = 0;

		while( i < a.size() && j  < b.size()){
			if(a.get(i) < b.get(j)){
				result.add(a.get(i));
				i++;
			}else if(a.get(i) > b.get(j)){
				result.add(b.get(j));
				j++;
			}else{
				result.add(a.get(i));
				result.add(b.get(j));
				i++;
				j++;
			}
		}

		if( i != a.size()){
			while( i < a.size()){
				result.add(a.get(i));
				i++;
			}
		}

		if( j != b.size()){
			while( j < b.size()){
				result.add(b.get(j));
				j++;
			}
		}

		return result;
		

	}

	public static void main(String [] args){
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(9);
		b.add(0);
		b.add(1);
		b.add(2);
		b.add(3);

		System.out.println(mergeArrays(a,b));
	}
}