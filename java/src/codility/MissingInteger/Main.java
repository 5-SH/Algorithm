package codility.MissingInteger;

import java.util.*;

public class Main {
  // O(N * log(N))
  static public int solution2(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int a : A) {
      set.add(a);
    }

    int min = 1;
    for (int i = 0; i < set.size(); i++) {
      if (set.contains(min)) min++;
    }

    return min;
  }

  // O(N^2)
  static public int solution(int[] A) {
    List<Integer> list = new ArrayList<>();
    for (int a : A) {
      list.add(a);
    }

    int min = 1;
    for (int i = 0; i < list.size(); i++) {
      if (list.contains(min)) min++;
    }

    return min;
  }

  public static void main(String[] args) {
//    int[] A = {-4, -3, -2, 0, 1, 3};
//    int[] A = {-4, -3, -2, -1};
//    int[] A = {0, 100, 100, 100, 101, 1001};
//    int[] A = {5, 5, 5};
    int[] A = {1, 3, 6, 4, 1, 2};
    System.out.println(solution(A));
    System.out.println(solution2(A));
  }
}
