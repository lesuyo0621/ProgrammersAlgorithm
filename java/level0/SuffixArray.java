import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuffixArray {
    private static String[] solution(String my_string) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {
            list.add(my_string.substring(i, my_string.length()));
        }

        return list.stream().sorted().toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
    }
}
