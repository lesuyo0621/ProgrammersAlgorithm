import java.util.Arrays;

public class MakeMax2 {
    private static int solution(int[] numbers) {
        Arrays.sort(numbers);
        int num1 = numbers[0] * numbers[1];
        int num2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

        return num1 > num2 ? num1 : num2;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, -3, 4, -5}));
    }
}
