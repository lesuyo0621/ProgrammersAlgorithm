import java.util.*;

public class DiskController {
    private static int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
        );

        int[] progressTime = {-1, 0};
        int answer = 0;
        int time = 0;
        int idx = 0;
        while (!(idx >= jobs.length && pq.isEmpty() && progressTime[1] <= 0)) {
            if (progressTime[1] <= 0) {
                while (idx < jobs.length) {
                    int[] j = jobs[idx];

                    if (j[0] > time) break;
                    pq.add(j);
                    idx++;
                }

                if (!pq.isEmpty()) {
                    progressTime = pq.poll();
                }
            }

            time++;
            progressTime[1]--;

            if (progressTime[0] != -1 && progressTime[1] == 0) {
                answer += time - progressTime[0];
            }
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}
