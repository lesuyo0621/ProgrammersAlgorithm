import java.util.Arrays;

public class ConvertSequenceByCondition3 {
    private static int[] solution(int[] arr, int k) {
        return Arrays.stream(arr)
                .map(i -> k % 2 == 0 ? i + k : i * k)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 100, 99, 98}, 3)));
    }
}
