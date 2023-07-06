public class ExpressionNumber {
    private static int solution(int n){
        int answer = 0;

        for(int i = 1; i <= n; i++){
            if((n - (i / 2.0 * (i - 1))) > 0 && (n - (i / 2.0 * (i - 1))) % i == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
