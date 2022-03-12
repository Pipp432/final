# Sorting
## Bubble sort
### Intro
Bubble sort is one of the most basic sorting method.
The main idea is to compare and swap each adjecent data until the data is sorted.
### Algoritm
Consider the array: [1, 4, 5, 10, 7,6]
*_First Pass_*<br>
[**_1_**, **_4_**, 5, 10, 7, 6]<br>
[1, **_4_**, **_5_**, 10, 7, 6]<br>
[1, 4, **_5_**, **_1_0**, 7, 6]<br>
[1, 4, 5, **_1_0**, **_7_**, 6] Swap occurs <br>
[1, 4, 5, 7, **_1_0**, **_6_**] Swap occurs <br>
[1, 4, 5, 7, 6, 10] End first pass (10 is sorted)<br>
*_Second Pass_*<br>
[**_1_**, **_4*_*, 5, 7, 6, 10] <br>
[1, **_4_**, **_5_**, 7, 6, 10] <br>
[1, 4, **_5_**, **_7_**, 6, 10] <br>
[1, 4, 5, **_7_**, **_6_**, 10] Swap occurs <br>
[1, 4, 5, 6, 7, 10] End of second pass (7 and 10 are sorted)<br>
*_Third, Foruth & Fifth Pass_*<br>
[1, 4, 5, 6, 7, 10] End of second pass (1,4,5,6,7 and 10 are sorted)<br>
**NOTE**: The code does not stop when the array is sorted. It stops when it completes the length-1 pass.<br>
*_Time complexity: O(n^2)_*