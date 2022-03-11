# AVL tree
## Basic & Introduction
&nbsp;AVL tree was created to solve a problem with BST. Consider the case where the data is input in a sorted manner (ascending or descending). A problem will arise that the searching algorithms will have time complexity of O(n) so AVL is created to help balance the tree.

![alt text](https://www.tutorialspoint.com/data_structures_algorithms/images/unbalanced_bst.jpg)

&nbsp;AVL tree named after its inventors: Adelson, Velski & Landis
The structure of the tree is very similar to BST but with one big differrence that is the **_Balance Factor._**

The balance factor can be calculated by:
```java
BalanceFactor = height(leftSubtree) − height(rightSubtree)
```
This can be applied to each node to see its balance factor
![alt text](https://www.tutorialspoint.com/data_structures_algorithms/images/unbalanced_avl_trees.jpg)

An AVL tree is considered **_balance_** if the nodes have a balance factor of -1, 0 or 1.
![alt text](https://static.javatpoint.com/ds/images/avl-tree.png)
## AVL operation
These are very similar to BST

| Algorithm        | Time Complexity |
| ------------- |:-------------:| 
| Search      | O(log n) | 
| Insert    | O(log n) |     
| Delete| O(log n) |      

## AVL Rotations
These are preformed on the AVL tree if the balance factors are not -1, 0 or 1.