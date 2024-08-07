public class ThreeNTile {
    private static final int[] MEM = new int[5001];
    private static final int MOD = 1000000007;

    private static int dp(int n) {
        if (n == 1) return 2;
        if (n == 2) return 3;
        if (MEM[n] != 0) return MEM[n];

        if (n % 2 == 0) {
            return MEM[n] = (dp(n - 1) + dp(n - 2)) % MOD;
        } else {
            return MEM[n] = ((dp(n - 1) * 2 % MOD) + dp(n - 2)) % MOD;
        }
    }

    private static int solution(int n) {
        return dp(n);
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
