/**
 * You are given a 0-indexed array nums of size n consisting of non-negative
 * integers.
 * 
 * You need to apply n - 1 operations to this array where, in the ith operation
 * (0-indexed), you will apply the following on the ith element of nums:
 * 
 * If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to
 * 0. Otherwise, you skip this operation.
 * After performing all the operations, shift all the 0's to the end of the
 * array.
 * 
 * For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end,
 * is [1,2,1,0,0,0].
 * Return the resulting array.
 * 
 * Note that the operations are applied sequentially, not all at once.
 */
public class Solution {
  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static int[] applyOperations(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        nums[i] = nums[i] * 2;
        nums[i + 1] = 0;
      }
    }

    int pos = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[pos] = nums[i];
        pos++;
      }
    }

    while (pos < nums.length) {
      nums[pos] = 0;
      pos++;
    }

    return nums;
  }

  public static void printResult(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      System.err.print(nums[i] + " ");
    }
    System.err.println("");
  }

  public static void main(String[] args) {
    int[] test1 = { 1, 2, 2, 1, 1, 0 };
    int[] test2 = { 1, 2, 3, 4, 8, 0, 1, 2, 0, 0, 3 };
    // 1 2 3 4 8 0 1 2 0 0 3
    // 1, i, p
    // 2, i, p
    // 3, i, p
    // 4, i, p
    // 8, i, p
    // 1, , p,
    // 2, , p
    // 0, , p
    long startTime = System.currentTimeMillis();
    printResult(applyOperations(test1));
    printResult(applyOperations(test2));

    System.err.println("runtime: " + (System.currentTimeMillis() - startTime));
  }
}
