import java.util.Arrays;

public class SumOfConsecutiveSequences {
    private static int[] solution(int[] sequence, int k){
        int left = 0;
        int right = sequence.length - 1;
        int sum = 0;
        int end = sequence.length;
        int range = 0;

        for(int L = 0, R = 0; L < end; L++){
            while(R < end && sum < k){
                sum += sequence[R];
                R++;
            }

            if(sum == k){
                range = (R - 1) - L;
                if((right - left) > range){
                    left = L;
                    right = R - 1;
                }
            }

            sum -= sequence[L];
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
//        int[] sequence = {1, 2, 3, 4, 5};
//        int k = 7;

        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

//        int[] sequence = {2, 2, 2, 2, 2};
//        int k = 6;

        System.out.println(Arrays.toString(solution(sequence, k)));
    }
}
