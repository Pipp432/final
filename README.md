# Final

Hello.

# Table of contents

| Topic/Problems | Source | Complexity | Where to find |
|:----------------:|:--------:|:-------:|:---------------:|
|makeAVL()|AVL Aj.Sukree HW|-|AVLTree.java|
|isAVL()|AVL Aj.Sukree HW|-|AVLTree.java|
|same()|AVL Aj.Sukree HW|-|AVLTree.java|
|CovidData class|Hash Aj.Sukree HW|-|CovidData.java|
|SelectionSort|final_2015|-|SelectionSort2.java|
|Hash Table Insertions|final_2015|-|[Here](https://github.com/Pipp432/final/blob/main/Hash/Hash%20table%201-2015.pdf)|
|Hash Table Lazy Deletion|final_2015|-|[Here](https://github.com/Pipp432/final/blob/main/Hash/Hash%20Table%202-2015.pdf)|
|Hash Table Insert & Delete|final_2019|-|[Here](https://github.com/Pipp432/final/blob/main/Hash/Hash%20Table%202019-1.pdf)|
|add() for Double Hashing|final_2019|-|DoubleHashing.java|
|Invert()|EVERY CODING INTERVIEW EVER|O(n)|[Here](https://leetcode.com/problems/invert-binary-tree)|
|Faster than O(nlogn) sorting algorithm|final_2015|O(d(n+b))|[Here](https://github.com/Pipp432/final/tree/main/Sorting/RadixSort)|
|Hash Table Quadratic Probing|HW|-|[Here](https://github.com/Pipp432/final/blob/main/Hash/Hash%20Table%20HW_%20Quadratic%20probing.pdf)|
|Hash Table Double Hasing|HW|-|[Here](https://github.com/Pipp432/final/blob/main/Hash/Hash%20Table_%20Double%20Hashing.pdf)|
|Max-Heap Class|-|-|[Here](https://github.com/Pipp432/final/blob/main/Heap/MaxHeap.java)|
|isHeap()|-|-|Heap.java|
|makeHeap3()|-|-|Heap.java|
|Heap Deletion and insertion|final_2019|-|Heap.java|
|Heap changeData()|final_2019|-|Heap.java|f
|Doubly Linked List sorting algorithms|HW|-|CDLinkedList.java|
|CalculateMaxIndex()|Prof's book|-|Heap.java|
|RemoveValue()|Prof's book|-|Heap.java|
|recursiveNumLeaves()|Prof's book|-|BSTRecursive.java|
|maxNode()|Prof's book|-|BSTRecursive.java|
|createMirror()|Prof's book|-|BSTRecursive.java|
|isLeaf()|Prof's book|-|BSTRecursive.java|
|All tree traversal methods|Prof's book|-|BSTRecursive.java|
|Tree Deep Copy|-|-|BSTRecursive.java|
|SortedArrayToAVL()|GeekForGeeks.com|O(n)|BSTRecursive.java|
|hasPathSum()|GeekForGeeks.com|O(nlogn)|BSTRecursive.java|
|Kth largest element in an array|LeetCode.com|-|heap.java|
|average()|Prof's book|-|BSTRecurrsive.java|
same|Prof's book|-|BSTRecurrsive.java|
|sameData()|Prof's book|-|BSTRecurrsive.java|
|findParent()|Prof's book|-|BSTRecurrsive.java|
|findNextLargest()|Prof's book|-|BSTRecurrsive.java|
|removeSecond()|Prof's book|-|Heap.java|
|sortTwoArray()|Prof's book|-|Heap.java|

# What I have learn while preparing

## General

1. Do not pigeonhole yourself with the method header. Crate Overloaded methods to help.


## AVL tree and BST

1. When inserting a data into an AVL tree the syntax is : `node = tree.insert(node)`

2. When recurrsion must be done to a BST or AVL tree the base cases are the node inputed is null and the left and right child is null (leaf case)
`if(inputNode == null) return true (or false)`<br>
`if(node.left == null && node.right==null) return true (or false)`

3. Use traversals for cases

- `Preorder (root, left, right)`: Explores the root before leaves (Uses: create deep copy of the tree)

- `Postorder (left, right, root)`: Explores the leaves before root (Uses: delete leaf to root)
- `Inorder (left, root, right)`: Best for BST it returns the data in non decreasing order (basically returns the sequence in which the tree is created)
- `Breadth-first`: Returns each level of the tree

4. Think of the action that must be done to the current node then recurrse to the left and right.

5. DO NOT TRUST THE isAVL() method because null input returns true

6. It's easier to work with a node than the whole tree so any method passing in a BST should be overloaded to pass in the root node.