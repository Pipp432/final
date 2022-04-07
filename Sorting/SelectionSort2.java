package Sorting;

public class SelectionSort2 {
    public static int[] selectionSort(int[] input){
       // start interatig through the array
        for(int i=0;i<input.length;i++){
            int minIndex = i;
            for(int j= i;j<input.length;j++){
                // if the data at j is less than the minIndex make j the minIndex
                if(input[j]<input[minIndex]) minIndex = j;
            }
            swap(i,minIndex,input);

        }
        return null;
    }
    public static void swap(int index1,int index2,int[] a){

        int temp = a[index1];
                a[index1] =a[index2];
                a[index2] = temp;
    }
    public static void main(String[] args){
        int[] arr = {1,12,3,4,2,5,4,6,7,9,9,4,};
        SelectionSort2.selectionSort(arr);
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(arr);
    }
    
}
