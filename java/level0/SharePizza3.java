public class SharePizza3 {
    private static int solution(int slice, int n){
        return n % slice > 0 ? n / slice + 1 : n / slice;
    }

    public static void main(String[] args) {
        System.out.println(solution(7, 10));
    }
}
