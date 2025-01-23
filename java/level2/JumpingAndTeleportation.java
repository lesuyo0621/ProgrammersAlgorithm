public class JumpingAndTeleportation {
    private static int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if ((n & 1) == 1) ans++;
            n = n >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
