public class DiceGame1 {
    private static int solution(int a, int b) {
        if(a % 2 == 1 && b % 2 == 1) {
            return (int) (Math.pow(a, 2) + Math.pow(b, 2));
        }else if(a % 2 == 1 || b % 2 == 1) {
            return 2 * (a + b);
        }

        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 5));
    }
}
