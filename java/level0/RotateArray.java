import java.util.Arrays;

public class RotateArray {
    private static int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        switch (direction) {
            case "left" :
                System.arraycopy(numbers, 1, answer, 0, numbers.length - 1);
                answer[answer.length - 1] = numbers[0];
                break;
            case "right" :
                System.arraycopy(numbers, 0, answer, 1, numbers.length - 1);
                answer[0] = numbers[numbers.length - 1];
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, "right")));
    }
}
