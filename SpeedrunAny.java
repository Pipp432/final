
import Sorting.ArrayPrinter;

public class SpeedrunAny {
    public static void main(String args[]) {
        int[] test = {3,5,7,3,534,3,6,7,768,432,12};
        ArrayPrinter ap  = new ArrayPrinter();
        ap.printArray(test);
        mergeSort(test);
        ap.printArray(test);
        
    }
    //! So I must explain via comments and make the mergesort in 
    //! under 30 mins
    public static void mergeSort(int[] arr){
        // base cases since the method is recursive
        if(arr == null) return;
        if(arr.length<2) return;
        // basic info about the array
        int inputLength = arr.length;
        int middleLength = arr.length/2;
        // halving the arrays
        int[] leftHalf = new int[middleLength];
        int[] rightHalf = new int[inputLength-middleLength];
        // Do a deep copy of each half
        for(int i = 0;i<middleLength;i++){
            leftHalf[i] = arr[i];
        }
        for(int i =middleLength;i<inputLength;i++){
            rightHalf[i-middleLength] = arr[i];

        }
        // Recursive step
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        // Merge step 
        merge(arr,leftHalf,rightHalf);
    }
    
    // merge function

    public static void merge(int[] inputArray,int[] leftHalf,int[] rightHalf){
        // Basic info about arrays
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        // Declare 3 pointers
        int i = 0, j=0,k=0;
        while(i<leftSize && j<rightSize){
            if(leftHalf[i]<=rightHalf[j]){
                inputArray[k] = leftHalf[i++];
            }else{
                inputArray[k] =rightHalf[j++];
            }
            k++;
        }
        while(i<leftSize){
            inputArray[k++] = leftHalf[i++];
        }
        while(j<rightSize){
            inputArray[k++] = rightHalf[j++];
        }
    }
    // Done
}
