public class DiceCount {
    private static int solution(int[] box, int n) {
        return (box[0] / n) * (box[1] / n) * (box[2] / n);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1}, 1));
    }
}
