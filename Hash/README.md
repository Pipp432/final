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
### 1. Seperate chaining
This idea can simply be explained as follows:
- Each array slots, instead of storing a single element, sotres a linked list of data instead.
- All data with same hash value (key) go into the same linked list.
- To find a data, use the hash function to find the linked list and then search for the data within it.
- To add a new data, use a hash function to find a linked list that will (or already) store that data, then search the list for that data. If the list already have the data do nothing, else add new data to the front of the list
### 2. Open Addressing 
This implementation handles the event of a collision.<br>
The pattern of finding slots:<br>
- If data is x, we first check array slot h<sub>0</sub>(x) in the array.
- If the data collides with another existing data, try slot h<sub>1</sub>(x) in the array.
- If the data still collides, try slot h<sub>2</sub>(x), etc.<br>
Where, h<sub>i</sub>(x) = (hash(x) + f(i)) % array size and f(0) = 0

### Defining f(i)
1. Linear Probing 
f(i) in this implementation is defined as: f(i) = i<br>
, basically pushing the collided data to the next slot
#### Example 
Inserting  700, 50, 76, 85, 92, 101, 73 with h<sub>i</sub>(x) = (hash(x) + f(i)) % array size<br><br>
![alt text](https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2015/08/openAddressing1.png)<br>


