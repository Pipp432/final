# AVL
&nbsp;AVL tree was created to solve a problem with BST. Consider the case where the data is input in a sorted manner (ascending or descending). A problem will arise that the searching algorithms will have time complexity of O(n) so AVL is created to help balance the tree.

![alt text](https://www.tutorialspoint.com/data_structures_algorithms/images/unbalanced_bst.jpg)

&nbsp;AVL tree named after its inventors: Adelson, Velski & Landis
The structure of the tree is very similar to BST but with one big differrence that is the **Balance Factor.**

The balance factor can be calculated by:
```java
BalanceFactor = height(leftSubtree) − height(rightSubtree)
```
This can be applied to each node to see its balance factor
![alt text](https://www.tutorialspoint.com/data_structures_algorithms/images/unbalanced_avl_trees.jpg)

An AVL tree is considered **_balance_** if the nodes have a balance factor of -1, 0 or 1.