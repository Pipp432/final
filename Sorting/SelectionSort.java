package Sorting;

public class SelectionSort {
    public void selectionSort(int[] arr){
        
        for(int i=0;i<arr.length-1;i++){
            // Storing the first data as minIndex
            int minIndex = i;

            // Search for min within index from i+1 to length-1 
            for(int j= i+1;j<arr.length;j++){
                // Starting from the next Index
                // If a data is less than the minIndex 
                // Change the minIndex
                if (arr[j] < arr[minIndex])  minIndex = j;
            }
                // Swap then the 0th to ith index are sorted
                int temp = arr[minIndex];
                arr[minIndex] =arr[i];
                arr[i] = temp;
        }
     

    }
    public static void main(String args[]){
        ArrayPrinter ap = new ArrayPrinter();
        int[] arr = {1,4,3,2,10,24,13};
        ap.printArray(arr);
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);
        ap.printArray(arr);
    }
}
