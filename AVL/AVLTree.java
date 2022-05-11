package AVL;

import java.util.ArrayList;

import BST.*;
import LinkedList.CDLinkedList;
import LinkedList.DListIterator;

public class AVLTree {
	AVLNode root;
	int size;

	public AVLTree(){
		root = null;
		size = 0;
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

	public Iterator findMin(AVLNode n) {
		if (n == null)
			return null;
		if (n.left == null) {
			Iterator itr = new AVLTreeIterator(n);
			return itr;
		}
		return findMin(n.left);
	}

	public Iterator findMax() {
		return findMax(root);
	}

	public Iterator findMax(AVLNode n) {
		if (n == null)
			return null;
		if (n.right == null) {
			Iterator itr = new AVLTreeIterator(n);
			return itr;
		}
		return findMax(n.right);
	}

	public Iterator find(int v) {
		return find(v, root);
	}

	public Iterator find(int v, AVLNode n) {
		if (n == null)
			return null;
		if (v == n.data)
			return new AVLTreeIterator(n);
		if (v < n.data)
			return find(v, n.left);
		else
			return find(v, n.right);
	}

	public AVLNode insert(int v) {
		return insert(v, root, null);
	}

	// return the node n after v was added into the tree
	public AVLNode insert(int v, AVLNode n, AVLNode parent) {
		if (n == null){
			n = new AVLNode(v, null, null, parent, 0);
			size++;
		}else if (v < n.data) {
			n.left = insert(v, n.left, n);
		} else if (v > n.data) {
			n.right = insert(v, n.right, n);
		}
		n = rebalance(n);
		return n;
	}

	public AVLNode remove(int v) {
		return remove(v, root, null);
	}

	// return the node n after v was removed from the tree
	public AVLNode remove(int v, AVLNode n, AVLNode parent) {
		if (n == null)
			; // do nothing, there is nothing to be removed
		else if (v < n.data) {
			n.left = remove(v, n.left, n);
		} else if (v > n.data) {
			n.right = remove(v, n.right, n);
		} else {
			if (n.left == null && n.right == null) {
				n = null;
				size--;
			} else if (n.left != null && n.right == null) {
				n.left.parent = parent;
				n = n.left;
				size--;
			} else if (n.right != null && n.left == null) {
				n.right.parent = parent;
				n = n.right;
				size--;
			} else {
				AVLTreeIterator i = (AVLTreeIterator) findMin(n.right);
				int minInRightSubtree = i.currentNode.data;
				n.data = minInRightSubtree;
				n.right = remove(minInRightSubtree, n.right, n);
			}
		}
		n = rebalance(n);
		return n;
	}

	public AVLNode rebalance(AVLNode n) {
		if (n == null)
			return n;
		int balance = AVLNode.tiltDegree(n);
		if (balance == -2) {
			if (AVLNode.tiltDegree(n.left) == 1)
				n.left = rotateRightChild(n.left);
			n = rotateLeftChild(n);
		} else if (balance == 2) {
			if (AVLNode.tiltDegree(n.right) == -1)
				n.right = rotateLeftChild(n.right);
			n = rotateRightChild(n);
		}
		AVLNode.updateHeight(n);
		return n;
	}

	public AVLNode rotateLeftChild(AVLNode n) {
		AVLNode l = n.left;
		AVLNode lr = n.left.right; // can be null
		n.left = lr;
		if (lr != null) {
			lr.parent = n;
		}
		l.right = n;
		l.parent = n.parent;
		n.parent = l;
		
		AVLNode.updateHeight(n);
		AVLNode.updateHeight(l);
		return l;
	}
	public void makeAVL() throws Exception {
		AVLTreeIterator itr =(AVLTreeIterator)findMin();
		if(isEmpty()) return;
		ArrayList<Integer> arr =new ArrayList<>();
		
		while(itr.hasNext()) {
			
			arr.add(itr.currentNode.data);
			remove(itr.currentNode.data);
			itr.next();
		}
		
		for(int i=0;i<arr.size();i++) {
			
			this.root = this.insert(arr.get(i));
		}
				
	}

	public boolean isAVL() throws Exception {
		if(root==null) return true;
		AVLTree leftTree = new AVLTree();
		leftTree.root = root.left;
		AVLTree rightTree = new AVLTree();
		rightTree.root = root.right;
		if(Math.abs(root.left.height-root.right.height)<=1 && leftTree.isAVL() && rightTree.isAVL()) {
			return true;
		}
		return false; 
		
	}


	public static boolean same(AVLTree t1, AVLTree t2) {
		if(t1.root==null&&t2.root==null) return true;
		AVLNode current1 = t1.root;
		AVLNode current2 = t2.root;
		AVLTree tree1Left = new AVLTree();
		tree1Left.root = t1.root.left;
		AVLTree tree2Left = new AVLTree();
		tree2Left.root = t2.root.left;
		AVLTree tree1Right = new AVLTree();
		tree1Right.root = t1.root.right;
		AVLTree tree2Right = new AVLTree();
		tree2Right.root = t2.root.right;
		if(current1!=null && current2!=null) {
			
			return (current1.data==current2.data) && same(tree1Left,tree2Left) && same(tree1Right,tree2Right);
			
			
		}
		return false;
		
	
	
				
	
		
	}

	public AVLNode rotateRightChild(AVLNode n) {
		AVLNode r = n.right;
		AVLNode rl = n.right.left; // can be null
		n.right = rl;
		if (rl != null) {
			rl.parent = n;
		}
		r.left = n;
		r.parent = n.parent;
		n.parent = r;
		
		AVLNode.updateHeight(n);
		AVLNode.updateHeight(r);
		return r;
	}
	public static AVLTree CDLinkedListToAVL(CDLinkedList list) throws Exception{
		AVLTree result = new AVLTree();
		DListIterator iter = new DListIterator(list.header.nextNode);
		while(iter.currentNode!=list.header){
			result.insert(iter.currentNode.data);
			iter.next();
		}
		return result;
	}
	public static void main(String args[]) throws Exception{
		CDLinkedList list = new CDLinkedList();
		list.insert(10, new DListIterator(list.header));
		list.insert(6, new DListIterator(list.header));
		list.insert(13, new DListIterator(list.header));
		list.insert(11, new DListIterator(list.header));
		list.insert(2, new DListIterator(list.header));
		list.insert(15, new DListIterator(list.header));
		AVLTree result = CDLinkedListToAVL(list);
		System.out.println(result.isAVL());
	}

}
