package codility.MaxCounters;

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

  public static int[] solution2(int N, int[] A) {
    int[] counter = new int[N];
    int maxVal = 0;
    for (int i = 0; i < A.length; i++) {
      int inc = A[i] - 1;
      if (inc < N) {
        int val = counter[inc];
        val++;
        counter[inc] = val;
        maxVal = val > maxVal ? val : maxVal;
      } else if (inc == N) {
        for (int j = 0; j < N; j++) {
          counter[j] = maxVal;
        }
      } else {
        System.out.println("ERROR");
      }

      print(counter);
    }

    return counter;
  }

  public static int[] solution(int N, int[] A) {
    // 5, [3, 4, 4, 6, 1, 4, 4]
    int[] counter = new int[N];
    int maxVal = 0;
    int addVal = 0;
    for (int i = 0; i < A.length; i++) {
      int inc = A[i] - 1;
      if (inc < N) {
        int val = counter[inc];
        if ((val <= addVal) && (addVal != 0)) {
          counter[inc] = addVal + 1;
        } else {
          counter[inc]++;
        }

        maxVal = counter[inc] > maxVal ? counter[inc] : maxVal;
      } else if (inc == N) {
        addVal = maxVal;
      } else {
        System.out.println("ERROR");
      }
    }

    for (int i = 0; i < counter.length; i++) {
      if (counter[i] < addVal) {
        counter[i] = addVal;
      }
    }

    return counter;
  }

  public static void main(String[] args) {
    int[] A = {3,4,4,6,1,4,4,6,1,6};
    int N = 5;
//    int[] A = new int[100000];
//    int N = 100000;
//    for (int i = 0; i < 100000; i++) {
//      A[i] = (i % 2) == 0 ? 1 : 100001;
////      A[i] = 6;
////      A[i] = i + 1;
//    }
//    print(A);
    long start1 = System.currentTimeMillis();
    solution2(N, A);
    long end1 = System.currentTimeMillis();
    System.out.println("수행시간 : " + (end1 - start1) + " ms");



    long start2 = System.currentTimeMillis();
    solution(N, A);
    long end2 = System.currentTimeMillis();
    System.out.println("수행시간 : " + (end2 - start2) + " ms");
  }
}
