import java.util.Arrays;

public class top {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int h = 0;

        for (int i = heights.length - 1; i > 0; i--) {
            h = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (h < heights[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] heights = { 1, 5, 3, 6, 7, 6, 5 };

        top t = new top();
        System.out.println(Arrays.toString(t.solution(heights)));
    }
}