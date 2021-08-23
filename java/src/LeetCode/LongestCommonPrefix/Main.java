package LeetCode.LongestCommonPrefix;

public class Main {
    static public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int idx = -1;
        boolean finished = false;
        while (!finished) {
            idx++;
            String add = "";
            for (int i = 0; i < strs.length; i++) {
                String target = strs[i];
                if (idx > target.length() - 1) {
                    finished = true;
                    break;
                }
                if (add.equals("")) {
                    add = target.charAt(idx) + "";
                } else {
                    if (add.equals(target.charAt(idx) + "")) {

                    } else {
                        finished = true;
                        break;
                    }
                }
            }

            if (!finished) {
                prefix += add;
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
