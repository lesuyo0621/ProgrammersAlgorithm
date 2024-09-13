public class SumOfContinuousPulseSubsequences {
    private static long solution(int[] sequence) {
        int[] pulse1 = new int[sequence.length];
        int[] pulse2 = new int[sequence.length];

        int p = 1;
        for (int i = 0; i < sequence.length; i++) {
            pulse1[i] = sequence[i] * p;
            pulse2[i] = sequence[i] * p * -1;

            p *= -1;
        }

        long pulse1Max = 0;
        long pulse2Max = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < pulse1.length; i++) {
            sum1 = Math.max(sum1 + pulse1[i], pulse1[i]);
            sum2 = Math.max(sum2 + pulse2[i], pulse2[i]);

            pulse1Max = Math.max(pulse1Max, sum1);
            pulse2Max = Math.max(pulse2Max, sum2);
        }

        return Math.max(pulse1Max, pulse2Max);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }
}
