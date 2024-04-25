import java.util.Arrays;

public class NumberOfDuplicate {
    private static int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(i -> n == i)
                .count();
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 5};
        System.out.println(solution(array, 1));
    }
}
