import java.util.*;

public class MedianStream{


    static void addNumbers(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.size() == 0 || number < lowers.peek()){
                lowers.add(number);
        }else{
                highers.add(number);
        }
    }

    static void rebalanceHeaps(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
            // get the lesser size heap
            PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
            PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers: lowers;
            if(bigger.size() - smaller.size() >= 2){
                    smaller.add(bigger.poll());
            }
    }

    static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
            PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
            PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers: lowers;
            if(bigger.size() == smaller.size()){
                    // return average
                    return ((double)bigger.peek() + smaller.peek())/2;
            }else{
                    return bigger.peek();
            }
    }

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
            PriorityQueue<Integer> lowersHeap = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                            return -1 * a.compareTo(b);
                    }
            });
            PriorityQueue<Integer> highersHeap = new PriorityQueue<>();
            double[] medians = new double[a.length];
            
            for (int i = 0; i < a.length; i++) {
                    int number = a[i];
                    addNumbers(number, lowersHeap, highersHeap);
                    rebalanceHeaps(lowersHeap, highersHeap);
                    medians[i] = getMedian(lowersHeap, highersHeap);
            }

            return medians;
    }

    public static void main(String [] args){
    	int [] arr = new int[]{12,4,5,3,8,7};
    	double [] medians = runningMedian(arr);
    	System.out.println(Arrays.toString(medians));
    }

}