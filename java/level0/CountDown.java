import java.util.Arrays;
import java.util.stream.IntStream;

public class CountDown {
    public static int[] solution(int start, int end_num) {
        return IntStream.iterate(start, i -> i >= end_num, i -> i - 1).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 3)));
    }
}
