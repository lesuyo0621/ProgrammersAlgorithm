public class NumberOf7 {
    private static int solution(int[] array) {
        int answer = 0;

        for (int num : array) {
            char[] cArr = String.valueOf(num).toCharArray();

            for (char c : cArr) {
                if (c == '7') answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 77, 17}));
    }
}
