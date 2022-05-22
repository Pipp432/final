

import Sorting.ArrayPrinter;

public class SpeedrunAny {
    public static void main(String args[]) {
        int[] test = {3,5,7,3,534,3,6,7,768,432,12};
        ArrayPrinter ap  = new ArrayPrinter();
        ap.printArray(test);
        quickSort(test,0,test.length-1);
        ap.printArray(test);
        
    }
    //! So I must explain via comments and make the mergesort in 
    //! under 30 mins
   public static void mergeSort(int[] array){
       if(array==null) return;
       if(array.length<2) return;
       int inputLength = array.length;
       int middleLength = inputLength/2;
       int[] leftHalf = new int[middleLength];
       int[] rightHalf  = new int[inputLength-middleLength];
       for(int i=0;i<middleLength;i++){
            leftHalf[i] = array[i];
       }
       for(int i=middleLength;i<inputLength;i++){
           rightHalf[i-middleLength] = array[i];
       }
       mergeSort(leftHalf);
       mergeSort(rightHalf);
       merge(array,leftHalf,rightHalf);
   }
   public static void merge(int[] array, int[] leftHalf,int[] rightHalf){
       int leftSize  = leftHalf.length;
       int rightSize = rightHalf.length;
       int i =0, j=0,k=0;
       while(i<leftSize&&j<rightSize){
           if(leftHalf[i]<=rightHalf[j]){
               array[k] = leftHalf[i++];
           }else{
               array[k] = rightHalf[j++];
           }
           k++;
       }
       while(i<leftSize){
           array[k++] = leftHalf[i++];
       }
       while(j<rightSize){
           array[k++] = rightHalf[j++];
       }
   }
   public static void quickSort(int[] arr,int lowIndex,int highIndex){
       if(lowIndex>=highIndex) return;
       int pivot = arr[ highIndex];
       int leftPointer =lowIndex;
       int rightPointer = highIndex;
       while(leftPointer<rightPointer){
           while(arr[leftPointer]<=pivot && leftPointer<rightPointer) leftPointer++;
           while(arr[rightPointer]>=pivot && leftPointer<rightPointer) rightPointer--;
           swap(arr,leftPointer,rightPointer);
       }
       swap(arr,leftPointer,highIndex);

       quickSort(arr, lowIndex, leftPointer-1);
       quickSort(arr, leftPointer+1, highIndex);
   }
   public static void swap(int[]arr, int index1,int index2){
       int temp = arr[index1];
       arr[index1] = arr[index2];
       arr[index2] = temp;

   }
}
