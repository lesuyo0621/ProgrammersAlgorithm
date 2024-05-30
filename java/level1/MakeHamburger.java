import java.util.Stack;

public class MakeHamburger {
    private static boolean makeHamburger(Stack<Integer> stack) {
        int[] ingreArr = new int[3];

        for (int i = 0; i < 3; i++) {
            if(stack.empty()) {
                break;
            }else {
                ingreArr[i] = stack.pop();
            }
        }

        if(ingreArr[0] == 3 && ingreArr[1] == 2 && ingreArr[2] == 1) {
            return true;
        }else {
            for (int i = 2; i >= 0; i--) {
                if(ingreArr[i] != 0) stack.push(ingreArr[i]);
            }

            return false;
        }
    }

    private static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i : ingredient) {
            if(i == 1) {
                if(makeHamburger(stack)) {
                    answer++;
                }else {
                    stack.push(i);
                }
            }else {
                stack.push(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }
}
