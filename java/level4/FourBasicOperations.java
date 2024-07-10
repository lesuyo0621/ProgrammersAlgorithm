import java.util.Arrays;

public class FourBasicOperations {
    private static final int[][] maxMem = new int[202][202];
    private static final int[][] minMem = new int[202][202];

    private static int max(int start, int end, String[] arr) {
        if (maxMem[start][end] != Integer.MIN_VALUE) {
            return maxMem[start][end];
        }

        if (end - start == 1) {
            return Integer.parseInt(arr[start]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int l = max(start, i, arr);

            int v = 0;
            if ("+".equals(arr[i])) {
                int r = max(i + 1, end, arr);

                v = l + r;
            } else {
                int r = min(i + 1, end, arr);

                v = l - r;
            }

            max = Math.max(max, v);
        }

        return maxMem[start][end] = max;
    }

    private static int min(int start, int end, String[] arr) {
        if (minMem[start][end] != Integer.MAX_VALUE) {
            return minMem[start][end];
        }

        if (end - start == 1) {
            return Integer.parseInt(arr[start]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int l = min(start, i, arr);

            int v = 0;
            if ("+".equals(arr[i])) {
                int r = min(i + 1, end, arr);

                v = l + r;
            } else {
                int r = max(i + 1, end, arr);

                v = l - r;
            }

            min = Math.min(min, v);
        }

        return minMem[start][end] = min;
    }

    public static int solution(String[] arr) {
        for (int[] m : minMem) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for (int[] m : maxMem) {
            Arrays.fill(m, Integer.MIN_VALUE);
        }

        return max(0, arr.length, arr);
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
    }
}
