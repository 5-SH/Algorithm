package codility.Distinct;

import java.util.HashSet;
import java.util.Set;

public class Main {
  static public int solution(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < A.length; i++) {
      set.add(A[i]);
    }

    return set.size();
  }

  public static void main(String[] args) {
//    int[] A = {2,1,1,2,3,1};
//    int[] A = {0,0,0,0,0,0};
    int[] A = {-1000000};
    System.out.println(solution(A));
  }
}
