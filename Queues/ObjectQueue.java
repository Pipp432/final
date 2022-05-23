package Queues;


public class ObjectQueue{

    protected Object[] theArray;
	protected int size; // number of currently stored data.
	protected int front; // index of the first data

	static final int DEFAULT_CAPACITY = 10;

	public ObjectQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ObjectQueue(int capacity) {
		theArray = new Object[capacity];
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

   
	public Object front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[front];
	}

	public Object back() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[(front + size - 1) % theArray.length];
	}
    public Object removeFirst() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		size--;

		Object frontItem = theArray[front];
		front = (front + 1) % theArray.length;
		return frontItem;
	}

	public void doubleCapacity() { // resize array to twice the original size
		Object[] temp = new Object[theArray.length * 2];
		
		//cannot use arraycopy because we have to go round the array
		for (int i = 0; i < size; i++) {
			temp[i] = theArray[(front+i)%theArray.length];
		}
		theArray = temp;
		front =0;
	}

	public void insertLast(Object data) {
		if (isFull())
			doubleCapacity();
		if(isEmpty())
			front=0;
		theArray[(front + size) % theArray.length] = data;
		size++;
	}

   
}