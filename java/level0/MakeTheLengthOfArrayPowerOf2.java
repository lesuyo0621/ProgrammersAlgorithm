import java.util.Arrays;

public class MakeTheLengthOfArrayPowerOf2 {
    private static int[] solution(int[] arr) {
        int targetLength = 1;
        while (arr.length > targetLength) {
            targetLength *= 2;
        }

        int[] answer = new int[targetLength];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
