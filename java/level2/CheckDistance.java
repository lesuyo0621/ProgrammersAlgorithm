import java.util.Arrays;

public class CheckDistance {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    private static boolean outIndex(int x, int y) {
        return x >= 5 || y >= 5 || x < 0 || y < 0;
    }

    private static boolean hasPeople(String[] place, int[] xy) {
        for (int i = 0; i < 4; i++) {
            int x = xy[1] + dx[i];
            int y = xy[0] + dy[i];

            if (outIndex(x, y)) continue;

            if ('P' == place[y].charAt(x)) {
                return true;
            }

            if ('O' == place[y].charAt(x)) {
                for (int j = 0; j < 4; j++) {
                    int xRe = x + dx[j];
                    int yRe = y + dy[j];

                    if (xRe == xy[1] && yRe == xy[0]) continue;
                    if (outIndex(xRe, yRe)) continue;

                    if ('P' == place[yRe].charAt(xRe)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            boolean illegal = false;

            String[] place = places[i];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if ('P' == place[j].charAt(k) && hasPeople(place, new int[]{j, k})) {
                        illegal = true;
                        break;
                    }
                }

                if (illegal) break;
            }

            if (!illegal) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        System.out.println(Arrays.toString(solution(places)));
    }
}
