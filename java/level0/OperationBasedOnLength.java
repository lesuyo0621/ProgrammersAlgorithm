import java.util.Arrays;

public class OperationBasedOnLength {
    public static int solution(int[] num_list) {
        return Arrays.stream(num_list)
                .reduce((x, y) -> num_list.length > 10 ? x + y : x * y)
                .getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1}));
    }
}
