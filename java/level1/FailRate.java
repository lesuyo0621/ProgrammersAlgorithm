import java.util.*;

public class FailRate {
    private static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] played = new int[N];
        int[] success = new int[N];
        Double[] rate = new Double[N];
        boolean[] add = new boolean[N];

        for(int stage : stages) {
            // 도달한 사람 카운트
            for(int i = 0; i < stage - 1; i++) {
                played[i]++;
                success[i]++;
            }

            // 클리어 중인 사람 추가
            if(stage <= N) played[stage - 1]++;
        }

        // 클리어 중인 사람 / 도달한 사람
        for(int i = 0; i < N; i++) {
            rate[i] = played[i] == 0 ? 0.0 : (double) (played[i] - success[i]) / played[i];
        }

        Double[] sortedRate = Arrays.copyOf(rate, N);
        Arrays.sort(sortedRate, Comparator.reverseOrder());

        int index = 0;
        for(Double sr : sortedRate) {
            for(int i = 0; i < N; i++) {
                if(sr.equals(rate[i]) && !add[i]) {
                    answer[index] = i + 1;
                    index++;
                    add[i] = true;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
}
