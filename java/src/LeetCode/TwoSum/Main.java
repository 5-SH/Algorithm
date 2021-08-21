package LeetCode.TwoSum;

import java.util.Arrays;

public class Main {
  public static void print(int[] arr) {
    StringBuilder builder = new StringBuilder();
    builder.append("(");
    for (int i = 0; i < arr.length; i++) {
      builder.append(arr[i]);
      if (i != arr.length - 1) {
        builder.append(", ");
      }
    }
    builder.append(")");
    System.out.println(builder.toString());
  }

  static public int[] twoSum(int[] nums, int target) {
    int result[] = new int[2];
    boolean end = false;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int a = nums[i];
        int b = nums[j];

        if ((a + b) == target) {
          result[0] = i;
          result[1] = j;
          end = true;
          break;
        }
        if (end) break;
      }
    }

    return result;
  }

  public static void main(String[] args) {
//    int[] nums = {2,7,11,15};
//    int target = 9;
//    int[] nums = {3,2,4};
//    int target = 6;
//    int[] nums = {0, 3};
//    int target = 3;
//    int[] nums = {10,10,10,10,10,2,3,3};
//    int target = 6;
//    int[] nums = {0, 0};
//    int target = 0;
//    int[] nums = {-1000000000, 0};
//    int target = -1000000000;
//    int[] nums = new int[10000];
//    for (int i = 0; i < 10000; i++) {
//      if (i == 9998) nums[i] = 1000000000;
//      else if (i == 9999) nums[i] = -1;
//      else nums[i] = 0;
//    }
//    print(nums);
//    int target = 999999999;
//    for (int i = 0; i < 10000; i++) {
//      if (i == 9999) nums[i] = 1000000000;
//      else if (i == 2) nums[i] = -1;
//      else nums[i] = 0;
//    }
//    print(nums);
//    int target = 999999999;
//    int[] nums = {0,4,3,0};
//    int target = 0;
    int[] nums = {-1,-2,-3,-4,-5};
    int target = -8;

    print(twoSum(nums, target));
  }
}
