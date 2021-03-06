package AVL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BST.*;
import LinkedList.CDLinkedList;
import LinkedList.DListIterator;
import Queues.EmptyQueueException;
import Queues.ObjectQueue;
import Queues.QueueArray;

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
			// Searching for v
		else if (v < n.data) {
			n.left = remove(v, n.left, n);
		} else if (v > n.data) {
			n.right = remove(v, n.right, n);
		} else {
			// Removing step
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
		if(root.left==null && root.right ==null) return true;
		AVLTree leftTree = new AVLTree();
		leftTree.root = root.left;
		
		AVLTree rightTree = new AVLTree();
		rightTree.root = root.right;
		if(Math.abs(height(root.left)-height(root.right))<=1 && leftTree.isAVL() && rightTree.isAVL()) {
			return true;
		
			
		}

		return false;
		}
	public int height(AVLNode node){
		 if (node == null)
           return 0;
      
       return 1 + Math.max(height(node.left), height(node.right));

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
	public AVLNode lowestCommonAncestor(AVLNode root, AVLNode p, AVLNode q){
		if(root==null) return null;
		if(p==null || q==null) return null;
		if(p.data>root.data && q.data>root.data && root.right!=null) return lowestCommonAncestor(root.right, p, q);
		if(p.data<root.data && q.data<root.data&& root.left!=null) return lowestCommonAncestor(root.left , p, q) ;
		return root;

	}
	
	public void preOrderTraversal(AVLNode node){
		if(node==null) return;
		System.out.print(" "+node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public AVLNode rotateRightChild(AVLNode n) {
		AVLNode r = n.right;
		AVLNode rl = n.right.left; // can be null
		n.right = rl;
		if (rl != null) {
			rl.parent = n;
		}
		System.out.println(r.parent.data);
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
			result.root = result.insert(iter.currentNode.data);
			iter.next();
		}
		return result;
	}
	public AVLNode insertNoBalance(int v) {
		return insertNoBalance(v, root, null);
	}

	private AVLNode insertNoBalance(int v, AVLNode n, AVLNode parent) {
		if (n == null) {
			n = new AVLNode(v, null, null, parent, 0);
			size++;
		} else if (v < n.data) {
			n.left = insertNoBalance(v, n.left, n);
		} else if (v > n.data) {
			n.right = insertNoBalance(v, n.right, n);
		}
		AVLNode.updateHeight(n);
		return n;
	}
	public void breadthFirstTraversal(){
		Queue<AVLNode> q = new LinkedList<AVLNode>();
		q.clear();
		q.add(root);
		while(!q.isEmpty()){
			AVLNode temp = q.remove();

			 System.out.print(temp.data+" ");
			
			if(temp.left!=null) q.add(temp.left);
			if(temp.right!=null)q.add(temp.right);
				
		}
	}
	public AVLNode addUp(int num, AVLNode rootNode){
		if(num==root.data) return root;
		if(rootNode==null) return null;
		insert(num);
		AVLNode node =finds(num);
	
		if(rootNode==this.root){
			while(node.parent!=null){
				node = node.parent;
				node = helper(num, node);
			}
			root = node;
		return node;

		}else{
				while(node.data!=rootNode.parent.data){
					node = node.parent;
					node = helper(num, node);
				}			
			return node;
		}	
	}
	private AVLNode helper(int num, AVLNode node) {
		if(node.right!=null && node.right.data==num){
				node = rotateRightChild(node);
				if(node.parent!=null && node.data<node.parent.data){
					node.parent.left = node;
				}
				if(node.parent!=null && node.data>node.parent.data){
					node.parent.right  = node;
					
				}
		}
		if(node.left!=null&& node.left.data==num){
			
			node = rotateLeftChild(node);
			
			if(node.parent!=null && node.data<node.parent.data){
				node.parent.left = node;
			}
			if(node.parent!=null && node.data>node.parent.data){
				node.parent.right= node;
				
			}
		}
		return node;
	}
	public AVLNode finds(int v){
		AVLNode current  =this.root;
		while(current!=null){
			if(current.data>v) current = current.left;
			if(current.data<v) current = current.right;
			if(current.data==v) return current;
		}
		return null;
	}


	public int sumOfLeaf() throws EmptyQueueException{
		QueueArray q = new QueueArray();
		addDataLeaf(this.root,q);
		int result = 0;
		while(!q.isEmpty()){
			result+=q.removeFirst();
		}
		return result;		
	}
	public void addDataLeaf(AVLNode node,QueueArray q){
		if(node==null) return;
		if(node.left==null && node.right==null) q.insertLast(node.data);
		addDataLeaf(node.left,q);
		addDataLeaf(node.right,q);
	}
	public int deepestLeavesSum(AVLNode node) throws EmptyQueueException{
		ObjectQueue q = new ObjectQueue();
        q.insertLast(root);
        int level_sum = 0;
        while(!q.isEmpty()){
           level_sum = 0;
            int size = q.size();
            for(int i =0;i<size;i++){
                AVLNode current = (AVLNode) (q.removeFirst());
                level_sum+=current.data;
                if(current.left!=null) q.insertLast(current.left);
                if(current.right!=null) q.insertLast(current.right);
            }
            
        }
        return level_sum;

	}



	
	public static void main(String args[]) throws Exception{
		AVLTree tree = new AVLTree();
		
		tree.root = tree.insert(10);
		tree.root = tree.insert(11);
		tree.root = tree.insert(12);
		tree.root = tree.insert(4);
		tree.root = tree.insert(3);
		tree.root = tree.insert(2);
		tree.root = tree.insert(1);
		
		
		
		
		tree.breadthFirstTraversal();
		System.out.println();
		System.out.println(tree.deepestLeavesSum(tree.root));
		// tree.root = tree.rebalance(tree.root);
		
	 	// tree.addUp(20, tree.root);
		//  tree.root.right = (tree.rotateRightChild(tree.root.right));
		// System.out.println((tree.rotateRightChild(tree.root)).data);
		
		
		//  System.out.println(node.right.left.data);
		
	

		
		
		

		
		
		
		// System.out.println();
		
		
		// tree.root=tree.rotateLeftChild(tree.root);
		// System.out.println(tree.root.left.data);
		// tree.breadthFirstTraversal();

		
		
	}

}
