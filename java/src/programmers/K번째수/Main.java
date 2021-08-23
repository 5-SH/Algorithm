package programmers.K번째수;

import java.util.Arrays;

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

    static public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2];

            if (start < 0) start = 0;
            if (end > array.length - 1) end = array.length - 1;
            int[] sliced = new int[end - start + 1];
            int idx = 0;
            for (int j  = start; j <= end; j++) {
                sliced[idx] = array[j];
                idx++;
            }
            Arrays.sort(sliced);
            if (k - 1> sliced.length - 1) k = sliced.length;
            if (k - 1 < 0) k = 1;
            answer[i] = sliced[k - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] array = {1, 5, 2, 6, 3, 7, 4};
//        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
//        int[][] commands = {{2,5,3}, {4,4,1}};
//        int[][] commands ={{1,7,3}};
        int[] array = {1};
        int[][] commands = {{1,1,1}, {0,10,10}, {0,10,-10}};

        print(solution(array, commands));
    }
}
