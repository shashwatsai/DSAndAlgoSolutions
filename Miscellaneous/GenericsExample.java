import java.util.*;

public class GenericsExample{

	public static <E> void removeDuplicates(ArrayList<E> list){
		Set<E> set = new HashSet<>(list);
		list.clear();
		list.addAll(set);
	}

	public static void main(String [] args){
		ArrayList<Integer> l = new ArrayList<Integer>(){{add(1);add(1);add(2);add(4);add(3);add(5);add(6);add(2);add(3);add(5);}};
		System.out.println("With Duplicates: "+l);
		removeDuplicates(l);
		System.out.println("Without Duplicates " + l);
	}
}