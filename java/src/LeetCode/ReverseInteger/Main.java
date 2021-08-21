package LeetCode.ReverseInteger;

import java.util.Stack;

public class Main {
  static public int reverse(int x) {
    String str = String.valueOf(x);
    String reverse = "";
    boolean minus = false;
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);

      if (c == '-') {
        minus = true;
        continue;
      }

      if (c == '0') {
        if (reverse.length() > 0) {
          reverse += c;
        }
      } else {
        reverse += c;
      }
    }

    if (reverse.length() == 0) reverse += '0';
    if (minus) reverse = '-' + reverse;

    int result = 0;
    try {
      result = Integer.parseInt(reverse);
    } catch (Exception e) {
      result = 0;
    } finally {
      return result;
    }
  }

  public static void main(String[] args) {
    System.out.println(reverse(15)); // 51
    System.out.println(reverse(123)); // 321
    System.out.println(reverse(120)); // 21
    System.out.println(reverse(100)); // 1
    System.out.println(reverse(0)); // 0
    System.out.println(reverse(2147483647)); // 0

    System.out.println(reverse(-120)); // -21
    System.out.println(reverse(-100)); // -1
    System.out.println(reverse(-123)); // -321
    System.out.println(reverse(-321)); // -123
    System.out.println(reverse(-2147483648)); // 0

    // 최대 2147483647
    // 최소 -2147483648
  }
}
