import java.util.HashMap;

/**
 * A sequence x1, x2, ..., xn is Fibonacci-like if:
 * 
 * n >= 3
 * xi + xi+1 == xi+2 for all i + 2 <= n
 * Given a strictly increasing array arr of positive integers forming a
 * sequence, return the length of the longest Fibonacci-like subsequence of arr.
 * If one does not exist, return 0.
 * 
 * A subsequence is derived from another sequence arr by deleting any number of
 * elements (including none) from arr, without changing the order of the
 * remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6,7,
 * 8].
 * 
 */
class Solution {

  public static int lenLongestFibSubseq(int[] arr) {
    int maxCount = 0;
    int[][] dp = new int[arr.length][arr.length];
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      indexMap.put(arr[i], i);
    }

    for (int i = 1; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int prev = arr[j] - arr[i];
        if (indexMap.containsKey(prev)) {
          int k = indexMap.get(prev);
          if (k < i) {
            dp[i][j] = Math.max(dp[i][j], dp[k][i] > 0 ? dp[k][i] + 1 : 3);
            maxCount = Math.max(maxCount, dp[i][j]);
          }
        }
      }
    }

    return maxCount;
  }

  public static void main(String[] args) {
    int[] test2 = { 1, 3, 7, 11, 12, 14, 18 };
    int[] test1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int[] test3 = { 2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50 };
    int[] test4 = { 2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 34 };
    int[] test5 = { 1, 2, 5, 6, 11, 13, 15, 17, 28 };

    System.err.println("Test case 1, 5: " + lenLongestFibSubseq(test1));
    System.err.println("Test case 2, 3: " + lenLongestFibSubseq(test2));
    System.err.println("Test case 3, 5: " + lenLongestFibSubseq(test3));
    System.err.println("Test case 4, 5: " + lenLongestFibSubseq(test4));
    System.err.println("Test case 5, 6: " + lenLongestFibSubseq(test5));
  }
}