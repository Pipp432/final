# Final

Hello.

# Table of contents

| Topic/Problems | Source | Complexity | Where to find |
|:----------------:|:--------:|:-------:|:---------------:|
|makeAVL()|AVL Aj.Sukree HW|-|AVLTree.java|
|same()|AVL Aj.Sukree HW|-|AVLTree.java|
|CovidData class|Hash Aj.Sukree HW|-|CovidData.java|
|Hash Table Quadratic Probing|HW|-|-|
|Hash Table Double Hasing|HW|-|-|
|Doubly Linked List sorting algorithms|HW|-|CDLinkedList.java|
|isAVL()|AVL Aj.Sukree HW & final_2015|-|AVLTree.java|
|SelectionSort|final_2015|-|SelectionSort2.java|
|removeValue()|final_2015|-|Heap.java|
|addUp()|Prof's book & final_2015|-|AVLTree.java|
|Hash Table Insertions|final_2015|-|-|
|Hash Table Lazy Deletion|final_2015|-|-|
|Faster than O(nlogn) sorting algorithm|final_2015|O(d(n+b))|RadixSort.java & bucketSort.java|
|nonAVLNodes()|final_2017|-|BSTRecursive.java|
|Heap Tree and Heap Node|final_2017|-|HeapTree.java|
|getHeight|final_2017|-|BSTRecursive.java|
|percolateDown()|final_2017|-|HeapTree.java|
|Hash Table Insert & Delete|final_2019|-|-|
|add() for Double Hashing|final_2019|-|DoubleHashing.java|
|Huffman encoding|final_2019|-|Heap file|
|makeHeap3()|final_2019|-|Heap.java|
|Heap Deletion and insertion|final_2019|-|Heap.java|
|Heap changeData()|final_2019|-|Heap.java|
|SortedArrayToAVL()|GeekForGeeks.com|O(n)|BSTRecursive.java|
|hasPathSum()|GeekForGeeks.com|O(nlogn)|BSTRecursive.java|
|average()|Prof's book|-|BSTRecurrsive.java|
|same|Prof's book|-|BSTRecurrsive.java|
|sameData()|Prof's book|-|BSTRecurrsive.java|
|findParent()|Prof's book|-|BSTRecurrsive.java|
|findNextLargest()|Prof's book|-|BSTRecurrsive.java|
|removeSecond()|Prof's book|-|Heap.java|
|sortTwoArray()|Prof's book|-|Heap.java|
|CalculateMaxIndex()|Prof's book|-|Heap.java|
|RemoveValue()|Prof's book|-|Heap.java|
|recursiveNumLeaves()|Prof's book|-|BSTRecursive.java|
|maxNode()|Prof's book|-|BSTRecursive.java|
|createMirror()|Prof's book|-|BSTRecursive.java|
|isLeaf()|Prof's book|-|BSTRecursive.java|
|All tree traversal methods|Prof's book|-|BSTRecursive.java|
|lowestCommonNode()|LeetCode.com|-|BSTRecursive.java|
|sumOfLeaves()|LeetCode.com|-|AVLTree.java|
|deepestLeavesSum()|LeetCode.com|-|AVLTree.java|
|Kth largest element in an array|LeetCode.com|-|heap.java|
|Invert()|EVERY CODING INTERVIEW EVER|O(n)|-|
|AVL Rotation code explanation|-|-|AVL file|
|Tree Deep Copy|-|-|BSTRecursive.java|
|Max-Heap Class|-|-|-|
|isHeap()|-|-|Heap.java|





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

5. It's easier to work with a node than the whole tree so any method passing in a BST should be overloaded to pass in the root node.

## Heap

1. Heap's tree sturcture will have its leaves starting form index `floor(n/2)+1` in its array representation. Use this to help with checking and parent only operations

2. Max heap and Min heap's code are similar

## Sorting

### Bubble sort

- Iterate n-1 times, compares adjecent data
- Slow

### Insertion sort

- Two Pointer algorithm: First one points at array. Second one points to the sorted part of the array
- When the first pointer moves to a new data, the second pointer searches for a position within the sorted array to insert the first pointer's data into

### Selection sort

- Two Pointer algorithm: First one points to a data in the array. Second one points to any data we want to compare the first pointer's data to.

- When the first pointer moves, we assume it is the minimum data, then second pointer search the rest of the array from the first pointer's position to find whether there is a data less than the first pointer's data if found swap them and move the first pointer forward.

### Merge sort

- Divide and Conquer algorithm: steps 
<br>1. divide the array into left and right halves
<br> 2. sort the halves
<br> 3. merge them back

- Explaination of each function
<br>
`mergeSort(int[] array)` divides the array into its two halves. It is recurrsivly called until the size of each half is less than 2. It then calls merge(int[] array, int[] left, int[] right)<br><br>
`merge(int[] array, int[] left, int[] right)` 3 pointers are declared for each array and a basic comparison is made until either the left of right half is ran through then empty the remaining data into the array

### Quick sort

- Divide and Conquer algorithm: steps
<br>1. Choose a pivot 
<br>2. Throw every data less than the pivot to the left of the pivot and the data more than the pivot to the right
<br> 3. The pivot is sorted and do the same for each half 

- Explaination of each function
<br> `swap(int[]arr, int index1,int index2)`<br>
basically swap data from index 1 and 2<br>
`quickSort(int[]arr)` does the pivot selection and rearrange the data using swap
