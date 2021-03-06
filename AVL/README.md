# AVL tree
## Basic & Introduction
&nbsp;&nbsp;AVL tree was created to solve a problem with BST. Consider the case where the data is input in a sorted manner (ascending or descending). A problem will arise that the searching algorithms will have time complexity of O(n) so AVL is created to help balance the tree.

![alt text](https://www.tutorialspoint.com/data_structures_algorithms/images/unbalanced_bst.jpg)

&nbsp;&nbsp;AVL tree named after its inventors: Adelson, Velski & Landis
The structure of the tree is very similar to BST but with one big differrence that is the **_Balance Factor._**

The balance factor can be calculated by:
```java
BalanceFactor = height(leftSubtree) − height(rightSubtree)
```
This can be applied to each node to see its balance factor
![alt text](https://www.tutorialspoint.com/data_structures_algorithms/images/unbalanced_avl_trees.jpg)

An AVL tree is considered **_balance_** if the nodes have a balance factor of -1, 0 or 1.<br>
![alt text](https://static.javatpoint.com/ds/images/avl-tree.png)
## AVL operation
These are very similar to BST

| Algorithm        | Time Complexity |
| ------------- |:-------------:| 
| Search    | O(log n) | 
| Insert    | O(log n) |     
| Delete    | O(log n) |      

## AVL Rotations
These are preformed on the AVL tree if the balance factors are not -1, 0 or 1.
There are 4 types of AVL rotations.

| Unbalance State      | Operation | Action|
| ------------- |:-------------:|:-------------:| 
| Right Right Unbalanced (RR)| Left Rotation|![alt text](https://static.javatpoint.com/ds/images/avl-tree.jpg)|
| Left Left Unbalanced (LL)| Right Rotation|![alt text](https://static.javatpoint.com/ds/images/avl-tree2.jpg)|
| Left Right Unbalanced (LR)| RR + LL <br>(Left Rotation + Right Rotation)|1.<br> ![alt text](https://static.javatpoint.com/ds/images/avl-tree3.jpg)<br> 2.<br>![alt text](https://static.javatpoint.com/ds/images/avl-tree4.jpg)<br> 3.<br>![alt text](https://static.javatpoint.com/ds/images/avl-tree5.jpg)<br> 4.<br>![alt text](https://static.javatpoint.com/ds/images/avl-tree6.jpg) <br>5.<br>![alt text](https://static.javatpoint.com/ds/images/avl-tree7.jpg)|
|Right Left Unbalanced| LL + RR <br>(Right Rotation + Left Rotation)|1.<br> ![alt text](https://static.javatpoint.com/ds/images/avl-tree8.jpg)<br> 2.<br> ![alt text](https://static.javatpoint.com/ds/images/avl-tree9.jpg)<br> 3.<br> ![alt text](https://static.javatpoint.com/ds/images/avl-tree10.jpg)<br> 4.<br>![alt text](https://static.javatpoint.com/ds/images/avl-tree11.jpg)<br> 5.<br> ![alt text](https://static.javatpoint.com/ds/images/avl-tree12.jpg) |

## AVL vs BST
| Parameter     | BST | AVL tree|
| ------------- |:-------------:|:-------------:| 
|Height of the tree|can be log(n) to n depends on order of insertion|always log(n)|
|Searching for sorted insertions|Time complexity: O(n)| Time Complexity: O(log n)|