package LeetCode.PlusOne;

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

    static public int[] plusOne(int[] digits) {
        boolean up = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
                if (i == 0) {
                    up = true;
                    break;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }

        if (up) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9,9};
        print(plusOne(digits));
    }
}
