import java.util.Arrays;

public class LottoHighestAndLowest {
    private static int[] solution(int[] lottos, int[] win_nums) {
        int correctCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCount++;
                continue;
            }

            for(int j = 0; j < win_nums.length; j++) {
                if(win_nums[j] == lottos[i]) {
                    correctCount++;
                    break;
                }
            }
        }

        int high = correctCount == 0 && zeroCount == 0 ? 6 : 7 - correctCount - zeroCount;
        int low = correctCount <= 1 ? 6 : 7 - correctCount;

        return new int[]{high, low};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }
}
