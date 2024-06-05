public class NearNumber {
    private static int solution(int[] array, int n) {
        int minAbs = Integer.MAX_VALUE;
        int num = 0;

        for (int i : array) {
            int abs = Math.abs(n - i);

            if (abs < minAbs) {
                minAbs = abs;
                num = i;
            } else if (abs == minAbs && n - i > 0) {
                minAbs = abs;
                num = i;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 10, 28}, 20));
    }
}
