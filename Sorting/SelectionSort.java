package Sorting;

public class SelectionSort {
    public void selectionSort(int[] arr){
        
        for(int i=0;i<arr.length-1;i++){
            // Storing the first data as minIndex
            int minIndex = i;
            for(int j= i+1;j<arr.length;j++){
                // Starting from the next Index
                // If a data is less than the minIndex 
                // Change the minIndex
                if (arr[j] < arr[minIndex])  minIndex = j;
                // Swap then the 0th to ith index are sorted
                int temp = arr[minIndex];
                arr[minIndex] =arr[i];
                arr[i] = temp;
            }
        }
     

    }
}
