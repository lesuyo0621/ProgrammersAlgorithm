import java.util.Arrays;

public class MakeMaximum {
    public static int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 31, 24, 10, 1, 9}));
    }
}
