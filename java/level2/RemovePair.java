import java.util.Stack;

public class RemovePair {
    private static int solution(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);

            if(stack.size() != 0 && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }
}
