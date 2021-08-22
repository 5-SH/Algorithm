package programmers.카펫;

public class Main {
    static public int[] solution(int brown, int yellow) {
        // 가로(w) >= 세로(h)
        int w = 0;
        int h = 0;

        int a = 0;
        int b = 0;
        int ab = (brown + 4) / 2;
        for (int i = 3; i < ab; i++) {
            a = i;
            b = ab - i;
            if (a > b) break;

            if ((a - 2) * (b - 2) == yellow) {
                w = Math.max(a, b);
                h = Math.min(a, b);
            }
        }

        int[] result = new int[2];
        result[0] = w;
        result[1] = h;
        return result;
    }

    public static void main(String[] args) {
        int[] r = solution(24, 24);
        System.out.println(r[0] + ", " + r[1]);
    }
}
