import java.util.Arrays;
import java.util.stream.IntStream;

public class MakeArray1 {
    public static int[] solution(int n, int k) {
        return IntStream.iterate(k, i -> i <= n, i -> i + k).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 3)));
    }
}
