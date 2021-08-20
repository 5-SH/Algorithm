package codility.OddOccurrencesInArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static int solution(int[] A) {
    Arrays.sort(A);
    StringBuilder builder = new StringBuilder();
    for (int a : A) {
      builder.append(a);
      builder.append(",");
    }

    int num = A[0];
    int count = 1;
    for (int i = 1; i < A.length; i++) {
      if (num == A[i]) {
        count++;
      } else {
        if ((count % 2) == 1) return num;
        count = 1;
        num = A[i];
      }

    }

    return num;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] list = in.nextLine().trim().split(",");
    int[] A = new int[list.length];
    for (int i = 0; i < list.length; i++) {
      A[i] = Integer.parseInt(list[i]);
    }

    System.out.println(solution(A));
  }
}
