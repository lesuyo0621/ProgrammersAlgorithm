import java.util.*;

public class TableHashFunction {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]
        );

        for (int[] d : data) {
            pq.add(d);
        }

        for (int i = 0; i < row_begin - 1; i++) {
            pq.poll();
        }

        int[] sum = new int[row_end - row_begin + 1];
        for (int i = row_begin; i <= row_end; i++) {
            int[] d = pq.poll();

            for (int num : d) {
                sum[i - row_begin] += num % i;
            }
        }

        int answer = 0;
        for (int s : sum) {
            answer ^= s;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }
}
