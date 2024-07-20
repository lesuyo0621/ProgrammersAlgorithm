import java.util.*;

public class NQueen {
    private static int answer = 0;

    private static boolean[][] getUsed(int x, int y, boolean[][] used) {
        int n = used.length;
        boolean[][] copy = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(used[i], n);
        }

        int[] dx = {-1, 0 ,1};
        int[] dy = {1, 1, 1};

        int p1X = x, p2X = x, p3X = x;
        int p1Y = y, p2Y = y, p3Y = y;
        while ((p1X >= 0 && p1Y < n) || (p2Y < n) || (p3X < n && p3Y < n)) {
            p1X += dx[0];
            p1Y += dy[0];

            p2X += dx[1];
            p2Y += dy[1];

            p3X += dx[2];
            p3Y += dy[2];

            if (p1X >= 0 && p1Y < n) copy[p1Y][p1X] = true;
            if (p2Y < n) copy[p2Y][p2X] = true;
            if (p3X < n && p3Y < n) copy[p3Y][p3X] = true;
        }

        return copy;
    }

    private static void dfs(int depth, int x, int y, boolean[][] used, int n) {
        if (depth == n) {
            answer++;
            return;
        }

        if (y + 1 >= n) return;

        boolean[][] copy = getUsed(x, y, used);

        for (int i = 0; i < n; i++) {
            if (copy[y + 1][i]) continue;

            dfs(depth + 1, i, y + 1, copy, n);
        }
    }

    private static int solution(int n) {
        for (int i = 0; i < n; i++) {
            dfs(1, i, 0, new boolean[n][n], n);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
