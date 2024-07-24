public class ThrowBall {
    private static int solution(int[] numbers, int k) {
        return numbers[((k - 1) * 2) % numbers.length];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}, 2));
    }
}
