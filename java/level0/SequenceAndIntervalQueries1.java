import java.util.Arrays;

public class SequenceAndIntervalQueries1 {
    private static int[] solution(int[] arr, int[][] queries) {
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[1]; i++) {
                arr[i]++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{0, 1, 2, 3, 4}, new int[][]{{0, 1}, {1, 2}, {2, 3}})));
    }
}
