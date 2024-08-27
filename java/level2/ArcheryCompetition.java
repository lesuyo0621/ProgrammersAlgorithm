import java.util.*;

public class ArcheryCompetition {
    private static int[] answer = {-1};
    private static int scoreGap = 0;
    private static int remainArrow = 0;

    private static boolean isMoreAnswer(int[] rionInfo, int currentGap) {
        if (answer.length == 1) return true;
        if (scoreGap < currentGap) return true;
        if (scoreGap > currentGap) return false;

        for (int i = rionInfo.length - 1; i >= 0; i--) {
            if (rionInfo[i] == answer[i]) continue;

            return rionInfo[i] > answer[i];
        }

        return false;
    }

    private static void dfs(int n, int idx, int[] info, int[] rionInfo, int apeachScore, int rionScore) {
        if (n < 0) return;

        if (apeachScore < rionScore && isMoreAnswer(rionInfo, rionScore - apeachScore)) {
            answer = Arrays.copyOf(rionInfo, rionInfo.length);
            scoreGap = rionScore - apeachScore;
            remainArrow = n;
        }

        if (idx > 10) return;

        for (int i = idx; i < 11; i++) {
            int needArrow = info[i] + 1;
            int nextN = n - needArrow;
            int nextRionScore = rionScore + (10 - i);
            int nextApeachScore = apeachScore;
            if (info[i] > 0) nextApeachScore -= (10 - i);

            rionInfo[i] = needArrow;
            dfs(nextN, i + 1, info, rionInfo, nextApeachScore, nextRionScore);
            rionInfo[i] = 0;
        }
    }

    public static int[] solution(int n, int[] info) {
        int apeachScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] > 0) {
                apeachScore += 10 - i;
            }
        }

        int[] rionInfo = new int[11];
        dfs(n, 0, info, rionInfo, apeachScore, 0);

        if (remainArrow > 0) {
            answer[10] += remainArrow;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
    }
}
