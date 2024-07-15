import java.util.*;

public class EscapeMaze {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static int getMinPath(String[] maps, int startX, int startY, int endX, int endY, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited[startY][startX] = true;

        int min = -1;
        while (!q.isEmpty()) {
            int[] nextPoint = q.poll();

            if (nextPoint[0] == endX && nextPoint[1] == endY) {
                min = nextPoint[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nextPoint[0] + DX[i];
                int nextY = nextPoint[1] + DY[i];
                int count = nextPoint[2] + 1;

                if (nextX >= maps[0].length() || nextX < 0) continue;
                if (nextY >= maps.length || nextY < 0) continue;
                if (visited[nextY][nextX]) continue;

                if (maps[nextY].charAt(nextX) != 'X') {
                    q.add(new int[]{nextX, nextY, count});
                    visited[nextY][nextX] = true;
                }
            }
        }

        return min;
    }

    private static int solution(String[] maps) {
        int rowCount = maps.length;
        int columnCount = maps[0].length();

        int[] xyS = new int[2];
        int[] xyL = new int[2];
        int[] xyE = new int[2];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                switch (maps[i].charAt(j)) {
                    case 'S':
                        xyS[0] = j;
                        xyS[1] = i;
                        break;
                    case 'L':
                        xyL[0] = j;
                        xyL[1] = i;
                        break;
                    case 'E':
                        xyE[0] = j;
                        xyE[1] = i;
                        break;
                }
            }
        }

        int minL = getMinPath(maps, xyS[0], xyS[1], xyL[0], xyL[1], new boolean[rowCount][columnCount]);
        if (minL == -1) return -1;

        int minE = getMinPath(maps, xyL[0], xyL[1], xyE[0], xyE[1], new boolean[rowCount][columnCount]);
        if (minE == -1) return -1;

        return minL + minE;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
    }
}
