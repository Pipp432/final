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
        
    }

    public static int[]  makeHeap2(int[] a){
        //? We shall make assumptions: 1. The array is unsorted, 2. No searching algorithm is allowed, 3. Input array is allowed to be modified
       // This is working on a techniacallity a sorted array is min heap.
        QuickSort.quickSort(a, 0, a.length-1);
        return a;
       
    }
    public static int[] makeHeap3(int[] a){
        //? This is probably the best solution
        for(int i =a.length/2-1;i>=0;i--){  
            heapify(a,a.length,i);

        }
        return a;
    }
    public static void heapify(int[] a,int size,int root){
        int minimum = root;
        int left = 2*root+1;
        int right = 2*root+2;
        if(left<size && a[left]<a[minimum]){
            minimum =left;
        }
        if(right<size && a[right]<a[minimum]){
            minimum =right;
        }
        if(minimum!=root){
            int temp = a[root];
            a[root] = a[minimum];
            a[minimum] = temp;

            heapify(a,size,minimum);
        }
        
    }
    public static boolean isHeap(int[] a, int parent){
        int left = 2*parent+1;
        int right = 2*parent+2;
        if(a.length==0) return false;
        if(parent<0 || left<0||right<0) return false;
        if(left>right) return false;
        if(left>=a.length || right>=a.length) return true;
        if(a[parent]<a[left] && a[parent]<a[right]){
            parent++;
            return isHeap(a,parent);
        }

        return false;
    }
    public void changeData(int data, int index){
        //? I will assume that when changing data the index can change to its correct position.
        //? If this is not the case the whole array must change to fit the new data, which is impractical. 
        // Overwrite the inital data
        mData[index] = data;
        // Check the left, right and parent
        int left = 2*index+1;
        int right = 2*index+2;
        int parent = (index-1)/2;
        // If the data is in correct position and presever the heap property exit 
        if(mData[left]>data && mData[right]>data && mData[parent]<data) return;
        // If not percolate the data down until such.
        if(mData[left]<data ||mData[right]<data) percolateDown(index);
        if(mData[parent]>data ){
        
            // I don't want to create boiler plate so instead an overloaded percolateUp() I will do a swap
            int temp = mData[index];
            mData[index] = mData[parent];
            mData[parent] = temp;
            
        }
    }
    public int calculateMaxIndex(){
        // Since the min heap must have its maximum data as a leaf
        // We can ignore the nodes in between
        // Intialize the result as the middle value
        int maximum = mData[mData.length/2];

        // Our for loop will start at the middle index since all index before that are not leaves.
        // It can be proved that leaf nodes of a heap starts at n/2 + 1 until n
        // https://rishi-a.github.io/2018/04/03/starting-index-of-heap.html , it's a proof by contradiction
        for(int i = mData.length/2 +1;i<mData.length;i++){
            if(mData[i]>maximum){
                maximum = mData[i];
            }
        }
        return maximum;


    }
    public void removeValue(int value) throws Exception{
        int indexOfRemove = 10;
        for(int i=0;i<mData.length;i++){
            if(mData[i]==value && i<mData.length-1){
                
                indexOfRemove = i;
                break;
              
            }
            
           
        } 
        // System.out.println(indexOfRemove);
        if(indexOfRemove<mData.length/2+1 && indexOfRemove!=0){
            // System.out.println(mData.length);
            if(2*indexOfRemove+1<mData.length && 2*indexOfRemove+2<mData.length){
                System.out.println("1");
                if(mData[2*indexOfRemove+1]<mData[2*indexOfRemove+2]){
                    mData[indexOfRemove] = mData[2*indexOfRemove+1];
                    mData[2*indexOfRemove+1] = 0;
                    size--;
                }else{
                    // System.out.println("2");
                    mData[indexOfRemove] = mData[2*indexOfRemove+2];
                    mData[2*indexOfRemove+2] = 0;
                    size--;
                }
                
            }
        
            if(2*indexOfRemove+1<mData.length && 2*indexOfRemove+2>=mData.length){
                // System.out.println("3");
                mData[indexOfRemove] = mData[2*indexOfRemove+1];
                mData[2*indexOfRemove+1] = 0;
                size--;
            }
        }
        if(indexOfRemove>mData.length/2+1){
            // System.out.println("4");
            mData[indexOfRemove] =0;
            size--;

        }
        if(indexOfRemove==0){
            pop();
        }


    }
    public static int findKthLargest(int[] nums, int k) throws Exception {
        Heap heap = new Heap();
        for(int e : nums){
            heap.add(e);
        }
        
        while(heap.size()>k){
          
            heap.pop();
        }
        return heap.top();
        
    }
    public void removeSecond(){
        if(this.size<3) return;
        
        mData[1] = mData[mData.length-1];
        size--;
        mData[mData.length-1]=0;
        percolateDown(1);

        

    }
    
   
   


    public static void main(String[] args) throws Exception{
        int[] arr = {54,243,53,876,59,4,6,8,2,1};
        // System.out.println(isHeap(arr,0));
        Heap.makeHeap3(arr);
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(arr);
        // Heap heap = new Heap();
        // heap.mData = arr;
        // heap.size = arr.length;
        // heap.removeValue(59);
        // heap.removeValue(1);
        // ap.printArray(arr);
        // System.out.println(isHeap(arr, 0));
        // // System.out.println(findKthLargest(arr, 1));
      
        // ap.printArray(arr);
     
       
       
    //     Heap heap = new Heap();
    //     heap.add(26);
    //     heap.add(40);
    //     heap.add(31);
    //     heap.add(48);
    //     heap.add(50);
    //     heap.add(85);
    //     heap.add(36);
    //     heap.add(99);
    //     heap.add(55);
    //     heap.add(57);
    //     heap.add(88);
    //    ap.printArray(heap.mData);
    //    heap.changeData(10, 1);
    //    ap.printArray(heap.mData);
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