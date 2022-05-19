package Heap;

public class HeapNode {
    public int data; //the value that the node stores.
    public HeapNode left;
    public HeapNode right;
    public HeapNode parent; //pointers to other nodes within
    //the same tree.
    public HeapNode(int data){
		this(data,null,null,null);
	}
	
	public HeapNode(int data, HeapNode left, HeapNode right, HeapNode parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
    
}
