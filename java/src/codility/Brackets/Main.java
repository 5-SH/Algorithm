package codility.Brackets;

import java.util.Stack;

public class Main {
  static public int solution(String S) {
    // write your code in Java SE 8
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      String b = S.charAt(i) + "";
      if (b.equals("(") || b.equals("{") || b.equals("[")) {
        stack.push(b);
      } else {
        if (stack.isEmpty()) return 0;
        String chk = stack.pop();
        if (b.equals(")")) {
          if (!chk.equals("(")) return 0;
        } else if (b.equals("}")) {
          if (!chk.equals("{")) return 0;
        } else if (b.equals("]")) {
          if (!chk.equals("[")) return 0;
        }
      }
    }

    if (stack.isEmpty()) return 1;
    return 0;
  }

  public static void main(String[] args) {
//    String S = "{[()()]}"; // 1
//    String S = "[)"; // 0
//    String S = "[()"; // 0
//    String S = ""; // 1
//    String S = "}"; // 0
    String S = "{{{[[]]}}}{}{}{}{}{}{}{}{}{}[][][][][][][][]()()()()()()()"; // 1
    System.out.println(solution(S));
  }
}
