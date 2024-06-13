import java.util.ArrayList;
import java.util.List;

public class CutAndSaveArray {
    private static List<String> solution(String my_str, int n) {
        List<String> answer = new ArrayList<>();
        int l = my_str.length();

        for (int i = 0; i < l; i += n) {
            answer.add(my_str.substring(i, i + n > l ? l : i + n));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc1Addfggg4556b", 6));
    }
}
