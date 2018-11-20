public class MaxDiff{
	// Complete the maxDifference function below.
    static int maxDifference(int[] a) {
        // find the minimum
        int min = a[0];
        int max_diff = a[1]-a[0];
        boolean flag = false;
        for(int i=1; i<a.length; i++){
            if(a[i] - min > max_diff){
                max_diff = a[i]-min;
                flag = true;
            }
            if(a[i] <= min){
                min = a[i];
            }
        }
        
        return flag == false ? -1 : max_diff;
    }

    public static void main(String [] args){
    	int a[] = new int[]{8,5,6,7};
    	System.out.println(maxDifference(a));
    }
}