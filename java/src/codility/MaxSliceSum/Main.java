package codility.MaxSliceSum;

import java.util.ArrayList;

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

    // 카데인 알고리즘으로 풀어야 한다
    static public int solution2(int[] A) {
        int localMax = A[0];
        int globalMax = A[0];

        for (int i = 1; i < A.length; i++) {
            localMax = Math.max(localMax + A[i], A[i]);
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;
    }

    static public int dp(int[] A) {
        int[][] sum = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (i == 0) {
                    sum[i][j] = A[i];
                } else {
                    sum[i][j] = sum[i - 1][j] + A[i];
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            print(sum[i]);
        }

        return 0;
    }

    static public int solution(int[] A) {
        int sum = 0;
        int[] sumList = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            sumList[i] = sum;
        }

        int idx = 0;
        int max = Integer.MIN_VALUE;
        while (idx < A.length) {
            for (int j = idx; j < A.length; j++) {
                if (j == A.length - 1) {
                    int val = 0;
                    if (idx - 1 > 0) {
                        val = sumList[j] - sumList[idx];
                    } else {
                        val = sumList[j];
                    }
                    if (val > max) max = val;

                } else {
                    if (sumList[j + 1] < sumList[j]) {
                        int val = 0;
                        if (idx - 1 > 0) {
                            val = sumList[j] - sumList[idx];
                        } else {
                            val = sumList[j];
                        }
                        if (val > max) max = val;
                        break;
                    }
                }
            }
            idx++;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] A = {3,2,-6,4,0};
//        int[] A = {3,2,-6,4,10};
//        int[] A = {10,-1,-1,100};
//        int[] A = {0,10,-1,0,10,0,10,0};
        int[] A = {1,1,1,1};

        System.out.println(solution2(A));

    }
}
