package codility.MinAvgTwoSlice;

public class Main {
  public static void print(int[] arr) {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for (int i = 0; i < arr.length; i++) {
      builder.append(arr[i]);
      if (i != arr.length - 1) {
        builder.append(", ");
      }
    }
    builder.append("]");
    System.out.println(builder.toString());
  }

  static public int solution(int[] A) {
    int sum[] = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      if (i == 0) {
        sum[i] = A[0];
        continue;
      }
      sum[i] = sum[i - 1] + A[i];
    }

    int pos = 0;
    double avg = 0.0;
    for (int i = 0; i < A.length - 1; i++) {
      print(sum);
      for (int j = i + 1; j < A.length; j++) {
        double val = (double) sum[j] / (j - i + 1);
        if (j == 1) {
          avg = val;
          pos = 0;
        } else {
          if (val < avg) {
            avg = val;
            pos = i;
          }
        }
        sum[j] -= sum[i];
//        System.out.println(val + ", " + avg + ", " + pos);
      }
//      System.out.println("");
//      System.out.println(avg + ", " + pos);
//      System.out.println("---------------------------------------------------");
//      System.out.println("---------------------------------------------------");
    }
    return pos;
  }

  public static void main(String[] args) {
//    int[] A = {10000, 10000,-10000,-10000};
//    int[] A = {1,2,-100};
//    int[] A = {4,2,2,5,1,8};
//    int[] A = {4,2,2,5,1,5,8};
//    int[] A = {8,1,5,2,2,4};
//    int[] A = {4,-2,-2,5,1,8};
//    int[] A = {5,4,2,1,0,-12};
    int[] A = {-3,-5,-8,-4,-10};
//    int[] A = new int[100000];
//    for (int i = 0; i < 100000; i++) {
//      A[i] = -10000;
//    }
    System.out.println(solution(A));

  }
}
