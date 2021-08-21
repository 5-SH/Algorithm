package LeetCode.RemoveDuplicates;

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

  // two pointer
  static public int removeDuplicates(int[] nums) {
    final int NaN = -7777;
    int chk = NaN;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        chk = nums[i];
      } else {
        if (chk == nums[i]) {
          nums[i] = NaN;
        } else {
          chk = nums[i];
        }
      }
    }

    int start = 0;
    int end = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == NaN) {
        start = i;
        end = start;

        while(nums[end] == NaN && (end + 1 < nums.length)) {
          if (end + 1 < nums.length) {
            end++;
          }
        }
        nums[start] = nums[end];
        nums[end] = NaN;
      }
    }

    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != NaN) count++;
    }
    return count;
  }

  public static void main(String[] args) {
//    int[] nums = {0,0,1,1,1,2,2,3,3,4};
//    int[] nums = {1};
//    int[] nums = {};
    int[] nums = {0,0,0,0};
    System.out.println(removeDuplicates(nums));
  }
}
