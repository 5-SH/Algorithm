package codility.FrogRiverOne;

public class Main {
  public static int solution(int X, int[] A) {
    boolean[] road = new boolean[X + 1];
    int remain = X;

    for (int i = 0; i < A.length; i++) {
      int a = A[i];
      if (!road[a] && a != 0) {
        road[a] = true;
        remain--;
      }
      if (remain == 0) return i;
    }

    return -1;
  }

  public static void main(String[] args) {
//    int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
//    int X = 5;
//    int[] A = new int[100000];
//    int X = 100000;
//    for (int i = 0; i < 100000; i++) {
//      A[i] = i + 1;
//    }
//    int[] A = {4, 1, 2, 3, 5};
//    int X = 5;
    int[] A = {1, 1, 1, 1, 1, 2, 2, 2, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4};
    int X = 5;

    long start = System.currentTimeMillis();
    System.out.println(solution(X, A));
    long end = System.currentTimeMillis();
    System.out.println("수행시간 : " + (end - start) + " ms");
  }
}
