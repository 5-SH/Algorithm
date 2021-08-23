package LeetCode.ValidParentheses;

import java.util.Stack;

public class Main {
    static public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char pop;
                if (stack.isEmpty()) {
                    return false;
                } else {
                    pop = stack.pop();
                }

                if (pop == '(') {
                    if (c != ')') {
                        return false;
                    }
                } else if (pop == '{') {
                    if (c != '}')  {
                        return false;
                    }
                } else if (pop == '[') {
                    if (c != ']') {
                        return false;
                    }
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("))))"));
        System.out.println(isValid("))))"));
        System.out.println(isValid("()"));
        System.out.println(isValid("()(){}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("("));
        System.out.println(isValid(")"));


    }
}
