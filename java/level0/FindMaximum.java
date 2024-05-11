import java.util.Arrays;

public class FindMaximum {
    public static int[] solution(int[] array) {
        int[] answer = new int[2];

        for(int i = 0; i < array.length; i++){
            if(array[i] > answer[0]){
                answer[0] = array[i];
                answer[1] = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 8, 3})));
    }
}
