public class BacterialGrowth {
    public static int solution(int n, int t) {
        return n * (int) Math.pow(2, t);
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10));
    }
}
