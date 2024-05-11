public class AddUntilGreaterThanN {
    public static int solution(int[] numbers, int n) {
        int answer = 0;

        for(int i = 0; i < numbers.length; i++){
            if(answer > n) break;
            answer += numbers[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{34, 5, 71, 29, 100, 34}, 123));
    }
}
