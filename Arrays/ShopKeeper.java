import java.util.*;
import java.util.stream.*;

public class ShopKeeper{


	public static int can_give_change(List<Integer> rupee_notes) {
		int five = 0, ten = 0, customerNumber = 1;

		for(int i = 0 ; i < rupee_notes.size(); i++){
			if(rupee_notes.get(i) == 5){
				five++;
			}else if(rupee_notes.get(i) == 10){
				ten++;
				five--;
			}else if(ten > 0){
				ten--;
				five--;
			}else{
				five -= 3;
			}

			if(five < 0){
				return i+1;
			}
		}

		return 0;
   	}

   	public static void main(String [] args){
   		int [] customersRupee = new int[]{5,10,5};
   		List<Integer> customersList = Arrays.stream(customersRupee).boxed().collect(Collectors.toList());
   		System.out.println(can_give_change(customersList));
   	}
}