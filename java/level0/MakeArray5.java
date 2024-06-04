import java.util.ArrayList;
import java.util.List;

public class MakeArray5 {
    private static List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();

        for (String intStr : intStrs) {
            int i = Integer.parseInt(intStr.substring(s, s + l));

            if (i > k) {
                answer.add(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"0123456789", "9876543210", "9999999999999"}, 50000, 5, 5));
    }
}
