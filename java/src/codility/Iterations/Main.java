package codility.Iterations;

// codility Lesson - 1


import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static int solution(int N) {
    String binary = Integer.toBinaryString(N);
    int result = 0;
    int count = 0;

    Stack<String> stack = new Stack<>();
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '1') {
        if (stack.empty()) {
          stack.push("1");
        } else {
          stack.pop();
          if (count > result) {
            result = count;
            count = 0;
          }
          stack.push("1");
        }
      } else {
        if (!stack.empty()) count++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String l = in.nextLine();
    int N = Integer.parseInt(l);
    System.out.println(solution(N));
  }
}
