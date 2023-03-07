public class LengthOfVisit {

    public int solution(String dirs) {
        int answer = 0;
        int[][][][] map = new int[11][11][11][11];
        int x = 5;
        int y = 5;

        // 맵체크
        // 넘어가면 무시

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                // 상
                if (y == 0) {
                    continue;
                } else {
                    // 첫 길인지 체크
                    if (map[y][x][y - 1][x] == 0 && map[y - 1][x][y][x] == 0) {
                        answer++;
                    }
                    map[y][x][y - 1][x]++;
                    map[y - 1][x][y][x]++;
                    y--;
                }
            } else if (dirs.charAt(i) == 'D') {
                // 하
                if (y == 10) {
                    continue;
                } else {
                    // 첫 길인지 체크
                    if (map[y][x][y + 1][x] == 0 && map[y + 1][x][y][x] == 0) {
                        answer++;
                    }
                    map[y][x][y + 1][x]++;
                    map[y + 1][x][y][x]++;
                    y++;
                }
            } else if (dirs.charAt(i) == 'L') {
                // 좌
                if (x == 0) {
                    continue;
                } else {
                    // 첫 길인지 체크
                    if (map[y][x][y][x - 1] == 0 && map[y][x - 1][y][x] == 0) {
                        answer++;
                    }
                    map[y][x][y][x - 1]++;
                    map[y][x - 1][y][x]++;
                    x--;
                }
            } else if (dirs.charAt(i) == 'R') {
                // 우
                if (x == 10) {
                    continue;
                } else {
                    // 첫 길인지 체크
                    if (map[y][x][y][x + 1] == 0 && map[y][x + 1][y][x + 1] == 0) {
                        answer++;
                    }
                    map[y][x][y][x + 1]++;
                    map[y][x + 1][y][x]++;
                    x++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String dirs = "LULLLLLLU";

        LengthOfVisit lov = new LengthOfVisit();
        System.out.println(lov.solution(dirs));
    }
}