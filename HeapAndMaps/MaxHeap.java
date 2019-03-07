import java.util.*;

public class MaxHeap{

	int size;
	int [] heap;

	MaxHeap(int [] arr){
		this.size = arr.length;
		this.heap = Arrays.copyOf(arr, size);
	}

	public void maxHeapify(int index){
		int largest = index;
		int leftChildIndex = 2*index + 1;
		int rightChildIndex = 2*index + 2;

		if(leftChildIndex < this.size && this.heap[index] < this.heap[leftChildIndex]){
			largest = leftChildIndex;
		}

		if(rightChildIndex < this.size && this.heap[largest] < this.heap[rightChildIndex]){
			largest = rightChildIndex;
		}

		if(largest != index){
			swap(index, largest);
			maxHeapify(largest);
		}

	}

	public void buildMaxHeap(){
		for(int i = size/2-1; i>=0; i--){
			maxHeapify(i);
		}
	}

	private void swap(int source, int destination){
		int temp = this.heap[source];
		this.heap[source] = this.heap[destination];
		this.heap[destination] = temp;
		return;
	}

	private void printHeap() throws Exception{
		if( heap == null){
			throw new Exception("Heap is Null");
		}

		int iMax = this.size -1, i;
		if(iMax == -1){
			System.out.println("[]");
		}

		StringBuilder b = new StringBuilder();
		b.append("[");
		for(i=0; i<iMax; i++){
			b.append(this.heap[i]);
			b.append(", ");
		}

		System.out.println(b.append(heap[i]).append(']').toString());
	}

	private int extractMax(){
		if(this.size == 0){
			return -1;
		}

		int max = this.heap[0];
		this.heap[0] = this.heap[this.size-1];
		size--;
		maxHeapify(0);
		return max;
	}

    private int findMax() {
        if (size == 0) {
            return -1;
        } else {
            return heap[0];
        }
    }

    public void insert(int elem) {
    	this.heap = Arrays.copyOf(this.heap, this.size+1);
    	int i = this.size;
    	int parentIndex = (int) Math.floor((i-1)/2);
    	while( i > 0 && this.heap[parentIndex] < elem){
    		this.heap[i] = this.heap[parentIndex];
    		i = parentIndex;
    		parentIndex = (int) Math.floor((i-1)/2);
    	}

    	this.heap[i] = elem;
    	this.size++;
    	return;
    }


	public static void main(String [] args){
		int [] arr = new int[]{2, 4, 5, 1, 6, 7, 8};
		MaxHeap heap = new MaxHeap(arr);
		try{
			heap.printHeap();
			heap.buildMaxHeap();
			heap.printHeap();
			heap.extractMax();
			heap.printHeap();
			heap.insert(12);
			heap.printHeap();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}