import java.util.*;

public class NumberBlock {
    private static int getNum(int target) {
        if (target == 1) return 0;

        int sqrt = (int) Math.sqrt(target);
        boolean[] used = new boolean[sqrt + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 2; i <= sqrt; i++) {
            if (!used[i]) {
                for (int j = i; j <= sqrt; j += i) {
                    if (target % j == 0) {
                        pq.add(j);
                        pq.add(target / j);
                    }

                    used[j] = true;
                }
            }
        }

        int max = 1;
        while (!pq.isEmpty()) {
            int n = pq.poll();

            if (n <= 10000000) {
                max = n;
                break;
            }
        }

        return max;
    }

    private static int[] solution(long begin, long end) {
        int b = (int) begin;
        int e = (int) end;
        int[] answer = new int[e - b + 1];

        for (int i = b; i <= e; i++) {
            answer[i - b] = getNum(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1, 10)));
    }
}
