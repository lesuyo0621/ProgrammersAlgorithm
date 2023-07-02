import java.util.Arrays;
import java.util.stream.IntStream;

public class CountUp {

    private static int[] solution(int start, int end) {
        return IntStream.rangeClosed(start, end).toArray();
    }

    public static void main(String[] args) {
        int start = 3;
        int end = 10;

        System.out.println(Arrays.toString(solution(start, end)));
    }
}
