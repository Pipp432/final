package Queues;

import Sorting.*;

public class QueueArray implements MyQueue {
	protected int[] theArray;
	protected int size; // number of currently stored data.
	protected int front; // index of the first data

	static final int DEFAULT_CAPACITY = 10;

	public QueueArray() {
		this(DEFAULT_CAPACITY);
	}

	public QueueArray(int capacity) {
		theArray = new int[capacity];
		size = 0;
		front = -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == theArray.length;
	}

	public void makeEmpty() {
		size = 0;
		front = -1;
	}

	public int size() {
		return size;
	}

	public int front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[front];
	}

	public int back() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[(front + size - 1) % theArray.length];
	}

	/*
	 * return an item at the front of the queue, delete that item. Throw
	 * exception if the queue is empty.
	 */
	public int removeFirst() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		size--;

		int frontItem = theArray[front];
		front = (front + 1) % theArray.length;
		return frontItem;
	}

	public void doubleCapacity() { // resize array to twice the original size
		int[] temp = new int[theArray.length * 2];
		
		//cannot use arraycopy because we have to go round the array
		for (int i = 0; i < size; i++) {
			temp[i] = theArray[(front+i)%theArray.length];
		}
		theArray = temp;
		front =0;
	}

	public void insertLast(int data) {
		if (isFull())
			doubleCapacity();
		if(isEmpty())
			front=0;
		theArray[(front + size) % theArray.length] = data;
		size++;
	}
	@Override
	public String toString(){
		String result ="";
		for(int element: theArray){
			result+=(" "+element);
		}
		return result;
	}
	

	public void mergeSort(QueueArray q) throws EmptyQueueException{
		MergeSort.sort(q.theArray);
			
	}


	public static void main(String[] args) throws EmptyQueueException {
		QueueArray q = new QueueArray();
		q.insertLast(10);
		q.insertLast(20);
		q.insertLast(30);
		q.insertLast(40);
		q.insertLast(60);
		q.insertLast(70);
		ArrayPrinter ap = new ArrayPrinter();
		 q.mergeSort(q);
		ap.printArray(q.theArray);
	}
	public void selectionSort() throws EmptyQueueException{
		if(isEmpty()) return;
		QueueArray temp = new QueueArray();
		int past = Integer.MIN_VALUE;
		for(int i = 0;i<size;i++){
			if(past>front()){
			while(front()!=past){
				insertLast(removeFirst());
			}
			temp.insertLast(this.removeFirst());
			this.insertLast(this.removeFirst());
			this.insertLast(temp.removeFirst());

		}else{
			past = front();
			insertLast(removeFirst());
		}
		}
		
		
			
		
		}
		
	}


