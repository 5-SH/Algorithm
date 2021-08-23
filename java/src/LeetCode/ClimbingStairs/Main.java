package LeetCode.ClimbingStairs;

import java.util.HashSet;

public class Main {

    static public void recur(int num, String str, HashSet<String> set) {
        if (num == 0) {
            set.add(str);
            return;
        }
        if (num - 1 >= 0) {
            recur(num - 1, str + "1", set);
        }

        if (num - 2 >= 0) {
            recur(num - 2, str + "2", set);
        }
    }

    // 재귀 방법 메모리 초과 발생
    // TODO: DP 이용해서 푸는 방법 찾아보기
    static public int climbStairs(int n) {
        HashSet<String> set = new HashSet<>();
        recur(n, "", set);
        return set.size();
    }


    public static void main(String[] args) {

    }
}
