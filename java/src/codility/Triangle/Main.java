package codility.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0) {
        list.add(A[i]);
      }
    }
    Collections.sort(list);

    long P, Q, R;
    // 정렬된 상태에서 P + R > Q, Q + R > P 항상 만족
    // P + Q > R 만 확인
    ArrayList<ArrayList<Long>> checkList = new ArrayList<ArrayList<Long>>();
    for (int i = 0; i < list.size() - 2; i++) {
      P = Long.valueOf(list.get(i));
      for (int j = i + 1; j < list.size() - 1; j++) {
        Q = Long.valueOf(list.get(j));
        for (int k = j + 1; k < list.size(); k++) {
          R = Long.valueOf(list.get(k));
          if (P + Q <= R) {
            break;
          }
          ArrayList<Long> l = new ArrayList<>();
          l.add(P);
          l.add(Q);
          l.add(R);
          checkList.add(l);
        }
      }
    }

    for (ArrayList<Long> l : checkList) {
      long vP = l.get(0);
      long vQ = l.get(1);
      long vR = l.get(2);

      if ((vP + vQ > vR) && (vQ + vR > vP) && (vR + vP > vQ)) {
        return 1;
      }
    }
    return 0;
  }

  static public int solution2(int[] A) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0) {
        list.add(A[i]);
      }
    }
    Collections.sort(list);

    long P, Q, R;
    // 정렬된 상태에서 P + R > Q, Q + R > P 항상 만족
    // P + Q > R 만 확인
    for (int i = 0; i < list.size() - 2; i++) {
      P = Long.valueOf(list.get(i));
      for (int j = i + 1; j < list.size() - 1; j++) {
        Q = Long.valueOf(list.get(j));
        for (int k = j + 1; k < list.size(); k++) {
          R = Long.valueOf(list.get(k));
          if (P + Q > R) {
            return 1;
          } else {
            break;
          }
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) {
//    int[] A = {10,2,5,1,8,20};
//    int[] A = {10,2,5,1,8,20,-10,-1,0,-50};
    int[] A = {10,50,5,1};
//    int[] A = {2147483647, 2147483647, 2147483647, 10,2,5,1,8,20,-10,-1,0,-50};
    System.out.println(solution(A));
  }
}
