import java.util.stream.Collectors;

public class SortString2 {
    private static String solution(String my_string) {
        return my_string.toLowerCase().chars().sorted().mapToObj(Character::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(solution("Bcad"));
    }
}
