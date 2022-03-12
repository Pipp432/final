package Sorting;

public class InsertionSort {
    public void insertionSort(int[] arr){
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
    
}
