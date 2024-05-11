import java.util.Arrays;

public class ChooseMultipleOfN {
    public static int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .filter(i -> i % n == 0)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{1, 9, 3, 10, 13, 5})));
    }
}
