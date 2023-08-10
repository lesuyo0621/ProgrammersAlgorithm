public class FindTheNumberOfDecimalsInBaseK {
    private static boolean isPrimeNum(long num){
        if(num == 0 || num == 1) return false;

        int sqrt = (int) Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    private static int solution(int n, int k){
        int answer = 0;
        String numStr = Integer.toString(n, k);

        String[] numList = numStr.split("(0)+");
        for(String num : numList){
            long number = Long.parseLong(num);

            if(isPrimeNum(number)){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }
}
