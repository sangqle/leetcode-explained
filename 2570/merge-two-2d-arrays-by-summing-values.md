# Introduction
problem: https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
## Description
You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.


### Example 1

```plaintext
Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: The resulting array contains the following:
- id = 1, the value of this id is 2 + 4 = 6.
- id = 2, the value of this id is 3.
- id = 3, the value of this id is 2.
- id = 4, the value of this id is 5 + 1 = 6.
```

### Example 2
```plaintext
Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
Explanation: There are no common ids, so we just include each id with its value in the resulting list.
```

# Solution


## Hint
- You can use a HashMap to store the ids and their values. In this case we can use TreeMap to store the ids to keep them sorted.
- You also can use 2 pointers to iterate over the 2 arrays.

## Approach

We are going to use both approaches to solve this problem.
1. We will use a TreeMap to store the ids and their values.
  - We will iterate over the first array and add the ids and their values to the TreeMap.
  - We will iterate over the second array and add the ids and their values to the TreeMap.
    - If the id is already in the TreeMap, we will increse the value by the value in the second array.
  - We will return the TreeMap as a list of lists.

2. We will use 2 pointers to iterate over the 2 arrays.
  - We will initialize 2 pointers `i` and `j` to 0.
  - We will iterate over the 2 arrays until one of the pointers reaches the end of the array.
    - If the id in the first array is equal to the id in the second array, we will add the id and the sum of the values to the result list. And we will increment both pointers.
    - If the id in the first array is less than the id in the second array, we will add the id and the value from the first array to the result list. And we will increment the pointer of the first array.
    - Otherwise, we will add the id and the value from the second array to the result list. And we will increment the pointer of the second array.
  - We will add the remaining elements of the first array to the result list.
  - We will add the remaining elements of the second array to the result list.
  - Return the result list.

## Time complexity

1. When using TreeMap, the time complexity is O(nlog(n)) where n is the length of the longest array.
2. When using 2 pointers, the time complexity is O(n) where n is the length of the longest array.

## Code

### 1. Using TreeMap

```java
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> sumMap = new TreeMap<>();

        for(int i = 0; i < nums1.length; i++) {
            int key = nums1[i][0];
            int value = nums1[i][1];
            if(!sumMap.containsKey(key)) {
                sumMap.put(key, value);

            }
        }

        for(int i = 0; i < nums2.length; i++) {
            int key = nums2[i][0];
            int value = nums2[i][1];
            if(!sumMap.containsKey(key)) {
                sumMap.put(key, value);
            } else {
                int curr = sumMap.get(key);
                sumMap.put(key, curr + value);
            }
        }

        int[][] rs = new int[sumMap.size()][];

        int k = 0;
        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
        int[] arr = new int[2];
        arr[0] = entry.getKey();
        arr[1] = entry.getValue();
        rs[k++] = arr;
        }

        return rs;
    }
}
```

### 2. Using 2 pointers

```java
class Solution {
  public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    // Use 2 pointers to iterate through the 2 arrays
    int i = 0, j = 0;
    int n = nums1.length, m = nums2.length;
    List<List<Integer>> rs = new ArrayList<>();

    // Iterate through the 2 arrays and merge them
    while (i < n && j < m) {
      if (nums1[i][0] == nums2[j][0]) {
        rs.add(Arrays.asList(nums1[i][0], nums1[i][1] + nums2[j][1]));
        i++;
        j++;
      } else if (nums1[i][0] < nums2[j][0]) {
        rs.add(Arrays.asList(nums1[i][0], nums1[i][1]));
        i++;
      } else {
        rs.add(Arrays.asList(nums2[j][0], nums2[j][1]));
        j++;
      }
    }

    // Add the remaining elements
    while (i < n) {
      rs.add(Arrays.asList(nums1[i][0], nums1[i][1]));
      i++;
    }

    while (j < m) {
      rs.add(Arrays.asList(nums2[j][0], nums2[j][1]));
      j++;
    }

    // Convert the list to 2D array
    int[][] result = new int[rs.size()][2];
    for (int k = 0; k < rs.size(); k++) {
      result[k][0] = rs.get(k).get(0);
      result[k][1] = rs.get(k).get(1);
    }

    return result;

  }

  public static void printResult(int[][] rs) {
    for (int[] r : rs) {
      System.out.println(r[0] + " " + r[1]);
    }
  }

  public static void main(String[] args) {
    int[][] nums1 = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 } };
    int[][] nums2 = new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } };

    printResult(mergeArrays(nums1, nums2));

  }
}
```
