package codility.PermCheck;

import java.util.*;

public class Main {
  static public int solution2(int[] A) {
    List<Integer> list = new ArrayList<>();
    for (int a : A) {
      list.add(a);
    }
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      if ((i + 1) != list.get(i)) return 0;
    }
    return 1;
  }

  static public int solution(int[] A) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int a : A) {
      queue.add(a);
    }

    int init = queue.peek();
    if (init != 1) return 0;
    while (!queue.isEmpty()) {
      int poll = queue.poll();
      if (queue.isEmpty()) break;
      int peek = queue.peek();
      if (peek - poll > 1) return 0;
    }

    return 1;
  }

  public static void main(String[] args) {
    int[] A = {1, 2};
//    int[] A = {4,1,3,2};
//    int[] A = {4,1,3};
//    int N = 10;
//    int val = 1000000000;
//    int[] A = new int[N];
//
//    for (int i = 0; i < A.length; i++) {
//      if (i == 5) {
//        A[i] = 1;
//      } else {
//        A[i] = val--;
//      }
//    }

    System.out.println(solution(A));
  }
}
