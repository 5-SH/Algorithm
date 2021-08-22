package codility.Dominator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
  static public int solution(int[] A) {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      int d = A[i];
      if (map.containsKey(d)) {
        map.get(d).add(i);
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(d, list);
      }
    }

    Set<Integer> keys = map.keySet();
    for (int k : keys) {
      if (map.get(k).size() > A.length / 2) return map.get(k).get(0);
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] A = {3,4,3,2,3,-1,3,3};
//    int[] A = {4,3,3,1,3};
//    int[] A = {};
//    int[] A = {1,3,3,1};
    System.out.println(solution(A));

  }
}
