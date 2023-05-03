import java.util.Arrays;
import java.util.stream.IntStream;

public class SequenceAndIntervalQueries4 {

    public static int[] solution(int[] arr, int[][] queries) {
        Arrays.stream(queries).forEach(query -> {
            IntStream.range(query[0], query[1] + 1).forEach(i -> {
                if(i % query[2] == 0) arr[i]++;
            });
        });

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 1}, {0, 3, 2}, {0, 3, 3}};

        System.out.println(Arrays.toString(solution(arr, queries)));
    }
}
