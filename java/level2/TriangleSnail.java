import java.util.Arrays;

public class TriangleSnail {
    private static void move(int direction, int[][] map, int x, int y, int moveCount, int startNum) {
        int[][] xy = {{1, 0}, {0, 1}, {-1, -1}};
        int yAdd = xy[direction][0];
        int xAdd = xy[direction][1];

        for (int i = 0; i < moveCount; i++) {
            x += xAdd;
            y += yAdd;
            startNum++;

            map[y][x] = startNum;
        }
    }

    private static int[] solution(int n) {
        int[][] map = new int[n][n];

        int x = 0;
        int y = -1;
        int moveCount = n;
        int direction = 0;
        int startNum = 0;
        while (moveCount > 0) {
            move(direction, map, x, y, moveCount, startNum);

            switch (direction) {
                case 0:
                    // down
                    y += moveCount;
                    direction = 1;
                    break;
                case 1:
                    // right
                    x += moveCount;
                    direction = 2;
                    break;
                case 2:
                    // up
                    y -= moveCount;
                    x -= moveCount;
                    direction = 0;
                    break;
            }

            startNum += moveCount;
            moveCount--;
        }

        int[] answer = new int[startNum];
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) break;

                answer[index] = map[i][j];
                index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6)));
    }
}
