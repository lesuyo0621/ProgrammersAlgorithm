import java.util.Arrays;

public class CountingAfterQuadCompression {
    private static void process(int[][] arr, int[] x, int[] y, int[] answer) {
        int count = 0;
        boolean allMatch = true;
        int targetNum = arr[x[0]][x[1]];
        int size = y[0] - x[0] + 1;

        if (size == 1) return;

        for (int i = x[0]; i <= y[0]; i++) {
            for (int j = x[1]; j <= y[1]; j++) {
                if (targetNum != arr[i][j]) {
                    allMatch = false;
                    break;
                }

                count++;
            }
        }

        if (allMatch) {
            answer[targetNum % 2] -= count - 1;
        } else {
            int[][] xAcc = new int[][]{{0, 0}, {0, size / 2}, {size / 2, 0}, {size / 2, size / 2}};
            int[][] yAcc = new int[][]{{size / 2, size / 2}, {size / 2, 0}, {0, size / 2}, {0, 0}};

            for (int i = 0; i < 4; i++) {
                int[] xResize = new int[]{x[0] + xAcc[i][0], x[1] + xAcc[i][1]};
                int[] yResize = new int[]{y[0] - yAcc[i][0], y[1] - yAcc[i][1]};

                process(arr, xResize, yResize, answer);
            }
        }
    }

    private static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        for (int[] a : arr) {
            for (int n : a) {
                answer[n % 2]++;
            }
        }

        process(arr, new int[]{0, 0}, new int[]{arr.length - 1, arr[0].length - 1}, answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }
}
