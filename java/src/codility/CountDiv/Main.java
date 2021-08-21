package codility.CountDiv;

import java.util.*;

public class Main {
  static public int solution2(int A, int B, int K) {
    int result = 0;
    result = (B / K) - (A / K);
    if ((A / K) >= 1 && (A % K) == 0) result += 1;
    if (A == 0 || B == 0) result += 1;
    return result;
  }

  // 시간초과 발생
  static public int solution(int A, int B, int K) {
    int result = 0;
    for (int i = A; i <= B; i++) {
      if (i != 0 && i < K) continue;
      if (i % K == 0) result++;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(solution2(0, 2000000000, 2000000000)); // 2
    System.out.println(solution2(0, 2000000000, 1)); // 2000000001
    System.out.println(solution2(0, 5, 2000000000)); // 1
    System.out.println(solution2(0, 0, 11)); // 1
    System.out.println(solution2(0, 1, 1)); // 2
    System.out.println(solution2(0, 7, 3)); // 3
    System.out.println(solution2(0, 3, 20)); // 1
    System.out.println(solution2(1, 4, 7)); // 0
    System.out.println(solution2(1, 15, 7)); // 2
    System.out.println(solution2(6, 11, 2)); // 3
    System.out.println(solution2(1, 5, 1)); // 5
    System.out.println(solution2(0, 5, 1)); // 6
  }
}
