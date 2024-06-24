import java.util.LinkedList;
import java.util.Queue;

public class MakeTheSumOfTwoQueuesEqual {
    private static int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];

            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        int count = 0;
        int limit = (queue1.length + queue2.length) * 2;
        while (count <= limit) {
            int n = 0;

            if (sum1 < sum2) {
                n = q2.poll();
                sum2 -= n;

                q1.add(n);
                sum1 += n;
            } else if (sum1 > sum2) {
                n = q1.poll();
                sum1 -= n;

                q2.add(n);
                sum2 += n;
            } else {
                answer = count;
                break;
            }

            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    }
}
