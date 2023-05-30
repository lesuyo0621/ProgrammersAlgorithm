public class OddOrEven {
    public static int solution(int n){
        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(i % 2 == 0 && n % 2 == 0){
                answer += i * i;
            }else if(i % 2 == 1 && n % 2 == 1){
                answer += i;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(7));
    }
}
