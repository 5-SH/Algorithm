package codility.EquiLeader;

import java.util.*;

public class Main {
    public static void print(int[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i != arr.length - 1) {
                builder.append(", ");
            }
        }
        builder.append(")");
        System.out.println(builder.toString());
    }

    // 시간복잡도 해결
    static public int solution2(int[] A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int d = A[i];
            if (map.containsKey(d)) {
                map.get(d).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(d, list);
            }
        }

        Set<Integer> keys = map.keySet();
        int dom = Integer.MIN_VALUE;
        for (int k : keys) {
            if (map.get(k).size() > (A.length / 2)) dom = k;
        }

        int[] sum = new int[A.length];
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int d = A[i];
            if (d == dom) cnt++;
            sum[i] = cnt;
        }

        int equal = 0;
        for (int s = 0; s < sum.length; s++) {
            if (sum[s] > ((s + 1) / 2)) {
                if ((sum[sum.length - 1] - sum[s])  > (sum.length - s - 1) / 2) {
                    equal++;
                }
            }
        }

        return equal;
    }


    // 10,000 * 10,000 timeout
    static public int solution(int[] A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int d = A[i];
            if (map.containsKey(d)) {
                map.get(d).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(d, list);
            }
        }

        Set<Integer> keys = map.keySet();
        int dom = Integer.MIN_VALUE;
        for (int k : keys) {
            if (map.get(k).size() > (A.length / 2)) dom = k;
        }

        int count1 = 0;
        int equal = 0;
        for (int s = 0; s < A.length - 1; s++) {
            int d = A[s];
            if (dom == d) count1++;
            if (count1 > ((s + 1) / 2)) {
                int count2 = 0;
                for (int j = s + 1; j < A.length; j++) {
                    if (A[j] == dom) count2++;
                }

                if (count2 > ((A.length - s - 1) / 2)) {
                    equal++;
                }
            }
        }

        return equal;
    }

    public static void main(String[] args) {
//    int A[] = {4,3,4,4,4,2};
        int A[] = {-10,3,-10,2,-10,-10};
        System.out.println(solution2(A));
        System.out.println(solution(A));

    }
}
