package LeetCode.RomanToInteger;

import java.util.ArrayList;

public class Main {
    static public int romanToInt(String s) {
        ArrayList<String> list = new ArrayList<>();
        String[] strCase = {"IV", "IX", "XL", "XC", "CD", "CM"};
        while (s.contains("IV") || s.contains("IX") || s.contains("XL")
                || s.contains("XC") || s.contains("CD") || s.contains("CM")) {
            for (int i = 0; i< strCase.length; i++) {
                String chk = strCase[i];
                if (s.indexOf(chk) > -1) {
                    s = s.substring(0, s.indexOf(chk)) + s.substring(s.indexOf(chk) + 2);
                    list.add(chk);
                }
            }
        }

        // 계산
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                sum += 1;
            } else if (c == 'V') {
                sum += 5;
            } else if (c == 'X') {
                sum += 10;
            } else if (c == 'L') {
                sum += 50;
            } else if (c == 'C') {
                sum += 100;
            } else if (c == 'D') {
                sum += 500;
            } else if (c == 'M') {
                sum += 1000;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String chk = list.get(i);
            if (chk.equals("IV")) {
                sum += 4;
            } else if (chk.equals("IX")) {
                sum += 9;
            } else if (chk.equals("XL")) {
                sum += 40;
            } else if (chk.equals("XC")) {
                sum += 90;
            } else if (chk.equals("CD")) {
                sum += 400;
            } else if (chk.equals("CM")) {
                sum += 900;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
//        String s = "MCMXCIV";
//        String s = "XXIV";
//        String s = "IV";
//        String s = "XCIV";
//        String s = "III";
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }
}
