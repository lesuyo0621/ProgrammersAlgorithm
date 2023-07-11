public class LongJump {
    private static long solution(int n){
        int[] fibo = new int[n];

        if(n == 1) return 1;
        if(n == 2) return 2;

        fibo[0] = 1;
        fibo[1] = 1;
        for(int i = 2; i < n; i++){
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        return (fibo[n - 1] + fibo[n - 2]) % 1234567;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
