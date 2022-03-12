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