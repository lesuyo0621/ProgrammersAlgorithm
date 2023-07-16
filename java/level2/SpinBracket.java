import java.util.EmptyStackException;
import java.util.Stack;

public class SpinBracket {
    private static int solution(String s){
        int answer = 0;
        String ss = s + s;
        Stack<Character> stack = new Stack<>();
        boolean stop = false;

        for(int i = 0; i < s.length(); i++){
            stack.clear();
            stop = false;

            for(int j = 0; j < s.length(); j++){
                char c = ss.charAt(i + j);

                try{
                    switch (c) {
                        case ')' :
                            if(stack.peek() == '('){
                                stack.pop();
                            }else{
                                stop = true;
                            }
                            break;
                        case '}' :
                            if(stack.peek() == '{'){
                                stack.pop();
                            }else{
                                stop = true;
                            }
                            break;
                        case ']' :
                            if(stack.peek() == '['){
                                stack.pop();
                            }else{
                                stop = true;
                            }
                            break;
                        default :
                            stack.push(c);
                            break;
                    }
                }catch (EmptyStackException e){
                    stop = true;
                }

                if(stop) break;
            }

            if(!stop && stack.isEmpty()) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }
}
