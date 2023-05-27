public class MergeBigger {

    public static int solution(int a, int b){
        int ab = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int ba = Integer.parseInt(String.valueOf(b) + String.valueOf(a));

        return ab > ba ? ab : ba;
    }

    public static void main(String[] args) {
        int a = 9;
        int b = 91;

        System.out.println(solution(a, b));
    }
}
