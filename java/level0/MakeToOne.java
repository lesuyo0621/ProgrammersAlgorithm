public class MakeToOne {
    private static int solution(int[] num_list) {
        int answer = 0;

        for (int num : num_list) {
            while (num != 1) {
                answer++;
                num /= 2;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{12, 4, 15, 1, 14}));
    }
}
