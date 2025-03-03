# Introduction
problem: https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

## Description
You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

Every element less than pivot appears before every element greater than pivot.
Every element equal to pivot appears in between the elements less than and greater than pivot.
The relative order of the elements less than pivot and the elements greater than pivot is maintained.
More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
Return nums after the rearrangement.

### Example 1

```plaintext
Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
Explanation: 
The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.

```

### Example 2
```plaintext
Input: nums = [-3,4,3,2], pivot = 2
Output: [-3,2,4,3]
Explanation: 
The element -3 is less than the pivot so it is on the left side of the array.
The elements 4 and 3 are greater than the pivot so they are on the right side of the array.
The relative ordering of the elements less than and greater than pivot is also maintained. [-3] and [4, 3] are the respective orderings.
```

## Approach
- We can use a two pointer approach to solve this problem.



## Hint
- Iterate over the array and keep track of the elements less than and greater than the pivot.
- Use a temporary array to store the elements in the required order.

## Explanation
1. Initialize two pointers, one for the left side and one for the right side.
2. Iterate over the array and check if the element is less than, greater than to the pivot.
    - Push the element to the left side if it is less than the pivot.
    - Push the element to the right side if it is greater than the pivot.
3. Fill the middle with the elements equal to the pivot.
4. Return the new array.

## Time complexity
The time complexity is O(n) where n is the length of the prices array.

## Code
```java
public static int[] pivotArray(int[] nums, int pivot) {
int[] rs = new int[nums.length];

int i = 0;
int j = nums.length - 1;

for (int l = 0, r = nums.length; l < nums.length; l++, r--) {
    if (nums[l] < pivot) {
    rs[i++] = nums[l];
    }
    if (nums[r] > pivot) {
    rs[j--] = nums[r];
    }
}

while (i <= j) {
    rs[i++] = pivot;
}

return rs;
}
```