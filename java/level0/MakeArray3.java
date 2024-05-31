import java.util.Arrays;

public class MakeArray3 {
    private static int[] solution(int[] arr, int[][] intervals) {
        int firstSize = intervals[0][1] - intervals[0][0] + 1;
        int secondSize = intervals[1][1] - intervals[1][0] + 1;
        int[] answer = new int[firstSize + secondSize];

        System.arraycopy(arr, intervals[0][0], answer, 0, firstSize);
        System.arraycopy(arr, intervals[1][0], answer, firstSize, secondSize);

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[][] intervals = {{1, 3}, {0, 4}};

        System.out.println(Arrays.toString(solution(arr, intervals)));
    }
}
