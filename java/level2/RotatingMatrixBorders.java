import java.util.Arrays;

public class RotatingMatrixBorders {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static int swap(int[][] nums, int currNum, int[] p) {
        int nextNum = nums[p[0]][p[1]];
        nums[p[0]][p[1]] = currNum;

        return nextNum;
    }

    private static int rotate(int[][] nums, int[] query) {
        int min = Integer.MAX_VALUE;
        int[] point = {query[0] - 1, query[1] - 1};
        int columnCount = query[2] - query[0];
        int rowCount = query[3] - query[1];
        int[] moveCount = {rowCount, columnCount, rowCount, columnCount};

        int currNum = nums[point[0]][point[1]];
        for (int i = 0; i < moveCount.length; i++) {
            for (int j = 0; j < moveCount[i]; j++) {
                if (currNum < min) min = currNum;

                point[0] += DY[i];
                point[1] += DX[i];

                currNum = swap(nums, currNum, point);
            }
        }

        return min;
    }

    private static int[] solution(int rows, int columns, int[][] queries) {
        int num = 1;
        int[][] nums = new int[rows][columns];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = num;
                num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(nums, queries[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4},{3, 3, 6, 6},{5, 1, 6, 3}})));
    }
}
