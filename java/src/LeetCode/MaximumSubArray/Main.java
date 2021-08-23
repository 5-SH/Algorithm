package LeetCode.MaximumSubArray;

public class Main {
    // 카데인 알고리즘
    static public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int globalMax = nums[0];
        int localMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(localMax, globalMax);

            // System.out.println(localMax + ", " + globalMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {1};
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {5,9,8,15};
//        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
