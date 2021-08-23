package LeetCode.sqrt_x;

public class Main {
    // x = 0 인 경우하고 x = Integer.MAX_VALUE 인 경우를 생각해야함
    static public int mySqrt(int x) {
        if (x == 0) return 0;

        for (int i = 1; i < 46341; i++) {
            if (((i * i) <= x) && (((i + 1) * (i + 1)) > x)) {
                return i;
            }
        }

        return 46340;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(2147483646));
        System.out.println(mySqrt(0));

    }
}
