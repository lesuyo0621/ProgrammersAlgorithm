import java.util.stream.IntStream;

public class FirstNegativeNumber {
    public static int solution(int[] num_list) {
        return IntStream.range(0, num_list.length)
                .filter(i -> num_list[i] < 0)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{12, 4, 15, 46, 38, -2, 15}));
    }
}
