import java.util.*;

public class HowToLineUp {
    private static int[] solution(int n, long k) {
        long count = 1;
        for (long i = 2; i <= n - 1; i++) {
            count *= i;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--;
        int[] answer = new int[n];
        int answerIdx = 0;
        while (k > 0) {
            int idx = (int) (k / count);

            answer[answerIdx] = nums.remove(idx);

            k %= count;
            count /= (n - 1 - answerIdx);
            answerIdx++;
        }

        while (answerIdx < answer.length) {
            answer[answerIdx] = nums.remove(0);
            answerIdx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
    }
}
