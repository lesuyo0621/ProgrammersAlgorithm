public class SpecificString {
    public static int solution(String ineq, String eq, int n, int m){
        int answer = 0;

        if(ineq.equals(">")){
            if(eq.equals("=")){
                if(n >= m) answer = 1;
            }else{
                if(n > m) answer = 1;
            }
        }else{
            if(eq.equals("=")){
                if(n <= m) answer = 1;
            }else{
                if(n < m) answer = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("<", "=", 20, 50));
    }
}
