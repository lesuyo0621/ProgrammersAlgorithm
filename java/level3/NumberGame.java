import java.util.Arrays;

public class NumberGame {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        while (aIndex < A.length) {
            if (bIndex >= B.length) {
                return answer;
            }
            if (A[aIndex] > B[bIndex] || A[aIndex] == B[bIndex]) {
                bIndex++;
            } else if (A[aIndex] < B[bIndex]) {
                answer++;
                aIndex++;
                bIndex++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6 };
        int[] B = { 1, 1, 3, 4, 5, 6 };

        NumberGame ng = new NumberGame();
        System.out.println(ng.solution(A, B));
    }
}