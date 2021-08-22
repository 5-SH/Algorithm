package codility.MaxProfit;

public class Main {
    static public int solution(int[] A) {
        // write your code in Java SE 8
        int max = 0;
        int i = 0;
        while (i < A.length - 1) {
            int cur = A[i];
            int next = A[i + 1];
            if (cur > next) {
                i++;
            } else {
                boolean isSet = false;
                for (int j = i + 1; j < A.length; j++) {
                    int val = A[j];
                    if (cur > val) {
                        i = j;
                        isSet = true;
                        break;
                    }
                    if ((val - cur) > max) {
                        max = val - cur;
                    }
                }
                if (!isSet) i++;
            }
        }

        return max;
    }
    public static void main(String[] args) {
//        int[] A = {5,2,10,1,0,100};
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
//        int[] A = {5,4,5,7,1,100};
        System.out.println(solution(A));
    }
}
