# Sorting
## Bubble Sort
### Intro & General Idea
&ensp;Bubble sort is one of the most basic sorting method.
The main idea is to compare and swap each adjecent data until the data is sorted and therefore the data with smallest value is "bubbled" to the front.
### Algoritm
Consider the array: [1, 4, 5, 10, 7, 6]<br>
*_First Pass_*<br>
[`1`, `4`, 5, 10, 7, 6]<br>
[1, `4`, `5`, 10, 7, 6]<br>
[1, 4, `5`, `10`, 7, 6]<br>
[1, 4, 5, `10`, `7`, 6] Swap occurs <br>
[1, 4, 5, 7, `10`, `6`] Swap occurs <br>
[1, 4, 5, 7, 6, 10] End first pass (10 is sorted)<br>
*_Second Pass_*<br>
[`1`, `4`, 5, 7, 6, 10] <br>
[1, `4`, `5`, 7, 6, 10] <br>
[1, 4, `5`, `7`, 6, 10] <br>
[1, 4, 5, `7`, `6`, 10] Swap occurs <br>
[1, 4, 5, 6, 7, 10] End of second pass (7 and 10 are sorted)<br>
*_Third, Foruth & Fifth Pass_*<br>
[1, 4, 5, 6, 7, 10] End of second pass (1, 4, 5, 6, 7 and 10 are sorted)<br>
_*DONE*_
**NOTE**: The code does not stop when the array is sorted. It stops when it completes the length-1 pass.<br>
### *_Time complexity: O(n^2)_*

## Selection Sort
### Intro & General Idea
&ensp;Selection sort works by finding the minimum element in an array and put it into the beginning of the array. The algorithm uses 2 subarrays. One that stores the sorted data and the other stores the remaining unsorted data.
### Algoritm
Consider the array: [1, 4, 5, 10, 7, 6]<br>
*_First Pass_*<br>
Find minimum data from index 0 to 5 and swap with index 0<br>
[`1`,| 4, 5, 10, 7, 6]<br>
*_Second Pass_*<br>
Find minimum data from index 1 to 5 and swap with index 1<br>
[`1`, `4`,| 5, 10, 7, 6]<br>
*_Third Pass_*<br>
Find minimum data from index 2 to 5 and swap with index 2<br>
[`1`, `4`, `5`,| 10, 7, 6]<br>
*_Fourth Pass_*<br>
Find minimum data from index 3 to 5 and swap with index 3<br>
[`1`, `4`, `5`,`6`,| 10, 7]<br>
*_Fifth Pass_*<br>
Find minimum data from index 4 to 5 and swap with index 4<br>
[`1`, `4`, `5`,`6`,`7`,| 10]<br>
*_Fifth Pass_*<br>
Find minimum data from index 5 to 5 and swap with index 5<br>
[`1`, `4`, `5`,`6`,`7`,`10`]<br>
_*DONE*_
### *_Time complexity: O(n^2)_*

## Insertion Sort
### Intro & General Idea
&ensp;Insertion sort works by comparing an element to the index next of it, if the next one is lesser than it insert the lesser data to the front of the selected data (Hence, insertion sort)
### Algoritm
Consider the array: [1, 4, 5, 10, 7, 6]<br>
*_First Pass_*<br>
Select 4 (i = 1)<br>
Since 1 is lesser than 4 no need to do insertion<br>
*_Second Pass_*<br>
Select 5 (i = 2)<br>
Since 1 and 4 is lesser than 5 no need to do insertion<br>
*_Third Pass_*<br>
Select 10 (i = 3)<br>
Since 1, 4 and 5 is lesser than 10 no need to do insertion<br>
*_Fourth Pass_*<br>
Select 7 (i = 4)<br>
7 is less than 10 so insert it infront of 10<br>
[1, 4, 5, `7`, `10`,6]<br>
*_Fifth Pass_*<br>
Select 6 (i = 5)<br>
6 is less than 10 and 7 so insert it infront of 7<br>
[1, 4, 5, `6`, `7`, `10`]<br>
[1, 4, 5, 6, 7, 10]<br>
_*DONE*_

