import java.util.*;

public class RicochetRobot {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static void addNextPoint(String[] board, boolean[][] visited, Queue<int[]> q, int[] point) {
        int count = point[2];

        for (int i = 0; i < 4; i++) {
            int x = point[0];
            int y = point[1];

            while (true) {
                x += DX[i];
                y += DY[i];

                if ((i == 0 && x >= board[0].length()) || (i == 2 && x < 0)) {
                    x -= DX[i];
                    break;
                } else if ((i == 1 && y >= board.length) || (i == 3 && y < 0)) {
                    y -= DY[i];
                    break;
                }

                if (board[y].charAt(x) == 'D') {
                    x -= DX[i];
                    y -= DY[i];
                    break;
                }
            }

            if (!visited[y][x]) {
                q.add(new int[]{x, y, count + 1});
                visited[y][x] = true;
            }
        }
    }

    private static int getMinCount(String[] board, int startX, int startY, int endX, int endY, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            int count = point[2];

            if (x == endX && y == endY) {
                min = Math.min(min, count);
            }

            addNextPoint(board, visited, q, point);
        }

        return min;
    }

    private static int solution(String[] board) {
        int rowCount = board.length;
        int columnCount = board[0].length();

        int[] xyR = new int[2];
        int[] xyG = new int[2];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                switch (board[i].charAt(j)) {
                    case 'R':
                        xyR[0] = j;
                        xyR[1] = i;
                        break;
                    case 'G':
                        xyG[0] = j;
                        xyG[1] = i;
                        break;
                }
            }
        }

        boolean[][] visited = new boolean[rowCount][columnCount];
        int min = getMinCount(board, xyR[0], xyR[1], xyG[0], xyG[1], visited);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}
