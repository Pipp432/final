package Sorting;

public class InsertionSort {
    public  static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j=i-1;
            // while the data infront of the selected data is more than it.
            while(j>=0 && arr[j]>key){
                // Move the bigger data back by one
                arr[j+1] = arr[j];
                j--;
                // if all data is more than it. The loops breaks
            }
            // Insertion step
            arr[j+1] = key;
        }

    }
    public static  void insertionSortFirstK(int[] arr,int k){
        int n = k;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j=i-1;
            // while the data infront of the selected data is more than it.
            while(j>=0 && arr[j]>key){
                // Move the bigger data back by one
                arr[j+1] = arr[j];
                j--;
                // if all data is more than it. The loops breaks
            }
            // Insertion step
            arr[j+1] = key;
        }

    }

    public static void InsertionSortReccursion(int[] arr, int n){

        // Base case
        if(n<=1) return;

        // Recurrsive call
        InsertionSortReccursion(arr, n-1);
        // inserting the last nodes into the sorted arrays
         int last = arr[n-1];
         int j = n-2;
         // This loop is used to get the index of first data 
         // that has value less than the inserted one
         while (j >= 0 && arr[j] > last)
         {
             arr[j+1] = arr[j];
             j--;
         }
         // Then inserted the new value in front of it.
         arr[j+1] = last;
        

    }
    public static void main(String args[]){
        int[] arr = {2,1,7,5,6,4,6,9};
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(arr);
        
        insertionSortFirstK(arr, 4);
        ap.printArray(arr);
    }
    
}
