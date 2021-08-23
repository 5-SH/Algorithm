package LeetCode.AddBinary;

public class Main {
    static public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            int padSize = a.length() - b.length();
            String pad = "";
            for (int i = 0; i < padSize; i++) {
                pad += "0";
            }
            b = pad + b;
        } else if (a.length() < b.length()) {
            int padSize = b.length() - a.length();
            String pad = "";
            for (int i = 0; i < padSize; i++) {
                pad += "0";
            }
            a = pad + a;
        }

//        System.out.println("a : " + a);
//        System.out.println("b : " + b);

        String up = "0";
        String sum = "";
        int size = Math.max(a.length(), b.length());
        for (int i = size - 1; i >= 0; i--) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1' && up.equals("1")) {
                up = "1";
                sum = "1" + sum;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1' && up.equals("0")) {
                up = "1";
                sum = "0" + sum;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '0' && up.equals("1")) {
                up = "1";
                sum = "0" + sum;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '0' && up.equals("0")) {
                up = "0";
                sum = "1" + sum;
            } else if (a.charAt(i) == '0' && b.charAt(i) == '1' && up.equals("1")) {
                up = "1";
                sum = "0" + sum;
            } else if (a.charAt(i) == '0' && b.charAt(i) == '1' && up.equals("0")) {
                up = "0";
                sum = "1" + sum;
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0' && up.equals("1")) {
                up = "0";
                sum = "1" + sum;
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0' && up.equals("0")) {
                up = "0";
                sum = "0" + sum;
            }

//            System.out.println("sum : " + sum);
        }


        if (up.equals("1")) {
            return "1" + sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        addBinary("11", "1");
    }
}
