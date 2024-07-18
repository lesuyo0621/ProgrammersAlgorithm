import java.util.*;

public class OilDrilling {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static int[] oils;

    private static void countOil(int x, int y, int[][] land, boolean[][] visited) {
        Set<Integer> xSet = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;
        int oil = 0;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            xSet.add(xy[0]);
            oil++;

            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + DX[i];
                int ny = xy[1] + DY[i];

                if (nx >= 0 && nx < land[0].length
                        && ny >= 0 && ny < land.length
                        && land[ny][nx] == 1 && !visited[ny][nx]) {
                    q.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                }
            }
        }

        for (int i : xSet) {
            oils[i] += oil;
        }
    }

    public static int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        oils = new int[m];

        boolean[][] visited = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (land[y][x] == 1 && !visited[y][x]) {
                    countOil(x, y, land, visited);
                }
            }
        }

        int maxOil = 0;
        for (int o : oils) {
            maxOil = Math.max(maxOil, o);
        }

        return maxOil;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
    }
}
