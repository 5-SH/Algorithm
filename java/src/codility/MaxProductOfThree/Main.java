package codility.MaxProductOfThree;

import java.util.Arrays;
import java.util.Collections;

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

  static public int solution(int[] A) {
    Arrays.sort(A);
    int size = A.length;
    int max;
    // 제일 큰 양수 3개
    int cand1 = A[size - 1] * A[size - 2] * A[size -3];
    max = cand1;
    // 제일 작은 음수 2개  * 제일 큰 양수 1개
    if (A[0] < 0 && A[1] < 0) {
      int cand2  = A[0] * A[1] * A[size - 1];
      if (cand2 > max) {
        max = cand2;
      }
    }

    return max;
  }

  public static void main(String[] args) {
//    int[] A = {-3,1,2,-2,5,6};
//    int[] A = {0,0,0};
    int[] A = {0,0,0,-1,-2,3};
//    int[] A = {3,-1000,-1,1,-1000,-1000,1000};
//    int[] A = {-1000, -1000, -10, 1, 2, 3}; // 3,000,000
    System.out.println(solution(A));

  }
}
