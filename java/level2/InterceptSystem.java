import java.util.*;

public class InterceptSystem {
    private static int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int answer = 0;
        int last = -1;
        for (int[] t : targets) {
            if (last > t[0] && last <= t[1]) continue;

            last = t[1];
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }
}
