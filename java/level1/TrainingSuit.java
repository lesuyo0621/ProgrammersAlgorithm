public class TrainingSuit {
    private static int solution(int n, int[] lost, int[] reserve) {
        int[] suit = new int[n + 1];

        for (int l : lost) {
            suit[l]--;
        }

        for (int r : reserve) {
            suit[r]++;
        }

        int answer = 0;
        for (int i = 1; i < suit.length; i++) {
            if (suit[i] == -1) {
                if (suit[i - 1] == 1) {
                    suit[i - 1]--;
                    suit[i]++;
                    answer++;
                } else if (i + 1 < suit.length && suit[i + 1] == 1) {
                    suit[i + 1]--;
                    suit[i]++;
                    answer++;
                }
            } else {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }
}
