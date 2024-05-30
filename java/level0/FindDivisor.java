import java.util.Arrays;
import java.util.stream.IntStream;

public class FindDivisor {
    private static int[] solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24)));
    }
}
