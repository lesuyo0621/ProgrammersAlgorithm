import java.util.Arrays;
import java.util.Stack;

public class FindNextBigNumber {
    private static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            int target = numbers[i];

            while (!stack.empty()) {
                int num = stack.pop();

                if (num > target) {
                    answer[i] = num;
                    stack.push(num);
                    break;
                }
            }

            stack.push(target);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
    }
}
