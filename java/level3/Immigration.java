public class Immigration {
    private static long solution(int n, int[] times) {
        long left = 1;
        long right = 1000000000000000000L;

        while (left < right) {
            long count = 0;
            long mid = (left + right) / 2;

            for (int t : times) {
                count += mid / t;
            }

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }
}
