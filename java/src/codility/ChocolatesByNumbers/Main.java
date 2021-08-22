package codility.ChocolatesByNumbers;

public class Main {
    static public int solution(int N, int M) {
        boolean[] choco = new boolean[N];
        for (int i = 0; i < N; i++) {
            choco[i] = true;
        }
        int cnt = N;
        int eat = 1;
        choco[0] = false;
        int idx = 0;
        while (cnt > 0) {
            int d = (idx + M) % N;
            if (!choco[d]) {
                break;
            } else {
                eat++;
                choco[d] = false;
                cnt--;
            }
            idx = d;
        }

        return eat;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 1));

    }
}
