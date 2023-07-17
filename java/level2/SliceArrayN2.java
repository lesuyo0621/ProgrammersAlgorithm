import java.util.Arrays;

public class SliceArrayN2 {
    private static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        long t = (long) n;

        for(long i = 0; i < answer.length; i++){
            long quotient = ((left + i) / t) + 1L;
            long remainder = ((left + i) % t);

            answer[(int)i] = (int) (remainder < quotient ? quotient : quotient + (remainder - quotient + 1));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }
}
