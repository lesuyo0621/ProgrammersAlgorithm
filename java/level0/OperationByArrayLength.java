import java.util.Arrays;

public class OperationByArrayLength {
    private static int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr.length % 2 == 0){
                answer[i] = i % 2 == 0 ? arr[i] : arr[i] + n;
            }else{
                answer[i] = i % 2 == 0 ? arr[i] + n : arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{49, 12, 100, 276, 33}, 27)));
    }
}
