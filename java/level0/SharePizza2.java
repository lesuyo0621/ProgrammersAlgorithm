public class SharePizza2 {
    private static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }

    private static int solution(int n){
        int gcd = 0;

        if(n > 6){
            gcd = gcd(n, 6);
        }else{
            gcd = gcd(6, n);
        }

        return n / gcd;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
