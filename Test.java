
import LinkedList.*;
import Sorting.ArrayPrinter;

public class Test {
    public static void main(String args[]) throws Exception{
        int[] arr = {3,5,6,7,4,3,2,1};
        mergeSort(arr);
        ArrayPrinter ap = new ArrayPrinter();
        ap.printArray(arr);
        int[] arr1 ={ 0,4,3,2,4,4,6,8,9,32,1};
        // quickSort(arr1, 0, arr1.length-1);ap.printArray(arr1);
        
        // ap.printArray(arr1);
        // CDLinkedList list = new CDLinkedList();
        // list.insert(3, new DListIterator(list.header));
        // list.insert(2, new DListIterator(list.header));
        // list.insert(5, new DListIterator(list.header));
        // list.insert(1, new DListIterator(list.header));
        // list.insert(10, new DListIterator(list.header));
        // list.insert(23, new DListIterator(list.header));
        // list.insert(11, new DListIterator(list.header));
        // DListIterator iter = new DListIterator(list.header.nextNode);
       
      
        // // quickSort(list);
        // while(iter.currentNode.nextNode!=list.header){
        //     System.out.println(iter.currentNode.data);
        //    iter.next();
        // }


    }
    // public static void quickSort(int[] arr, int low, int high){
    //     if(low>=high) return;
    //     if(arr ==null) return;
    //     int leftPointer = low;
    //     int rightPointer = high;
    //     int pivot = arr[high];
    //     while(leftPointer<rightPointer){
    //         while(arr[leftPointer]<=pivot&&leftPointer<rightPointer) leftPointer++;
    //         while(arr[rightPointer]>=pivot&& leftPointer<rightPointer) rightPointer--;
    //         swap(arr, leftPointer,rightPointer);

    //     }
    //     swap(arr, leftPointer,high);

    //     quickSort(arr, low, leftPointer-1);
    //     quickSort(arr, leftPointer+1, high);
    // }
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    // public static void mergeSort(int[] arr){
    //     if(arr==null) return;
    //     if(arr.length<2) return;
    //     int inputLength = arr.length;
    //     int middleLength =inputLength/2;
    //     int[] leftHalf = new int[middleLength];
    //     int[] rightHalf = new int[inputLength-middleLength];
    //     for(int i=0;i<middleLength;i++){
    //         leftHalf[i] = arr[i];
    //     }
    //     for(int i =middleLength;i<inputLength;i++){
    //         rightHalf[i-middleLength] = arr[i];
    //     }
    //     mergeSort(leftHalf);
    //     mergeSort(rightHalf);

    //     merge(arr,leftHalf,rightHalf);
        

    // }
    // public static void merge(int[]inputArr,int[] left, int[] right){
    //     int leftSize = left.length;
    //     int rightSize = right.length;
    //     int i =0 , k=0, j=0;

    //     while(i<leftSize && j<rightSize){
    //         if(left[i]<=right[j]){
    //             inputArr[k] = left[i];
    //             i++;
    //         }else{
    //             inputArr[k] = right[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     while(i<leftSize){
    //         inputArr[k] = left[i];
    //         i++;
    //         k++;
    //     }
    //     while(j<rightSize){
    //         inputArr[k] = right[j];
    //         j++;
    //         k++;
    //     }


        

    // }
    // public static void quickSort(int[] arr, int low, int high){
    //     if(high<=low) return;
    //     int leftPointer = low;
    //     int rightPointer = high;
    //     int pivot = arr[high];

    //     while(leftPointer<rightPointer){
    //         while(arr[leftPointer]<=pivot&&leftPointer<rightPointer){
    //             leftPointer++;
    //         }
    //         while(arr[rightPointer]>=pivot&&leftPointer<rightPointer){
    //             rightPointer--;
    //         }
    //         swap(arr,leftPointer,rightPointer);
    //     }
    //     swap(arr,leftPointer,high);

    //     quickSort(arr, low, leftPointer-1);

    //     quickSort(arr, leftPointer+1, high);

    // }
    // public static void swap(int[] arr, int id1, int id2){
    //     int temp = arr[id1];
    //     arr[id1] = arr[id2];
    //     arr[id2] = temp;
    // }

    // public static void mergeSort(int[] arr){
    //     if(arr==null) return;
    //     if(arr.length<2) return;
    //     int inputLength = arr.length;
    //     int middleLength = arr.length/2;
    //     int[] leftHalf = new int[middleLength];
    //     int[] rightHalf = new int[inputLength-middleLength];
    //     for(int i =0;i<middleLength;i++){
    //         leftHalf[i] = arr[i];
    //     }
    //     for(int i = middleLength;i<inputLength;i++){
    //         rightHalf[i-middleLength] = arr[i];
    //     }

    //     mergeSort(leftHalf);
    //     mergeSort(rightHalf);

    //     merge(arr,leftHalf,rightHalf);

    // }
    // public static void merge(int[] inpurArr,int[] leftHalf,int[] rightHalf){
    //     int leftSize = leftHalf.length;
    //     int rightSize = rightHalf.length;
    //     int i =0,k=0,j=0;
    //     while(i<leftSize && j<rightSize){
    //         if(leftHalf[i]<=rightHalf[j]){
    //             inpurArr[k] =leftHalf[i];
    //             i++;
    //         }else{
    //             inpurArr[k] = rightHalf[j];
    //             j++;

    //         }
    //         k++;
    //     }
    //     while(i<leftSize){
    //         inpurArr[k] = leftHalf[i];
    //         k++;
    //         i++;
    //     }
    //     while(j<rightSize){
    //         inpurArr[k] =rightHalf[j];
    //         k++;
    //         j++;
    //     }
    // }
    // public static void mergeSort(CDLinkedList list) throws Exception{
    //     if(list == null) return;
    //     if(list.size()<2) return;
    //     int inputLength = list.size();
    //     int middleLength = inputLength/2;
    //     CDLinkedList leftHalf = new CDLinkedList();
    //     CDLinkedList rightHalf = new CDLinkedList();
    //     DListIterator inputPointer = new DListIterator(list.header.nextNode);
    //     DListIterator leftPointer = new DListIterator(leftHalf.header);
    //     DListIterator rightPointer = new DListIterator(rightHalf.header);
    //     for(int i = 0;i<middleLength;i++){
    //       leftHalf.insert(inputPointer.currentNode.data, leftPointer);
    //         leftPointer.next();
    //         inputPointer.next();
        
    //     }
    //     for(int i = middleLength;i<inputLength;i++){
    //         rightHalf.insert(inputPointer.currentNode.data, rightPointer);
    //         rightPointer.next();
    //         inputPointer.next();
    //     }
    //     mergeSort(leftHalf);
    //     mergeSort(rightHalf);
    //     merge(list,leftHalf,rightHalf);
        

    // }
    // public static void merge(CDLinkedList list,CDLinkedList leftHalf, CDLinkedList rightHalf) throws Exception{
    //     DListIterator leftPointer = new DListIterator(leftHalf.header.nextNode);
    //     DListIterator rightPointer = new DListIterator(rightHalf.header.nextNode);
    //     DListIterator listPointer = new DListIterator(list.header.nextNode);
    //     while(leftPointer.currentNode!=leftHalf.header && rightPointer.currentNode!=rightHalf.header){
    //         if(leftPointer.currentNode.data<=rightPointer.currentNode.data){
    //             listPointer.currentNode.data = leftPointer.currentNode.data;
    //             leftPointer.next();
    //         }else{
    //             listPointer.currentNode.data = rightPointer.currentNode.data;
    //             rightPointer.next();
    //         }
    //         listPointer.next();
    //     }
    //     while(leftPointer.currentNode!=leftHalf.header){
    //         listPointer.currentNode.data = leftPointer.currentNode.data;
    //         leftPointer.next();
    //         listPointer.next();

    //     }
    //     while(rightPointer.currentNode!=rightHalf.header){
    //         listPointer.currentNode.data = rightPointer.currentNode.data;
    //             rightPointer.next();
    //             listPointer.next();

    //     }
    // }
    // public static void quickSort(CDLinkedList list) throws Exception{
	// 	DListIterator low = new DListIterator(list.header);
	// 	DListIterator high = new DListIterator(list.header);
	// 	while(high.currentNode.nextNode!=list.header){
	// 		high.next();
	// 	}
	// 	//System.out.println(low.currentNode.data);
		
	// 	quickSort(low, high);
	// }
	// static void quickSort(DListIterator low, DListIterator high) throws Exception{
	// 	if(low.currentNode == high.currentNode) return;
	// 	DListIterator pivot = new DListIterator(high.currentNode);
	// 	DListIterator leftPointer = new DListIterator(low.currentNode);
	// 	DListIterator rightPointer = new DListIterator(high.currentNode);

	// 	while(leftPointer.currentNode!=rightPointer.currentNode ){
	// 		while(leftPointer.currentNode.data<= pivot.currentNode.data && leftPointer.currentNode != rightPointer.currentNode ){
	// 			leftPointer.next();
	// 		}
	// 		while(rightPointer.currentNode.data>=pivot.currentNode.data && leftPointer.currentNode != rightPointer.currentNode ){
	// 			rightPointer.previous();
	// 		}
	// 		swap(leftPointer,rightPointer);
		
	// 	}
	// 	swap(leftPointer,high);

	// 	quickSort(low, new DListIterator(leftPointer.currentNode.previousNode));
	// 	quickSort(new DListIterator(leftPointer.currentNode),high);
		
	// }
	// public static void swap( DListIterator pointer1, DListIterator pointer2){
	// 	int temp = pointer1.currentNode.data;
	// 	pointer1.currentNode.data = pointer2.currentNode.data;
	// 	pointer2.currentNode.data = temp;
	// }
    // public static void quickSort(int[] arr, int low,int high){
    //     if(arr==null) return;
    //     if(low>=high) return;
    //     int rightPointer = high;
    //     int leftPointer = low;
    //     int pivot = arr[high];
    //     while(leftPointer<rightPointer){
    //         while(leftPointer<rightPointer && arr[leftPointer]<= pivot) leftPointer++;
    //         while(leftPointer<rightPointer && arr[rightPointer]>=pivot) rightPointer--;
    //         swap(arr,leftPointer,rightPointer); 
    //     }
    //     swap(arr,leftPointer,high);

    //     quickSort(arr, low, leftPointer-1);
    //     quickSort(arr, leftPointer+1, high);
    // }
    public static void mergeSort(int[] array)
    {
        if(array==null) return;
        if(array.length<2) return;
        int inputLength = array.length;
        int middleLength = inputLength/2;
        int[] leftHalf = new int[middleLength];
        int[] rightHalf = new int[inputLength-middleLength];
        for(int i =0; i<middleLength;i++){
            leftHalf[i] = array[i];
        }
        for(int i = middleLength;i<inputLength;i++){
            rightHalf[i-middleLength] = array[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(array,leftHalf,rightHalf);
    }
    public static void merge(int[] array, int[] left, int[] right){
        if(array==null||left==null||right==null) return;
        int leftSize = left.length;
        int rightSize = right.length;
        int i =0, j=0,k=0;
        while(i<leftSize && j<rightSize){
            if(left[i]<right[j]){
                array[k] = left[i++];
            }else{
                array[k] = right[j++];
            }
            k++;
        }
        while(i<leftSize){
            array[k++] = left[i++];
        }
        while(j<rightSize) {
            array[k++] = right[j++];
        }
    }
}
