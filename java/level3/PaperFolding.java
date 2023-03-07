import java.util.Arrays;

public class PaperFolding {

    public int[] solution(int n) {
        int[] answer = { 0 };
        int[] reverse = { 0 };
        int[] forward = { 0 };
        int step = 1;

        if (n == 1) {
            return answer;
        } else {
            while (step < n) {
                reverse = new int[forward.length];
                for (int i = 0; i < forward.length; i++) {
                    if (forward[i] == 0) {
                        reverse[i] = 1;
                    } else if (forward[i] == 1) {
                        reverse[i] = 0;
                    }
                }

                answer = new int[forward.length + reverse.length + 1];

                for (int j = 0; j < answer.length; j++) {
                    if (j == forward.length) {
                        answer[j] = 0;
                    } else if (j < forward.length) {
                        answer[j] = forward[j];
                    } else if (j > forward.length) {
                        answer[j] = reverse[reverse.length * 2 - j];
                    }
                }
                forward = answer;
                step++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;

        PaperFolding pf = new PaperFolding();
        System.out.println(Arrays.toString(pf.solution(n)));
    }
}