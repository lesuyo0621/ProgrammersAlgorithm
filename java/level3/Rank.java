public class Rank {
    private static int countWin(int target, boolean[][] game, boolean[] visited) {
        int count = 1;
        visited[target] = true;

        for (int i = 0; i < game.length; i++) {
            if (visited[i]) continue;

            if (game[target][i]) {
                count += countWin(i, game, visited);
            }
        }

        return count;
    }

    private static int countLose(int target, boolean[][] game, boolean[] visited) {
        int count = 1;
        visited[target] = true;

        for (int i = 0; i < game.length; i++) {
            if (visited[i]) continue;

            if (game[i][target]) {
                count += countLose(i, game, visited);
            }
        }

        return count;
    }

    private static int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] game = new boolean[n + 1][n + 1];
        for (int[] r : results) {
            game[r[0]][r[1]] = true;
        }

        for (int i = 1; i <= n; i++) {
            int win = countWin(i, game, new boolean[n + 1]) - 1;
            int lose = countLose(i, game, new boolean[n + 1]) - 1;

            if (win + lose + 1 == n) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
