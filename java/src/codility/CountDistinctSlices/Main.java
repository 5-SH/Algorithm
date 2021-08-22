package codility.CountDistinctSlices;

public class Main {
    // TODO: 캐터필러 방법론 확인
    static public int solution(int M, int[] A) {
        long cnt = 0;
        int same = 0;
        for (int i = 0; i < A.length; i++) {
            same++;
            if (i + 1 == A.length) {
                // 마지막
                cnt += same * (same + 1) / 2;
                same = 0;
                break;
            }
            if (A[i] == A[i + 1]) {
                // 개수 세기
                cnt += same * (same + 1) / 2;
                same = 0;
            }
        }

        if (cnt > 1000000000) return 1000000000;

        return Long.valueOf(cnt).intValue();
    }

    public static void main(String[] args) {
//        int[] A = {3,4,5,5,2};
//        int[] A = {1,2,1};
//        int M = 6;
        int[] A = new int[100000];
        for (int i = 0; i < 100000; i++) {
            A[i] = i + 1;
        }
        int M = 100000;
        System.out.println(solution(M, A));
    }
}
