public class ConvertSequenceByCondition2 {
    private static int solution(int[] arr) {
        int answer = 0;
        boolean find = false;

        while (!find) {
            find = true;

            for (int i = 0; i < arr.length; i++) {
                int n = arr[i];

                if (n >= 50 && n % 2 == 0) {
                    arr[i] /= 2;
                } else if (n < 50 && n % 2 == 1) {
                    arr[i] = n * 2 + 1;
                }

                if (arr[i] != n) find = false;
            }

            if (!find) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 100, 99, 98}));
    }
}
