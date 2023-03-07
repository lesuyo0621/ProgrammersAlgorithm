import java.util.Stack;

public class IronStick {
    public int solution(String arrangement) {
        int answer = 0;
        int addstick = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] array = arrangement.toCharArray();

        for (int i = 0; i < array.length; i++) {
            stack.push(array[array.length - 1 - i]);
        }

        for (int n = 0; n < array.length; n++) {
            if (n == 0) {
                if (String.valueOf(stack.peek()).equals(")")) {
                    stack2.push(stack.pop());
                    continue;
                } else if (String.valueOf(stack.peek()).equals("(")) {
                    stack2.push(stack.pop());
                    addstick++;
                }
            } else if (String.valueOf(stack.peek()).equals(")") && String.valueOf(stack2.peek()).equals("(")) {
                stack2.push(stack.pop());
                addstick--;
                answer = answer + addstick;
            } else if (String.valueOf(stack.peek()).equals(")") && String.valueOf(stack2.peek()).equals(")")) {
                stack2.push(stack.pop());
                addstick--;
                answer++;
            } else if (String.valueOf(stack.peek()).equals("(")) {
                stack2.push(stack.pop());
                addstick++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        String arrangement = "()(((()())(())()))(())";

        IronStick ir = new IronStick();
        System.out.println(ir.solution(arrangement));
    }
}