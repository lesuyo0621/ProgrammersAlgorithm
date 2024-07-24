import java.util.*;

public class MasterOfPlayingAlone {
    private static int solution(int[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        boolean[] used = new boolean[cards.length];

        int idx = 0;
        while (idx != -1) {
            idx = -1;
            for (int i = 0; i < cards.length; i++) {
                if(!used[i]) {
                    idx = i;
                    break;
                }
            }

            if (idx == -1) break;

            int count = 0;
            while (!used[idx]) {
                used[idx] = true;
                count++;

                idx = cards[idx] - 1;
            }

            if (count > 0) pq.add(count);
        }

        int answer = 0;
        if (pq.size() >= 2) {
            answer = pq.poll() * pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }
}
