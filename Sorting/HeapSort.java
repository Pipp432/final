package Sorting;

public class HeapSort {
    //! This sorts from max to min
    public void heapSort(int[] arr){

        int n = arr.length;
 
        // Build heap (rearrange array)
        heapify(arr);
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            
            heapify(arr, i, 0);
        }
        


    }
    public int[] heapify(int[] arr){
        for(int i =arr.length/2-1;i>=0;i--){
            heapify(arr,arr.length,i);
        }
        return arr;


    }
    public void heapify(int[] arr,int size,int root){
        int minimum = root;
        int left = 2*root+1;
        int right = 2*root+2;
        if(left<size&& arr[left]<arr[minimum]){
            minimum = left;
        }
        if(right<size && arr[right]<arr[minimum]){
            minimum = right;
        }
        if(minimum!=root){
            int temp = arr[root];
            arr[root] = arr[minimum];
            arr[minimum] = temp;
            heapify(arr, size, minimum);
        }
    }
    public static void main(String args[]) {
        int[] arr = {4,5,7,3,2,6};
        HeapSort heapSort = new HeapSort();
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(arr);
        // heapSort.heapSort(arr);
        // ap.printArray(arr);
        heapSort.heapify(arr);
        ap.printArray(arr);
    }
    
}
