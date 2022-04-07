package Sorting;

class MergeSort 
{
   private static void sort(int[] inputArray){
       // Guard clause for null inputs
        if(inputArray==null) return;
       // First store the array length for later use
       int inputLength=inputArray.length;
       // Guard clause for empty or 1 element arrays
       if(inputLength<2) return;

       int midIndex = inputLength/2;
       int[] leftHalf = new int[midIndex];
       // Using inputLength-midIndex instead of midIndex for odd inputLength case
       int[] rightHalf = new int[inputLength-midIndex];

       // copying element into arrays 
       for(int i =0;i<midIndex;i++){
           leftHalf[i] = inputArray[i];
        }
       for(int i =midIndex;i<inputLength;i++){
            rightHalf[i-midIndex] = inputArray[i];
        }
        sort(leftHalf);
        sort(rightHalf);

        merge(inputArray,leftHalf,rightHalf);
    }
    private static void merge(int[] inputArray, int[] leftHalf,int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        // i will index the left, j the right and k the input arrays;
        int i=0,j=0,k=0;
        // Keep looping and adding elements to the input array
        // until either the right or left is empty
        while(i<leftSize && j<rightSize){
            // comparing the element of the left and right arrays
            if(leftHalf[i] <= rightHalf[j]){
                // if left is less add it to the input array
                inputArray[k] = leftHalf[i];
                i++;

            }else{
                //else add the right
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        // Since the loop breaks when either array are empty
        // The below loops are to insert the remaining elements
        // Which are sorted
        while(i<leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        } 
        while(j<rightSize){
            inputArray[k] = rightHalf[j];
            k++;
            j++;
        }
        
    }
           
       
  
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
  
        System.out.println("Given Array");
        printArray(arr);
  
       
        MergeSort.sort(arr);
        
  
        System.out.println("\nSorted array");
        printArray(arr);
    }
}