package codility.CountTriangles;

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

    // TODO: 캐터필러 방법으로 푸는 법 확인하기
    static public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int P = A[i];
            for (int j = i + 1; j < A.length -1; j++) {
                int Q = A[j];
                for (int k = j + 1; k < A.length; k++) {
                    int R = A[k];
                    if (P + Q > R) count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = {10,2,5,1,8,12};
        System.out.println(solution(A));
    }
}
