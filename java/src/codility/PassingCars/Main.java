package codility.PassingCars;

import java.util.HashSet;

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
    // write your code in Java SE 8
    int[] sumList = new int[A.length];
    HashSet<Integer> set = new HashSet<>();
    int sum = 0;
    for (int i = A.length - 1; i >= 0; i--) {
      if (A[i] == 1) {
        sum += 1;
      } else {
        set.add(i);
      }
      sumList[i] = sum;
    }

    long count = 0;
    for (int a : set) {
      count += sumList[a];
    }

    long max = Long.valueOf(1000000000);
    int result = 0;
    if (count > max) {
      result = -1;
    } else {
      result = Long.valueOf(count).intValue();
    }

    return result;
  }
  public static void main(String[] args) {
//    System.out.println(Integer.MAX_VALUE);
    int[] A1 = {0,1,0,1,1}; // 5
    int[] A2 = {0,1,0,1,0,1}; // 6
    int[] A3 = {0,0,0,1,1,1}; // 9
    int[] A4 = {0,1,0,1}; // 3
    int[] A5 = {0,0,0,1,1,0,1}; // 10
    int[] A6 = {1,1,1,0,0,0,1}; // 3
    int[] A7 = {0}; // 0
    int[] A8 = {0,0}; // 0
    int[] A9 = {0,0,1}; // 2
    int[] A10 = {1}; // 0
    int[] A11 = {1,1}; // 0
    int[] A12 = {1,1,0}; // 0

    int[] A13 = new int[100000];
    for (int i = 0; i < 100000; i++) {
      if (i <= 49999) {
        A13[i] = 0;
      } else {
        A13[i] = 1;
      }
    }

    System.out.println(solution(A1));
    System.out.println("----------------------------");
    System.out.println(solution(A2));
    System.out.println("----------------------------");
    System.out.println(solution(A3));
    System.out.println("----------------------------");
    System.out.println(solution(A4));
    System.out.println("----------------------------");
    System.out.println(solution(A5));
    System.out.println("----------------------------");
    System.out.println(solution(A6));
    System.out.println("----------------------------");
    System.out.println(solution(A7));
    System.out.println("----------------------------");
    System.out.println(solution(A8));
    System.out.println("----------------------------");
    System.out.println(solution(A9));
    System.out.println("----------------------------");
    System.out.println(solution(A10));
    System.out.println("----------------------------");
    System.out.println(solution(A11));
    System.out.println("----------------------------");
    System.out.println(solution(A12));
    System.out.println("----------------------------");
    System.out.println(solution(A13));


  }
}
