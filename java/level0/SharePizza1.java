public class SharePizza1 {
    private static int solution(int n){
        return (int) Math.ceil(n / 7.0);
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
