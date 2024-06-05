public class Factorial {
    private static int solution(int n) {
        int count = 1;

        for (int i = 1; i <= 11; i++) {
            count *= i;
            if (count > n) return i - 1;
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(3628800));
    }
}
