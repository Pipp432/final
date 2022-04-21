package Heap;

import Sorting.ArrayPrinter;
import Sorting.QuickSort;

public class Heap{
    int[] mData;
    int size = 0;

    public Heap(){
        final int DEFAULT_CAPACITY =11;
        mData = new int[DEFAULT_CAPACITY];
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public int size(){
        return size;
    }
    // Time complexity: O(1)
    public int top() throws Exception{
        if(size == 0) throw new Exception("Empty");
        return mData[0];
    }
    // Time complexity: O(n)
    public void add(int data){
        // If the size is as big as the data array length (and thus no avalible indexes) 
        // create a bigger array
        if(++size == mData.length){
            int[] newArr;
            newArr = new int[2*mData.length];
            // Array copy method time complexity O(n)
            System.arraycopy(mData, 0, newArr, 0, size);
            mData = newArr;
        }
        mData[size-1] = data; // Add the data to the last index
        percolateUp();
    }
    // Time complexity: O(log n)

    protected void percolateUp(){
        int parent;
        int child = size-1; // Newest data is intially inserted into the last index.
        int temp;
        while(child>0){
            parent = (child-1)/2;
            // If the parent is less than it s childs then the parent is in the correct postion exit the code.
            if(mData[parent]<mData[child]) break;
            // If the parent is more than the child (which breaks heap condition) swap them
            temp = mData[parent];
            mData[parent] = mData[child];
            mData[child] = temp;
            child = parent;
        }
    }

    public int pop() throws Exception{
        if(size ==0) throw new Exception("Priority queue empty");
        int minData = mData[0];
        mData[0] = mData[size-1]; // Overwrite the first with the last data
        size--;
        percolateDown(0); // Start percolateDown
        return minData;

    }
    protected void percolateDown(int start){
        int parent = start;
        int child = 2 * parent + 1; // Left Child
        int temp;
        // Check if left child exists
        while(child < size){
            int leftVal = mData[child]; // Get the left data
            // The left child must hav a right child to compare with 
            // so check if a right child exist
            if(child<size-1){
                int rightVal = mData[child+1]; // Get the right data
                if(leftVal>rightVal) child++; // Increment child index if left > right 
                //beacuse we need to compare with the parent to see who is less
            }

            int parentVal = mData[parent]; // Get parent data
            if(parentVal < mData[child]){
                break; // if the parent data is less than its child meaning it is in the correct index
            }
            // if not swap them
            temp = mData[child];
            mData[child] = mData[parent];
            mData[parent] = temp;
            //the parent index is changed and if the the node isn't a leaf the loop will run again until it reaches a leaf 
            //or the data (overwritten root) is in its correct index
            parent = child;
            child  =2*parent+1;

        }
    }
    public static int[]  makeHeap(int[] a){
        //? We shall make assumptions: 1. The array is unsorted, 2. No searching algorithm is allowed, 3. Input array is allowed to be modified
        //! Problem: it is not known whether or not we can call add(). The code for it is present but after this question
        Heap result = new Heap();
        for(int e : a){
            result.add(e);
        }
        return result.mData;
        // Time Complexity of O(nlogn): add takes logn the loop takes n
    }

    public static int[]  makeHeap2(int[] a){
        //? We shall make assumptions: 1. The array is unsorted, 2. No searching algorithm is allowed, 3. Input array is allowed to be modified
       // This is working on a techniacallity a sorted array is min heap.
        QuickSort.quickSort(a, 0, a.length-1);
        return a;
        // Time Complexity of O(nlogn): add takes logn the loop takes n
    }
    public static boolean isHeap(int[] a, int parent){
        int left = 2*parent+1;
        int right = 2*parent+2;
        if(a.length==0) return false;
        if(parent<0 || left<0||right<0) return false;
        if(left>right) return false;
        if(left>a.length || right>a.length) return true;
        if(a[parent]<a[left] && a[parent]<a[right]){
            parent++;
            return isHeap(a,parent);
        }

        return false;
    }

   


    public static void main(String[] args){
        ArrayPrinter ap = new ArrayPrinter();
        int[] arr = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        ap.printArray(makeHeap(arr));
        System.out.println(isHeap(makeHeap2(arr),0));
        int[] arr2 = { 3, 1, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        System.out.println(isHeap(arr, 0));
        System.out.println(isHeap(arr2, 0));
       
        Heap heap = new Heap();
        heap.add(26);
        heap.add(40);
        heap.add(31);
        heap.add(48);
        heap.add(50);
        heap.add(85);
        heap.add(36);
        heap.add(99);
        heap.add(55);
        heap.add(57);
        heap.add(88);
        // Heap heap2 = new Heap();
        // heap2.add(16);
        // heap2.add(30);
        // heap2.add(41);
        // heap2.add(58);
        // heap2.add(60);
        // heap2.add(75);
        // heap2.add(46);
        // heap2.add(100);
        // heap2.add(65);
        // heap2.add(7);
        // heap2.add(99);
        // ap.printArray(heap.mData);
        // ap.printArray(heap2.mData);


    }
}