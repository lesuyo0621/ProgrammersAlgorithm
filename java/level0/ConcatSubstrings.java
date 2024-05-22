import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcatSubstrings {
    private static String solution(String[] my_strings, int[][] parts) {
        return IntStream.range(0, my_strings.length)
                .mapToObj(i -> my_strings[i].substring(parts[i][0], parts[i][1] + 1))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};

        System.out.println(solution(my_strings, parts));
    }
}
