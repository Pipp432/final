package BST;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


import LinkedList.CDLinkedList;
import LinkedList.DListIterator;
import Queues.QueueArray;


public class BSTRecursive {

	public BSTNode root;
	int size;

	public BSTRecursive(BSTNode root, int size) {
		this.root = root;
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}

	public Iterator findMin() {
		return findMin(root);
	}

	public Iterator findMin(BSTNode n) {
		if (n == null)
			return null;
		if (n.left == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMin(n.left);
	}

	public Iterator findMax() {
		return findMax(root);
	}

	public Iterator findMax(BSTNode n) {
		if (n == null)
			return null;
		if (n.right == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMax(n.right);
	}

	public Iterator find(int v) {
		return find(v, root);
	}

	public Iterator find(int v, BSTNode n) {
		if (n == null)
			return null;
		if (v == n.data)
			return new TreeIterator(n);
		if (v < n.data)
			return find(v, n.left);
		else
			return find(v, n.right);
	}

	public BSTNode insert(int v) {
		return insert(v, root, null);
	}

	// return the node n after v was added into the tree
	public BSTNode insert(int v, BSTNode n, BSTNode parent) {
		if (n == null) {
			n = new BSTNode(v, null, null, parent);
			size++;
		} else if (v < n.data) {
			n.left = insert(v, n.left, n);
		} else if (v > n.data) {
			n.right = insert(v, n.right, n);
		}
		return n;
	}

	public BSTNode remove(int v) {
		return remove(v, root, null);
	}

	// return the node n after v was removed from the tree
	public BSTNode remove(int v, BSTNode n, BSTNode parent) {
		if (n == null)
			; // do nothing, there is nothing to be removed
		else if (v < n.data) {
			n.left = remove(v, n.left, n);
		} else if (v > n.data) {
			n.right = remove(v, n.right, n);
		} else {
			if (n.left == null && n.right == null) {
				n.parent = null; // disconnect from above
				n = null; // disconnect from below
				size--;
			} else if (n.left != null && n.right == null) {
				BSTNode n2 = n.left;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.left = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else if (n.right != null && n.left == null) {
				BSTNode n2 = n.right;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.right = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else {
				TreeIterator i = (TreeIterator) findMin(n.right);
				int minInRightSubtree = i.currentNode.data;
				n.data = minInRightSubtree;
				n.right = remove(minInRightSubtree, n.right, n);
			}
		}
		return n;
	}
	public boolean isAVL() {
		// My general idea is to do a recursive call on the 
		//left and right subtrees until it hits a leaf.
		
		// Null case
		 // If root (an empty tree) is null return true
		if(root==null) return true;
		
		// Leaf cases
		//Since a leaf (single node) is always an AVL tree it will return true
		if(root!=null && root.left==null && root.right ==null) return true;
		
		// Create the left and right subtrees.
		// Since the size of the sub tree are unpredictable, 
		//I'll pass in the original tree size
		BSTRecursive leftBST = new BSTRecursive(root.left,size);
		BSTRecursive rightBST = new BSTRecursive(root.right,size);
		
		// If a specific node of the tree is AVL(The height difference is 1) 
		//then check its left and right subtrees whether or not they are AVL
		//, so a recursive call is made to traverse down the tree.
		if(Math.abs(getHeight(root.left)-getHeight(root.right))<=1) {
			return true && leftBST.isAVL() &&rightBST.isAVL();
		}
		return false;
		
		

	}
	public static int getHeight(BSTNode node) {
		// Get the height of a tree
		// If null tree (empty tree) the height is -1
		// If single node the height is 0
		if (node == null)
			return -1;
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		return 1 + (leftHeight < rightHeight ? rightHeight : leftHeight);
	}
	public static boolean isValidBST(BSTNode root) {
        return isValidBST(root,null,null);
    }
    static boolean isValidBST(BSTNode root, Integer min, Integer max){
        if(root==null){
            return true;
        }
		
		// If any data in the right subtree is less than the root then its not a BST
        if(min!=null && root.data<=min) return false;
		// If any data in the right subtree is more than the root then its not a BST
        if(max!=null && root.data>=max) return false;
        
		// Recursive call
		// Make the root data be the maximum for the left subtree
		// Make the root data be the minimum for the right subtree
        return isValidBST(root.left,min,root.data) && isValidBST(root.right,root.data,max);
    }
	public static boolean isLeaf(BSTNode node){
		if(node==null) return false;
		if(node.left !=null || node.right != null) return false;
		return true;

	}
	public boolean isMirror(BSTNode node){
		return isMirror(node,node);
		
	}
	private boolean isMirror(BSTNode t1, BSTNode t2){
		if(t1==null && t2==null) return true;
		if(t1==null || t2==null) return false;
		return (t1.data == t2.data) && isMirror(t1.left, t2.right);
	}


	
	public int recursiveNumLeaves(BSTNode node){
		if(node==null) return 0;
		if(node.left==null && node.right==null) return 1;
		return recursiveNumLeaves(node.left) + recursiveNumLeaves(node.right);
	}
	public int maxNumberNode(){
		if(this.root==null) return -1;
		int height = getHeight(root);
		int total = 0;
		for(int i = -1;i<height;i++){
			total+=(int)(Math.pow(2, i+1));
		}
		return total;
	}
	public BSTNode invert(BSTNode root){
		// Base case
		if(root== null) return root;

		// Tree traversal
		// Invert the subtress until the reaching the leafs.
		BSTNode left = invert(root.left);
		BSTNode right = invert(root.right);
		// swap
		root.right = left;
		root.left = right;
		return root;

	}

	public BSTNode createMirror(){
		BSTNode root = new BSTNode(this.root.data);
		createMirror(root,this.root);
		return root;
	}

	public void createMirror(BSTNode node,BSTNode originalRoot){
		if(node==null||originalRoot==null) return;
		
		if(originalRoot.right!=null){
			node.left = new BSTNode(originalRoot.right.data);
			createMirror(node.left,originalRoot.right);
		}
		if(originalRoot.left!=null){
			node.right = new BSTNode(originalRoot.left.data);
			createMirror(node.right,originalRoot.left);
		}
	}

	public void inOrderTraversal(BSTNode node){
		if(node==null) return;
		inOrderTraversal(node.left);
		System.out.print(" "+node.data);
		inOrderTraversal(node.right);
	}
	public void reverseInOrderTraversal(BSTNode node){
		if(node==null) return;
		reverseInOrderTraversal(node.right);
		System.out.print(" "+node.data);
		reverseInOrderTraversal(node.left);
	}

	public void preOrderTraversal(BSTNode node){
		if(node==null) return;
		System.out.print(" "+node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

	}

	public BSTNode deepCopyTree(BSTNode node){
		if(node == null) return null;
		BSTNode root = node;
		root.left = deepCopyTree(node.left);
		root.right = deepCopyTree(node.right);
		return root;
	}

	public void postOrderTraversal(BSTNode node){
		if(node==null) return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(" "+node.data);
	}
	public void breadthFirstTraversal(){
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(root);
		while(!q.isEmpty()){
			BSTNode temp = q.poll();
			System.out.print(temp.data+" ");
			
			if(temp.left!=null) q.add(temp.left);
			if(temp.right!=null) q.add(temp.right);
		}
		
	}
	public static boolean same(BSTRecursive t1,BSTRecursive t2){
		return same(t1.root,t2.root);
	}
	public static boolean same(BSTNode t1,BSTNode t2){
		
		if(t1==null && t2==null) return true;
		if(t1==null||t2==null) return false;
		if(t1.data!=t2.data) return false;
		return same(t1.left,t2.left)&&same(t1.right,t2.right);
	}

	public int average(BSTRecursive t){
		return(average(t.root))/(t.size);
	}

	public int average(BSTNode node){
		if(node==null) return 0;
	
		return node.data + average(node.left)+ average(node.right);

	}

	public static BSTNode sortedArrayToAVL(int[] array, int startIndex, int endIndex){
		
		if(startIndex>endIndex) return null;
		int middle = (endIndex+startIndex)/2;
		BSTNode root = new BSTNode(array[middle]);
	

		root.left = sortedArrayToAVL(array,startIndex,middle-1);
		root.right = sortedArrayToAVL(array,middle+1,endIndex);
		return root;
	}
	public int maxDepth(BSTNode node){
		if(node ==null) return 0;
		
		int l = maxDepth(node.left);
	
		int r  = maxDepth(node.right);
		
		return 1+ Math.max(l,r);
	}

	public boolean hasPathSum(BSTNode node, int num){
		if(node ==null) return false;
		int current = node.data;
		if(current == num && node.left==null && node.right ==null) return true;
		if(node.left==null && node.right ==null && current!=num) return false;
		int remianing = num-current;
		return hasPathSum(node.left, remianing)|| hasPathSum(node.right, remianing);
	}

	public int maxSum(BSTNode node){
		return maxSum(node,0);
	}

	public int maxSum(BSTNode node,int current){
		current+=node.data;
		if(node.right!=null){
			node = node.right;
			return maxSum(node, current);
		}
		return current;
	}
	public int lowestCommonNode(BSTNode root, BSTNode p,BSTNode q){
		if(p.data<root.data && q.data<root.data) return lowestCommonNode(root.left, p, q);
		if(p.data>root.data && q.data>root.data) return lowestCommonNode(root.right, p, q);
		return root.data;
	}

	public boolean sameData(BSTRecursive t1, BSTRecursive t2){
		
		
		return sameData(t1.root,t2.root);
		
	}
	public boolean sameData(BSTNode t1, BSTNode t2){
		// If given a hash class use that instead
		
		HashSet<Integer> hash1 = new HashSet<>();
		HashSet<Integer> hash2 = new HashSet<>();
		insertDataIntoHash(t1,hash1);
		insertDataIntoHash(t2,hash2);
		return hash1.equals(hash2);
	}
	public void insertDataIntoHash(BSTNode node,HashSet<Integer> hash){
		if(node==null) return;
		insertDataIntoHash(node.left, hash);
		hash.add(node.data);
		insertDataIntoHash(node.right, hash);

	}
	public BSTNode findParent(BSTNode n, BSTNode d, BSTNode parent){
		if(n==null) {
			
			return null;
		}
		if(d.data>n.data&&n.right!=null){
			if(n.right.data!=d.data)return findParent(n.right, d, parent);
		}
		if(d.data<n.data&&n.left!=null ){
			if(n.left.data!=d.data)return findParent(n.left, d, parent);
		}
		
		parent = n;
		return parent;
	}
	
	public BSTNode nextLargest(BSTNode node){
		if(node.right!=null){
			node =node.right;
			while(node.left!=null){
				node = node.left;
			}
			return node;
		}
		while(node.parent!=null){
			if(node.parent.left==node){
				return node.parent;
			}
			node = node.parent;
			
			
		}
		return null;
		
	}
	public int[] toSortedArray(){
		ArrayList<Integer> arr = new ArrayList<>();
		int[] result = new int[this.size];
		// The idea is to do inorder traversal left, root, right
		
		toSortedArray(this.root,arr);
		for(int i=0;i<arr.size();i++){
			result[i] = arr.get(i);
 
		}
		return result;
	}
	
	public void toSortedArray(BSTNode node,ArrayList<Integer> arr){
		
		if(node==null) return;
		toSortedArray(node.left,arr);
		
		arr.add(node.data);
		
		toSortedArray(node.right,arr);
		
	}
	public QueueArray toSortedQueue(){
		
		QueueArray result = new QueueArray();
		// The idea is to do inorder traversal left, root, right
		
		toSortedQueue(this.root,result);
		
		return result;
	}
	
	public void toSortedQueue(BSTNode node,QueueArray q){
		
		if(node==null) return;
		toSortedQueue(node.left,q);
		
		q.insertLast(node.data);
		
		toSortedQueue(node.right,q);
		
	}
	public static CDLinkedList nonAVLNodes(BSTNode n) throws Exception{
		CDLinkedList list = new CDLinkedList();

		nonAVLNodes(n,list);
		return list;
	}
	public static CDLinkedList nonAVLNodes(BSTNode n,CDLinkedList list) throws Exception{
		if(n==null) return list;
		
		if(Math.abs(getHeight(n.left)-getHeight(n.right))>1) list.insert(n.data, new DListIterator(list.header));
		nonAVLNodes(n.left, list);
		nonAVLNodes(n.right, list);
		return list;
	}
	public int getNodeHeight(BSTNode node){
		if(node==null) return -1;
		return 1+Math.max(getNodeHeight(node.left),getNodeHeight(node.right));
	}
	public boolean isBalance(BSTNode node){
		if(node==null) return true;
		if(Math.abs(getNodeHeight(node.left)-getHeight(node.right))<=1) return true &&isBalance(node.left)&&isBalance(node.right);
		else return false;

		 

	}
	
	
	

	
	public static void main(String[] args) throws Exception {
		BSTRecursive t2 = new BSTRecursive(null, 0);
		t2.insert(1);
		t2.insert(5);
		BTreePrinter.printNode(t2.root);

		BSTNode r = new BSTNode(10);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(5);
		t.insert(11);
		t.insert(9);
		t.insert(14);
		
		t.insert(4);
		t.insert(6);
		

		BSTNode r1= new BSTNode(7);
		BSTRecursive t1 = new BSTRecursive(r1, 1);
		t1.insert(3);
		t1.insert(10);
		t1.insert(9);
		
		BTreePrinter.printNode(t.root);
		System.out.println(t.isBalance(t.root));
		System.out.println(t.isAVL());
		
		
		
		// BTreePrinter.printNode(t.root);
		// BSTNode node = t.deepCopyTree(t.root);
		// BTreePrinter.printNode(node);
		// BST b = new BST(node, 0);
		// b.invert(b.root);
		//  BTreePrinter.printNode(t.root);
		// System.out.println(t.getHeight(t.root));
		// BSTNode node = t.createMirror();
		// BTreePrinter.printNode(node);
		// BTreePrinter.printNode(t.invert(t.root));
		// int[] arr  = {1,2,3,4,5,6,7,8,9};
		// BSTNode node1 = BSTRecursive.sortedArrayToAVL(arr,0,arr.length-1);
		// BTreePrinter.printNode(node1);
		// t.reverseInOrderTraversal(t.root);
		// t.breadthFirstTraversal();
		// BSTNode t3  = t.createMirror();
		// System.out.println();
		// BSTRecursive tree = new BSTRecursive(t3, 0);
	
		// tree.breadthFirstTraversal();
		// System.out.println(t.size);
		// System.out.println(54/t.size);
		// System.out.println(t.average(t));
		// BTreePrinter.printNode(t.root);
		// CDLinkedList list =nonAVLNodes(t.root);
		// list.printList();
		
		
		// if(t.findParent(t.root,new BSTNode(15),new BSTNode(0))!=null){
		// 	System.out.println((t.findParent(t.root,new BSTNode(15),new BSTNode(0)).data));

		// }else{
		// 	System.out.println("No parent");
		// }
		// System.out.println(t.nextLargest(t.root.right.left).data);
		// ArrayPrinter a = new ArrayPrinter();
		// int[] arr = t.toSortedArray();
		// a.printArray(arr);
		// QueueArray q = t.toSortedQueue();
		// while(!q.isEmpty()){
		// 	System.out.println(q.removeFirst());
			
		// }
		
		// System.out.println(t.maxSum(t.root, 0));
		
		
		
	}

	// 	t.insert(0);
	// 	t.insert(8);
	// 	t.insert(10);
	// 	t.insert(12);
	// 	t.insert(13);
	// 	t.insert(14);
	// 	t.insert(4);
	// 	BTreePrinter.printNode(t.root);

	// 	System.out.println("Now, remove 2.");
	// 	t.remove(2);
	// 	BTreePrinter.printNode(t.root);

	// 	System.out.println("Now, remove 8.");
	// 	t.remove(8);
	// 	BTreePrinter.printNode(t.root);

	// 	System.out.println("Now, remove 1.");
	// 	t.remove(1);
	// 	BTreePrinter.printNode(t.root);
	// 	TreeIterator itr = (TreeIterator) t.find(0);
	// 	if (itr.currentNode.parent.data == 3) {
	// 		System.out.println("Parent of 0 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 0 is NOT correct.");
	// 	}

	// 	System.out.println("Now, remove 12.");
	// 	t.remove(12);
	// 	BTreePrinter.printNode(t.root);
	// 	itr = (TreeIterator) t.find(13);
	// 	if (itr.currentNode.parent.data == 11) {
	// 		System.out.println("Parent of 13 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 13 is NOT correct.");
	// 	}

	// 	System.out.println("Now, remove 0 and 3.");
	// 	t.remove(0);
	// 	t.remove(3);
	// 	BTreePrinter.printNode(t.root);
	// 	itr = (TreeIterator) t.find(5);
	// 	if (itr.currentNode.parent.data == 7) {
	// 		System.out.println("Parent of 5 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 5 is NOT correct.");
	// 	}

	// 	System.out.println("Now, remove 6, insert 1,2,3 and remove 5.");
	// 	t.remove(6);
	// 	t.insert(2);
	// 	t.insert(1);
	// 	t.insert(3);
	// 	t.remove(5);
	// 	BTreePrinter.printNode(t.root);
	// 	itr = (TreeIterator) t.find(4);
	// 	if (itr.currentNode.parent.data == 7) {
	// 		System.out.println("Parent of 4 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 4 is NOT correct.");
	// 	}

	// 	System.out.println("Reset the tree");
	// 	r = new BSTNode(7);
	// 	t = new BSTRecursive(r, 1);
	// 	t.insert(3);
	// 	t.insert(1);
	// 	t.insert(11);
	// 	t.insert(2);
	// 	t.insert(5);
	// 	t.insert(9);
	// 	t.insert(6);

	// 	t.insert(0);
	// 	t.insert(8);
	// 	t.insert(10);
	// 	t.insert(12);
	// 	t.insert(13);
	// 	t.insert(14);
	// 	t.insert(4);
	// 	BTreePrinter.printNode(t.root);

	// 	System.out.println("Now, remove 3.");
	// 	t.remove(3);
	// 	BTreePrinter.printNode(t.root);
	// 	itr = (TreeIterator) t.find(4);
	// 	if (itr.currentNode.parent.data == 7) {
	// 		System.out.println("Parent of 4 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 4 is NOT correct.");
	// 	}
	// 	itr = (TreeIterator) t.find(5);
	// 	if (itr.currentNode.parent.data == 4) {
	// 		System.out.println("Parent of 5 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 5 is NOT correct.");
	// 	}

	// 	System.out.println("Now, remove 9.");
	// 	t.remove(9);
	// 	BTreePrinter.printNode(t.root);
	// 	itr = (TreeIterator) t.find(10);
	// 	if (itr.currentNode.parent.data == 11) {
	// 		System.out.println("Parent of 10 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 10 is NOT correct.");
	// 	}
	// 	itr = (TreeIterator) t.find(8);
	// 	if (itr.currentNode.parent.data == 10) {
	// 		System.out.println("Parent of 8 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 8 is NOT correct.");
	// 	}

	// 	System.out.println("Now, remove 11.");
	// 	t.remove(11);
	// 	BTreePrinter.printNode(t.root);
	// 	itr = (TreeIterator) t.find(12);
	// 	if (itr.currentNode.parent.data == 7) {
	// 		System.out.println("Parent of 12 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 12 is NOT correct.");
	// 	}
	// 	itr = (TreeIterator) t.find(10);
	// 	if (itr.currentNode.parent.data == 12) {
	// 		System.out.println("Parent of 10 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 10 is NOT correct.");
	// 	}

	// 	System.out.println("Now, remove 7.");
	// 	t.remove(7);
	// 	BTreePrinter.printNode(t.root);
	// 	itr = (TreeIterator) t.find(4);
	// 	if (itr.currentNode.parent.data == 8) {
	// 		System.out.println("Parent of 4 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 4 is NOT correct.");
	// 	}
	// 	itr = (TreeIterator) t.find(12);
	// 	if (itr.currentNode.parent.data == 8) {
	// 		System.out.println("Parent of 12 is correct.");
	// 	} else {
	// 		System.out.println("Parent of 12 is NOT correct.");
	// 	}

	// }

}
