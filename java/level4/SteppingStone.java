import java.util.*;

public class SteppingStone {
    private static boolean isValid(int[] rocks, int d, int n) {
        int remove = 0;
        int pos = 0;

        for (int r : rocks) {
            if (r - pos < d) {
                remove++;
                continue;
            }

            pos = r;
        }

        return remove <= n;
    }

    private static int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);

        int min = 1;
        int max = distance + 1;
        while (max - min > 1) {
            int d = (min + max) / 2;

            if (isValid(rocks, d, n)) {
                min = d;
            } else {
                max = d;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
}
