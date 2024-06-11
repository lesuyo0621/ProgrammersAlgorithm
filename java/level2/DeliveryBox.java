import java.util.Stack;

public class DeliveryBox {
    private static int solution(int[] order) {
        int answer = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < order[0]; i++) {
            stack.push(i);
        }

        int right = order[0] + 1;
        for (int i = 1; i < order.length; i++) {
            int o = order[i];

            if (!stack.empty() && stack.peek() == o) {
                stack.pop();
                answer++;
            } else if (right <= o) {
                while (right < o) {
                    stack.push(right);
                    right++;
                }

                right = o + 1;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
    }
}
