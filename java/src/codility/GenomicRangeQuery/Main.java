package codility.GenomicRangeQuery;

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

  // 부분합으로 해결 O(N + M)
  static public int[] solution2(String S, int[] P, int[] Q) {
    int[][] map = new int[S.length()][4];
    for (int i = 0; i < S.length(); i++) {
      char s = S.charAt(i);
      for (int j = 0; j < 4; j++) {
        if (i - 1 < 0) continue;
        map[i][j] = map[i -1][j];
      }
      if (s == 'A') {
        map[i][0]++;
      } else if (s == 'C') {
        map[i][1]++;
      } else if (s == 'G') {
        map[i][2]++;
      } else {
        map[i][3]++;
      }
    }

    int[] result = new int[P.length];
    for (int i = 0; i < P.length; i++) {
      int pIdx = P[i];
      int qIdx = Q[i];

      int[] r = new int[4];
      if (pIdx - 1 < 0) {
        for (int j = 0; j < 4; j++) {
          r[j] = map[qIdx][j];
        }
      } else {
        for (int j = 0; j < 4; j++) {
          r[j] = map[qIdx][j] - map[pIdx - 1][j];
        }
      }

      for (int k = 0; k < 4; k++) {
        if (r[k] > 0) {
          result[i] = k + 1;
          break;
        }
      }
    }

    return result;
  }

  // 이중 반복문 O(N * M)
  static public int[] solution(String S, int[] P, int[] Q) {
    int[] result = new int[P.length];
    for (int i = 0; i < P.length; i++) {
      int pIdx = P[i];
      int qIdx = Q[i];
      int min = 5;
      for (int j = pIdx; j <= qIdx; j++) {
        char s = S.charAt(j);
        int val = 0;
        if (s == 'A') {
          val = 1;
        } else if (s == 'C') {
          val = 2;
        } else if (s == 'G') {
          val = 3;
        } else {
          val = 4;
        }
        if (val < min) min = val;
      }
      result[i] = min;
    }
    return result;
  }
  public static void main(String[] args) {
//    String S = "CAGCCTA";
//    int[] P = {2,5,0};
//    int[] Q = {4,5,6};
//    String S = "C";
//    int[] P = {0};
//    int[] Q = {0};
    String S = "";
    for (int i = 0; i < 100000; i++) {
      S += "G";
    }

    int[] P = new int[50000];
    int[] Q = new int[50000];
    for (int i = 0; i < 50000; i++) {
      P[i] = 0;
      Q[i] = 99999;
    }

    print(solution2(S, P, Q));
  }
}
