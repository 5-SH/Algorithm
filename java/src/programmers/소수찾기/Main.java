package programmers.소수찾기;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
  static public void recur(int depth, int maxDepth, String txt, String source, HashSet<Integer> result) {
    if (depth > maxDepth) return;
    for (int i = 0; i < source.length(); i++) {
      String newTxt = txt;
      newTxt += source.charAt(i);
      int val = Integer.parseInt(newTxt);
      result.add(val);
      String newSrc = source.substring(0, i) + source.substring(i + 1);
      recur(depth + 1, maxDepth, newTxt, newSrc, result);
    }
  }

  // 재귀 이용해 해결
  static public int solution(String numbers) {
    HashSet<Integer> result = new HashSet<>();
    recur(1, numbers.length(), "", numbers, result);

    int count = 0;
    for (int a : result) {
      if (a == 0 || a == 1) continue;
      boolean isPrime = true;
      for (int i = 2; i < a; i++) {
        if (a % i == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
//    String numbers = "17";
//    String numbers = "011";
//    String numbers = "0";
    String numbers = "222221";
    System.out.println(solution(numbers));

  }
}
