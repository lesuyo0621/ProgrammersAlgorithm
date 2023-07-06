import java.util.Arrays;

public class MakeMinimum {
    private static int solution(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i] * B[B.length - 1 - i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        System.out.println(solution(A, B));
    }
}
