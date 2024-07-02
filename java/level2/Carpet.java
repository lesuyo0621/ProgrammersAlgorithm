import java.util.Arrays;

public class Carpet {
    private static int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i != 0) continue;

            int yellowX = i;
            int yellowY = yellow / i;

            if ((yellowX + 2) * 2 + (yellowY + 2) * 2 - 4 == brown) {
                x = yellowX + 2;
                y = yellowY + 2;
                break;
            }
        }

        return new int[]{y, x};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
    }
}
