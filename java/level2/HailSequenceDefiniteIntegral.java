import java.util.*;

public class HailSequenceDefiniteIntegral {
    public static double[] solution(int k, int[][] ranges) {
        List<Double> area = new ArrayList<>();
        while (k > 1) {
            int prevK = k;
            int nextK = k % 2 == 0 ? k / 2 : k * 3 + 1;

            double sum = 0;
            if (prevK > nextK) {
                sum += (prevK - nextK) * 0.5;
                sum += nextK;
            } else {
                sum += (nextK - prevK) * 0.5;
                sum += prevK;
            }

            area.add(sum);
            k = nextK;
        }

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int from = ranges[i][0];
            int to = area.size() + ranges[i][1];

            if (to < from) {
                answer[i] = -1;
                continue;
            }

            for (int j = from; j < to; j++) {
                answer[i] += area.get(j);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}})));
    }
}
