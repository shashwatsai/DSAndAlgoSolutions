public class RotateArrayJumble{

	private void rotateArray(int [] arr, int d , int l){
		int i, j, k, temp;
		for(i=0; i< gcd(d, l); i++){
			temp = arr[i];
			j = i;
			while(true){

				k = j+d;
				if(k >= l){
					k = k-l;
				}
				if(k == i){
					break;
				}

				arr[j] = arr[k];
				j = k;
			}

			arr[j] = temp;
		}
	}

	private int gcd(int a, int b){
		if(b == 0){
			return a;
		}else{
			return gcd(b, a%b);
		}
	}

    void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

	public static void main(String [] args){
		RotateArrayJumble rotate = new RotateArrayJumble();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate.rotateArray(arr, 2, 7);
        rotate.printArray(arr, 7);
	}
}