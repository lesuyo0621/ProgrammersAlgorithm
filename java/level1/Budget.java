import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (d[i] <= budget) {
                answer++;
                budget -= d[i];
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] d = { 1, 3, 2, 5, 4 };
        int budget = 9;

        Budget b = new Budget();
        System.out.println(b.solution(d, budget));
    }
}