import java.util.*;

public class FunctionDevelopment {
    private static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain / speeds[i]) + (remain % speeds[i] > 0 ? 1 : 0);

            q.add(day);
        }

        int max = q.poll();
        int count = 1;
        while (!q.isEmpty()) {
            int day = q.poll();

            if (max < day) {
                answer.add(count);
                max = day;
                count = 1;
            } else {
                count++;
            }
        }
        answer.add(count);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    }
}
