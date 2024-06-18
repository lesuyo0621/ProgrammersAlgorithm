import java.util.Arrays;

public class NoMoreThan2DifferentBits {
    private static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            String s = Long.toString(num, 2);
            int k = 0;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '0') break;
                k++;
            }

            answer[i] = k == 0 ? num + 1 : num + (long) Math.pow(2, k - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{2, 7})));
    }
}
