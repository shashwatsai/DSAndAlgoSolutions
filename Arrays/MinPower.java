import java.util.*;

public class MinPower{

	public static int minPower(List<Integer> p){
	    int initMinEnergy = 0; 
	    int currEnergy = 0; 
	    boolean flag = false; 
	  	int n = p.size(); 
	    for (int i = 0; i < n; i++) { 
		    currEnergy += p.get(i);  
		    if (currEnergy <= 0) { 
		        initMinEnergy += Math.abs(currEnergy) + 1; 
		        currEnergy = 1; 
		        flag = true; 
		    } 
	    } 
	    return (flag == false) ? 1 : initMinEnergy; 
	}

	public static void main(String [] args){
		List<Integer> p = new ArrayList<>();
		p.add(-5);
		p.add(4);
		p.add(-2);
		p.add(3);
		p.add(1);
		p.add(-1);
		p.add(-6);
		p.add(-1);
		p.add(0);
		p.add(5);

		System.out.println(MinPower.minPower(p));


	}
}