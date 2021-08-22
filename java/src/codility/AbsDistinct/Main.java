package codility.AbsDistinct;

import java.util.HashSet;

public class Main {
    static public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int d = Math.abs(A[i]);
            set.add(d);
        }

        return set.size();
    }

    public static void main(String[] args) {
//        int[] A = {-5,-3,-1,0,3,6};
        int[] A = {-1,1,2,-2,-3};
        System.out.println(solution(A));
    }
}
