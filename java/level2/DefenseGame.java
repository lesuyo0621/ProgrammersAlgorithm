import java.util.*;

public class DefenseGame {
    private static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int e : enemy) {
            n -= e;
            max.add(e);

            while (n < 0 && k > 0 && !max.isEmpty()) {
                n += max.poll();
                k--;
            }

            if (n < 0) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    }
}
