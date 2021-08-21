package codility.Fish;

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

  static public int solution(int[] A, int[] B) {
    for (int i = B.length - 1; i >= 0; i--) {
//      System.out.println("OUT");
//      print(B);

      int start;
      int end;
      if (B[i] == 1) {
        start = i;
        end = i;
        while (end < B.length - 1) {
          end++;
          if (B[end] == 0) {
            if (A[start] < A[end]) {
              B[start] = -1;
              break;
            } else {
              B[end] = -1;
            }
          }

//          System.out.println("IN");
//          print(B);
        }

      }


    }

    int count = 0;
    for (int i = 0; i < B.length; i++) {
      if (B[i] != -1) count++;
    }
    return count;
  }
  public static void main(String[] args) {
//    int[] A = {4,3,2,1,5};
//    int[] B = {0,1,0,0,0};

//    int[] A = {3,5,3};
//    int[] B = {1,1,0};

//    int[] A = {5,7,3,1,2,4};
//    int[] B = {0,0,1,0,1,0};

    int[] A = {1};
    int[] B = {1};
    System.out.println(solution(A, B));
  }
}
