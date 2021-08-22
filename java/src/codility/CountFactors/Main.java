package codility.CountFactors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    // sqrt(N) 보다 작은 것 까지만 세고 * 2
    // sqrt(N) 이 정수면 +1
    static public int solution(int N) {
        // write your code in Java SE 8
        int cnt = 0;
        for (int i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                cnt += 2;
            }
        }

        if (Math.sqrt(N) % 1 == 0) {
            cnt += 1;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(36));
    }
}
