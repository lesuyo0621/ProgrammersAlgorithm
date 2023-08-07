import java.util.Arrays;
import java.util.stream.IntStream;

public class OvertimeIndex {
    private static long solution(int n, int[] works){
        int max = Arrays.stream(works).max().getAsInt();

        long[] timeCount = new long[max + 1];
        Arrays.stream(works)
                .forEach(i -> timeCount[i]++);

        while (n > 0){
            timeCount[max - 1]++;
            long count = --timeCount[max];

            if(count == 0) max--;
            if(max == 0) return 0;
            n--;
        }

        return IntStream.rangeClosed(0, max)
                .filter(i -> timeCount[i] != 0)
                .mapToLong(i -> i * i * timeCount[i])
                .sum();
    }

    public static void main(String[] args) {
        int[] works = {4, 3, 3};
        int n = 4;
        System.out.println(solution(n, works));
    }
}
