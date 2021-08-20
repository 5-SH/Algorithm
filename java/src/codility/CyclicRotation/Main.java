package codility.CyclicRotation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static int[] solution(int[] A, int K) {
    // write your code in Java SE 8
    List<Integer> linkedList = new LinkedList<>();
    for (int a : A) {
      linkedList.add(a);
    }

    // System.out.println("linkedList1 : " + linkedList.toString());

    int rotate = K % A.length;
    // System.out.println("rotate " + rotate);
    if (rotate == 0) {
      return A;
    }

    for (int i = 0; i < rotate; i++) {
      int item = linkedList.get(linkedList.size() - 1);
      linkedList.remove(linkedList.size() - 1);
      linkedList.add(0, item);
    }


    int[] result = new int[linkedList.size()];
    for (int i = 0; i < linkedList.size(); i++) {
      result[i] = linkedList.get(i);
    }

    // System.out.println("linkedList2 : " + result.toString());

    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    String substr = line.substring(1, line.length());
    int idx = substr.lastIndexOf("]");
    String[] arr = substr.substring(0, idx).split(",");
    int K = Integer.parseInt(substr.substring(idx + 2, substr.length()));

    int[] A = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      A[i] = Integer.parseInt(arr[i].trim());
    }

    int[] result = solution(A, K);
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for (int i = 0; i < result.length; i++) {
      builder.append(result[i]);
      if (i != result.length - 1) {
        builder.append(", ");
      }
    }
    builder.append("]");
    System.out.println(builder.toString());
  }
}
