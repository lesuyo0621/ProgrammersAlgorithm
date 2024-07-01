import java.util.*;

public class CreateStarAtTheIntersection {
    private static List<Long[]> findStar(int[][] line) {
        List<Long[]> starList = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0], B = line[i][1], E = line[i][2];
                long C = line[j][0], D = line[j][1], F = line[j][2];

                long denominator = (A * D) - (B * C);
                long xFunc = (B * F) - (E * D);
                long yFunc = (E * C) - (A * F);

                if (denominator == 0
                        || xFunc % denominator != 0
                        || yFunc % denominator != 0) {
                    continue;
                }

                Long[] star = new Long[]{xFunc / denominator, yFunc / denominator};
                starList.add(star);
            }
        }

        return starList;
    }

    private static String[] solution(int[][] line) {
        // 별 좌표 구하고
        List<Long[]> starList = findStar(line);

        // 정답으로 기록할 String 배열(네모) 사이즈 구하고
        long left = starList.get(0)[0];
        long right = starList.get(0)[0];
        long up = starList.get(0)[1];
        long down = starList.get(0)[1];
        for (int i = 1; i < starList.size(); i++) {
            long x = starList.get(i)[0];
            long y = starList.get(i)[1];

            if (x < left) {
                left = x;
            } else if (x > right) {
                right = x;
            }

            if (y < down) {
                down = y;
            } else if (y > up) {
                up = y;
            }
        }

        // 별 위치 기록하고
        int ySize = (int)(up - down) + 1;
        int xSize = (int)(right - left) + 1;
        boolean[][] starPosition = new boolean[ySize][xSize];
        for (int i = 0; i < starList.size(); i++) {
            long x = starList.get(i)[0];
            long y = starList.get(i)[1];

            starPosition[(int)(y - down)][(int)(x - left)] = true;
        }

        // 별 좌표를 정답 형태로 가공
        String[] answer = new String[starPosition.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < starPosition.length; i++) {
            for (int j = 0; j < starPosition[0].length; j++) {
                sb.append(starPosition[i][j] ? "*" : ".");
            }

            answer[answer.length - i - 1] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));
    }
}
