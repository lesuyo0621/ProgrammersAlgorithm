import java.util.stream.Collectors;

public class UpperAndLower {
    public static String solution(String my_string) {
        return my_string.chars()
                .mapToObj(c -> String.valueOf((char) (c > 96 ? c - 32 : c + 32)))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(solution("cccCCC"));
    }
}
