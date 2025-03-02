import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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