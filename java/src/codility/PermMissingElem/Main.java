package codility.PermMissingElem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static int solution(int[] A) {
    if (A.length == 0) return 1;
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
      if (i + 1 != A[i]) return i + 1;
    }
    return A.length + 1;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] arr = in.nextLine().trim().split(",");

    int[] A = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      A[i] = Integer.parseInt(arr[i]);
    }

    System.out.println(solution(A));
  }
}
