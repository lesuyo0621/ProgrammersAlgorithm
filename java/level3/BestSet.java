import java.util.Arrays;

public class BestSet {
    private static int[] solution(int n, int s){
        int quotient = s / n;
        int remainder = s % n;

        if(quotient == 0) return new int[]{-1};

        int[] answer = new int[n];
        for(int i = 0; i < answer.length; i++){
            answer[i] = i >= (n - remainder) ? quotient + 1 : quotient;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
        System.out.println(Arrays.toString(solution(4, 31)));
    }
}