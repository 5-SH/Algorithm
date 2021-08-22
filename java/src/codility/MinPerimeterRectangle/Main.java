package codility.MinPerimeterRectangle;

public class Main {
    static public int solution(int N) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                int a = i;
                int b = N / i;

                min = Math.min(min, 2 * (a + b));
            }
        }


        if ((Math.sqrt(N) % 1) == 0) {
            int v = (int) Math.sqrt(N);
            min = Math.min(4 * v, min);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution(121));
        System.out.println(solution(1));
        System.out.println(solution(1000000000));
        System.out.println(solution(30));
    }
}
