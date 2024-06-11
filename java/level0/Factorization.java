import java.util.ArrayList;
import java.util.List;

public class Factorization {
    private static List<Integer> solution(int n) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }

                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        System.out.println(solution(12));
    }
}
