package Sorting;

public class BucketSort {
    public static void bucketSort(int[] a){
        int n = a.length;
        int max = getMax(a);
        int[] bucket = new int[max+1];
        // Intializing bucket arrays
        for (int i = 0; i <= max; i++)  
        {  
            bucket[i] = 0;  
        }
        for (int i = 0; i < n; i++)  
        {  
            bucket[a[i]]++;  
        } 
        for (int i = 0, j = 0; i <= max; i++)  
        {  
            while (bucket[i] > 0)  
            {   
                a[j++] = i; 
                bucket[i]--;
            }  
        }
      
    }  
    
    public static int getMax(int a[])
    {  
        int n = a.length;  
        int max = a[0];  
        for (int i = 1; i < n; i++)  
        if (a[i] > max)  
        max = a[i];  
        return max;  
    }  
    public static void main(String args[]){
        int a[] = {4,6,12,11,13,15,1,10};
        bucketSort(a);
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(a);

    }
    
}
