import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

public class OutputToFileExample {
	
	private static void writeToFile(String fileName) {
		try(OutputStream out = new FileOutputStream(fileName, true)){
			while(true) {
				int data = getRandomParan();
				out.write(data);
			}
		}catch(Exception e) {
			System.out.println("Exception: " +e);
		}
	}

	private static void checkValidParanthesis(String fileName){
		long count = 0;
		try(InputStream in = new FileInputStream(fileName)){
			int data = in.read();
    		while(data != -1) {
        		char currentParan = (char) data;
        		if(currentParan == '('){
        			count++;
        		}else if(currentParan == ')'){
        			count--;
        		}
        		data = in.read();
    		}
		}catch(Exception e){
			System.out.println(e);
		}

		if(count == 0){
			System.out.println("Balanced: " + count);
		}else{
			System.out.println("Not Balanced: " + count);
		}
	}
	
	private static int getRandomParan() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
		return randomNum == 1 ? '(' :')';
	}
	
	public static void main(String [] args) {
		String fileName = "paranthesis.txt";
		checkValidParanthesis(fileName);
	}

}
