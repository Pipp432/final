# Sorting
## Table of Complexity
 Sortig Algorithm| Complexity|
|:----------------:|:--------:|
|Bubble Sort|O(n^2)|
|Selection Sort|O(n^2)|
|Insertion Sort|O(n^2)|
|Merge Sort|O(log(n))|
|Quick Sort|O(log(n))|
|Bucket Sort|O(n^2)|
## Bubble Sort
### Intro & General Idea
&ensp;Bubble sort is one of the most basic sorting method.
The main idea is to compare and swap each adjecent data until the data is sorted and therefore the data with smallest value is "bubbled" to the front.
### Algorithm
Consider the array: [1, 4, 5, 10, 7, 6]<br><br>
*_First Pass_*<br>
[`1`, `4`, 5, 10, 7, 6]<br>
[1, `4`, `5`, 10, 7, 6]<br>
[1, 4, `5`, `10`, 7, 6]<br>
[1, 4, 5, `10`, `7`, 6] Swap occurs <br>
[1, 4, 5, 7, `10`, `6`] Swap occurs <br>
[1, 4, 5, 7, 6, 10] End first pass (10 is sorted)<br><br>
*_Second Pass_*<br>
[`1`, `4`, 5, 7, 6, 10] <br>
[1, `4`, `5`, 7, 6, 10] <br>
[1, 4, `5`, `7`, 6, 10] <br>
[1, 4, 5, `7`, `6`, 10] Swap occurs <br>
[1, 4, 5, 6, 7, 10] End of second pass (7 and 10 are sorted)<br>

*_Third, Foruth & Fifth Pass_*<br>
[1, 4, 5, 6, 7, 10] End of second pass (1, 4, 5, 6, 7 and 10 are sorted)<br>
### *_Time complexity: O(n^2)_*
**NOTE**: The code does not stop when the array is sorted. It stops when it completes the length-1 pass.<br>
_*DONE*_<br>

## Selection Sort
### Intro & General Idea
&ensp;Selection sort works by finding the minimum element in an array and put it into the beginning of the array. The algorithm uses 2 subarrays. One that stores the sorted data and the other stores the remaining unsorted data.
### Algorithm
Consider the array: [1, 4, 5, 10, 7, 6]<br><br>
*_First Pass_*<br>
Find minimum data from index 0 to 5 and swap with index 0<br>
[`1`,| 4, 5, 10, 7, 6]<br><br>
*_Second Pass_*<br>
Find minimum data from index 1 to 5 and swap with index 1<br>
[`1`, `4`,| 5, 10, 7, 6]<br><br>
*_Third Pass_*<br>
Find minimum data from index 2 to 5 and swap with index 2<br>
[`1`, `4`, `5`,| 10, 7, 6]<br><br>
*_Fourth Pass_*<br>
Find minimum data from index 3 to 5 and swap with index 3<br>
[`1`, `4`, `5`,`6`,| 10, 7]<br><br>
*_Fifth Pass_*<br>
Find minimum data from index 4 to 5 and swap with index 4<br>
[`1`, `4`, `5`,`6`,`7`,| 10]<br><br>
*_Fifth Pass_*<br>
Find minimum data from index 5 to 5 and swap with index 5<br>
[`1`, `4`, `5`,`6`,`7`,`10`]<br><br>
### *_Time complexity: O(n^2)_*
_*DONE*_

## Insertion Sort
### Intro & General Idea
&ensp;Insertion sort works by comparing an element to the index next of it, if the next one is lesser than it insert the lesser data to the front of the selected data (Hence, insertion sort)
### Algorithm
Consider the array: [1, 4, 5, 10, 7, 6]<br>
*_First Pass_*<br>
Select 4 (i = 1)<br>
Since 1 is lesser than 4 no need to do insertion<br><br>
*_Second Pass_*<br>
Select 5 (i = 2)<br>
Since 1 and 4 is lesser than 5 no need to do insertion<br><br>
*_Third Pass_*<br>
Select 10 (i = 3)<br>
Since 1, 4 and 5 is lesser than 10 no need to do insertion<br><br>
*_Fourth Pass_*<br>
Select 7 (i = 4)<br>
7 is less than 10 so insert it infront of 10<br>
[1, 4, 5, `7`, `10`,6]<br><br>
*_Fifth Pass_*<br>
Select 6 (i = 5)<br>
6 is less than 10 and 7 so insert it infront of 7<br>
[1, 4, 5, `6`, `7`, `10`]<br>
[1, 4, 5, 6, 7, 10]<br><br>
### *_Time complexity: O(n^2)_*
_*DONE*_

## Merge Sort
### Intro & General Idea
&ensp; Merge sort is known as a *_divide and conquer algorithm_*. These types of these algorithm work by dividing the array into 2 halves, sort them and merge the sorted halves. To illustrate the algorithm<br><br>
![alt text](https://media.geeksforgeeks.org/wp-content/cdn-uploads/Merge-Sort-Tutorial.png)<br>
### Algorithm
Consider the array: [1, 4, 5, 10, 7, 6]<br><br>
#### Dividing Array
*_First Pass_*<br>
Find the middle of the array: between 5 and 10<br>
Result Array: [1, 4, 5], [10, 7, 6]<br><br>
*_Second Pass_*<br>
Find middle of arrays : 4 and 7<br>
Result Array: [1, 4], [5], [10], [7, 6] (or [1], [4, 5], [10] [7, 6] up to you!)<br><br>
*_Third Pass_*<br>
Find middle of arrays : between 1 and 4 and between 7 and 6<br>
Result Array: [1], [4], [5], [10], [7], [6] <br><br>
Since the arrays are as small as possible we sort them<br>
#### Sorting & Merge Arrays
Current Arrays: [1], [4], [5], [10], [7], [6] <br><br>
Select 2 arrays sort them and then merge them<br><br>
*_First Pass_*<br>
Result Array: [1, 4], [5], [10], [6, 7]<br><br>
*_Second Pass_*<br>
Result Array: [1, 4, 5], [6, 7, 10]<br><br>
*_Third Pass_*<br>
Result Array: [1, 4, 5, 6, 7, 10]<br>
#### A very good explantion and source code: https://www.youtube.com/watch?v=bOk35XmHPKs
### *_Time complexity: O(log(n))_*
_*DONE*_
## Quick Sort
&ensp;&ensp; Quick sort is again a divide and conquer algorithm. It is one of the fastest sorting algorithm. The algorithm is composed of three parts: *Pivot selection*, *Partitioning*, and *Recursive calling*.
### Algorithm
Consider the array: [1, 5, 7, 9, 10, 6, 11, 8]<br>

#### Pivot Selection<br>

For simplicity we shall select the last element of an array to be the pivot.<br>
[1, 5, 7, 9, 10, 6, 11, `8`] <br>

#### Partition<br>

Now put all element with value less than the pivot to the left and all element with value more than the pivot to the right.<br>
[1, 5, 7, 6, `8`, 9, 10, 11]<br>
The details of this method will be best explained in the code (Easy to say, hard to code situation).<br>
Note that the current pivot is now in the sorted position.<br>

#### Recursive Calls<br>

The method will now be called for the left and right partition arrays until the whole array is sorted.
## Heap Sort
A Heap is sorted by nature 