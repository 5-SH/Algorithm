package programmers.가장큰수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static public String solution2(int[] numbers) {
        List<String> list = new LinkedList<>();
        boolean allZero = true;
        for (int a : numbers) {
            if (a != 0) allZero = false;
            String s = Integer.toString(a);
            list.add(s);
        }

        if (allZero) return "0";

        Collections.sort(list, (a, b) -> {
            int size = Math.max(a.length(), b.length());
            String str1 = a + b;
            String str2 = b + a;

            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            if (num2 < num1) return -1;
            if (num1 < num2) return 1;
            return 0;
        });

        String answer = "";
        for (String a : list) {
            answer += a;
        }

        return answer;
    }

    // 오답
    static public String solution(int[] numbers) {
        List<String> list = new LinkedList<>();
        boolean allZero = true;
        for (int a : numbers) {
            if (a != 0) allZero = false;
            String s = Integer.toString(a);
            list.add(s);
        }

        if (allZero) return "0";

        Collections.sort(list, (a, b) -> {
            int size = Math.max(a.length(), b.length());
            for (int i = 0; i < size; i++) {
                int ia, ib;
                if (i > a.length() - 1) {
                    ia = Integer.parseInt(a.charAt(a.length() - 1) + "");
                } else {
                    ia = Integer.parseInt(a.charAt(i) + "");
                }

                if (i > b.length() - 1) {
                    ib = Integer.parseInt(b.charAt(b.length() - 1) + "");
                } else {
                    ib = Integer.parseInt(b.charAt(i) + "");
                }

                if (ib > ia) return 1;
                if (ia > ib) return -1;
            }
            return 0;
        });

        String answer = "";
        for (String a : list) {
            answer += a;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {6,10,2};
//        int[] numbers = {3,30,34,5,9};
//        int[] numbers = {30, 34};
//        int[] numbers = {125, 70, 126, 6};
//        int[] numbers = {7,7,7,7,7,7};
//        int[] numbers = {0,2,1};
//        int[] numbers = {0,0};
//        int[] numbers = {1};
//        int[] numbers = {11111,11112,11111,11112};
//        int[] numbers = {121, 12};
        System.out.println(solution2(numbers));
    }
}
