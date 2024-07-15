import java.util.*;

public class MineralMining {
    private static int solution(int[] picks, String[] minerals) {
        int pickCount = 0;
        for (int p : picks) {
            pickCount += p;
        }

        int idx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int i = 0; i < pickCount; i++) {
            int[] cost = new int[3];

            for (int j = 0; j < 5; j++) {
                if (idx >= minerals.length) break;

                switch (minerals[idx]) {
                    case "diamond":
                        cost[0] += 1;
                        cost[1] += 5;
                        cost[2] += 25;
                        break;
                    case "iron":
                        cost[0] += 1;
                        cost[1] += 1;
                        cost[2] += 5;
                        break;
                    case "stone":
                        cost[0] += 1;
                        cost[1] += 1;
                        cost[2] += 1;
                        break;
                }

                idx++;
            }

            pq.add(cost);
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (!pq.isEmpty()) {
                    answer += pq.poll()[i];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
    }
}
