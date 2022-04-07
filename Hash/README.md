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
#### 1. Linear Probing 
f(i) in this implementation is defined as: f(i) = i, basically pushing the collided data to the next slot
#### Example 
Inserting  700, 50, 76, 85, 92, 101, 73 with h<sub>i</sub>(x) = (hash(x) + f(i)) % array size<br><br>
![alt text](https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2015/08/openAddressing1.png)<br>

&ensp;&ensp;For searching and removing are the same, but a problem arises. Since the searching and removing algorithms stops when an empty slot (data is not in table) or the data is found. _**This can cause our algorithm to stop prematurely**_.
A solution is using _**lazy deletion**_ by adding `DL` into a removed slot to make the algorithm continue.<br>
&ensp;&ensp;Another problem with linear probing is _**primary clustering**_, where several slots are likely to be cosecutively occupied, which causes collisions because linear probing searches the next slot to the one collided.
#### 2. Quadratic Probing 
In this approach we have: f(i) = i^2<br>
#### Example 
Inserting  700, 50, 76, 85, 92, 101, 73 with h<sub>i</sub>(x) = (hash(x) + f(i)) % array size<br><br>
<img src="https://media.geeksforgeeks.org/wp-content/uploads/20200421211818/Hashing3.png" alt="drawing" width="450"/><br>

&ensp;&ensp;A problem with this implementation is if a collision occurs on same slots the longer it takes to find an empty slot. This is called _**secondary clustering**_. An occurs because the method of calculation is the same for the data that has the same collision.
&ensp;&ensp;A size of the hash table using this technique is special because if the table size is a prime and the hash table is not yet half full then we can always find a new slot for the data.
#### 3. Double Hashing
This implementation uses<br>
f(i) =  i * hash<sub>2</sub>(x), where x is the data.<br>
This implementation avoids primary and secondary clustering beacause the second hashing will make the pattern for each data likely to be different. An example<br>
<img src="https://media.geeksforgeeks.org/wp-content/uploads/double-hash-function.png" alt="drawing" width="450"/><br>