import java.util.*;

public class MaximizeFormula {
    private static final String[] OPERS = {"*", "+", "-"};
    private static long max = 0;

    private static long calc(long left, long right, String oper) {
        switch (oper) {
            case "*":
                return left * right;
            case "-":
                return left - right;
            case "+":
                return left + right;
        }

        return 0;
    }

    private static void getMax(List<String> list, boolean[] visited, int operCount) {
        if (operCount > 3) {
            max = Math.max(max, Math.abs(Long.parseLong(list.get(0))));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;

            List<String> copy = new ArrayList<>(list);
            String oper = OPERS[i];
            visited[i] = true;

            for (int j = 0; j < copy.size(); j++) {
                if (oper.equals(copy.get(j))) {
                    long left = Long.parseLong(copy.get(j - 1));
                    long right = Long.parseLong(copy.get(j + 1));
                    long result = calc(left, right, oper);

                    copy.remove(j - 1);
                    copy.remove(j - 1);
                    copy.remove(j - 1);
                    copy.add(j - 1, String.valueOf(result));

                    j -= 2;
                }
            }

            getMax(copy, visited, operCount + 1);
            visited[i] = false;
        }
    }

    private static long solution(String expression) {
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        boolean[] visited = new boolean[3];
        getMax(list, visited, 1);

        return max;
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
}
