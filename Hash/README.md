# Hash Table & Hash Function
## Hash Table
&ensp;A hash table is an array that uses hashing to store its data this allows for quick retrieval of data.<br>

## Hashing
&ensp;Hashing is a technique is a process of mapping key, values into the hash table by using hash functions (denoted as H(x)). In most cases the effiency of hashing is dependent on the hash function used.

_*The main idea*_ is to map an Object into an integer.
_*Hash Function*_ should be:<br>
1. Fast to calculate the keys.
2. Be apporpriate with the type of data.
3. Different keys map to diferent values
## Why use hashing?
The main advantage of hashing is searching only taking 
O(1) for the average cases and O(n) for the worst case<br><br>
![alt text](https://www.tutorialspoint.com/data_structures_algorithms/images/hash_function.jpg)<br>

## Collision and Design of Hash Function 
Since the hash function might not be 1-1 relation an event called _*collision*_, where 2 seperate values generate the same key, which can cause our algorithms to slow down, so to deal with this problem two implementations are used to deal with collisions:<br>
1. Seperate chaining
2. Open addressing