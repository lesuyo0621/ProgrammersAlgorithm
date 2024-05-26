import java.util.Arrays;

public class Back5th2 {
    private static int[] solution(int[] num_list) {
        return Arrays.stream(num_list)
                .sorted()
                .limit(5)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{12, 4, 15, 46, 38, 1, 14})));
    }
}
