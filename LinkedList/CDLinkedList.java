package LinkedList;

public class CDLinkedList {
	public DListNode header;
	int size;
	static final int HEADERVALUE = -9999999;

	public CDLinkedList() {
		header = new DListNode(HEADERVALUE);
		makeEmpty();// necessary, otherwise next/previous node will be null
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	public boolean isFull() {
		return false;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
		size =0;
	}

	// put in new data after the position of p.
	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(int value) throws Exception {
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v == value)
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public int findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size-1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(int value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		int currentData = itr2.next();
		while (currentData != value) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(int value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();
			if((int)data!=header.data){
				System.out.print(" "+data);

			}else{
				System.out.println("Empty");
			}
			
			if(((DListIterator)itr).currentNode.nextNode==header){
				break;

			}

		}
	}

	public int size() throws Exception {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}
	// Change to Intersect Problem
	public void changeToIntersect(CDLinkedList list2) throws Exception{
		DListIterator iter = new DListIterator(header);
		iter.next();
		while(iter.currentNode!=header){
			
			int current = list2.find(iter.currentNode.data);
			
			if(current == -1){
				remove(iter.currentNode.data);
			}else{

			}
			
			iter.next();
		}
		
		
		
	}
	public void swap(int v1,int v2) throws Exception{
		if(find(v1) ==-1||find(v2)==-1){
			return; //O(n)
		}
		if(isEmpty()) return;
		DListIterator itr1 = new DListIterator(header);
		DListIterator itr2 = new DListIterator(header);
		// Move the iterator to the nodes we want to swap
		
		for(int i= -1;i<find(v1);i++){
			itr1.next();
		}
		for(int i= -1;i<find(v2);i++){
			itr2.next();
		}
		DListNode tempNext =itr1.currentNode.nextNode;
		DListNode tempPrev =itr1.currentNode.previousNode;
		
		
		itr1.currentNode.previousNode.nextNode = itr2.currentNode;
		itr1.currentNode.nextNode.previousNode = itr2.currentNode;
		itr1.currentNode.nextNode = itr2.currentNode.nextNode;
		itr1.currentNode.previousNode = itr2.currentNode.previousNode;
		
		itr2.currentNode.nextNode.previousNode = itr1.currentNode;
		itr2.currentNode.previousNode.nextNode = itr1.currentNode;
		itr2.currentNode.nextNode = tempNext;
		itr2.currentNode.previousNode = tempPrev;

		
		


	}
	public void sort() throws Exception{
		selectionSort();
	}
	public void selectionSort() throws Exception{
		// Create pointers
		DListIterator iter1  = new DListIterator(this.header.nextNode);
		DListIterator iter2  = new DListIterator(this.header.nextNode);
		while(iter1.currentNode!=this.header){
			DListIterator min = new DListIterator(iter2.currentNode);
			while(iter2.currentNode!=this.header){
				
				if(min.currentNode.data>iter2.currentNode.data){
					// System.out.println(min.currentNode.data);
					min.currentNode = iter2.currentNode;
					
				}
				iter2.next();

			}
			// System.out.println(min.currentNode.data);
			if(min.currentNode!=this.header && min.currentNode.data<iter1.currentNode.data){
				int temp = iter1.currentNode.data;
				iter1.currentNode.data = min.currentNode.data;
				min.currentNode.data = temp;
			}
			

			iter1.next();
			iter2.currentNode = iter1.currentNode.nextNode;
		}
	}
	public void selectionSortPointer() throws Exception{
		// Create pointers
		DListIterator iter1  = new DListIterator(this.header.nextNode);
		DListIterator iter2  = new DListIterator(this.header.nextNode.nextNode);
		while(iter1.currentNode!=this.header){
			DListIterator min  = new DListIterator(iter2.currentNode);

			while(iter2.currentNode!=this.header){
				if(min.currentNode.data>iter2.currentNode.data){
					min.currentNode = iter2.currentNode;
				}
				iter2.next();

			}
			if(min.currentNode!= header && min.currentNode.data<iter1.currentNode.data){
				swap(min, iter1);
				System.out.println(min.currentNode.data);
			}
			iter1.next();
			// System.out.println(iter1.currentNode.data);
			iter2.currentNode = iter1.currentNode.nextNode;
		}
	}
	public void bubbleSort() throws Exception{
		DListIterator iter1  = new DListIterator(this.header.nextNode);
		
		while(iter1.currentNode!=header){
			DListIterator iter2  = new DListIterator(this.header);
			while(iter2.currentNode.nextNode!=header){
				if(iter2.currentNode.data>iter2.currentNode.nextNode.data){
					int temp = iter2.currentNode.nextNode.data;
					iter2.currentNode.nextNode.data = iter2.currentNode.data;
					iter2.currentNode.data = temp;
				}
				iter2.next();
			}
			iter1.next();

		}
	}
	public void bubbleSortPointer() throws Exception{
		DListIterator iter1  = new DListIterator(this.header.nextNode);
		
		while(iter1.currentNode!=header){
			DListIterator iter2  = new DListIterator(this.header);
			while(iter2.currentNode.nextNode!=header){
				if(iter2.currentNode.data>iter2.currentNode.nextNode.data){
					
					
					removeAt(iter2);
					insert(iter2.currentNode.data, new DListIterator(iter2.currentNode.nextNode));
				}
				iter2.next();
			}
			iter1.next();

		}
	}
	public void insertionSort() throws Exception{
		if(this.isEmpty()) return;
		if(this.size==1) return;
		DListIterator iter1  = new DListIterator(this.header);
		DListIterator iter2  = new DListIterator(this.header.nextNode.nextNode);
		
			while(iter2.currentNode!=header){
				while(iter1.currentNode!=iter2.currentNode){
					if(iter1.currentNode.data>iter2.currentNode.data){
						
						removeAt(iter2);
						insert(iter2.currentNode.data, new DListIterator(iter1.currentNode.previousNode));
						break;
					}
					iter1.next();
				}
				iter1.currentNode = this.header;
				iter2.next();
			}
			

		
	}
	
	

	public void quickSort() throws Exception{
		DListIterator low = new DListIterator(this.header);
		DListIterator high = new DListIterator(header);
		while(high.currentNode.nextNode!=this.header){
			high.next();
		}
		//System.out.println(low.currentNode.data);
		
		quickSort(low, high);
	}
	void quickSort(DListIterator low, DListIterator high) throws Exception{
		if(low.currentNode == high.currentNode) return;
		DListIterator pivot = new DListIterator(high.currentNode);
		DListIterator leftPointer = new DListIterator(low.currentNode);
		DListIterator rightPointer = new DListIterator(high.currentNode);

		while(leftPointer.currentNode!=rightPointer.currentNode ){
			while(leftPointer.currentNode.data<= pivot.currentNode.data && leftPointer.currentNode != rightPointer.currentNode ){
				leftPointer.next();
			}
			while(rightPointer.currentNode.data>=pivot.currentNode.data && leftPointer.currentNode != rightPointer.currentNode ){
				rightPointer.previous();
			}
			swap(leftPointer,rightPointer);
		
		}
		swap(leftPointer,high);

		quickSort(low, new DListIterator(leftPointer.currentNode.previousNode));
		quickSort(new DListIterator(leftPointer.currentNode),high);
		
	}
	public void swap( DListIterator pointer1, DListIterator pointer2){
		int temp = pointer1.currentNode.data;
		pointer1.currentNode.data = pointer2.currentNode.data;
		pointer2.currentNode.data = temp;
	}
	
	public static void mergesort(CDLinkedList list) throws Exception{
		if(list==null) return;
		int inputLength = list.size;
		if(inputLength<2) return;
		
		int midIndex = inputLength/2;
		CDLinkedList list1 = new CDLinkedList();
		CDLinkedList list2 = new CDLinkedList();
		DListIterator iter1 = new DListIterator(list1.header);
		DListIterator iter2 = new DListIterator(list2.header);
		DListIterator iter = new DListIterator(list.header.nextNode);
		for(int i =0;i<midIndex;i++){
			list1.insert(iter.currentNode.data, iter1);
			iter1.next();
			iter.next();
		}
		
		for(int i =midIndex;i<inputLength;i++){
			list2.insert(iter.currentNode.data, iter2);
			iter2.next();
			iter.next();
		}
		
		mergesort(list1);
		mergesort(list2);
		mergeLinkedList(list,list1, list2);

	
	}
	
	public static void mergeLinkedList(CDLinkedList list,CDLinkedList list1, CDLinkedList list2) throws Exception{
		
		DListIterator iter1  = new DListIterator(list1.header.nextNode);
		DListIterator iter2 = new DListIterator(list2.header.nextNode);
		DListIterator iter3 = new DListIterator(list.header.nextNode);
		while(iter1.currentNode!=list1.header && iter2.currentNode!=list2.header){
			if(iter1.currentNode.data<=iter2.currentNode.data){
				iter3.currentNode.data = iter1.currentNode.data;
				// System.out.println("iter1 "+iter1.currentNode.data);
				iter1.next();
				
			}
			else{
				iter3.currentNode.data = iter2.currentNode.data;
				// System.out.println("iter2 "+iter2.currentNode.data);
				iter2.next();
				

			}
			iter3.next();

		}
		while(iter1.currentNode!=list1.header){
			iter3.currentNode.data = iter1.currentNode.data;
				iter1.next();
				iter3.next();
		}
		while(iter2.currentNode!=list2.header){
			iter3.currentNode.data = iter2.currentNode.data;
				iter2.next();
				iter3.next();
		}
		

	}
	

}