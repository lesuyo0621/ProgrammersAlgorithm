import java.util.Arrays;

public class AreaOf2 {
    private static int[] solution(int[] arr) {
        int first = -1;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (first == -1) {
                    first = i;
                } else {
                    end = end < i ? i : end;
                }
            }
        }

        if (first == -1) return new int[]{-1};
        if (end == 0) return new int[]{2};
        return Arrays.copyOfRange(arr, first, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 4, 5, 2, 9}));
    }
}
