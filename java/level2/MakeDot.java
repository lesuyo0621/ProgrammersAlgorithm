public class MakeDot {
    private static long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            long dSquare = (long) d * d;
            long iSquare = (long) i * i;

            answer += (long) Math.sqrt(dSquare - iSquare) / k + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
    }
}
