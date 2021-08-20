package codility.TapeEquilibrium;

import java.util.Scanner;

public class Main {
  public static int solution(int[] A) {
    int total = 0;
    for (int a : A) {
      total += a;
    }

    int result = 0;
    boolean init = true;
    int frontSum = 0;
    for (int p = 0; p < A.length - 1; p++) {
      frontSum += A[p];
      int add2 = total - frontSum;
      int cal = Math.abs(frontSum - add2);
      if (init) {
        result = cal;
        init = false;
      } else {
        if (cal < result) result = cal;
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    String[] arr = in.nextLine().trim().split(",");
//
//    int[] A = new int[arr.length];
//    for (int i = 0; i < arr.length; i++) {
//      A[i] = Integer.parseInt(arr[i]);
//    }

//    System.out.println(solution(A));

//    StringBuilder builder = new StringBuilder();
//    builder.append("[");
//    for (int i = 0; i < 100000; i++) {
//      builder.append("1");
//      if (i != 100000 - 1) builder.append(",");
//    }
//    builder.append("]");
//    System.out.println(builder);

//    int[] A = new int[100000];
//    for (int i = 0; i < 100000; i++) {
//      A[i] = 1000;
//    }
//    int[] A = {3,1,2,4,3};
//    int[] A = {0,0};
//    int[] A = {1000,-1000};
//    int[] A = {1000,0,0,0,-1000};
    int[] A = new int[100000];
    A[0] = -1000;
    A[100000 - 1] = -1000;
    for (int i = 0; i < 100000 - 2; i++) {
      A[i] = -1000;
    }
    long start = System.currentTimeMillis();
    System.out.println(solution(A));
    long end = System.currentTimeMillis();
    System.out.println("수행시간 : " + (end - start) + " ms");
//    int count = 0;
//    for (int k : A) {
//      System.out.println(count++ + " : " + k);
//    }
  }
}
