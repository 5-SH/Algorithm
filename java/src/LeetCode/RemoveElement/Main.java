package LeetCode.RemoveElement;

public class Main {
    public void print(int[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i != arr.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    // [1,1,1,1,1], 1
    // [1,1,1,1,1], 2

    public int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] != val) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            } else {
                // do nothing
            }
        }

        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) m++;
        }

        return nums.length - m;
    }

    // 리트코드에서 풀어야함
    public static void main(String[] args) {

    }

}
