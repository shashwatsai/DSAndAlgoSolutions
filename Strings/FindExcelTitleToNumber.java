import java.util.*;
import java.lang.*;

public class FindExcelTitleToNumber{

	private int titleToNumber(char [] title){
		int result = 0;
		for(char ch : title){
			result *=26;
			result += ch  - 'A'+1;
		}

		return result;
	}

	private String numberToTitle(int number){
		StringBuilder columnName = new StringBuilder();

		while(number > 0){
			int remainder = number%26;

			if(remainder == 0){
				columnName.append('z');
				number = (number/26)-1;
			}else{
				columnName.append((char)((remainder-1)+'a'));
				number = number/26;
			}
		}

		return columnName.reverse().toString();
	}

	public static void main(String [] args){
		FindExcelTitleToNumber test = new FindExcelTitleToNumber();
		System.out.println(test.titleToNumber("A".toCharArray()));
		System.out.println(test.numberToTitle(1));
	}
}