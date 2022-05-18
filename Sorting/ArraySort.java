package Sorting;



public class ArraySort {
    public static int[] sortTwoArrayCombine(int[] a, int[] b){
        QuickSort.quickSort(a, 0,a.length-1);
        QuickSort.quickSort(b, 0,b.length-1);
        int[] result = new int[a.length+b.length];
        int i =0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]>b[j]){
                result[k] = b[j];
               
                j++;
            }
            else{
                result[k] = a[i];
               
                i++;
            }
            k++;
        }
        while(i<a.length){
            result[k] = a[i];
            k++;
            i++;
        }
        while(j<b.length){
            result[k] = b[j];
            k++;
            j++;
        }
        return result;

    }
    public static void sortTwoArray(int[] a, int[] b){
        QuickSort.quickSort(a, 0,a.length-1);
        QuickSort.quickSort(b, 0,b.length-1);
        int[] a1 = new int[a.length];
        int[] b1 = new int[b.length];
        int i=0,j=0,k=0,s=0;
        while(i<a.length&&j<b.length){
            if(k<a1.length){
                if(a[i]<b[j]){
                    a1[k] = a[i];
                    i++;
                    k++;
                }else{
                    a1[k]=b[j];
                    j++;
                    k++;
                }

            }else{
                if(a[i]<b[j]){
                    b1[s] = a[i];
                    i++;
                    s++;
                }else{
                    b1[s]=b[j];
                    j++;
                    s++;
                }

            }
        }
        while(i<a.length){
            b1[s] = a[i];
            s++;
            i++;
        }
        while(j<b.length){
            b1[s] = b[j];
            s++;
            j++;
        }
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(a1);
        ap.printArray(b1);
      



    }
    public static void main(String args[]){
        ArrayPrinter ap = new ArrayPrinter();
        int[] a = {8,4,7,5,2};
        int[] b = {6,10,3,0,11,1};
        
        ap.printArray(sortTwoArrayCombine(a,b));
        sortTwoArray(a, b);
    }
}
