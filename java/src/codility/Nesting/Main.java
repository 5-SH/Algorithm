package codility.Nesting;

import java.util.Stack;

public class Main {
  static public int solution(String S) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      System.out.println(stack.toString());

      char c = S.charAt(i);
      if (c == '(') {
        stack.push(c);
      } else {
        // ')'
        if (stack.isEmpty()) return 0;
        char chk = stack.pop();
        if (chk != '(') return 0;
      }
    }

    if (stack.empty()) return 1;

    return 0;
  }
  public static void main(String[] args) {
    // [0..1,000,000]
//    String S = "(()(())())";
//    String S = ")";
//    String S = "";
//    String S = "()()()()";
    String S = "((())))";

    System.out.println(solution(S));
  }
}
