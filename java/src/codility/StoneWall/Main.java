package codility.StoneWall;

import java.util.Stack;

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

  // stack 을 이용해 해결 (어려움)
  static public int solution(int[] H) {
    // write your code in Java SE 8
    Stack<Integer> stack = new Stack<>();
    int count = 0;
    for (int i = 0; i < H.length; i++) {
      while (!stack.isEmpty() && stack.peek() > H[i]) {
        stack.pop();
      }
      if (stack.isEmpty() || stack.peek() < H[i]) {
        stack.push(H[i]);
        count++;
      }
      System.out.println(stack);
    }

    return count;
  }
  public static void main(String[] args) {
    int[] H = {8,8,5,7,9,8,7,4,8};
//    int[] H = {3,2,1};
    System.out.println(solution(H));
  }
}
