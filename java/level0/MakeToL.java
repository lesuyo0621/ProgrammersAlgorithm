import java.util.stream.Collectors;

public class MakeToL {
    private static String solution(String myString) {
        return myString.chars()
                .mapToObj(c -> c < 108 ? "l" : Character.toString(c))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdevwxyz"));
    }
}
