package Heap;
import Sorting.ArrayPrinter;



public class MaxHeap {
    // The normal attributes and functions for heap
    int[] mData;
    int size = 0;

    public MaxHeap(){
        final int DEFAULT_CAPACITY =11;
        mData = new int[DEFAULT_CAPACITY];
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public int size(){
        return size;
    }
     public void add(int data){
         // If the array is full increase its size
         if(++size == mData.length){
            int[] newArr;
            newArr = new int[2*mData.length];
            System.arraycopy(mData, 0, newArr, 0, size);
            mData = newArr;
         }
         // Note I'm going off my own ideas this might not be the way prof. wants it
         mData[size-1] = data;
         percolateUp();

     }
     public void percolateUp(){
         int parent;
         int child = size-1;
         while(child>0){
             parent = (child-1)/2;
             if(mData[parent]>mData[child]) break; 
             // If the parent is more than child, // it is in its correct index
             // If not do a swap
             int temp = mData[parent];
             mData[parent] = mData[child];
             mData[child] = temp;
             // The child is now in the parent's index so assign the index accordingly
             child = parent;
         }

     }
     public int pop() throws Exception{
         if(size==0) throw new Exception("No data");
            // Store max data for return
         int maxData = mData[0];
         mData[0] = mData[size-1];
         size--;
         return maxData; 


     }
     public static void main(String args[]){
         MaxHeap heap = new MaxHeap();
         int[] arr = {50,30,19,10,2,15,5,20};
         for (int element :arr) {
             heap.add(element);
             
         }
         ArrayPrinter ap = new ArrayPrinter();
         ap.printArray(heap.mData);
       

     }
    
}
