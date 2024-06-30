import java.util.*;

public class NumberCardDivision {
    private static int gcd(int a, int b) {
        int n;

        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }

        return a;
    }

    private static int findGcd(int[] a) {
        int gcd = a[0];

        for (int i = 1; i < a.length; i++) {
            gcd = gcd(a[i], gcd);
        }

        return gcd;
    }

    private static int findMax(int[] t, int gcd) {
        for (int n : t) {
            if (n % gcd == 0) return 0;
        }

        return gcd;
    }

    private static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int aGcd = findGcd(arrayA);
        int maxA = findMax(arrayB, aGcd);

        int bGcd = findGcd(arrayB);
        int maxB = findMax(arrayA, bGcd);

        return Math.max(maxA, maxB);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
    }
}
