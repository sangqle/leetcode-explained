import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public static List<List<Integer>> twoSum(int[] nums, int j, int target) {
    int aPointer = j + 1;
    int bPointer = nums.length - 1;
    List<List<Integer>> threeSums = new ArrayList<>();
    while (aPointer < bPointer) {
      int curSum = nums[aPointer] + nums[bPointer];
      if (curSum < target) {
        aPointer++;
      } else if (curSum > target) {
        bPointer--;
      } else {
        threeSums.add(Arrays.asList(nums[j], nums[aPointer], nums[bPointer]));
        aPointer++;
        bPointer--;
      }
    }
    return threeSums;
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> uniqueSet = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {

      List<List<Integer>> sums = twoSum(nums, i, -nums[i]);
      uniqueSet.addAll(sums);
    }
    return new ArrayList<>(uniqueSet);
  }

  public static void main(String[] args) {
    int[] test1 = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
    int[] test2 = { -4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4 };
    int[] test3 = { -1, 0, 1, 2, -1, -4 };

    System.err.println(threeSum(test1));
    System.err.println(threeSum(test2));
    System.err.println(threeSum(test3));
  }
}