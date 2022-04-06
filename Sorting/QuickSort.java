package Sorting;

public class QuickSort{
    public static void quickSort(int[] arr, int lowIndex,int highIndex){
        if(lowIndex>=highIndex) return;
        
        // Pivot selection
        int pivot = arr[highIndex];

        // Partitioning step
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer<rightPointer){
            while(arr[leftPointer]<=pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while(arr[rightPointer]>=pivot && leftPointer<rightPointer){
                rightPointer--;
            }
            // When the left pointer sees a data bigger than pivot and right pointer 
            //see a data less than the pivot swap them
            swap(arr,leftPointer,rightPointer);
        }
        // Lastly when LP and RP see the same data swap that data with the pivot
        swap(arr, leftPointer, highIndex);

        // Recursive step
        // Left partition
        quickSort(arr, lowIndex, leftPointer-1);
        // Right partition
        quickSort(arr, leftPointer+1, highIndex);


    }
    // Swapping helper function
    private static void swap(int[]arr, int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }



    public static void main(String[] args) {
        int[] arr ={ 0,4,3,2,4,4,6,8,9,32,1};
        quickSort(arr, 0, arr.length-1);
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(arr);
        
    }
}