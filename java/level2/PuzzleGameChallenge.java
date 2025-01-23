public class PuzzleGameChallenge {
    private static long getTotalTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int levelDiff = diffs[i] - level;

            totalTime += levelDiff > 0 ? ((times[i - 1] + times[i]) * levelDiff) + times[i] : times[i];
        }

        return totalTime;
    }

    private static int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100000;

        while ((min != max)) {
            int mid = (min + max) / 2;
            if (mid == min) break;

            long totalTime = getTotalTime(diffs, times, mid);

            if (totalTime > limit) {
                min = mid;
            } else {
                max = mid;
            }
        }

        long totalTime = getTotalTime(diffs, times, (min + max) / 2);

        return totalTime > limit ? max : min;
    }

    public static void main(String[] args) {
        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        long limit = 30;
        System.out.println(solution(diffs, times, limit));
    }
}
