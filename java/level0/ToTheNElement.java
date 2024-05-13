import java.util.Arrays;
import java.util.stream.IntStream;

public class ToTheNElement {
    public static int[] solution(int[] num_list, int n) {
        return IntStream.range(0, n)
                .map(i -> num_list[i])
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 2, 1, 7, 5}, 3)));
    }
}
