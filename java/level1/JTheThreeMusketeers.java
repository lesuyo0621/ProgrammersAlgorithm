public class JTheThreeMusketeers {
    private static int answer = 0;

    private static void find(int[] number, int start, int sum, int count){
        for(int i = start; i < number.length; i++){
            if(count == 3){
                if(sum + number[i] == 0) answer++;
                continue;
            }

            find(number, i + 1, sum + number[i], count + 1);
        }
    }

    private static int solution(int[] number) {
        find(number, 0, 0, 1);
        return answer;
    }

    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(solution(number));
    }
}
