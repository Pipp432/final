package Sorting;

public class BubbleSort {
    public void bubbleSort(int[] arr){
        int n = arr.length;
        // Going through each data once excpet the last one
        for(int i= 0;i<n-1;i++){
            System.out.println("i: "+i);
            // The size of needing to check 
            //will decrease as we go through each pass
            for(int j = 0; j < n-i-1; j++ ){
                System.out.println("j: "+j);
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("=========================");
        }
        
    }
    public static void main(String args[]){
        BubbleSort b = new BubbleSort();
        ArrayPrinter ap = new ArrayPrinter();
        int[] arr= {1,64,23,2135,324};
        b.bubbleSort(arr);
        ap.printArray(arr);
        }
}
