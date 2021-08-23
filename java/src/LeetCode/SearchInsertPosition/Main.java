package LeetCode.SearchInsertPosition;

public class Main {
    static public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            if (d >= target) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
//        int[] nums = {};
//        int target = 1;
//        int[] nums = {1,3,5,6};
//        int target = 5;
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}
