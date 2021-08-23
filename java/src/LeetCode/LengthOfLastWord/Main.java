package LeetCode.LengthOfLastWord;

public class Main {
    static public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        int len = 0;
        for (String a : split) {
            if (a.length() > 0) {
                len = a.length();
            }
        }

        return len;
    }

    public static void main(String[] args) {
//        String s = " s";
//        String s = "                                                                                               s";
//        String s = "   fly me   to   the                 moon";
//        String s = "moon";
//        String s = "Hello World";
        String s = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(s));
    }
}
