public class Budgets {

    public int solution(int[] budgets, int M) {
        int max = 0;
        int min = 0;
        int mid = 0;
        long sum = 0;

        for (int i = 0; i < budgets.length; i++) {
            sum += budgets[i];
            if (max < budgets[i]) {
                max = budgets[i];
            }
        }

        if (sum <= M) {
            return max;
        } else {
            sum = 0;
        }

        while (min <= max) {
            mid = (min + max) / 2;
            sum = 0;

            for (int j = 0; j < budgets.length; j++) {
                if (budgets[j] > mid) {
                    sum += mid;
                } else {
                    sum += budgets[j];
                }
            }

            if (sum == M) {
                return mid;
            } else if (sum < M) {
                min = mid + 1;
            } else if (sum > M) {
                max = mid - 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] budgets = { 120, 110, 140, 150 };
        int M = 485;

        Budgets b = new Budgets();
        System.out.println(b.solution(budgets, M));
    }
}