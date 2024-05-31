import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortString1 {
    private static int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();

        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                list.add(Character.getNumericValue(c));
            }
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("hi12392")));
    }
}
