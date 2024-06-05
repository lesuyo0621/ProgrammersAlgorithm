import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSeparators {
    private static String[] solution(String myStr) {
        String[] arr = myStr.split("[abc]");

        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s.length() == 0) continue;
            list.add(s);
        }

        String[] answer;
        if (list.size() == 0) {
            answer = new String[]{"EMPTY"};
        } else {
            answer = new String[list.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("baconlettucetomato")));
    }
}
