import java.util.Arrays;
import java.util.Stack;

public class MakeArray4 {

    private static int[] solution(int[] arr){
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            int num = arr[i];

            if(stk.size() != 0){
                if(num > stk.peek()){
                    stk.push(num);
                }else{
                    stk.pop();
                    i--;
                }
            }else{
                stk.push(arr[i]);
            }
        }

        return stk.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
